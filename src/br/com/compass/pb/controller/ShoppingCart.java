package br.com.compass.pb.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ShoppingCart {

    private List<Products> products = new ArrayList<>();

    public void addProduct(Products product){
        if(product.getQuantity() > 0){
            this.products.add(product);
            System.out.println("Product added to cart");
        }
        else{System.out.println("Product not available, out of stock");}
    }

    public void removeProduct(Products product){
        if(this.products.contains(product)){
            this.products.remove(product);
            System.out.println("Product removed from cart");
        }
        else{System.out.println("There was a problem removing this product from cart");}
    }

    public void showProducts(){
        System.out.println("\n Total of products in cart: " + this.products.size());
        System.out.print("Products: ");
        for (Products p : products) {
            System.out.print(p.getName() + ", ");
        }
    }

}
