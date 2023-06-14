package br.com.compass.pb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "1234");
            } catch (SQLException e) {
                System.out.println("An error occurred while trying to the database");
            }
        }
        return connection;
    }
}
