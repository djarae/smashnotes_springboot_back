package smashnotest_back.repositorys;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.util.StringUtils;
import smashnotest_back.configs.Configs;
import smashnotest_back.model.Registro;

//Colocare una carpeta para querys, para cumplir con el principio 5 de solid ,y en caso de que necesite cambiar de sql a mongo db
public class RegistroRepository {
    public static ResultSet getDataRegistro(
            String filtroEmisor,
            String filtroReceptor,
            String filtroRage,
            String filtroPosicion,
            String filtroStage,
            String filtroMovimiento) throws SQLException {
        System.out.println("filtro emisor");System.out.println(filtroEmisor);
        System.out.println("filtro receptor");System.out.println(filtroReceptor);
        System.out.println("filtro rage");System.out.println(filtroRage);
        System.out.println("filtro posicion");System.out.println(filtroPosicion);
        System.out.println("filtro stage");System.out.println(filtroStage);
       System.out.println("filtro mov");System.out.println(filtroMovimiento);

//Creamos las variables auxiliares de filtro
       String auxFiltroEmisor = filtroEmisor;
        String auxFiltroReceptor = filtroReceptor;
        String auxFiltroRage = filtroRage;
        String auxFiltroPosicion = filtroPosicion;
       String auxFiltroMovimiento=filtroMovimiento;
        String auxFiltroStage=filtroStage;

  //la creacion de filtros podria ser una funcion luego!
   //Validamos si el filtro viene vacio!
        //FILTRO EMISOR:
        if (!StringUtils.hasText(auxFiltroEmisor)                // null, "", "   "
                || "0".equals(auxFiltroEmisor.trim())            // "0"
                || "undefined".equalsIgnoreCase(auxFiltroEmisor) // "undefined"
                || "null".equalsIgnoreCase(auxFiltroEmisor)) {   // "null"

            System.out.println("auxFiltroEmisor es nulo o vacío, se usa cláusula neutra");
            auxFiltroEmisor = "PE.nombre = PE.nombre";
        } else {
            System.out.println("valor presente, se aplica filtro");
            auxFiltroEmisor = "PE.nombre LIKE '%" + auxFiltroEmisor.trim() + "%'";
        }

        //FILTRO RECEPTOR
        if (!StringUtils.hasText(auxFiltroReceptor)                // null, "", "   "
                || "0".equals(auxFiltroReceptor.trim())            // "0"
                || "undefined".equalsIgnoreCase(auxFiltroReceptor) // "undefined"
                || "null".equalsIgnoreCase(auxFiltroReceptor)) {   // "null"
            System.out.println("auxFiltroReceptor es nulo");
            auxFiltroReceptor="PR.nombre=PR.nombre";
        }else{
            System.out.println("no es nulo se cambia");
            auxFiltroReceptor = "PR.nombre LIKE '%" + filtroReceptor + "%'";

            System.out.println(auxFiltroReceptor);
        }

        //FILTRO RAGE
        if (!StringUtils.hasText(auxFiltroRage)                // null, "", "   "
                || "undefined".equalsIgnoreCase(auxFiltroRage) // "undefined"
                || "null".equalsIgnoreCase(auxFiltroRage)) {   // "null"
            System.out.println("auxFiltroRage es nulo");
            auxFiltroRage="R.rage=R.rage";
        }else{
            System.out.println("no es nulo se cambia");
            auxFiltroRage = "R.rage =" + filtroRage ;

            System.out.println(auxFiltroRage);
        }


        //FILTRO POSICION
        if (!StringUtils.hasText(auxFiltroPosicion)                // null, "", "   "
                || "0".equals(auxFiltroPosicion.trim())            // "0"
                || "undefined".equalsIgnoreCase(auxFiltroPosicion) // "undefined"
                || "null".equalsIgnoreCase(auxFiltroPosicion)) {   // "null"
            System.out.println("auxFiltroPosicion es nulo");
            auxFiltroPosicion="POS.nombre=POS.nombre";
        }else{
            System.out.println("no es nulo se cambia");
            auxFiltroPosicion = "POS.nombre LIKE '%" + filtroPosicion + "%'";

            System.out.println(auxFiltroPosicion);
        }


        //filtro movimiento
        if (!StringUtils.hasText(auxFiltroMovimiento)                // null, "", "   "
                || "0".equals(auxFiltroMovimiento.trim())            // "0"
                || "undefined".equalsIgnoreCase(auxFiltroMovimiento) // "undefined"
                || "null".equalsIgnoreCase(auxFiltroMovimiento)) {   // "null"
            System.out.println("auxFiltroMovimiento es nulo");
           auxFiltroMovimiento="M.nombre=M.nombre";
       }else{
           System.out.println("no es nulo se cambia");
           auxFiltroMovimiento = "M.nombre LIKE '%" + filtroMovimiento + "%'";

           System.out.println(auxFiltroMovimiento);
       }



        //FILTRO stage
        if (!StringUtils.hasText(auxFiltroStage)                // null, "", "   "
                || "0".equals(auxFiltroStage.trim())            // "0"
                || "undefined".equalsIgnoreCase(auxFiltroStage) // "undefined"
                || "null".equalsIgnoreCase(auxFiltroStage)) {   // "null"
            System.out.println("auxFiltroStage es nulo");
            auxFiltroStage="E.nombre=E.nombre";
        }else{
            System.out.println("no es nulo se cambia");
            auxFiltroStage = "E.nombre LIKE '%" + filtroStage+ "%'";

            System.out.println(auxFiltroStage);
        }


        Statement s = Configs.Conexion.createStatement();System.out.println("get list escenario inicio");
        //SQL: Obtenemos la data
        String sql ="SELECT R.id as id,\n" +
                "                R.idPersonajeEmisor as idPersonajeEmisor,\n" +
                "               PE.nombre as nombrePersonajeEmisor,\n" +
                "                R.idPersonajeReceptor as idPersonajeReceptor, \n" +
                "                PR.nombre as nombrePersonajeReceptor, \n" +
                "                R.idMovimiento as idMovimiento, \n" +
                "                M.nombre as nombreMovimiento, \n" +
                "                E.id as idEscenario, \n" +
                "                E.nombre as nombreEscenario, \n" +
                "                R.idPosicion as idPosicion, \n" +
                "                POS.nombre as nombrePosicion, \n" +
                "                R.rage as  rage, \n" +
                "                R.di as  di, \n" +
                "                R.porcentajeKO as  porcentajeKO \n" +
                "                FROM registro R \n" +
                "                INNER JOIN personaje PE ON   R.idPersonajeEmisor=PE.id  \n" +
                "                INNER JOIN personaje PR ON   R.idPersonajeReceptor=PR.id  \n" +
                "                INNER JOIN movimiento M ON  R.idMovimiento=M.id \n" +
                "                INNER JOIN escenario E ON R.idEscenario=E.id\n" +
                "                INNER JOIN posicion POS ON R.idPosicion=POS.id " +
                "  WHERE "+ auxFiltroEmisor        + " and " +
                            auxFiltroReceptor      + " and " +
                            auxFiltroRage         + " and " +
                            auxFiltroStage         + " and " +
                            auxFiltroPosicion      + " and " +
                "         "+auxFiltroMovimiento +

                " ORDER BY id";
        System.out.println("sql4"+sql);
        ResultSet rs = s.executeQuery ( sql);
        System.out.println("resuuuuuuuuuuuuuuuuuuult"+rs);
        return rs;
    }
    public static String insertRegistro(Registro registro) throws SQLException {
        System.out.println("get id escenario");
        System.out.println( registro.getIdEscenario());

        // Establecemos la conexión y la declaración SQL
        Statement s = Configs.Conexion.createStatement();
        // Creamos la consulta SQL
        String sql = "INSERT INTO registro (id, idPersonajeEmisor, idPersonajeReceptor, idMovimiento, idEscenario, idPosicion, porcentajeKO,rage,di) " +
                "VALUES ((SELECT MAX(id)+1 from registro), " +
                registro.getIdPersonajeEmisor() + ", " +
                registro.getIdPersonajeReceptor() + ", " +
                registro.getIdMovimiento() + ", " +
                registro.getIdEscenario() + ", " +
                1 + ", " +
                registro.getPorcentajeKO() + ", "+
                registro.getRage()
                +", true)";

        // Ejecutamos la consulta con executeUpdate() para una operación de inserción
        int rowsAffected = s.executeUpdate(sql); // Esto debería devolver la cantidad de filas afectadas.

        // Retornamos el mensaje si se ha insertado correctamente
        if (rowsAffected > 0) {
            return "OK"; // Se insertó correctamente
        } else {
            return "Error al insertar el registro"; // Algo falló
        }
    }
    public static String updateRegistro(Registro registro) throws SQLException {
        System.out.println("registro update ");
        System.out.println("getId: " + registro.getId());
        System.out.println("getIdPersonajeEmisor: " + registro.getIdPersonajeEmisor());
        System.out.println("getIdPersonajeReceptor: " + registro.getIdPersonajeReceptor());
        System.out.println("getIdMovimiento: " + registro.getIdMovimiento());
        System.out.println("getIdEscenario: " + registro.getIdEscenario());
        System.out.println("getIdPosicion: " + registro.getIdPosicion());
        System.out.println("getRage: " + registro.getRage());
        System.out.println("getPorcentajeKO: " + registro.getPorcentajeKO());
        System.out.println("antes de crear el sql");

        Statement s = Configs.Conexion.createStatement();
        String sql = "UPDATE registro SET " +
                "idPersonajeEmisor = " + registro.getIdPersonajeEmisor() + ", " +
                "idPersonajeReceptor = " + registro.getIdPersonajeReceptor() + ", " +
                "idMovimiento = " + registro.getIdMovimiento() + ", " +
                "idEscenario = " + registro.getIdEscenario() + ", " +
                "idPosicion = " + registro.getIdPosicion() + ", " +
                "porcentajeKO = " + registro.getPorcentajeKO() + ", " +
                 "rage = " + registro.getRage() +
                " WHERE id = " + registro.getId();
        System.out.println("Antes de executeudatezzz");
        s.executeUpdate(sql);  // Ejecuta la actualización
        return "0";  // Retorna un código de éxito
    }
    public static String deleteRegistro(int id) throws SQLException {
        Statement s = Configs.Conexion.createStatement();
        String sql = "DELETE FROM registro WHERE id = " + id;
        s.executeUpdate(sql);  // Ejecuta la eliminación
        return "0";  // Retorna un código de éxito
    }
}
