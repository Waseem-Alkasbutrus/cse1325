package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Store {
    protected String storeName;
    protected ArrayList<Product> products;
    protected ArrayList<Person> people;

    public Store(String storeName) {
        this.storeName = storeName;
        this.products = new ArrayList<>(0);
        this.people = new ArrayList<>(0);
    }

    public Store(BufferedReader bufferedReader) throws IOException{
        this(bufferedReader.readLine());
       
        int numOfProducts = Integer.parseInt(bufferedReader.readLine());
        int numOfPeople = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < numOfProducts; i++) {
            String productType = bufferedReader.readLine();
            if (productType.equals("JAVA")) {
                this.products.add(new Java(bufferedReader));
            } else if (productType.equals("DONUT")) {
                this.products.add(new Donut(bufferedReader));
            }
        }

        for(int i = 0; i < numOfPeople; i++) {
            String personType = bufferedReader.readLine();
            if (personType.equals("CUSTOMER")) {
                this.people.add(new Customer(bufferedReader));
            } else if (personType.equals("SERVER")) {
                //TODO: Add new server to people
            } else if (personType.equals("MANAGER")) {
                //TODO: Add new manager to people
            }
        }
    }

    public void save(BufferedWriter bufferedWriter) throws IOException, RuntimeException {
        bufferedWriter.write(this.storeName + '\n');
        
        bufferedWriter.write(Integer.toString(this.products.size()) + '\n');
        bufferedWriter.write(Integer.toString(this.people.size()) + '\n');
        
        for (Product p : this.products) {           
            p.save(bufferedWriter);
        }

        for (Person p : this.people) {
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
        return this.products.size();
    }

    public String toString(int productIndex) {
        return this.products.get(productIndex).toString();
    }
    
    public void addPerson(Person person) {
        this.people.add(person);
    }
    
    public int numberOfPeople() {
        return this.people.size();
    }

    public String personToString(int peopleIndex) {
        return this.people.get(peopleIndex).toString();
    }

    public String peopleToString() {
        String peopleString = "\nOur Beloved Customers!\n\n";
        for (Person p : this.people) {
            peopleString += p.toString() + '\n';
        }
        return peopleString;
    }

    @Override
    public String toString() {
        String storeString = "\nWelcome to " + this.storeName + "!\n\n";
        for (Product p: this.products) {
            storeString += p.toString() + '\n';
        }
        return storeString;
    }
}