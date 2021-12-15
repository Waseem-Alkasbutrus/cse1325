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

    public double price() {
        return this.price;
    }

    public double cost() {
        return this.cost;
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

    @Override 
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (this.getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return (this.name.equals(product.name)) && (this.price == product.price) && (this.cost == product.cost);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = (31*hash) + this.name.hashCode() + Double.hashCode(this.price) + Double.hashCode(this.cost);
        return hash;
    }
}