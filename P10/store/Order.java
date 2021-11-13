package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Order {
    private int id;
    private static Integer nextId;
    private Server server;
    private Customer customer;

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
    }
    
    public Order(BufferedReader bufferedReader) throws IOException {
        bufferedReader.readLine(); //Read "CUSTOMER" written by Customer.save
        this.customer = new Customer(bufferedReader);
        bufferedReader.readLine(); //Read "SERVER" written by Server.save
        this.server = new Server(bufferedReader);
        //TODO: handle id
    }

    public void save(BufferedWriter bufferedWriter) throws IOException {
        this.customer.save(bufferedWriter);
        this.server.save(bufferedWriter);
        //TODO: handle id
    }
}