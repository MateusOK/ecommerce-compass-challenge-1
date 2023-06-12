package br.com.compass.pb.controller;

import java.sql.*;

public class Stock {

    private Connection connection;

    public Stock() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "1234");
        } catch (SQLException e) {
            System.out.println("Failed to connect to database");
        }
    }

    public void addProduct() {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("insert into products values (1 ,\"soap\", 2.49, 5)");
            statement.close();
            System.out.println("Product added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
