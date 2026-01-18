# Resumen de Implementación: Autenticación JWT para SmashNotes

## ✅ Estado: COMPLETADO

Este documento resume los cambios realizados para implementar autenticación JWT en el proyecto SmashNotes.

---

## 📁 Archivos Creados/Modificados

### Backend (Spring Boot)

#### Nuevos archivos en `auth/`:

```
src/main/java/smashnotest_back/auth/
├── config/
│   ├── DataInitializer.java      ← Crea el usuario admin automáticamente
│   ├── JwtAuthenticationFilter.java ← Filtro que valida tokens JWT
│   └── SecurityConfig.java       ← Configuración de Spring Security + CORS
├── controller/
│   └── AuthController.java       ← POST /api/auth/login
├── dto/
│   ├── LoginRequestDTO.java      ← { email, password }
│   └── LoginResponseDTO.java     ← { token, email, rol }
├── entity/
│   └── Usuario.java              ← Entidad JPA (implements UserDetails)
├── repository/
│   └── UsuarioRepository.java    ← findByEmail(), existsByEmail()
└── service/
    ├── AuthService.java          ← Lógica de autenticación
    ├── CustomUserDetailsService.java ← Carga usuario desde DB
    └── JwtService.java           ← Generación/validación de tokens
```

#### Archivos modificados:

| Archivo | Cambio |
|---------|--------|
| `pom.xml` | Añadidas dependencias de spring-boot-starter-security y jjwt |
| `application.properties` | Añadidas propiedades jwt.secret y jwt.expiration |
| `configs/CorsConfig.java` | DESHABILITADO (CORS ahora en SecurityConfig) |

#### Scripts SQL:

| Archivo | Descripción |
|---------|-------------|
| `Docs/sql_crear_tabla_usuarios.sql` | Script para crear tabla `usuarios` e insertar admin |

---

### Frontend (Angular)

#### Nuevos archivos:

```
src/services/authentication/
└── auth.service.ts               ← Manejo de login, tokens, localStorage

src/app/authentication/
├── authentication.component.ts   ← Wrapper (muestra login o usuario)
├── authentication.component.html
├── authentication.component.css
├── authentication.module.ts      ← Módulo que exporta componentes
└── login/
    ├── login.component.ts        ← Formulario de login
    ├── login.component.html
    └── login.component.css       ← Diseño glassmorphism moderno
```

#### Archivos modificados:

| Archivo | Cambio |
|---------|--------|
| `app.module.ts` | Importado AuthenticationModule |
| `services/matchups/registro.service.ts` | Añadido token JWT en headers POST/PUT/DELETE |

---

## 🗄️ Base de Datos

### Opción 1: Automática (Recomendada)
La aplicación creará automáticamente el usuario admin al iniciar si no existe (via `DataInitializer.java`).

### Opción 2: Manual
Ejecuta el siguiente SQL en tu base de datos PostgreSQL:

```sql
-- Crear tabla
CREATE TABLE IF NOT EXISTS usuarios (
    id BIGSERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(50) NOT NULL DEFAULT 'ADMIN'
);

-- Insertar usuario admin (password ya hasheado)
INSERT INTO usuarios (email, password, rol) VALUES (
    'megawhitegengar@gmail.com',
    '$2a$10$N9qo8uLOickgx2ZMRZoMy.Mrq4H9Q0q5aTvPxGHvl/Zy3GQQ6O1pu',
    'ADMIN'
) ON CONFLICT (email) DO NOTHING;
```

---

## 🔐 Credenciales del Admin

| Campo | Valor |
|-------|-------|
| Email | `megawhitegengar@gmail.com` |
| Password | `Secreta655%` |
| Rol | `ADMIN` |

---

## 🌐 Endpoints de Autenticación

| Método | Endpoint | Auth | Descripción |
|--------|----------|------|-------------|
| POST | `/api/auth/login` | ❌ | Login, devuelve JWT |
| GET | `/api/auth/verify` | ✅ | Verifica si token es válido |

### Request de Login:
```json
POST /api/auth/login
{
  "email": "megawhitegengar@gmail.com",
  "password": "Secreta655%"
}
```

### Response exitoso:
```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "email": "megawhitegengar@gmail.com",
  "rol": "ADMIN"
}
```

---

## 🛡️ Protección de Endpoints

| Método | Endpoints | Requiere Token |
|--------|-----------|----------------|
| GET | `/apiSmash/*` | ❌ Público |
| POST | `/apiSmash/*` | ✅ Requiere JWT |
| PUT | `/apiSmash/*` | ✅ Requiere JWT |
| DELETE | `/apiSmash/*` | ✅ Requiere JWT |

---

## 📋 Pasos para Probar

### 1. Backend

1. Ejecutar el SQL para crear la tabla `usuarios` (o dejar que DataInitializer lo haga)
2. Compilar y ejecutar:
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```
3. Probar login con Postman/curl:
   ```bash
   curl -X POST http://localhost:8080/api/auth/login \
     -H "Content-Type: application/json" \
     -d '{"email":"megawhitegengar@gmail.com","password":"Secreta655%"}'
   ```

### 2. Frontend

1. Instalar dependencias si es necesario:
   ```bash
   npm install
   ```
2. Ejecutar:
   ```bash
   ng serve
   ```
3. Navegar a la ruta de autenticación para ver el login

---

## ⚠️ Notas Importantes

1. **CORS**: Actualiza los orígenes permitidos en `SecurityConfig.java` según tus dominios de producción
2. **JWT Secret**: En producción, usa una variable de entorno en lugar del valor hardcodeado
3. **SSL**: En producción, asegúrate de usar HTTPS para proteger los tokens en tránsito
4. **Token Expiration**: Actualmente configurado a 24 horas (86400000 ms)

---

## 🔄 Flujo de Uso

```
1. Usuario abre la app → Ve formulario de login
2. Ingresa credenciales → Click "Iniciar Sesión"
3. Angular envía POST /api/auth/login
4. Backend valida y devuelve JWT
5. Angular guarda token en localStorage
6. Usuario puede crear/editar/eliminar registros
7. Cada request protegido incluye "Authorization: Bearer {token}"
8. Al hacer logout, se elimina el token
```

---

Creado: 2026-01-18
