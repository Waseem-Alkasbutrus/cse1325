public class Taxed extends Product {
    private static double tax;

    public Taxed (String name, double cost) {
        super(name, cost);
    }

    public static setSalesTaxRate (double salesTaxRate) {
        this.tax = salesTaxRate;
    }

    @Override
    public Product placeOrder(int quantity) IllegalArgumentException {
        if (quantity < 1) {
            throw new IllegalArgumentException("Order must have a quantity of atleast 1");
        }
        
        Product product = new Taxed(this.name, this.cost);
        product.setQuantity(quantity);

        return product;
    }

    public double price() {
        return quantity * unitCost * (1 + tax);
    }
}