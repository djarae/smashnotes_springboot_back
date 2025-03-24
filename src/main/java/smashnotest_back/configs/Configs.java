package smashnotest_back.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class Configs {
    //Datos a conexion a produccion a
     public static String url = "jdbc:postgresql://ep-shrill-cell-a5wddks2.us-east-2.aws.neon.tech:5432/neondb"; public static String user="neondb_owner"; public static String password="x2umTeFRS8bA";
    //Datos a conexion a desarrollo x
   //public static String  url="jdbc:postgresql://localhost:5432/postgres"; public static String user="postgres"; public static String password="mipostgre345";
    public static Connection Conexion= null;
    public static void ConexionDB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("driver found / Encontrado");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found / no encontrado" + e);
        }
        try {
            Configs.Conexion= DriverManager.getConnection(Configs.url, Configs.user, Configs.password);
            System.out.println("Conexion exitosa");
        } catch (SQLException e) {
            System.out.println("Error en la conexion" + e);
        }

    }
}
