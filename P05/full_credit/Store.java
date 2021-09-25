import java.util.ArrayList;

public class Store {
    //TODO: ask about absense of constructor

    public static void main (String[] args) {
        Store store = new Store();
    }

    public void cli() {
        ArrayList<Product> availableProducts = new ArrayList () {{
            add new Taxfree("Milk", 3.33);
            add new Taxfree("Eggs", 2.33);
            add new Taxfree("Bread", 2.48);
            add new Taxed("Ben & Jerry's", 4.38);
            add new Taxed("DumDums", 3.64);
            add new Taxed("Skittles", 2.28)
        }};
        ArrayList<Product> shoppingCart = new ArrayList();
        
        
    }
}