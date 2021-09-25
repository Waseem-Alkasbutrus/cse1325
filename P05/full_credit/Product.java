public abstract class Product {
    //Attributes
    protected final String name;
    protected final double unitCost;
    protected int quantity;
    
    //Abstract methods
    public abstract Product placeOrder(int quantity);
    public abstract double price();

    //TODO: throw exception if unitCost is negative
    public Product (String name, double unitCost) throws BadArgumentException{
        this.name = name;
        this.unitCost = unitCost;
        this.quantity = 0;
    }

    @Override 
    public String toString() {
        if (quantity == 0) {
            return String.format("%s ($%.2f)", name, unitCost);
        } else {
            return String.format("%s (%d @ $%.2f)", name, unitCost);
        }
    }
}