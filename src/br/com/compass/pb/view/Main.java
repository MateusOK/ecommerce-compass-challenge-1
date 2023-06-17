package br.com.compass.pb.view;

import br.com.compass.pb.controller.Checkout;
import br.com.compass.pb.controller.ShoppingCart;
import br.com.compass.pb.controller.Stock;
import br.com.compass.pb.model.ProductsInsertion;

public class Main {

    public static void main(String[] args) {

        new ProductsInsertion().insertProducts();

        ShoppingCart cart = new ShoppingCart();
        Checkout checkout = new Checkout(cart, new Stock());

        new Menu(cart, checkout).run();

    }
}