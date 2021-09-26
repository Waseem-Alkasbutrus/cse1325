/**
 Represents a grocery product for sale.



 @author               Waseem Alkasbutrus
 @version              1.0
 @since                1.0
 @license.agreement    Gnu General PUblic License 3.0
 */

package cart;

public abstract class Product {
    /**
    The name of this product 
    */
    protected final String name;
    /**
    The cost of one unit if this product 
    */
    protected final double unitCost;
    /**
    If zero, indicates this instance is on the store shelf or website If positive, is the number of units in the shopping cart 
    */
    protected int quantity;
    
    /**
    Creates a new Product object with a specified quantity.
    
    @param quantity     The number of units of this product.
    @return             A new product object. 
    @throws IllegalArgumentException
    @since              1.0
    */
    public abstract Product placeOrder(int quantity) throws IllegalArgumentException;
    /**
    Calculates the price of this product.
    
    @return             The total price for this product 
    @since              1.0
    */
    public abstract double price();

    /**
    Creates a Product instance with a name and unit cost.
    
    @param name                         The name of this product
    @param unitCost                     The cost of one unit of this product
    @throws IllegalArgumentException    If unitCost is negative
    @since                              1.0
    */
    public Product (String name, double unitCost) throws IllegalArgumentException {
        if (unitCost < 0) {
            throw new IllegalArgumentException("Unit cost cannot be less than zero");
        }

        this.name = name;
        this.unitCost = unitCost;
        this.quantity = 0;
    }

    @Override 
    /** 
    Returns the string represntation of Product
    @since             1.0
    */
    public String toString() {
        if (quantity == 0) {
            return String.format("%-15s ($%.2f)", name, unitCost);
        } else {
            return String.format("%-15s (%d @ $%.2f)", name, quantity, unitCost);
        }
    }
}