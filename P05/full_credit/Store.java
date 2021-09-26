import java.util.ArrayList;

public class Store {
    //TODO: ask about absense of constructor

    public static void main (String[] args) {
        Store store = new Store();

        store.cli();
    }

    public void cli() {
        ArrayList<Product> availableProducts = new ArrayList () {{
            new Taxfree("Milk", 3.33);
            new Taxfree("Eggs", 2.33);
            new Taxfree("Bread", 2.48);
            new Taxed("Ben & Jerry's", 4.38);
            new Taxed("DumDums", 3.64);
            new Taxed("Skittles", 2.28);
        }};
        ArrayList<Product> shoppingCart = new ArrayList();
        Menu menu = new Menu("Please select a product below:", availableProducts);

        menu.input();
    }
}