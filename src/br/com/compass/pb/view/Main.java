package br.com.compass.pb.view;

import br.com.compass.pb.controller.Products;
import br.com.compass.pb.controller.ShoppingCart;
import br.com.compass.pb.controller.Stock;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static ShoppingCart cart;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        cart = new ShoppingCart();

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayAllProducts();
                    break;
                case 2:
                    addToCart(scanner);
                    break;
                case 3:
                    cart.showProducts();
                    break;
                case 4:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 4);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("Menu:");
        System.out.println("1. Display all products");
        System.out.println("2. Add a product to the cart");
        System.out.println("3. See your cart");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void displayAllProducts() {
        Set<Products> products = Products.getAllProducts();
        System.out.println("Available products:");
        for (Products product : products) {
            System.out.println(product.getId() + " - " + product.getName() + " - $" + product.getPrice());
        }
        System.out.println();
    }

    private static void addToCart(Scanner scanner) {
        System.out.print("Enter the product ID: ");
        String productId = scanner.next();

        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();

        Products selectedProduct = findProductById(productId);
        if (selectedProduct != null) {
            String result = cart.addProduct(new Products(selectedProduct.getName(), selectedProduct.getPrice(), quantity));
            System.out.println(result);
        } else {
            System.out.println("Invalid product ID");
        }
        System.out.println();
    }


    private static Products findProductById(String productId) {
        Set<Products> products = Products.getAllProducts();
        for (Products product : products) {
            if (product.getId().equals(Integer.parseInt(productId))) {
                return product;
            }
        }
        return null;
    }

}