public abstract class Product {
    protected final String name;
    protected final double unitCost;
    protected int quantity;

    //TODO: throw exception if unitCost is negative
    public Product (String name, double unitCost) {
        this.name = name;
        this.unitCost = unitCost;
        this.quantity = 0;
    }

    public setQuantity (int quantity) {
        this.quantity = quantity;
    }

    public abstract Product placeOrder(int quantity);

    public abstract double price();

    @Override 
    public String toString() {
        if (quantity == 0) {
            return String.format("%s ($%.2f)", name, unitCost);
        } else {
            return String.format("%s (%d @ $%.2f)", name, unitCost);
        }
    }
}