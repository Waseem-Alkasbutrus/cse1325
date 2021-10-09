import java.util.ArrayList;

public class Main {
    public Store store;

    public Main(String storeName) {
        this.store = new Store(storeName);
    }

    public static void main(String[] args) {
        Main main = new Main("Totally Not StarBucks :)");

        Java blackCoffee = new Java("Black Coffee", 2.25, 1.50, Darkness.light);
        Java hazlenutCoffee = new Java("Hazlenut Coffee", 2.25, 1.50, Darkness.medium);
        hazlenutCoffee.addShot(Shot.hazelnut);
        Java mochaLatte = new Java("Mocha Latte", 4.35, 2.50, Darkness.dark);
        mochaLatte.addShot(Shot.chocolate);

        main.store.addProduct(blackCoffee);
        main.store.addProduct(hazlenutCoffee);
        main.store.addProduct(mochaLatte);

        main.cli();
    }

    public void cli() {
        Menu mainMenu = new Menu("Select an Option:", new String[]{"Add Java", "Add Donut", "Exit"});
        Menu javaMenu = new Menu("Select a Coffee:");
        javaMenu.appendOption(this.store);
        while(true) {
            switch(mainMenu.input()) {
                case 1: //Add Java
                    break;
                case 2: //Add Donut
                    javaMenu.input();
                    break;
                case 3: //Exit
                    System.out.println("Thank you for shopping at " + this.store.storeName());
                    System.exit(0);
            }
        }
    }
}