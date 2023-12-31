package br.com.compass.pb.controller;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Products> products = new ArrayList<>();

    public List<Products> getProducts() {
        return products;
    }
    public void addProduct(Products product){
        if(product.getQuantity() <= product.getProductQuantity(product.getId())){
            this.products.add(product);
            System.out.println("Product added to cart");
        }
        else{System.out.println("Product quantity not available, out of stock");}
    }

    public void removeProduct(Products product){
        if(this.products.contains(product)){
            this.products.remove(product);
            System.out.println("Product removed from cart");
        }
        else{System.out.println("There was a problem removing this product from cart");}
    }

    public void showProducts(){
        Integer totalProducts = 0;
        System.out.print("Products: ");
        for (Products p : products) {
            System.out.print(p.getName() + ", ");
            totalProducts += p.getQuantity();
        }
        System.out.println("\n Total of products in cart: " + totalProducts);
    }

}
