public class MenuTest{
    public static void main(String[] args) {
        Menu menu = new Menu("Select an option below:", 2);
        int numOfFailedTests = 0;

        //TEST 1: Verify the prompt provided to the constructor is correctly returned by the getPrompt() method
        final String menuPrompt = menu.getPrompt();

        if (menuPrompt != "Select an option below:") {
            numOfFailedTests++;

            System.out.println("\nTEST 1 FAILED: getPrompt() method did not return prompt correctly.");
            System.out.println("\tEXPECTED: \"Select an option below:\"");
            System.out.println("\tRETURNED: \"" + menuPrompt + "\"");
        }

        //TEST 2: Verify that the options are properly returned by the  getOptions() method
        menu.appendOption("OPTION 1");
        menu.appendOption("OPTION 2");
        final String menuOptions = menu.getOptions();
        
        if (!menuOptions.equals("[OPTION 1, OPTION 2]")) {
            numOfFailedTests++;

            System.out.println("\nTEST 2 FAILED: getOptions() method did not return options correctly.");
            System.out.println("\tEXPECTED: \"[OPTION 1, OPTION 2]\"");
            System.out.println("\tRETURNED: \"" + menuOptions + "\"");
        }

        

        if (numOfFailedTests > 0) {
            System.out.println("\n" + numOfFailedTests + " TESTS FAILED");

            System.exit(1);
        }
    }
}