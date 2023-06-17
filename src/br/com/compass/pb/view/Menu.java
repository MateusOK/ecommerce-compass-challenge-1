package br.com.compass.pb.view;

import br.com.compass.pb.controller.Checkout;
import br.com.compass.pb.controller.Products;
import br.com.compass.pb.controller.ShoppingCart;

import java.util.List;
import java.util.Scanner;

class Menu {
    private ShoppingCart cart;
    private Checkout checkout;

    public Menu(ShoppingCart cart, Checkout checkout) {
        this.cart = cart;
        this.checkout = checkout;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            displayMenu();
            choice = scanner.nextInt();

            switch (choice) {
                case 1 -> displayAllProducts();
                case 2 -> addToCart(scanner);
                case 3 -> removeFromCart(scanner);
                case 4 -> cart.showProducts();
                case 5 -> {
                    checkout.totalPrice();
                    proceedCheckout(scanner);
                }
                case 6 -> System.out.println("Exiting the program...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 6);

        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Display all products");
        System.out.println("2. Add a product to the cart");
        System.out.println("3. Remove a product from the cart");
        System.out.println("4. See your cart");
        System.out.println("5. Checkout");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private void displayAllProducts() {
        List<Products> products = Products.getAllProducts();
        System.out.println("\n Available products:");
        for (Products product : products) {
            System.out.println("ID: " + product.getId() + " - Name: " + product.getName()
                    + " - $" + product.getPrice() + " - Stock: " + product.getQuantity());
        }
        System.out.println();
    }

    private void addToCart(Scanner scanner) {
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

    private void removeFromCart(Scanner scanner) {
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

    private Products findProductById(String productId) {
        List<Products> products = Products.getAllProducts();
        for (Products product : products) {
            if (product.getId().equals(Integer.parseInt(productId))) {
                return product;
            }
        }
        return null;
    }

    private void proceedCheckout(Scanner scanner) {
        System.out.print("Proceed checkout[Y or N]: ");
        String choice = scanner.next();
        if (choice.contains("Y") || choice.contains("y")) {
            checkout.finishCheckout();
        } else {
            System.out.println("Cancelled purchase!");
        }
    }
}
