package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

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

    public Donut(BufferedReader bufferedReader) throws IOException, IllegalArgumentException {
        super(bufferedReader);
        this.frosting = Frosting.valueOf(bufferedReader.readLine().replaceAll("\n", ""));
        this.sprinkles = Boolean.parseBoolean(bufferedReader.readLine());
        if (this.frosting == Frosting.unfrosted && this.sprinkles) {
            throw new IllegalArgumentException("Cannot add sprinkles on an unfrosted donut");
        }
        this.filling = Filling.valueOf(bufferedReader.readLine().replaceAll("\n", ""));
    } 

    public void save(BufferedWriter bufferedWriter) throws IOException, IllegalArgumentException {
        super.save(bufferedWriter);
        bufferedWriter.write(this.frosting.name() + '\n');
        bufferedWriter.write(Boolean.toString(this.sprinkles) + '\n');
        bufferedWriter.write(this.filling.name() + '\n');
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