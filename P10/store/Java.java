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
        this.shots = new ArrayList<>(0);
        int shotCount = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < shotCount; i++) {
            this.shots.add(Shot.valueOf(bufferedReader.readLine().replaceAll("\n", "")));
        }
    }

    public void save(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write("JAVA\n");
        super.save(bufferedWriter);
        bufferedWriter.write(this.darkness.name() + '\n');

        bufferedWriter.write(Integer.toString(this.shots.size()) + '\n');
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
        String seperator = "";
        if (this.shots.size() > 1) {
            javaString += " with ";

            for (Shot s : this.shots) {
                javaString += seperator + s;
                seperator = ", ";
            }
        } else {
            javaString += " with no shots";
        }
        javaString += ") $" + super.price;
        return javaString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return true;
        if (this.getClass() != o.getClass()) return false;
        Java java = (Java) o;
        return (super.equals(java)) && (this.darkness == java.darkness) && (this.shots.equals(java.shots));
    }
}