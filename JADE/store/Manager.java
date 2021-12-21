package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Manager extends Person {
    String pin;

    public Manager(String name, String phone, String pin) {
        super(name, phone);
        this.pin = pin;
    }

    public Manager(BufferedReader bufferedReader) throws IOException {
        super(bufferedReader);
        this.pin = bufferedReader.readLine();
    }

    @Override
    public void save(BufferedWriter bufferedWriter) throws IOException {
        super.save(bufferedWriter);
        bufferedWriter.write(this.pin + '\n');
    }
    
    @Override
    public String toString() {
        return "Manager: " + super.name + " (" + super.phone + ")";
    }
}
