import store.Java;
import store.Darkness;
import store.Shot;

public class TestJava {
    public static void main (String[] args) {
        Java java = new Java("Test Java", 3.99, 1.33, Darkness.medium);
        int numOfFailedTests = 0;

        //Test 1: Test if toString() returns the correct information
        final String javaString = java.toString();

        if (!javaString.equals("Test Java (medium with no shots)")) {
            numOfFailedTests++;

            System.out.println("\nTEST 1 FAILED: toString() did not return the java information correctly.");
            System.out.println("\tEXPECTED: \"Test Java (medium with no shots)\"");
            System.out.println("\tRETURNED: \"" + javaString + "\"");            
        }

        //Test 2:Test if addShot(Shot) correctly adds shots to the java
        java.addShot(Shot.peppermint);
        final String javaShots = java.toString();

        if (!javaString.equals("Test Java (medium with no shots)")) {
            numOfFailedTests++;

            System.out.println("\nTEST 1 FAILED: toString() did not return the java information correctly.");
            System.out.println("\tEXPECTED: \"Test Java (medium with no shots)\"");
            System.out.println("\tRETURNED: \"" + javaString + "\"");            
        }

        //Print Summary
        if (numOfFailedTests > 0) {
            System.out.println("\n" + numOfFailedTests + " TESTS FAILED");

            System.exit(1);
        }
    }
}