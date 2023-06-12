package br.com.compass.pb.controller;

import java.util.Collection;
import java.util.HashSet;

public class ShoppingCart {

    private Collection<Products> products = new HashSet<>();

    public String addProduct(Products product){
        if(product.getQuantity() > 0){
            this.products.add(product);
            return "Product added to cart";
        }
        else{return "Product not available, out of stock";}
    }

    public String removeProduct(Products product){
        if(this.products.remove(product)){
            return "Product removed from cart";
        }
        else{return "There was a problem adding this product to cart";}
    }

    public void showProducts(){
        System.out.println("br.com.compass.pb.controller.Products in cart: " + this.products.size());
    }

}
