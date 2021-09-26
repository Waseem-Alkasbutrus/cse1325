import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    private Scanner scan = new Scanner(System.in);

    public static void main (String[] args) {
        Store store = new Store();

        store.cli();
    }

    public void cli() {
        ArrayList<Product> availableProducts = new ArrayList<Product> () {{
            add(new Taxfree("Milk", 3.33));
            add(new Taxfree("Eggs", 2.33));
            add(new Taxfree("Bread", 2.48));
            add(new Taxed("Ben & Jerry's", 4.38));
            add(new Taxed("DumDums", 3.64));
            add(new Taxed("Skittles", 2.28));
        }};
        ArrayList<Product> shoppingCart = new ArrayList(0);
        Menu productsMenu = new Menu("Please select a product below:", availableProducts);

        Menu mainMenu = new Menu("Please select an option:");
        mainMenu.appendOption("Add Items to Cart");
        mainMenu.appendOption("View Cart");
        
        Menu cartMenu = new Menu("Please select an optoin:");
        cartMenu.appendOption("Checkout Cart");
        cartMenu.appendOption("Keep Shopping");

        while(true) {
            int mainMenuSelection = mainMenu.input();
            if (mainMenuSelection == 1) {
                int productSelection = productsMenu.input(); 

                while (true) {
                    try {
                        System.out.printf("Enter the quantity you would like to add:\n>> ");
                        int productQuantity = Integer.parseInt(scan.nextLine());
                        //TODO: place prder properly 
                        //shoppingCart.add(availableProducts.get(productSelection - 1).placeOrder());

                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("\n" + e.getMessage() + "\n");
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again.");
                    }
                }
            } else if (mainMenuSelection == 2) { 
                if (shoppingCart.size() == 0) {
                    System.out.println("You have nothing in your cart.");
                } else {
                    System.out.println("Current Order:");

                    for (int i = 0; i < shoppingCart.size(); i++) {
                        System.out.println("\t" + shoppingCart.get(i));
                    }

                    System.out.println("Total due: " + calculateTotal(shoppingCart));
                }

                int cartMenuSelection = cartMenu.input();
 
                if (cartMenuSelection == 2) {
                    System.out.println("Thanks for shopping with us!");
                    break;
                }
            }
        }
    }

    public double calculateTotal(final ArrayList shoppingCart) {
        double totalDue;

        for (int i = 0; i < shoppingCart.size(); i++) {
            totalDue += shoppingCart.get(i).price();
        }

        return totalDue;
    }
}