package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private int id;
    private static Integer nextId;
    private Server server;
    private Customer customer;
    private HashMap<Product, Integer> products;

    public Order(Customer customer, Server server) {
        this.customer = customer;
        this.server = server;
        if (nextId == null) {
            this.id = 0;
            nextId = 1;    
        } else {
            this.id = nextId;
            nextId++;
        }
        this.products = new HashMap<>();
    }
    
    public Order(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine(); //Read "CUSTOMER" written by Customer.save
        this.customer = new Customer(bufferedReader);
        
        bufferedReader.readLine(); //Read "SERVER" written by Server.save
        this.server = new Server(bufferedReader);
        
        this.id = Integer.parseInt(bufferedReader.readLine());
        if (nextId <= this.id || nextId == null) {
            nextId = this.id + 1;
        }
        
        this.products = new HashMap<>(Integer.parseInt(bufferedReader.readLine()));
        for (int i = 0; i < this.products.size(); i++) {
            int quantity = Integer.parseInt(bufferedReader.readLine());
            Product product = new Product(bufferedReader);
            this.products.put(product, quantity);
        }
    }

    public int getID() {
        return this.id;
    }

    public void addProduct(Product product, Integer quantity) {
        this.products.put(product, quantity);
    }

    public void save(BufferedWriter bufferedWriter) throws IOException {
        this.customer.save(bufferedWriter);
        this.server.save(bufferedWriter);
        bufferedWriter.write(Integer.toString(this.id));
        
        bufferedWriter.write(Integer.toString(this.products.size()));
        for (Map.Entry<Product, Integer> p : this.products.entrySet()) {
            bufferedWriter.write(Integer.toString(p.getValue()) + '\n');
            bufferedWriter.write(p.getKey().toString() + '\n');
        }
    }

    @Override
    public String toString() {
        String orderString = "Order " + this.id + " for " + this.customer.toString() + "\nServer: " + this.server.toString() + "\n";
        double totalPrice = 0;

        for (Map.Entry<Product, Integer> p : this.products.entrySet()) {
            orderString += p.getValue() + " " + p.getKey() + "\n";
            totalPrice += p.getValue() * p.getKey().price;
        }

        orderString += "Total price: $" + totalPrice;

        return orderString;
    }
}