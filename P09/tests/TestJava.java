package tests;

import store.Java;
import store.Darkness;
import store.Shot;

public class TestJava {
    public static void main (String[] args) {
        Java java = new Java("Test Java", 3.99, 1.33, Darkness.medium);
        int numOfFailedTests = 0;

        //Test 1: Test if toString() returns the correct information
        final String javaString = java.toString();

        if (!javaString.equals("Test Java (medium with no shots) $3.99")) {
            numOfFailedTests++;

            System.out.println("\nTEST 1 FAILED: toString() did not return the java information correctly.");
            System.out.println("\tEXPECTED: \"Test Java (medium with no shots) $3.99\"");
            System.out.println("\tRETURNED: \"" + javaString + "\"");            
        }

        //Test 2:Test if addShot(Shot) correctly adds shots to the java
        java.addShot(Shot.peppermint);
        final String javaShots = java.toString();

        if (!javaShots.equals("Test Java (medium with peppermint) $3.99")) {
            numOfFailedTests++;

            System.out.println("\nTEST 2 FAILED: addShot(Shot) did no add a shot to the java correctly.");
            System.out.println("\tEXPECTED: \"Test Java (medium with peppermint) $3.99\"");
            System.out.println("\tRETURNED: \"" + javaShots + "\"");            
        }

        //Print Summary
        if (numOfFailedTests > 0) {
            System.out.println("\n" + numOfFailedTests + " TESTS FAILED");

            System.exit(1);
        }
    }
}