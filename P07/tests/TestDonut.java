package tests;

import store.Donut;
import store.Filling;
import store.Frosting;

public class TestDonut {
    public static void main(String[] args) {
        Donut donut = new Donut("Test Donut", 0.99, .33, Frosting.chocolate, true, Filling.strawberry);
        int numOfFailedTests = 0;

        //Test 1: Test if toString() returns the correct information
        final String donutString = donut.toString();

        if (!donutString.equals("Test Donut with sprinkles (chocolate frosting strawberry filling) $0.99")) {
            numOfFailedTests++;

            System.out.println("\nTEST 1 FAILED: toString() did not return the donut information correctly.");
            System.out.println("\tEXPECTED: \"Test Donut with sprinkles (chocolate frosting strawberry filling) $0.99\"");
            System.out.println("\tRETURNED: \"" + donutString + "\"");   
        }

        //Print Summary
        if (numOfFailedTests > 0) {
            System.out.println("\n" + numOfFailedTests + " TESTS FAILED");

            System.exit(1);
        }
    }
}