public class Taxed extends Product {
    private static double tax;

    public Taxed (String name, double cost) {
        super(name, cost);
    }

    public static void setSalesTaxRate (double salesTaxRate) {
        tax = salesTaxRate;
    }

    @Override
    public Product placeOrder(int quantity) throws IllegalArgumentException {
        if (quantity < 1) {
            throw new IllegalArgumentException("Order must have a quantity of 1 or more");
        }

        Product product = new Taxed(this.name, this.unitCost);
        product.quantity = quantity;

        return product;
    }

    public double price() {
        return quantity * unitCost * (1 + tax);
    }
}