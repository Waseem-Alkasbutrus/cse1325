package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Customer extends Person {
    public Customer(String name, String phone) {
        super(name, phone);
    }

    public Customer(BufferedReader bufferedReader) throws IOException {
        super(bufferedReader);
    }

    @Override
    public void save(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write("CUSTOMER\n");
        super.save(bufferedWriter);
    }

    @Override
    public String toString() {
        return "Customer: " + super.name + " (" + super.phone + ")";
    }
}