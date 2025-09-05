# Arquitectura para Frontend y Apps Mobile con API REST

## 1️⃣ Contexto inicial

- Para APIs RESTful, utilizo un patrón **clean-modular simplificado**:
    - Cada módulo tiene:
        - **Domain**: solo entidades y services.
        - **Interface**: DTOs, DAOs, Controllers, Models, Repositories.
    - Módulos según función: auth, alumnos, cursos, etc.

- En apps monolíticas con DB propia (tipo apps móviles), utilizo **MVC** clásico:
    - Model: datos y lógica
    - View: UI
    - Controller: coordinación y comunicación con Model

- En apps que son un **front UI consumiendo un API REST**, se requiere un patrón que mantenga separación clara de responsabilidades, ya que la lógica de negocio reside en el API.

---

## 2️⃣ Patrón recomendado: MVVM + Redux

### Componentes clave

1. **Modelo (Model)**
    - Representa los datos internos de la app (entidades).
    - No se comunica con la DB directamente; el API maneja persistencia.
    - Ejemplo: `User`, `Course`, `AuthToken`.

2. **ViewModel (VM / Interface)**
    - Actúa como **controller** de la UI.
    - Contiene servicios para llamar al API y DTOs para transformar datos.
    - Lógica mínima de presentación y validaciones locales.
    - Intermediario entre Model y View.

3. **Vista (View)**
    - Componentes HTML / CSS / JS o JSX/Vue templates.
    - Solo muestra datos y captura eventos del usuario.
    - No contiene lógica de negocio ni llama directamente al API.

4. **Redux (opcional / recomendado)**
    - Store global que mantiene el estado compartido entre vistas.
    - Permite flujo unidireccional: `Acción → Reducer → Estado → Vista`.
    - Puede considerarse un **ViewModel global** para apps complejas.

---

### Flujo de datos
===============================================================================================================
Usuario → Vista (JS/HTML/CSS)
Vista → ViewModel / Interface → llama al API
API → ViewModel / Interface → transforma a Model → actualiza Redux Store
Store → Vista → renderiza datos actualizados


===============================================================================================================

### Ventajas

- La app **nunca toca la DB**, todo lo hace el API.
- Separación clara: UI / estado / servicios / datos.
- Modular: cada módulo (`auth`, `alumnos`, `cursos`) funciona igual.
- Escalable y mantenible, ideal para front UI moderno consumiendo APIs complejas.
