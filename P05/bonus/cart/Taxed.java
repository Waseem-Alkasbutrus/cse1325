/**
 Represents a grocery product with a slaes tax.

 @author               Waseem Alkasbutrus
 @version              1.0
 @since                1.0
 @license.agreement    Gnu General PUblic License 3.0
 */

package cart;

public class Taxed extends Product {
    private static double tax;

    /**
    Creates a Taxed instance with a name and unitCost
    
    @param name         The name of this product
    @param cost         The cost of one unit of this taxed product 
    @since              1.0
    */
    public Taxed (String name, double cost) {
        super(name, cost);
    }

    /**
    Sets the sales tax rate for all Taxed products
    
    @param salesTaxRate     The tax rate to be applied to the price 
    @since                  1.0
    */
    public static void setSalesTaxRate (double salesTaxRate) {
        tax = salesTaxRate;
    }

    @Override
    /**
    Creates a new instance of this Taxed product with a different quantity.

    @param quantity                         The number of units of this product.
    @return                                 A new product object with the specified quantity.  
    @throws IllegalArgumentException        If quantity is less than 1
    @since                                  1.0
     */
    public Product placeOrder(int quantity) throws IllegalArgumentException {
        if (quantity < 1) {
            throw new IllegalArgumentException("Order must have a quantity of 1 or more");
        }

        Product product = new Taxed(this.name, this.unitCost);
        product.quantity = quantity;

        return product;
    }

    /**
    Calculates the price of this product including tax.
    
    @return             The total price for this product including tax (quantity * unitCost * (1 + tax)) 
    @since              1.0
    */
    public double price() {
        return quantity * unitCost * (1 + tax);
    }
}