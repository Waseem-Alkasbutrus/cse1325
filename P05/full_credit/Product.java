public abstract class Product {
    protected String name;
    protected double cost;
    protected int quantity;

    public Product (String name, double unitCost) {
        this.name = name;
        this.unitCost = unitCost;
    }

    public setQuantity (int quantity) {
        this.quantity = quantity;
    }

    public abstract price();

    @Override 
    public String toString() {
        return name + "\t\t\t" + (cost * quantity);
    }
}