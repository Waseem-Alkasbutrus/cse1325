public abstract class Product {
    protected final String name;
    protected final double unitCost;
    protected int quantity;
    
    public abstract Product placeOrder(int quantity) throws IllegalArgumentException;
    public abstract double price();

    public Product (String name, double unitCost) throws IllegalArgumentException {
        if (unitCost < 0) {
            throw new IllegalArgumentException("Unit cost cannot be less than zero");
        }

        this.name = name;
        this.unitCost = unitCost;
        this.quantity = 0;
    }

    @Override 
    public String toString() {
        if (quantity == 0) {
            return String.format("%-15s ($%.2f)", name, unitCost);
        } else {
            return String.format("%-15s (%d @ $%.2f)", name, quantity, unitCost);
        }
    }
}