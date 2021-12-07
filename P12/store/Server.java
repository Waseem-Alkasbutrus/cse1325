package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Server extends Person {
    String ssn;
    int filledOrders;

    public Server(String name, String phone, String ssn) {
        super(name, phone);
        this.ssn = ssn;
        this.filledOrders = 0;
    }

    public Server(BufferedReader bufferedReader) throws IOException {
        super(bufferedReader);
        this.ssn = bufferedReader.readLine();
    }

    public void fillOrder() {
        this.filledOrders++;
    }

    public int filledOrders() {
        return this.filledOrders;
    }

    public Object[] serverReport() {
        Object[] report = new Object[4];

        report[0] = super.name;
        report[1] = super.phone;
        report[2] = this.ssn;
        report[3] = this.filledOrders;

        return report;
    }

    public String getSSN() {
        return this.ssn;
    }

    @Override
    public void save(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write("SERVER" + '\n');
        super.save(bufferedWriter);
        bufferedWriter.write(this.ssn + '\n');
    }

    @Override
    public String toString() {
        return "Server " + this.name + " (" + this.phone + ")";
    } 
}