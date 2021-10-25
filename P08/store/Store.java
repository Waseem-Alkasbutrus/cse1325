package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Store {
    protected String storeName;
    protected ArrayList<Product> products;

    public Store(String storeName) {
        this.storeName = storeName;
        products = new ArrayList<>();
    }

    public Store(BufferedReader bufferedReader) throws IOException{
        this.storeName = bufferedReader.readLine();
        this.products = new ArrayList<>();
        for (int i = 0; i < Integer.parseInt(bufferedReader.readLine()); i++) {
            this.products.add(new Product(bufferedReader));
        }
    }

    public void save(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write(this.storeName + '\n');
        bufferedWriter.write(Integer.toString(this.products.size()) + '\n');
        for (Product p : this.products) {
            p.save(bufferedWriter);
        }
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
        String storeString = "\nWelcome to " + this.storeName + "!\n\n";
        for (Product p: this.products) {
            storeString += p.toString() + "\n";
        }
        return storeString;
    }
}