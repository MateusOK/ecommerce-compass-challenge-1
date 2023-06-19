package br.com.compass.pb.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {
    private static Connection connection;

    private static final String PASSWORD = ""; //set your database password
    private static final String USER = ""; //set your database user
    private static final String URL = ""; //usually: "jdbc:mysql://localhost:3306/"

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("An error occurred while trying to connect to the database");
            }
        }
        return connection;
    }


    public void createTable(){
        try {
            if (connection != null){
                Statement statement = connection.createStatement();
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS products(" + "id int auto_increment," +
                        "product_name varchar(100)," + "price double," + "quantity int," + "primary key(id)" + ")");
                statement.close();
            } else {
                System.out.println("Unable to create table!");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while trying to create the table");
        }
    }

    public void createDatabase(){
        try {
            if (connection != null) {
                Statement statement = connection.createStatement();
                statement.executeUpdate("CREATE DATABASE IF NOT EXISTS ecommerce");
                statement.executeUpdate("USE ecommerce");
                statement.close();
            } else {
                System.out.println("Unable to create database!");
            }
        } catch (SQLException e) {
            System.out.println("An error occurred while trying to create the database");
        }
    }


}
