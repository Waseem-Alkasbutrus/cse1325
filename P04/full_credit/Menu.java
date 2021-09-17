import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    //Atributes
    private String prompt;
    ArrayList<String> options;

    //Constructors
    public Menu(String prompt, int optionCount) {
        this.prompt = prompt;
        this.options = new ArrayList<String>(optionCount);
    }

    public Menu(String prompt) {
        this.prompt = prompt;
        this.options = new ArrayList<String>(0);
    }

    //Methods
    public String getPrompt() {
        return prompt;
    }

    public String getOptions() {
        return options.toString();
    }

    public boolean appendOption(String newOption) {
        return options.add(newOption);
    }

    public void addOptionAt(int index, String newOption) {
        options.add(index, newOption);
    }

    public String removeOptionAt(int index) {
        return options.remove(index);
    }

    public String replaceOptionAt(int index, String newOption) {
        return options.set(index, newOption);
    }

    public int input() {
        Scanner scan = new Scanner(System.in);
    
        while (true) {
            System.out.printf("%s", this);
            String selectionInput = scan.nextLine();

            try {
                int selection = Integer.parseInt(selectionInput);
                
                if (selection > 0 && selection <= this.options.size()) {
                    return selection;
                } else {
                    System.out.println("\nSelection is out of bounds. Please try again.\n");
                }
            } catch (Exception e) {
                System.out.println("\nInvalid input. Please try again.\n");
            }
        }
    }

    @Override
    public String toString() {
        String menu = this.prompt + "\n";

        for (int i = 0; i < this.options.size(); i++) {
            menu += ((i + 1) + ". " + this.options.get(i) + "\n");
        }

        menu += ">> ";

        return menu;
    }
}