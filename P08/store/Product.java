package store;

public class Product {
    protected String name;
    protected double price;
    protected double cost;

    public Product(String name, double price, double cost) {
        this.name = name;
        this.price = price;
        this.cost = cost;
    }

    public String name() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " @ $" + this.price + "(Costs $" + this.cost + ")";
    }
}