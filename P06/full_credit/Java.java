import java.util.ArrayList;

public class Java extends Product {
    protected Darkness darkness;
    protected ArrayList<Shot> shots;

    public Java(String name, double price, double cost, Darkness darkness) {
        super(name, price, cost);
        this.darkness = darkness;
    }

    public void addShot(Shot shot) {
        this.shots.add(shot);
    }

    @Override
    public String toString() {
        String javaString = super.name + " (" + this.darkness + " " + this.shots.get(0);
        for (int i = 1; i < this.shots.size(); i++) {
            javaString += this.shots.get(i);
        }
        javaString += ")";
        return javaString;
    }
}