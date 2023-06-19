package br.com.compass.pb.controller;

import br.com.compass.pb.model.Connector;

import java.sql.*;
import java.util.List;

import static br.com.compass.pb.controller.Products.getAllProducts;

public class Stock {

    private final Connection connection = Connector.getConnection();

    public void addProduct(Products prod) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO products (product_name, price, quantity) VALUES ('" +
                    prod.getName() + "', " + prod.getPrice() + ", " + prod.getQuantity() + ")");
            statement.close();
            System.out.println("Product added successfully.");
        } catch (SQLException e) {
            System.out.println("There was an error trying to add this product");
        }
    }

    public void removeProduct(int id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM products WHERE id ='" + id + "'");
            statement.close();
            System.out.println("Product removed successfully.");
        } catch (SQLException e) {
            System.out.println("There was an error trying to remove this product");
        }
    }

    public void updateProduct(Products prod, int id) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE products SET product_name='" +
                    prod.getName() + "', price=" + prod.getPrice() + ", quantity=" + prod.getQuantity() + " WHERE id='" + id + "'");
            statement.close();
            System.out.println("Product updated successfully.");
        } catch (SQLException e) {
            System.out.println("There was an error trying to update this product");
        }
    }

    public void updateProductQuantity(int productId, int quantity){
        try{
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE products SET quantity = (quantity - " + quantity + ") WHERE id = '" + productId + "'");
            statement.close();
            System.out.println("Product quantity updated successfully.");
        } catch (SQLException e) {
            System.out.println("Unable to update product quantity.");
        }
    }

    public boolean isProductExists(Products product) {
        List<Products> products = getAllProducts();
        for (Products existingProduct : products) {
            if (existingProduct.getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }


}
