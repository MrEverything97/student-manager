package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    final static String URL = "jdbc:sqlserver://10.1.47.66:1433;databaseName=BetLol";
    final static String USERNAME = "sa";
    final static String PASSWORD = "Bet@1234";

    public Connector() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("connect successfully!");
        }catch (ClassNotFoundException | SQLException e){
            System.out.println("connect failure!");
            e.printStackTrace();
        }
        return connection;
    }
}
