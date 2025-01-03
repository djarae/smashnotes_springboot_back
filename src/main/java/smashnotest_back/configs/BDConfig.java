package smashnotest_back.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class BDConfig {
    //Datos:
    //Datos a conexion a produccion
    //  public static String url = "jdbc:postgresql://ep-shrill-cell-a5wddks2.us-east-2.aws.neon.tech:5432/neondb"; public static String user="neondb_owner"; public static String password="x2umTeFRS8bA";
    //Datos a conexion a desarrollo
    public static String  url="jdbc:mysql://localhost:3306/smashbd"; public static String user="root"; public static String password="";
    public static Connection Conexion= null;

    public static void ConexionDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver found / Encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found / no encontrado" + e);
        }
        try {
            BDConfig.Conexion= DriverManager.getConnection(BDConfig.url,BDConfig.user,BDConfig.password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }

    }




}
