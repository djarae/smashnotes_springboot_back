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

@RestController
@RequestMapping("apiSmash")
public class SmashnotestBackController {
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
