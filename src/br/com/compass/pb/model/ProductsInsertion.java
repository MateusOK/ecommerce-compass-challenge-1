package br.com.compass.pb.model;

import br.com.compass.pb.controller.Products;
import br.com.compass.pb.controller.Stock;

import java.util.HashSet;
import java.util.Set;

public class ProductsInsertion {

    private final Set<Products> products;
    private final Stock stock;

    Connector connection;

    public ProductsInsertion() {
        products = new HashSet<>();
        stock = new Stock();
        connection = new Connector();
    }

    public void insertProducts() {
        connection.createDatabase();
        connection.createTable();

        products.add(new Products(0, "keyboard", 250.99, 6));
        products.add(new Products(1, "television", 799.99, 9));
        products.add(new Products(2, "smartphone", 1200.59, 17));
        products.add(new Products(3, "playstation 5", 4999.89, 86));
        products.add(new Products(4, "microphone", 99.99, 12));
        products.add(new Products(5, "monitor", 600.00, 4));
        products.add(new Products(6, "toilet paper", 3.50, 125));

        for(Products prod : products){
            stock.addProduct(prod);
        }
    }
}
