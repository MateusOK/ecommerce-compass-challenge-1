// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Products prod1 = new Products("AAABBVV", "Detergente", 3.90, 5 );
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(prod1);

        cart.showProducts();


        }
    }