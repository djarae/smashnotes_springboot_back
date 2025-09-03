package smashnotest_back.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configs {
    public static String url = "jdbc:postgresql://ep-spring-water-af90xnsw-pooler.c-2.us-west-2.aws.neon.tech:5432/neondb?sslmode=require&channelBinding=require";
    public static String user = "neondb_owner";
    public static String password = "npg_ioWd4GHDzj7J";

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
