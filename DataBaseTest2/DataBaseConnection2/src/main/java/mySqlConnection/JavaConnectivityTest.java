package mySqlConnection;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JavaConnectivityTest {

    static String URL = "jdbc:postgresql://localhost:5433/postgres";
    static String USER = "postgres";
    static String PASSWORD = "password";

    public static void main(String[] args) {

        try {
            testConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public static void testConnection() throws SQLException {

        try(Connection conn = DriverManager.getConnection(URL,USER,PASSWORD)){
            System.out.println("AVAILABLE");

            //GetMetadata from the connection to access database information
            DatabaseMetaData metaData = conn.getMetaData();

            //List all the data bases available
            try (ResultSet catalogs = metaData.getCatalogs()){
                System.out.println("Available Databases:");

                while(catalogs.next()){
                    String dbName = catalogs.getString(1);
                    System.out.println("- "+ dbName);
                }
            }
        }
    }
}