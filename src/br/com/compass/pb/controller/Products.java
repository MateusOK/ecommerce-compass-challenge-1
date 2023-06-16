package br.com.compass.pb.controller;
import br.com.compass.pb.model.Connector;

import java.sql.*;
import java.util.*;

public class Products {

    private Integer id;
    private String name;
    private double price;
    private Integer quantity;

    private static final Connection connection = Connector.getConnection();

    public Products(Integer id, String name, Double price, Integer quantity) {
        this.id = id;
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

    public double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public static List<Products> getAllProducts() {
        List<Products> products = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("product_name");
                Double price = resultSet.getDouble("price");
                Integer quantity = resultSet.getInt("quantity");

                Products product = new Products(id, name, price, quantity);
                products.add(product);
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public Integer getProductQuantity(Products product){
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT quantity FROM products WHERE id ='" + product.getId() + "'");

            while(resultSet.next()){
                Integer quantity = resultSet.getInt("quantity");
            }

        } catch (SQLException e) {
            System.out.println("Error trying to get quantity from database");;
        }

        return quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products product = (Products) o;
        return Objects.equals(id, product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}


