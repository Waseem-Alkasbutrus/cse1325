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

        mainMenu.appendOption("Add items to shopping cart");
        mainMenu.appendOption("Checkout items");


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
            }
        }
    }
}