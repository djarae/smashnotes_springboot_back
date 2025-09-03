MARZO 2025
dto=> Modelo de el archivo que enviaremos al front. 
model=>Modelo de lo que recibiremos de la bd
request=>Modelo de lo que recibiremos del front
response=>Tomamos el dto creamos una instancia y la enviamos
repository=>Tomamos el model y creamos una instancia y obtenemos o insertamos data
services=> logica de negocio,tecnicamente toma el
request y lo utiliza.
controllers=>HttpRutas.Llama services,recibe requests
===============================================================================================================
#Nota: Para no exceder en complejidad innecesaria, reglas:
1-DTO: Para recibir y enviar datos al front desde la api se utilizara un unico DTO por clase.
2-DTO: Solo se utilizara DTO en data compleja ,en data simple como "Personajes" & "Escenarios
" ,"Movimiento" ,etc. que es data no-mutuable no se agregaran.
2-Model:Reservado para las migraciones o utilizarlo para obtener data mas simple.
3-Controller: Se utilizara un unico controllador.
=============================================================================================================
TIPOS DE AVANCES:
1 Funcionales
2 Estructurales (Orden carpetas, patrones diseño,etc)
3 Seguridad (OWASP/Spring security
4 Velocidad(ORMS)
5 Estilo 




