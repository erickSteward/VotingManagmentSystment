package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {

    private static String URL = "jdbc:postgresql://localhost:4747/votingDB";
    private static String USER = "postgres";
    private static String PASSWORD = "1234";

    static {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("MySQL JDBC Driver is loaded!");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found.");
            e.printStackTrace();
        }
    }

    public static Connection getConnetion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
