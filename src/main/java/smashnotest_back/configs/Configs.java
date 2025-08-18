package smashnotest_back.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configs {
    public static String url = "jdbc:postgresql://ep-nameless-mountain-a6a39ou0.us-west-2.aws.neon.tech:5432/dbsmash?sslmode=require";
    public static String user = "dbsmash_owner";
    public static String password = "npg_BNqzCT5rV0Iu";
//a
    public static Connection Conexion = null;

    public static void ConexionDB() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver PostgreSQL encontrado.");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver PostgreSQL no encontrado: " + e);
        }

        try {
            Configs.Conexion = DriverManager.getConnection(Configs.url, Configs.user, Configs.password);
            System.out.println("Conexión exitosa.");
        } catch (SQLException e) {
            System.out.println("Error en la conexión: " + e);
        }
    }
}
