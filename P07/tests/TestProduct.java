import store.Product;

public class TestProduct {
    public static void main (String[] args) {
        Product product = new Product("Test Product", 2.99, 1.49);
        int numOfFailedTests = 0;

        //Test 1: Test that name() returns the name of the product correctly
        final String productName = product.name();

        if (!productName.equals("Test Product")) {
            numOfFailedTests++;

            System.out.println("\nTEST 1 FAILED:name() method did not return product name correctly.");
            System.out.println("\tEXPECTED: \"Test Product\"");
            System.out.println("\tRETURNED: \"" + productName + "\"");
        }

        //Test 2: Test that toString() returns the correct information
        final String productString = product.toString();

        if (!productString.equals("Test Product @ $2.99(Costs $1.49)")) {
            numOfFailedTests++;

            System.out.println("\nTEST 2 FAILED:toString() method did not return product information correctly.");
            System.out.println("\tEXPECTED: \"Test Product @ $2.99(Costs $1.49)\"");
            System.out.println("\tRETURNED: \"" + productString + "\"");
        }

        //Print Summary
        if (numOfFailedTests > 0) {
            System.out.println("\n" + numOfFailedTests + " TESTS FAILED");

            System.exit(1);
        }
    }
}