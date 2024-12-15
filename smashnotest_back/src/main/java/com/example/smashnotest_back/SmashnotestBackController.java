package com.example.smashnotest_back;
import java.sql.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
import java.util.List;

// await fetch('http://127.0.0.1:8080/api/v1/democors');
@RestController
@RequestMapping("apiSmash")
public class SmashnotestBackController {

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

}
