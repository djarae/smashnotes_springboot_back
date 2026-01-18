# Propuesta de Arquitectura Mobile y Sincronización Offline (React Native / Expo)

Este documento detalla una propuesta técnica para la implementación de una versión móvil de la aplicación con capacidades *Offline-First* (primero sin conexión), utilizando **React Native** con **Expo** y manteniendo la integración con el backend actual (Spring Boot).

## 1. Estrategia para el Frontend Mobile

Se utilizará **React Native** gestionado con **Expo** para el desarrollo.

*   **Tecnología:** React Native + Expo Framework.
*   **Por qué Expo:** Facilita enormemente la configuración de entornos nativos, manejo de permisos, actualizaciones OTA (Over The Air) y acceso a APIs del dispositivo.
*   **Lenguaje:** TypeScript (recomendado para compartir tipos/interfaces con el backend si se generan DTOs).

---

## 2. Almacenamiento Local (Persistencia)

Para lograr una experiencia *Offline-First* real, necesitamos una base de datos en el dispositivo, no solo `AsyncStorage` (que es solo clave-valor y lento para datos complejos).

### Opción Recomendada: WatermelonDB
Es una base de datos reactiva de alto rendimiento construida sobre SQLite, diseñada específicamente para aplicaciones offline-first en React Native.
*   **Ventajas:** Sincronización nativa, muy rápido con miles de registros, tipado fuerte.
*   **Modelo de Sync:** Ya trae protocolos de sincronización definidos que encajan con lo que buscas.

### Alternativa: Expo SQLite (SQL directo)
Si prefieres control total sobre las consultas SQL.
*   **Uso:** Creas tus tablas manualmente (`CREATE TABLE...`) y gestionas los INSERT/SELECT.
*   **Ventaja:** Simplicidad si el esquema es pequeño.

---

## 3. Estrategia de Sincronización (Online/Offline)

El patrón sigue siendo **"Offline First"**. La UI siempre consume datos de la BD local.

### Flujo de Trabajo

#### A. Detección de Estado
Usaremos `@react-native-community/netinfo` para detectar cambios en la red.
*   **Hook:** `useNetInfo()` en React.
*   **Lógica:** Si `isConnected` cambia a `true`, disparamos el proceso de sincronización.

#### B. Escritura (Guardado)
Cuando el usuario guarda un dato:
1.  **Persistencia Local:** Se guarda inmediatamente en SQLite/WatermelonDB.
2.  **Cola de Sync:** Se marca el registro como `_status: 'created'` o `_status: 'updated'` (o se inserta en una tabla cola aparte).
3.  **Intento de Envío:**
    *   Si hay internet, el "Sync Manager" intenta enviarlo al backend inmediatamente.
    *   Si no, se queda marcado como "pendiente" (dirty) en local.

#### C. Proceso de Sincronización (Sync Engine)

Este motor debe ejecutarse en segundo plano o al iniciar la app.

**Algoritmo con WatermelonDB (Ejemplo del estándar):**
WatermelonDB tiene una función `synchronize()` que espera dos funciones: `pullChanges` y `pushChanges`.

1.  **PULL (Traer cambios):** 
    *   Cliente pide al backend cambios desde `last_pulled_at`.
    *   Backend responde con `{ changes: { matchups: { created: [], updated: [], deleted: [] } }, timestamp: 12345 }`.
2.  **PUSH (Enviar cambios):**
    *   Cliente recolecta registros marcados como 'created'/'updated'.
    *   Envía al backend.
    *   Si éxito, el cliente marca esos registros como "synced".

### Actualización Automática

Para la consulta periódica, en React Native usamos `useEffect` y `setInterval` (o librerías como `expo-background-fetch` para background real, aunque con la app abierta basta un intervalo).

```typescript
// services/SyncService.ts
import NetInfo from '@react-native-community/netinfo';
import { synchronize } from '@nozbe/watermelondb/sync';
import { database } from './database'; // Tu instancia de DB

export const startSyncLoop = () => {
  // 1. Escuchar cambios de conexión activos
  const unsubscribe = NetInfo.addEventListener(state => {
    if (state.isConnected) {
      runSync();
    }
  });

  // 2. Intervalo periódico (ej. cada 5 min por si acaso)
  const intervalId = setInterval(() => {
    runSyncIfConnected();
  }, 5 * 60 * 1000);

  return () => {
    unsubscribe();
    clearInterval(intervalId);
  };
};

async function runSyncIfConnected() {
  const state = await NetInfo.fetch();
  if (state.isConnected) {
    runSync();
  }
}

async function runSync() {
  try {
    await synchronize({
      database,
      pullChanges: async ({ lastPulledAt }) => {
        const response = await fetch(`API_URL/sync/pull?last_at=${lastPulledAt}`);
        const { changes, timestamp } = await response.json();
        return { changes, timestamp };
      },
      pushChanges: async ({ changes, lastPulledAt }) => {
        await fetch(`API_URL/sync/push`, {
            method: 'POST',
            body: JSON.stringify(changes)
        });
      },
    });
  } catch (error) {
    console.log('Error en sync:', error);
  }
}
```

## Resumen de Arquitectura

1.  **Frontend (React Native + Expo):**
    *   **UI:** Componentes React nativos.
    *   **DB:** WatermelonDB (SQLite bajo el capó).
    *   **Red:** `NetInfo` para disparar eventos.
    *   **Lógica:** Un `SyncService` singleton que gestiona el ciclo de vida de los datos.

2.  **Backend (Spring Boot):**
    *   Mantener endpoints de sincronización compatibles.
    *   El backend debe ser la "fuente de la verdad", resolviendo conflictos si dos móviles editan lo mismo (normalmente "el último gana" o control de versiones).

Esta estructura es moderna, escalable y muy robusta para aplicaciones móviles profesionales con React Native.
