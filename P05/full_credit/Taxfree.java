public class Taxfree extends Product {
    public Taxfree (String name, double cost) {
        super(name, cost);
    }

    @Override
    public Product placeOrder(int quantity) {
        Product product = new Taxfree(this.name, this.cost);
        product.setQuantity(quantity);

        return product;
    }

    public double price() {
        return unitCost * quantity;
    }
}