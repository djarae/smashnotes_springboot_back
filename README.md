# 21-9-25  3:00 hh
Errores que no quiero corregir ahora
Estructurales:
1 Inserts, updates y deletes en controlller y deberia ir el codigo en services.
2 Dividir el controller en controllers chiquitos por funcion.
3 Dto Registro deberia tener list dto como nombre
Eso , no es mucho pero es desorden

============================================================================================================================================

# 20-9-25  23:50 hh
¡Ping recibido! ✅

INSERT: JdbcTemplate con SQL directo.

UPDATE / DELETE: JPQL (Spring Data / @Query).

Queda marcado y listo para implementar más adelante.

============================================================================================================================================


Conclusion : necsito pasar todo el proyecto a ORM para acabar con los problemas de caida de db , es arta pega..





Rebuilds To Fix DB:






2025 Septiembre: 
sab 13:
13 05 hh
13 36 hrs
14 37 hh fallo
15hh


========================
6-9-25.
update del app

≠=============================
3-9-25
EXPLIACION DE FUTURA ARQUITECTURA DE CAPAS (PRESENTACION-APLICACION-DB)a
Para mi api me sirve este patron.
Diagrama tipo matrioshka:
┌─────────────────────────────┐
│        Capa de Presentación  │
│  Controller + DTOs           │
│  - Recibe DTO de entrada     │
│  - Devuelve DTO de salida    │
│                             │
│  ┌─────────────────────────┐ │
│  │  Capa de Aplicación      │ │
│  │  Service + Request/Resp │ │
│  │  + Handlers             │ │
│  │  - Orquesta flujo       │ │
│  │  - Valida/transf. datos │ │
│  │  - Ejecuta lógica│ │
│  │                         │ │
│  │  ┌─────────────────────┐│ │
│  │  │ Capa de Datos        ││ │
│  │  │ DAO + Entities
││ │    +repostiris
│  │  │ - Persiste y consulta││ │
│  │  │ - Solo conoce Entities││ │
│  │  └─────────────────────┘│ │
│  └─────────────────────────┘ │
└─────────────────────────────┘

--------------------------------------------------------------------------------------------------------------------
Ejemplo estructura de carpeta. Puede variar, por ejemplo los handlers y daos pueden ir en un solo archivo y cosas asi:
modulos/
modulos/
├── animal/
│   ├── api/
│   │   └── AnimalController.java
│   │   └── dto/
│   │       ├── CreateAnimalDTO.java
│   │       ├── ReadAnimalDTO.java
│   │       ├── ListAnimalDTO.java
│   │       ├── UpdateAnimalDTO.java
│   │       └── DeleteAnimalDTO.java
│   ├── service/
│   │   ├── AnimalService.java
│   │   ├── AnimalRequest.java
│   │   ├── AnimalResponse.java
│   │   └── AnimalHandler.java
│   └── db/
│       ├── dao/
│       │   └── AnimalDao.java
│       ├── AnimalRepository.java
│       └── entity/
│           ├── AnimalEntity.java
│           ├── EspecieEntity.java
│           └── TerrenoEntity.java
│
├── vehiculo/
│   ├── api/
│   │   └── VehiculoController.java
│   │   └── dto/
│   │       ├── CreateVehiculoDTO.java
│   │       ├── ReadVehiculoDTO.java
│   │       ├── ListVehiculoDTO.java
│   │       ├── UpdateVehiculoDTO.java
│   │       └── DeleteVehiculoDTO.java
│   ├── service/
│   │   ├── VehiculoService.java
│   │   ├── VehiculoRequest.java
│   │   ├── VehiculoResponse.java
│   │   └── VehiculoHandler.java
│   └── db/
│       ├── dao/
│       │   └── VehiculoDao.java
│       ├── VehiculoRepository.java
│       └── entity/
│           ├── VehiculoEntity.java
│           └── PaisEntity.java
│
├── producto/
│   ├── api/
│   │   └── ProductoController.java
│   │   └── dto/
│   │       ├── CreateProductoDTO.java
│   │       ├── ReadProductoDTO.java
│   │       ├── ListProductoDTO.java
│   │       ├── UpdateProductoDTO.java
│   │       └── DeleteProductoDTO.java
│   ├── service/
│   │   ├── ProductoService.java
│   │   ├── ProductoRequest.java
│   │   ├── ProductoResponse.java
│   │   └── ProductoHandler.java
│   └── db/
│       ├── dao/
│       │   └── ProductoDao.java
│       ├── ProductoRepository.java
│       └── entity/
│           ├── ProductoEntity.java
│           ├── CategoriaEntity.java
│           └── ProveedorEntity.java
│
└── shared/
├── dtos/
└── entitys/


--------------------------------------------------------------------------------------------------------------------
🔹 Flujo general
Controller (Capa de Presentación)
│
│ -- recibe DTO de entrada del UI
│ -- devuelve DTO de salida al UI
▼
Service (Capa de Aplicación / Orquestador)
│
│ -- llama a Request → valida / transforma DTO de entrada
│ -- llama a Handler → ejecuta lógica de negocio
│ -- llama a Response → transforma resultados internos a DTO de salida
▼
Handler (Capa de Dominio / Lógica de negocio)
│
│ -- llama a Repository → realiza consultas o acciones
│ -- retorna resultados al Service
▼
Repository (Capa de Persistencia / Infraestructura)
│
│ -- llama a DAO(s) → ejecuta operaciones sobre Entity/Model
│ -- retorna resultados al Handler
▼
DAO (Capa de Acceso a Datos)
│
│ -- interactúa directamente con la DB usando Entities / Modelos
│ -- retorna resultados al Repository
▼
Entity / Model (Capa de Datos / Infraestructura)
--------------------------------------------------------------------------------------------------------------------
🔹 Roles y responsabilidades resumidos
Componente	Función principal
Controller	Recibe y devuelve datos usando DTOs, no conoce lógica interna ni DB
Service	Orquesta el flujo: valida entrada (Request), llama a Handler y formatea salida (Response)
Request	Valida y transforma la data de entrada
Handler	Ejecuta la lógica de negocio, coordina llamadas a DB/Repository
Response	Transforma resultados internos en DTO de salida
Repository	Encapsula la persistencia; llama a DAOs según Entities/Models
DAO	Acceso directo a la base de datos, realiza queries, inserts, updates, deletes
Entity / Model	Representación de la estructura de la base de datos



--------------------------------------------------------------------------------------------------------------------

==================================================================================================
2-9-25
Mejoras Futuras:
Finde app smash; colocar en la pagina de inicio:
" Errores comunes: x
Colocar en la app smash btn "nomenclaturas" y ajustar el css
Iniciar lo de gastos ,apk, bd ,crud en ese orden( la apk y bd es lo ma hard)
Mejoras necesarias app sma:
* 1- VISUAL: Tamaño en app mobile de frente
* 2- ABREVIATURAS para pjs,escenarios,posiciones,movs.
* 3- DB: Pool de conoecciones en neon ,crear nueva db y conectar
* 4- FILTRO: Crear filtro de di
* 5- Cronjob cada 14 mins, probar! en render!


#
=====================================================================
01-09-2025
# Esta api es para el front smashnotes_angular
================================================================================================================
# Objetivo app
# El objetivo de esta api es hacer un desarrollo crud simple, el cual la principal funcion
# es poder registrar informacion de super smash y respaldarla con un boton en mi correo.
# Ademas en esta aplicacion hay que usar lo menos posible "IA"
=============================================================================================================
# 01-09-2025
# NOTA: La folder"entity" es un intento de implementar ORM Spring Data Jpa no quitar de momento, pero
#  no es relevante en esta fase del desarrollo
=============================================================================================================
# 2027 : NUEVAS funciones:
#  - Estructura: algun dia aplicar los patrones del archivo "PatronAUsarHexagonalCleanSimple"
- ORM
- Login
# - Integracion con START GG (leer doc: "puntoNet_api_microservicio_stargg_argumento_separacion_responsabilidades")
- 
para el front leer: " MVVM-ReduxYPatronesEnTiposDeApps"
#
================================================================================================================
- Inicio app     : 1 Enero 2025
- Fin desarrollo : 15 de Agosto 2025 (En esta etapa solo se haran cambios menores)
  ===============================================================================================================
