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
        this.id = Integer.parseInt(bufferedReader.readLine());
        if (nextId == null) {
            nextId = this.id + 1;
        } else if (nextId <= this.id) {
            nextId = this.id + 1;
        }

        bufferedReader.readLine(); //Read "CUSTOMER" written by Customer.save
        this.customer = new Customer(bufferedReader);
        
        bufferedReader.readLine(); //Read "SERVER" written by Server.save
        this.server = new Server(bufferedReader);
        
        int numOfProducts = Integer.parseInt(bufferedReader.readLine());
        this.products = new HashMap<>(numOfProducts);
        for (int i = 0; i < numOfProducts; i++) {
            int quantity = Integer.parseInt(bufferedReader.readLine());
            Product product;
            
            String productType = bufferedReader.readLine();
            if (productType.equals("DONUT")) {
                product = new Donut(bufferedReader);
            } else if (productType.equals("JAVA")) {
                product = new Java(bufferedReader);
            } else {
                throw new IOException("Unrecognizable product type");
            }
            
            this.products.put(product, quantity);
        }
    }

    public void save(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write(Integer.toString(this.id) + '\n');

        this.customer.save(bufferedWriter);
        this.server.save(bufferedWriter);
        
        bufferedWriter.write(Integer.toString(this.products.size()) + '\n');
        for (Map.Entry<Product, Integer> p : this.products.entrySet()) {
            bufferedWriter.write(Integer.toString(p.getValue()) + '\n');
            p.getKey().save(bufferedWriter);
        }
    }
    
    public int getID() {
        return this.id;
    }

    public void addProduct(Product product, Integer quantity) {
        this.products.put(product, quantity);
    }

    @Override
    public String toString() {
        String orderString = "Order " + this.id + " for " + this.customer.toString() + "\nServer: " + this.server.toString() + "\n";
        double totalPrice = 0;

        for (Map.Entry<Product, Integer> p : this.products.entrySet()) {
            orderString += p.getValue() + " " + p.getKey() + "\n";
            totalPrice += p.getValue() * p.getKey().price;
        }

        orderString += "Total price: $" + totalPrice + '\n';

        return orderString;
    }
}