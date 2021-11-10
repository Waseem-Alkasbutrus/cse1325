package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Product {
    protected String name;
    protected double price;
    protected double cost;

    public Product(String name, double price, double cost) {
        this.name = name;
        this.price = price;
        this.cost = cost;
    }

    public Product(BufferedReader bufferedReader) throws IOException {
        this.name = bufferedReader.readLine();
        this.price = Double.parseDouble(bufferedReader.readLine());
        this.cost = Double.parseDouble(bufferedReader.readLine());
    }

    public String name() {
        return this.name;
    }

    public void save(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write(this.name + '\n');
        bufferedWriter.write(Double.toString(this.price) + '\n');
        bufferedWriter.write(Double.toString(this.cost) + '\n');
    }

    @Override
    public String toString() {
        return this.name + " @ $" + this.price + "(Costs $" + this.cost + ")";
    }
}