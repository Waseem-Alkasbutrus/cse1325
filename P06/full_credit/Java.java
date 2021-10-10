import java.util.ArrayList;

public class Java extends Product {
    protected Darkness darkness;
    protected ArrayList<Shot> shots;

    public Java(String name, double price, double cost, Darkness darkness) {
        super(name, price, cost);
        this.darkness = darkness;
        this.shots = new ArrayList<>(0);
    }

    public void addShot(Shot shot) {
        this.shots.add(shot);
    }

    @Override
    public String toString() {
        String javaString = super.name + " (" + this.darkness;
        if (this.shots.size() > 0) {
            javaString += " with ";
            for (Shot s : this.shots) {
                javaString += s + ", ";
            }
        } else {
            javaString += " with no shots";
        }
        javaString += ")";
        return javaString;
    }
}