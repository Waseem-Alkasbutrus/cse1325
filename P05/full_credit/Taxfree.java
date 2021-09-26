public class Taxfree extends Product {
    public Taxfree (String name, double cost) {
        super(name, cost);
    }

    @Override
    public Product placeOrder(int quantity) throws IllegalArgumentException {
        if (quantity < 1) {
            throw new IllegalArgumentException("Order must have a quantity 1 or more");
        }

        Product product = new Taxfree(this.name, this.unitCost);
        product.quantity = quantity;

        return product;
    }

    public double price() {
        return unitCost * quantity;
    }
}