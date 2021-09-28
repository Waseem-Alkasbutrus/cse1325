package cart;

/**
 Represents a grocery product with no slaes tax.

 @author               Waseem Alkasbutrus
 @version              1.0
 @since                1.0
 @license.agreement    Gnu General PUblic License 3.0
 */
public class Taxfree extends Product {
    /**
    Creates an instance of a Taxfree product with a name and cost.

    @param name         The name of this product
    @param cost         The cost of one unit of this tax-free product 
    @since              1.0
    */
    public Taxfree (String name, double cost) {
        super(name, cost);
    }

    @Override
    /**
    Creates a new instance of this Taxfree product with a different quantity.

    @param quantity                         The number of units of this product.
    @return                                 A new product object with the specified quantity.
    @throws IllegalArgumentException        If quantity is less than 1  
    @since                                  1.0
     */
    public Product placeOrder(int quantity) throws IllegalArgumentException {
        if (quantity < 1) {
            throw new IllegalArgumentException("Order must have a quantity 1 or more");
        }

        Product product = new Taxfree(this.name, this.unitCost);
        product.quantity = quantity;

        return product;
    }

    /**
    Calculates the price of this product.
    
    @return             The total price for this product (quantity * unitCost) 
    @since              1.0
    */
    public double price() {
        return unitCost * quantity;
    }
}