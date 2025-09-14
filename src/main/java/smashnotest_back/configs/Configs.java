package smashnotest_back.configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Configs {
    public static String url = "jdbc:postgresql://aws-1-us-east-2.pooler.supabase.com:6543/postgres?sslmode=require";
    public static String user = "postgres.bqdxudzlrisjvswtqpox";
    public static String password = "prueba1234";

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
