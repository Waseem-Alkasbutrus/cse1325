import java.util.ArrayList;
import java.util.Scanner;
import cart.Product;
import cart.Taxed;
import cart.Taxfree;

public class Store {
    private Scanner scan = new Scanner(System.in);

    public static void main (String[] args) {
        Store store = new Store();

        Taxed.setSalesTaxRate(0.08);

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
        ArrayList<Product> shoppingCart = new ArrayList<Product>(0);
        Menu productsMenu = new Menu("Please select a product below:", availableProducts);

        Menu mainMenu = new Menu("Please select an option:");
        mainMenu.appendOption("Add Items to Cart");
        mainMenu.appendOption("View Cart");
        
        Menu cartMenu = new Menu("Please select an optoin:");
        cartMenu.appendOption("Keep Shopping");
        cartMenu.appendOption("Checkout Cart");

        while(true) {
            int mainMenuSelection = mainMenu.input();

            if (mainMenuSelection == 1) {
                int productSelection = productsMenu.input(); 

                while (true) {
                    try {
                        System.out.printf("Enter the quantity you would like to add:\n>> ");
                        int productQuantity = Integer.parseInt(scan.nextLine());

                        try {
                            shoppingCart.add(availableProducts.get(productSelection - 1).placeOrder(productQuantity));
                            break;
                        }  catch (IllegalArgumentException e) {
                            System.out.println("\n" + e.getMessage() + "\n");
                        }

                    } catch (Exception e) {
                        System.out.println("\nInvalid input. Please try again.\n");
                    }
                }
            } else if (mainMenuSelection == 2) { 
                if (shoppingCart.size() == 0) {
                    System.out.println("\nYou have nothing in your cart.");
                } else {
                    System.out.println("\nCurrent Order:");

                    for (int i = 0; i < shoppingCart.size(); i++) {
                        System.out.println("\t" + shoppingCart.get(i));
                    }

                    System.out.printf("Total due: $%.2f\n", calculateTotal(shoppingCart));
                }

                int cartMenuSelection = cartMenu.input();
 
                if (cartMenuSelection == 2) {
                    System.out.println("\nThanks for shopping with us!");
                    break;
                }
            }
        }
    }

    public double calculateTotal(final ArrayList<Product> shoppingCart) {
        double totalDue = 0;

        for (int i = 0; i < shoppingCart.size(); i++) {
            totalDue += shoppingCart.get(i).price();
        }

        return totalDue;
    }
}