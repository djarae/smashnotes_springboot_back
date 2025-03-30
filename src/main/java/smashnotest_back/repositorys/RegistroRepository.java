package smashnotest_back.repositorys;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import smashnotest_back.configs.Configs;
import smashnotest_back.model.Registro;

//Colocare una carpeta para querys, para cumplir con el principio 5 de solid ,y en caso de que necesite cambiar de sql a mongo db
public class RegistroRepository {

    public static ResultSet  getDataRegistro()throws SQLException, JsonProcessingException {

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
                "                R.porcentajeKO as  porcentajeKO \n" +
                "                FROM registro R \n" +
                "                INNER JOIN personaje PE ON   R.idPersonajeEmisor=PE.id  \n" +
                "                INNER JOIN personaje PR ON   R.idPersonajeReceptor=PR.id  \n" +
                "                INNER JOIN movimiento M ON  R.idMovimiento=M.id \n" +
                "                INNER JOIN escenario E ON R.idEscenario=E.id\n" +
                "                INNER JOIN posicion POS ON R.idPosicion=POS.id " +
                "   ORDER BY id";
        System.out.println("sql"+sql);
        ResultSet rs = s.executeQuery ( "SELECT R.id as id,\n" +
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
                "                R.porcentajeKO as  porcentajeKO \n" +
                "                FROM registro R \n" +
                "                INNER JOIN personaje PE ON   R.idPersonajeEmisor=PE.id  \n" +
                "                INNER JOIN personaje PR ON   R.idPersonajeReceptor=PR.id  \n" +
                "                INNER JOIN movimiento M ON  R.idMovimiento=M.id \n" +
                "                INNER JOIN escenario E ON R.idEscenario=E.id\n" +
                "                INNER JOIN posicion POS ON R.idPosicion=POS.id " +
                "   ORDER BY id");
        return rs;
    }

    public static String insertRegistro(Registro registro) throws SQLException {
        System.out.println("get id escenario");
        System.out.println( registro.getIdEscenario());

        // Establecemos la conexión y la declaración SQL
        Statement s = Configs.Conexion.createStatement();
        // Creamos la consulta SQL
        String sql = "INSERT INTO registro (id, idPersonajeEmisor, idPersonajeReceptor, idMovimiento, idEscenario, idPosicion, porcentajeKO) " +
                "VALUES ((SELECT MAX(id)+1 from registro), " + 35 + ", " +
                registro.getIdPersonajeReceptor() + ", " +
                16 + ", " +
                registro.getIdEscenario() + ", " +
                1 + ", " +
                registro.getPorcentajeKO() + ")";

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
        System.out.println("getPorcentajeKO: " + registro.getPorcentajeKO());

        Statement s = Configs.Conexion.createStatement();
        String sql = "UPDATE registro SET " +
                "idPersonajeEmisor = " + registro.getIdPersonajeEmisor() + ", " +
                "idPersonajeReceptor = " + registro.getIdPersonajeReceptor() + ", " +
                "idMovimiento = " + registro.getIdMovimiento() + ", " +
                "idEscenario = " + registro.getIdEscenario() + ", " +
                "idPosicion = " + registro.getIdPosicion() + ", " +
                "porcentajeKO = " + registro.getPorcentajeKO() + " " +
                "WHERE id = " + registro.getId();
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
