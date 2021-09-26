import java.util.ArrayList;

public class Store {
    public static void main (String[] args) {
        Store store = new Store();

        store.cli();
    }

    public void cli() {
        ArrayList<Product> availableProducts = new ArrayList<> () {{
            add(new Taxfree("Milk", 3.33));
            add(new Taxfree("Eggs", 2.33));
            add(new Taxfree("Bread", 2.48));
            add(new Taxed("Ben & Jerry's", 4.38));
            add(new Taxed("DumDums", 3.64));
            add(new Taxed("Skittles", 2.28));
        }};

        ArrayList<Product> shoppingCart = new ArrayList();
        Menu menu = new Menu("Please select a product below:", availableProducts);

        menu.input();
    }
}