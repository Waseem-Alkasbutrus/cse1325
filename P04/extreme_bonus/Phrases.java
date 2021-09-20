import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;

public class Phrases {
    private ArrayList<String> phrases;

    public Phrases (String filename) {
        FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        
        while (true) {
            String fileLine = bufferedReader.readLine();

            if (fileLine == null) {
                break;
            } else {
                phrases.add(fileLine);
            }
        }
    }

    public String getPhrase() {
        int phraseIndex = (int) (Math.random() * (double) this.phrases.size());

        System.out.println(phraseIndex);

        return this.phrases.get(phraseIndex);
    }

    public static void main(String[] args) {
        Phrases phrases = new Phrases("file.txt");

        System.out.println(phrases.getPhrase());
    }
}