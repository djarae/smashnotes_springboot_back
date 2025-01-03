package smashnotest_back.controllers;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.sql.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import smashnotest_back.configs.BDConfig;
import smashnotest_back.model.Personaje;
import smashnotest_back.model.Registro;


import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("apiSmash")
public class SmashnotestBackController {
    //Constructor:
    public  SmashnotestBackController()
    {
        BDConfig.ConexionDB();
    }

    //Ruta de testing , importante para comprobar que funciona app sin conexion bd:
    @GetMapping(value = "/tLocalDeploy" )
    public String testLocalDeploy() {
        return "Hola22!Empoleon:ruta => http://127.0.0.1:8080/apiSmash/tLocalDeploy";
    }
    @GetMapping(value = "/tCloudDeploy" )
    public String testCloudDeploy() {
        return "Hola11 !Torterra:ruta=>http://https://smashnotes-springboot-back.onrender.com/apiSmash/tCloudDeploy";
    }
    @GetMapping("/GetListRegistros")
    public String GetListRegistros() throws SQLException, JsonProcessingException {
        Statement s = BDConfig.Conexion.createStatement();System.out.println("get list escenario inicio");
        // Instanciamos un listado de escenarios
        ResultSet rs = s.executeQuery ( "SELECT R.id as id,\n" +
                "R.idPersonajeEmisor as idPersonajeEmisor,\n" +
                "PE.nombre as nombrePersonajeEmisor,\n" +
                "R.idPersonajeReceptor as idPersonajeReceptor,\n" +
                "PR.nombre as nombrePersonajeReceptor,\n" +
                "R.idMovimiento as idMovimiento,\n" +
                "M.nombre as nombreMovimiento,\n" +
                "E.nombre as nombreEscenario,\n" +
                "R.idPosicionEscenario as idPosicionEscenario,\n" +
                "POS.nombre as nombrePosicionEscenario,\n" +
                "R.porcentajeKO as  porcentajeKO\n" +
                "FROM registro R\n" +
                "INNER JOIN personaje PE ON   R.idPersonajeEmisor=PE.id \n" +
                "INNER JOIN personaje PR ON   R.idPersonajeReceptor=PR.id \n" +
                "INNER JOIN movimiento M ON  R.idMovimiento=M.id\n" +
                "INNER JOIN posicionescenario POS ON R.idPosicionEscenario=POS.id\n" +
                "INNER JOIN escenario E ON POS.idEscenario=E.id");
        List<Registro> registroList = new ArrayList<>();
        while (rs.next()) {
            System.out.println ("agregamos data al listado de ojbetos de escenario");
            Registro itemRegistro = new Registro(
                    rs.getInt("id"),
                    rs.getInt("idPersonajeEmisor"),
                    rs.getString("nombrePersonajeEmisor"),
                    rs.getInt("idPersonajeReceptor"),
                    rs.getString("nombrePersonajeReceptor"),
                    rs.getInt("idMovimiento"),
                    rs.getString("nombreMovimiento"),
                    rs.getString("nombreEscenario"),
                    rs.getInt("idPosicionEscenario"),
                    rs.getString("nombrePosicionEscenario"),
                    rs.getInt("porcentajeKo")
            );
            registroList.add(itemRegistro);
            System.out.println (rs.getInt("id"));
            System.out.println (rs.getInt("idPersonajeEmisor"));
            System.out.println (rs.getString("nombrePersonajeEmisor"));

        };
        //Serializamos el objeto a json para enviarlo:
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(registroList);
        return json;
    }
    @GetMapping("/GetListPersonajes")
    public String GetListPersonajes() throws SQLException, JsonProcessingException {
        Statement s = BDConfig.Conexion.createStatement();
        ResultSet rs = s.executeQuery ( "SELECT id, echo, nombre FROM personaje");
        List<Personaje> personajeList = new ArrayList<>();
        while (rs.next()) {
            System.out.println ("agregamos data al listado de ojbetos de escenario");
            Personaje itemPersonaje = new Personaje(
                    rs.getInt("id"),
                    rs.getInt("echo"),
                    rs.getString("nombre"));
            personajeList.add(itemPersonaje);
            System.out.println (rs.getInt("id"));
            System.out.println (rs.getString("nombre"));
        };
        // Serializamos el objeto a json para enviarlo
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(personajeList);
        return json;
    }
}


