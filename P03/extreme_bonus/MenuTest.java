public class MenuTest{
    public static void main(String[] args) {
        Menu startMenu = new Menu("Select an option below:", 3);
        startMenu.appendOption("PLAY");
        startMenu.appendOption("SETTINGS");
        startMenu.appendOption("EXIT");

        startMenu.printMenu();

        System.out.println();

        startMenu.replaceOptionAt(1, "CREDITS");
        startMenu.addOptionAt(2, "Options");

        startMenu.input();
    }
}