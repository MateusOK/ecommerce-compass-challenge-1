package br.com.compass.pb.controller;

public class Checkout {

    Stock stock;
    ShoppingCart cart;

    public Checkout(ShoppingCart cart, Stock stock) {
        this.cart = cart;
        this.stock = stock;
    }

    public void totalPrice() {
        cart.showProducts();
        double totalPrice = 0;
        for (Products product : cart.getProducts()) {
            totalPrice += product.getPrice() * product.getQuantity();
        }
        System.out.println("Total price of your cart: " + totalPrice + "\n");
    }

    public void finishCheckout(){
        System.out.println("Purchase complete, thank you!");
        for(Products product : cart.getProducts()){
            stock.updateProductQuantity(product.getId(), product.getQuantity());
        }
    }

}