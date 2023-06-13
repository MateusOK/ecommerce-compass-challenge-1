package br.com.compass.pb.controller;
import br.com.compass.pb.model.Connector;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class Products {

    private Integer id;
    private String name;
    private double price;
    private Integer quantity;

    public Products(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }


    void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static Set<Products> getAllProducts() {
        Set<Products> products = new HashSet<>();
        Connection connection = Connector.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("product_name");
                Double price = resultSet.getDouble("price");
                Integer quantity = resultSet.getInt("quantity");

                Products product = new Products(name, price, quantity);
                product.setId(id); // Set the ID obtained from the database
                products.add(product);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}


