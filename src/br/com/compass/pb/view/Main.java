package br.com.compass.pb.view;

import br.com.compass.pb.controller.Checkout;
import br.com.compass.pb.controller.Products;
import br.com.compass.pb.controller.ShoppingCart;
import br.com.compass.pb.controller.Stock;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static ShoppingCart cart;
    public static Checkout checkout;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        cart = new ShoppingCart();
        checkout = new Checkout(cart, new Stock());

        int choice;

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
                    removeFromCart(scanner);
                    break;
                case 4:
                    cart.showProducts();
                    break;
                case 5:
                    checkout.totalPrice();
                    proceedCheckout(scanner);
                    break;
                case 6:
                    System.out.println("Exiting the program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Display all products");
        System.out.println("2. Add a product to the cart");
        System.out.println("3. Remove a product from the cart");
        System.out.println("4. See your cart");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void displayAllProducts() {
        List<Products> products = Products.getAllProducts();
        System.out.println("\n Available products:");
        for (Products product : products) {
            System.out.println("ID: "+ product.getId() + " - Name: " + product.getName()
                    + " - $" + product.getPrice() + " - Stock: " + product.getQuantity());
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
            cart.addProduct(new Products(selectedProduct.getId(), selectedProduct.getName(), selectedProduct.getPrice(), quantity));
        } else {
            System.out.println("Invalid product ID");
        }
        System.out.println();
    }

    private static void removeFromCart(Scanner scanner) {
        System.out.print("Enter the product ID: ");
        String productId = scanner.next();

        Products selectedProduct = findProductById(productId);
        if (selectedProduct != null) {
            cart.removeProduct(selectedProduct);
        } else {
            System.out.println("Invalid product ID");
        }
        System.out.println();
    }

    private static Products findProductById(String productId) {
        List<Products> products = Products.getAllProducts();
        for (Products product : products) {
            if (product.getId().equals(Integer.parseInt(productId))) {
                return product;
            }
        }
        return null;
    }

    private static void proceedCheckout(Scanner scanner){
        System.out.print("Proceed checkout[Y or N]: ");
        String choice = scanner.next();
        if (choice.contains("Y") || choice.contains("y")){
            checkout.finishCheckout();
        }
        else {
            System.out.println("Cancelled purchase!");
        }
    }

}