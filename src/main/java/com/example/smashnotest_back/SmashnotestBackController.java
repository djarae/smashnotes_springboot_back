package com.example.smashnotest_back;
import java.sql.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
        return "Hola!Empoleon:ruta => http://127.0.0.1:8080/apiSmash/tLocalDeploy";
    }
    @GetMapping(value = "/tCloudDeploy" )
    public String testCloudDeploy() {
        return "Hola!Torterra:ruta=>http://INGRESARRUTACLOUD:8080/apiSmash/tloudDeploy";
    }

    @GetMapping("/GetListRegistros")
    public String GetListRegistros() throws SQLException, JsonProcessingException {
        System.out.println("get list escenario inicio");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver found / Encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found / no encontrado" + e);
        }
        //Creamos la conexion
        String url="jdbc:mysql://localhost:3306/smashbd";
        String user="root";
        String password="";
        Connection Conexion= null;
        //Nos conectamos y testeamos la conexion
        try {
            Conexion= DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }
        Statement s = Conexion.createStatement();

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
        //Testeamos que funcione
        System.out.println("Inicio de listar escenarios xclase");
        for (Registro  registrox: registroList) {
            System.out.println(registrox.getId());
            System.out.println(registrox.getIdPersonajeEmisor());
            System.out.println(registrox.getNombrePersonajeEmisor());
        }
        System.out.println("Fin de listar escenarios");
        // Serializamos el objeto a json para enviarlo
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(registroList);
        return json;
    }

    @GetMapping("/GetListEscenarios")
    public String GetListEscenarios() throws SQLException, JsonProcessingException {
        System.out.println("get list escenario inicio");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver found / Encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found / no encontrado" + e);
        }
        //Creamos la conexion
        String url="jdbc:mysql://localhost:3306/smashbd";
        String user="root";
        String password="";
        Connection Conexion= null;
        //Nos conectamos y testeamos la conexion
        try {
            Conexion= DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }
        Statement s = Conexion.createStatement();

        // Instanciamos un listado de escenarios
        ResultSet rs = s.executeQuery ( "SELECT id, nombre FROM escenario");
        List<Escenario> escenarioList = new ArrayList<>();
        while (rs.next()) {
            System.out.println ("agregamos data al listado de ojbetos de escenario");
            Escenario itemEscenario = new Escenario(
                    rs.getInt("id"),
                    rs.getString("nombre"));
            escenarioList.add(itemEscenario);
            System.out.println (rs.getInt("id"));
            System.out.println (rs.getString("nombre"));
        };
        //Testeamos que funcione
        System.out.println("Inicio de listar escenarios xclase");
        for (Escenario escenariox: escenarioList) {
            System.out.println(escenariox.getId());
            System.out.println(escenariox.getNombre());
        }
        System.out.println("Fin de listar escenarios");
     // Serializamos el objeto a json para enviarlo
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(escenarioList);
        return json;
    }

    @GetMapping("/GetListMovimientos")
    public String GetListMovimientos() throws SQLException, JsonProcessingException {
        System.out.println("get list escenario inicio");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver found / Encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found / no encontrado" + e);
        }
        //Creamos la conexion
        String url="jdbc:mysql://localhost:3306/smashbd";
        String user="root";
        String password="";
        Connection Conexion= null;
        //Nos conectamos y testeamos la conexion
        try {
            Conexion= DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }
        Statement s = Conexion.createStatement();

        // Instanciamos un listado de escenarios
        ResultSet rs = s.executeQuery ( "SELECT id, nombre,abreviatura FROM movimiento");
        List<Movimiento> movimientoList = new ArrayList<>();
        while (rs.next()) {
            System.out.println ("agregamos data al listado de ojbetos de escenario");
            Movimiento itemMovimiento = new Movimiento(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("abreviatura")
            );
            movimientoList.add(itemMovimiento);
            System.out.println (rs.getInt("id"));
            System.out.println (rs.getString("nombre"));
        };
        //Testeamos que funcione
        System.out.println("Inicio de listar escenarios xclase");
        for (Movimiento movimientox: movimientoList) {
            System.out.println(movimientox.getId());
            System.out.println(movimientox.getNombre());
            System.out.println(movimientox.getAbreviatura());
        }
        System.out.println("Fin de listar escenarios");
        // Serializamos el objeto a json para enviarlo
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(movimientoList);
        return json;
    }

    @GetMapping("/GetListPersonajes")
    public String GetListPersonajes() throws SQLException, JsonProcessingException {
        System.out.println("get list escenario inicio");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver found / Encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found / no encontrado" + e);
        }
        //Creamos la conexion
        String url="jdbc:mysql://localhost:3306/smashbd";
        String user="root";
        String password="";
        Connection Conexion= null;
        //Nos conectamos y testeamos la conexion
        try {
            Conexion= DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }
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
    }

    @GetMapping("/GetListPosicionesEscenarios")
    public String GetListPosicionesEscenarios() throws SQLException, JsonProcessingException {
        System.out.println("get list escenario inicio");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver found / Encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found / no encontrado" + e);
        }
        //Creamos la conexion
        String url="jdbc:mysql://localhost:3306/smashbd";
        String user="root";
        String password="";
        Connection Conexion= null;
        //Nos conectamos y testeamos la conexion
        try {
            Conexion= DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }
        Statement s = Conexion.createStatement();

        // Instanciamos un listado de escenarios
        ResultSet rs = s.executeQuery ( "SELECT id,  nombre ,verticalHorizontal,idPosicionComun,idEscenario FROM posicionescenario");
        List<PosicionEscenario> posicionEscenarioList = new ArrayList<>();
        while (rs.next()) {
            System.out.println ("agregamos data al listado de ojbetos de escenario");
            PosicionEscenario itemPosicionEscenario = new PosicionEscenario(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("verticalHorizontal"),
                    rs.getInt("idPosicionComun"),
                    rs.getInt("idEscenario")
                    );
            posicionEscenarioList.add(itemPosicionEscenario);
            System.out.println (rs.getInt("id"));
            System.out.println (rs.getString("nombre"));
        };
        //Testeamos que funcione
        System.out.println("Inicio de listar escenarios xclase");
        for (PosicionEscenario posicionEscenariox: posicionEscenarioList) {
            System.out.println(posicionEscenariox.getId());
            System.out.println(posicionEscenariox.getNombre());
        }
        System.out.println("Fin de listar escenarios");
        // Serializamos el objeto a json para enviarlo
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(posicionEscenarioList);
        return json;
    }

    //Aqui SPRINGBOOT aplica un patròn adaptador de forma automatica, debido a que
    //convierte el JSON que se envio a la clase "Registro"
    @PostMapping(value = "/PostRegistro" )
    @ResponseBody
    public String PostRegistro(@RequestBody Registro registro) throws SQLException {
        System.out.println("valor del body");
        System.out.println(registro.getId());
        System.out.println(registro.getIdPersonajeEmisor());
        System.out.println(registro.getIdPersonajeReceptor());
        System.out.println(registro.getIdMovimiento());
        System.out.println(registro.getIdPosicionEscenario());
        System.out.println(registro.getPorcentajeKO());

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver found / Encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found / no encontrado" + e);
        }
        //Creamos la conexion
        String url="jdbc:mysql://localhost:3306/smashbd";
        String user="root";
        String password="";
        Connection Conexion= null;
        //Nos conectamos y testeamos la conexion
        try {
            Conexion= DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }
        Statement stmt = Conexion.createStatement();
        //Por ahora solo agregare data de PS2 en posicion central del escenario
        stmt.executeUpdate("INSERT INTO registro(id" +
                ", idPersonajeEmisor, " +
                "idPersonajeReceptor," +
                " idMovimiento, " +
                "idPosicionEscenario," +
                " porcentajeKO) VALUES ("+ registro.getId()+ "," +
                "  "+registro.getIdPersonajeEmisor()+"  ," +
                ""+registro.getIdPersonajeReceptor()+"," +
                ""+registro.getIdMovimiento()+"," +
                "4" +
                ","+registro.getPorcentajeKO()+")");




        return "Buterfree ok";
    }





































    // Rutasd de ejemplo



    @PostMapping(value = "holapost" )
    @ResponseBody
    public String holaPost() {
        return "has hecho una peticion post";
    }

    @PostMapping(value = "holapostBody" )
    @ResponseBody
    public String holapostBody(@RequestBody Item item) {
        System.out.println("valor del body");
        System.out.println(item.getItemNo());
        System.out.println(item.getItemDesc());
        System.out.println(item.getItemprice());
        return "has hecho una peticion postbody";

    }

    @GetMapping
    public ResponseEntity<String> smashnotesBackGet() throws SQLException {
        System.out.println("Komoo aqui se codifica");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver found / Encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found / no encontrado" + e);
        }
        //Creamos la conexion
        String url="jdbc:mysql://localhost:3306/db-productos";
        String user="root";
        String password="";
        Connection con= null;
        //Nos conectamos y testeamos la conexion
        try {
            con=DriverManager.getConnection(url,user,password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }

        Statement s = con.createStatement();

        //3 ejecuta sql
        ResultSet rs = s.executeQuery ( "SELECT id, nombre FROM producto");

        //4- Recorrer el Resulset
        while (rs.next()) {
            //System.out.println (rs.getInt ("Id") + " " + rs.getString (2)+  " " + rs.getDate(3));
            System.out.println (rs.getInt("id"));
            System.out.println (rs.getString("nombre"));
        }


        return new ResponseEntity<String>("Hola  Charizard!", HttpStatus.OK);


    };

    @GetMapping("/Object")
    public List<Item>  getObject(){
        List<Item> itmList= Arrays.asList(
                new Item(1,"Item1 desc",100),
                new Item(2,"Item2",200));
        return itmList;
    }
}
