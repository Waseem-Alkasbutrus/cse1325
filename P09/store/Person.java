package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

class Person {
    protected String name;
    protected String phone;

    public Person(String name, String phone) {
        this.name = name;
        this.name = phone;
    }

    public Person(BufferedReader bufferedReader) throws IOException {
        this.name = bufferedReader.readLine();
        this.phone = bufferedReader.readLine();
    }

    public void save(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write(this.name + '\n');
        bufferedWriter.write(this.phone + '\n');
    }

    @Override
    public String toString() {
        return this.name + " (" + this.phone + ")";
    }
}