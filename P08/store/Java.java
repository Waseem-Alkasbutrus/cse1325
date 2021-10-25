package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Java extends Product {
    protected Darkness darkness;
    protected ArrayList<Shot> shots;

    public Java(String name, double price, double cost, Darkness darkness) {
        super(name, price, cost);
        this.darkness = darkness;
        this.shots = new ArrayList<>(0);
    }

    public Java(BufferedReader bufferedReader) throws IOException {
        super(bufferedReader);
        this.darkness = Darkness.valueOf(bufferedReader.readLine().replaceAll("\n", ""));
        for (int i = 0; i < Integer.parseInt(bufferedReader.readLine()); i++) {
            this.shots.add(Shot.valueOf(bufferedReader.readLine().replaceAll("\n", "")));
        }
    }

    public void save(BufferedWriter bufferedWriter) throws IOException {
        super.save(bufferedWriter);
        bufferedWriter.write(this.darkness.name() + '\n');
        bufferedWriter.write(this.shots.size() + '\n');
        for (Shot s : this.shots) {
            bufferedWriter.write(s.name() + '\n');
        }
    }

    public void addShot(Shot shot) {
        this.shots.add(shot);
    }

    @Override
    public String toString() {
        String javaString = super.name + " (" + this.darkness;
        if (this.shots.size() > 0) {
            javaString += " with ";
            for (int i = 0; i < (this.shots.size() - 1); i++) {
                javaString += this.shots.get(i) + ", ";
            }
            javaString += this.shots.get(this.shots.size() - 1);
        } else {
            javaString += " with no shots";
        }
        javaString += ") $" + super.price;
        return javaString;
    }
}