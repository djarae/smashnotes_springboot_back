# Agregar dependecias puede arruionar fuertemente la aplicacin y el despliegue,
# por ejemplo , alguna dependencia de jdbc me staba arruinando el codigo

# funciona con jar 31-12-24


# Sgtes pasos complejos:
# conectar a la bd , colocando dependencias necesarias 
# sin que muera la app en el intento

# El despliegue fallaba por que tenia una carpeta extra 
 ,cuando debi colocar todo en la raiz para evitar que se 
  perdiera buscando comandos




# Creacion y conexion bd neon:
 https://www.youtube.com/watch?v=1Dhjede1xks&list=PLlwJCKng02GTT-AKYmZoFHpCTrgCrHujd&index=101
 Min 1.45 coencta bd con el string de conexion


# tambien se caia por las dependencias 