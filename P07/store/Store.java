import java.util.ArrayList;

public class Store {
    protected String storeName;
    protected ArrayList<Product> products;

    public Store(String storeName) {
        this.storeName = storeName;
        products = new ArrayList<>(0);
    }

    public String storeName() {
        return this.storeName;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public int numberOfProducts() {
        return products.size();
    }

    public String toString(int productIndex) {
        return this.products.get(productIndex).toString();
    }

    @Override
    public String toString() {
        String storeString = this.storeName + "\n";
        for (Product p: this.products) {
            storeString += p.toString() + "\n";
        }
        return storeString;
    }
}