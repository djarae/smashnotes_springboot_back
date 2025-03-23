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
        ResultSet rs = s.executeQuery ( " SELECT R.id as id,\n" +
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

    public static String insertRegistro(Registro registro)throws SQLException{
        Statement s = Configs.Conexion.createStatement();
        String sql = "INSERT INTO registro (idPersonajeEmisor, idPersonajeReceptor, idMovimiento, idEscenario, idPosicion, porcentajeKO) " +
                "VALUES (" + registro.getIdPersonajeEmisor() + ", " +
                registro.getIdPersonajeReceptor() + ", " +
                registro.getIdMovimiento() + ", " +
                registro.getIdEscenario() + ", " +
                registro.getIdPosicion() + ", " +
                registro.getPorcentajeKO() + ")";
        s .executeQuery(sql);  // Ejecuta la consulta SQL
        return "0";
    };


    public static String updateRegistro(Registro registro) throws SQLException {
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
