package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class Server extends Person {
    String ssn;

    public Server(String name, String phone, String ssn) {
        super(name, phone);
        this.ssn = ssn;
    }

    public Server(BufferedReader bufferedReader) throws IOException {
        super(bufferedReader);
        this.ssn = bufferedReader.readLine();
    }

    @Override
    public void save(BufferedWriter bufferedWriter) throws IOException {
        bufferedWriter.write("SERVER");
        super.save(bufferedWriter);
        bufferedWriter.write(this.ssn + '\n');
    }
}