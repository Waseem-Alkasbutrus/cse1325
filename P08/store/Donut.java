package store;

public class Donut extends Product {
    protected Frosting frosting;
    protected boolean sprinkles;
    protected Filling filling;

    public Donut(String name, double price, double cost, Frosting frosting, boolean sprinkles, Filling filling) throws IllegalArgumentException {
        super(name, price, cost);
        if (frosting == Frosting.unfrosted && sprinkles) {
            throw new IllegalArgumentException("Cannot add sprinkles on an unfrosted donut");
        } 
        this.frosting = frosting;
        this.sprinkles = sprinkles;
        this.filling = filling;
    }

    @Override
    public String toString() {
        String donutString = super.name;
        if (sprinkles) {
            donutString += " with sprinkles";
        }
        
        if (this.frosting == Frosting.unfrosted) {
            donutString += " (" + this.frosting + " ";    
        } else {
            donutString += " (" + this.frosting + " frosting ";    
        }

        if (this.filling == Filling.unfilled) {
            donutString += this.filling + ") $";
        } else {
            donutString += this.filling + " filling) $";
        }

        donutString += super.price;
        
        return donutString;
    }
}