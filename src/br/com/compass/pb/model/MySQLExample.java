package br.com.compass.pb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLExample {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establish the connection to the database
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Create a statement object
            statement = connection.createStatement();

            // Execute a SQL query
            String query = "SELECT * FROM test";
            resultSet = statement.executeQuery(query);

            // Iterate over the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("client_name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the result set, statement, and connection in reverse order
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
