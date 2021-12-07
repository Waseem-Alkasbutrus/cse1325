package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JTable;

public class Store {
    protected String storeName;
    protected ArrayList<Product> products;
    protected ArrayList<Person> people;
    protected ArrayList<Order> orders;

    public Store(String storeName) {
        this.storeName = storeName;
        this.products = new ArrayList<>(0);
        this.people = new ArrayList<>(0);
        this.orders = new ArrayList<>(0);
    }

    public Store(BufferedReader bufferedReader) throws IOException{
        this(bufferedReader.readLine());
       
        int numOfProducts = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < numOfProducts; i++) {
            String productType = bufferedReader.readLine();
            if (productType.equals("JAVA")) {
                this.products.add(new Java(bufferedReader));
            } else if (productType.equals("DONUT")) {
                this.products.add(new Donut(bufferedReader));
            }
        }
        
        int numOfPeople = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < numOfPeople; i++) {
            String personType = bufferedReader.readLine();
            if (personType.equals("CUSTOMER")) {
                this.people.add(new Customer(bufferedReader));
            } else if (personType.equals("SERVER")) {
                this.people.add(new Server(bufferedReader));
            } else if (personType.equals("MANAGER")) {
                //TODO: Add new manager to people
            }
        }
        
        int numOfOrders = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < numOfOrders; i++) {
            this.orders.add(new Order(bufferedReader));
        }
    }

    public void save(BufferedWriter bufferedWriter) throws IOException, RuntimeException {
        bufferedWriter.write(this.storeName + '\n');
        
        bufferedWriter.write(Integer.toString(this.products.size()) + '\n');
        for (Product p : this.products) {           
            p.save(bufferedWriter);
        }
        
        bufferedWriter.write(Integer.toString(this.people.size()) + '\n');
        for (Person p : this.people) {
            p.save(bufferedWriter);
        }
        
        bufferedWriter.write(Integer.toString(this.orders.size()) + '\n');
        for (Order o : this.orders) {
            o.save(bufferedWriter);
        }
    }

    public String storeName() {
        return this.storeName;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }
    
    public void editProduct(Product oldProduct, Product newProduct) {
        for (int i = 0; i < this.products.size(); i++) {
            if (this.products.get(i).equals(oldProduct)) {
                this.products.set(i, newProduct);
                break;
            }
        }
    }

    public int numberOfProducts() {
        return this.products.size();
    }

    public String toString(int productIndex) {
        return this.products.get(productIndex).toString();
    }
    
    public Object[] getProducts() {
        return this.products.toArray();
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

    public Object[] getCustomers() {
        ArrayList<Customer> customers = new ArrayList<>();
        for (Person p : this.people) {
            if (p instanceof Customer) {
                customers.add((Customer) p);
            }
        }
        return customers.toArray();
    }

    public Object[] getServers() {
        ArrayList<Server> servers = new ArrayList<>();
        for (Person p : this.people) {
            if (p instanceof Server) {
                servers.add((Server) p);
            }
        }
        return servers.toArray();
    }

    public ArrayList<Object[]> serverReport() {
        ArrayList<Object[]> report = new ArrayList<>();
        for (Object o : this.getServers()) {
            Server s = (Server) o;
            report.add(s.serverReport());
        }
        return report;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public int numberOfOrders() {
        return this.orders.size();
    }

    public String orderToString(int orderIndex) {
        return this.orders.get(orderIndex).toString();
    }

    public ArrayList<Object[]> PnLReport() {
        ArrayList<Object[]> report = new ArrayList<>(0);
        double income = 0;//total price
        double costs = 0;//total costs

        for (Order o : this.orders) {
            report.addAll(o.PnLReport());

            income += o.income();
            costs += o.cost();
        }

        Object[] total = {"Total", String.format("$%.2f", income), String.format("$%.2f", costs), String.format("$%.2f", income - costs)};
        report.add(total);
        
        return report;
    }

    public Order[] getOrders() {
        return (Order[]) this.orders.toArray();
    }

    public String ordersToString() {
        String ordersString = "\nWelcome to " + this.storeName + "!\n\nCurrent Orders\n\n";
        for (Order o : this.orders) {
            ordersString += o.toString() + '\n';
        }
        return ordersString;
    }

    public String peopleToString() {
        String peopleString = "\nWelcome to " + this.storeName + "!\n\nOur Beloved People!\n\n";
        for (Person p : this.people) {
            peopleString += p.toString() + '\n';
        }
        return peopleString;
    }

    @Override
    public String toString() {
        String storeString = "\nWelcome to " + this.storeName + "!\n\nOur Featured Products:\n\n";
        for (Product p: this.products) {
            storeString += p.toString() + '\n';
        }
        return storeString;
    }
}