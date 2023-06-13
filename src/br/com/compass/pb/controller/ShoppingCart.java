package br.com.compass.pb.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class ShoppingCart {

    private List<Products> products = new ArrayList<>();

    public String addProduct(Products product){
        if(product.getQuantity() > 0){
            this.products.add(product);
            System.out.println("Product added to cart");
        }
        else{System.out.println("Product not available, out of stock");}
        return null;
    }

    public String removeProduct(Products product){
        if(this.products.remove(product)){
            return "Product removed from cart";
        }
        else{return "There was a problem adding this product to cart";}
    }

    public void showProducts(){
        System.out.println("Total of products in cart: " + this.products.size());
        System.out.print("Products: ");
        for (Products p : products) {
            System.out.print(p.getName() + ", ");
        }
    }

}
