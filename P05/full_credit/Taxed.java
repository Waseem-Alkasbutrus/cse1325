public class Taxed extends Product {
    private static double tax;

    public Taxed (String name, double cost) {
        super(name, cost);
    }

    public static setSalesTaxRate (double salesTaxRate) {
        this.tax = salesTaxRate;
    }

    @Override
    public double price() {
        return quantity * unitCost * (1 + salesTaxRate);
    }
}