# 26-10-2025
En dbeaver: 
 De 3 12 0 a 3 12 9 ,registro todos los angulos de DI para ver como son para el upair 
  de ivysaur, pero en este caso solo para IVYSAUR -CLOUD

UpAir id => 12 
UGrab id => 20


3120 => primer digito 3 => codigo base de dis ; 12 => id del movimiento ; 0 => di neutro
3121 = primer digito 3 => codigo base de dis ; 12 => id del movimiento ; 1  => di afuera
3122 = primer digito 3 => codigo base de dis ; 12 => id del movimiento ; 1  => di afuera abajo


select * from MOVIMIENTO


INSERT INTO movimiento (id, nombre, abreviatura) VALUES (3120, 'Forward Throw', 'FGrab');
INSERT INTO movimiento (id, nombre, abreviatura) VALUES (19, 'Back Throw', 'BGrab');
INSERT INTO movimiento (id, nombre, abreviatura) VALUES (20, 'Up Throw', 'UGrab');
INSERT INTO movimiento (id, nombre, abreviatura) VALUES (21, 'Down Throw', 'DGrab');

INSERT INTO movimiento (id, nombre, abreviatura) VALUES (, 'Down Throw', 'DGrab');







# 19-10-2025

TICKET  FUTUROS:
Utilizar APP! LLENAR APP : UpAir IVY /UpGrab Zard/ A-lot-of-moves: Cloud
Auth estaria joya



============================================================================================================================================
# 17-10-2025 "Tickets futuros"

- Modulo "auth" 
 Me angustia tenerlo

- Modulo de informes:
  Me seria MUY util tener un informe completo del UPAIR que exporte a PDF lindo para verlo

- Modulo mantenedores:
  Por ejemplo ,el mantenedor de movimientos/combos se esta volviendo clave.

- Modulo "Startgg Integracion:
 Paranalisis es avanzado ,que pereza

-Modulo "contactos":
 Registro de contactos para practicar de cada personaje  



============================================================================================================================================
# 14-10-2025 (Mas simple) 
REGLA:
1 a 100      => Kill Percent
101 a 200    => Tumbling Percent
201 a 300    => Move Damage
1000 o  mas  => Kill-Combos  (KiCom) o Damage-Combos (DmCom). Se representa con abreviatura "KiCom" o "DmCom" .Ademas en el nombre debe terminar con "KC" para combos de daño o "DC"

Mas facil
 * SQL   : Anadir un combo ,tumbling o move damage deseado por medio de un insert en DB.
 * UI    : If idMovimiento > 999 => Utilizar "nombreMovimiento" en lugar de "abreviaturaMovimiento"
 * UI    : If idMovimiento > 999 => Utilizar un "td" con ancho fijo , cosa que se hagan saltos de linea por cada palabra


# PD:Representacion para flojos. No quiero tocar el api ,asi que representarlo asi como en db es mas facil. 
 Ejemplo1 : Ftilt => JabLock => Fsmash (KC)
 Ejemplo2 : DGrab => Dair => Dgrab => UpSmash (DC) 

 Esto yo entiendo que significa, ademas lo puedo entender


============================================================================================================================================
# 12-10-2025
# Soporte para registrar "Combos" percent

Tarea: De la forma mas simple , se debe permitir que la app pueda agregar "combos"
Forma facil: 
    * SQL: Modificar la tabla "Movimientos" campo "nombre" para que soporte 100 caracteres 
    * SQL: Crear tabla "tipo" ,con los tipos : "Movimiento" "Combo" "Damage" "Tumbling
    * SQL: Crear FK y campo "id_tipo" en la tabla "registros" que logicamente cargue el tipo
    * SQL: Insertar desde los movs 100 en adelante los combos(300-infinite) y TUMBLINGS(200-299) , damages (100-199)  
    * SQL: Agregar el FTILT (tumbling) abrev FTTmb 
    * SQL :Agregar 1 combo en el 201   
    * API: Crear entidad "tipo" 
    * API: Modificar el select para obtener el campo TIPO correctamente (en el HTML procesamos el correcto)
    * UI:  Agregrar un "IF" en el Front HTML :
               IF TIPO = "COMBO" agregamos el "nombre"
               ELSE => Agregamos "abrevacion"
               NOTA: Logicamente la abreviacion para combos sera NULL o COMBO
  
# (FUTURO) Ordenar el API por capas 
# (FUTURO) Crear AUTH con LOGIN y REGISTER(HASHED)
============================================================================================================================================
# 22-9-25  3:00 hh
Next tickets (leer los errores estruccturales de abajo too)
App smashData:
Rama: Refacctor: para ordenar mi codig
Rama: AUTH: para auth solo con login ; register y guardar auth token en front/back de forma SAFE  Y SIMPLE
============================================================================================================================================
# 21-9-25  3:00 hh
Errores que no quiero corregir ahora
Estructurales:
1 Inserts, updates y deletes en controlller y deberia ir el codigo en services.
2 Dividir el controller en controllers chiquitos por funcion.
3 Dto Registro deberia tener list dto como nombre
4 Los dtos y services deberian ir en las carpeta scorrectas
Eso , no es mucho pero es desorden
5 Filtro por di -si o no.
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
