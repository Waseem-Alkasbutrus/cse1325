public class Donut extends Product {
    protected Frosting frosting;
    protected boolean sprinkles;
    protected Filling filling;

    public Donut(String name, double price, double cost, Frosting frosting, boolean sprinkles, Filling filling) throws IllegalArgumentException {
        if (frosting == unfrosted && sprinkles) {
            throw new IllegalArgumentException("Cannot add sprinkles on an unfrosted donut");
        } 
        super(name, price, cost);
        this.frosting = frosting;
        this.sprinkles = sprinkles;
        this.filling = filling;
    }

    @Override
    public String toString() {
        //TODO: complete method
    }
}