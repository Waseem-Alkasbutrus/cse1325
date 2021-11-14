package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.util.HashMap;

public class Order {
    private int id;
    private static Integer nextId;
    private Server server;
    private Customer customer;
    private HashMap<Product, Integer> orders;

    public Order(Customer customer, Server server) {
        this.customer = customer;
        this.server = server;
        if (nextId != null) {
            this.id = 0;
            nextId = 1;    
        } else {
            this.id = nextId;
            nextId++;
        }
        this.orders = new HashMap<>();
    }
    
    public Order(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine(); //Read "CUSTOMER" written by Customer.save
        this.customer = new Customer(bufferedReader);
        bufferedReader.readLine(); //Read "SERVER" written by Server.save
        this.server = new Server(bufferedReader);
        //TODO: handle id
        this.orders = new HashMap<>();
    }

    public int getID() {
        return this.id;
    }

    public void addProduct(Product product) {
        //TODO: Implement this
    }

    public void save(BufferedWriter bufferedWriter) throws IOException {
        this.customer.save(bufferedWriter);
        this.server.save(bufferedWriter);
        //TODO: handle id
        bufferedWriter.write(Integer.toString(this.orders.size()));

    }

    @Override
    public String toString() {
        String orderString = "Order " + this.id + " for " + this.customer.toString() + "\nServer: " + this.server.toString();

        //TODO: add products and quantities to string

        return orderString;
    }
}