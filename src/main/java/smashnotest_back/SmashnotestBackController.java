package smashnotest_back;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Nota 17-12-2024: Ideas para ordenar codigo. Mover la conexion a otro archivo. El SQL a otras carpetas
 // e importarlo. Algunas funciones tambien y solo retornar, esto se volvio monolitico

@RestController
@RequestMapping("apiSmash")
public class SmashnotestBackController {
    //Ruta de testing , importante para comprobar que funciona app sin conexion bd:
    @GetMapping(value = "/tLocalDeploy" )
    public String testLocalDeploy() {
        return "Hola14!Empoleon:ruta => http://127.0.0.1:8080/apiSmash/tLocalDeploy";
    }
    @GetMapping(value = "/tCloudDeploy" )
    public String testCloudDeploy() {
        return "Hola11 !Torterra:ruta=>http://https://smashnotes-springboot-back.onrender.com/apiSmash/tCloudDeploy";
    }

    @GetMapping("/GetListPersonajes")
    public String GetListPersonajes() throws SQLException, JsonProcessingException {
        // INICIO CONEXION BD
        System.out.println("get list escenario inicio");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver found / Encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found / no encontrado" + e);
        }
        //Creamos la conexion
       // String url="jdbc:mysql://localhost:3306/smashbd";
        //String user="root";
        //String password="";
        String url="jdbc:postgresql://ep-shrill-cell-a5wddks2.us-east-2.aws.neon.tech:5432/neondb";
        String user="neondb_owner";
        String password="x2umTeFRS8bA";
        Connection Conexion= null;
        //Nos conectamos y testeamos la conexion
        try {
            Conexion= DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }

        //return "hola infrnape";
        // FIN CONEXION BD




        //INICIO CODIGO POST CONEXION
        Statement s = Conexion.createStatement();


        // Instanciamos un listado de escenarios
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
        //Testeamos que funcione
        System.out.println("Inicio de listar escenarios xclase");
        for (Personaje personajex: personajeList) {
            System.out.println(personajex.getId());
            System.out.println(personajex.getNombre());
        }
        System.out.println("Fin de listar escenarios");
        // Serializamos el objeto a json para enviarlo
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(personajeList);
        return json;

        //FIN CODIGO POST CONEXION






















    }



}
