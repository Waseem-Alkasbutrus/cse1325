public class TestStore {
    public static void main(String[] args) {
        Store store = new Store("JADE");
        int numOfFailedTests = 0;

        store.addProduct(new Product("Test Product", 2.99, 1.49));
        
        //TEST 1: Test storeName() returns correct store name
        final String storeName = store.storeName();

        if (!storeName.equals("JADE")) {
            numOfFailedTests++;

            System.out.println("\nTEST 1 FAILED: storeName() method did not return name correctly.");
            System.out.println("\tEXPECTED: \"JADE\"");
            System.out.println("\tRETURNED: \"" + storeName + "\"");
        }

        //Test 2: Test numberOfProducts() returns the correct count
        final int numOfProducts = store.numberOfProducts();

        if (numOfProducts != 1) {
            numOfFailedTests++;

            System.out.println("\nTEST 2 FAILED: numberOfProducts() method did not return the count correctly.");
            System.out.println("\tEXPECTED: \"1\"");
            System.out.println("\tRETURNED: \"" + numOfProducts + "\"");
        }

        //Test 3: Test toString(int) prints the correct product information
        final String firstProduct =  store.toString(0);

        if (!firstProduct.equals("Test Product @ $2.99(Costs $1.49)")) {
            numOfFailedTests++;

            System.out.println("\nTEST 3 FAILED: toString(int) did not return the correct product information.");
            System.out.println("\tEXPECTED: \"Test Product @ $2.99(Costs $1.49)\"");
            System.out.println("\tRETURNED: \"" + firstProduct + "\"");
        }

        //Test 5: Test toString() prints the correct information
        final String storeString = store.toString();

        if (!storeString.equals("JADE\nTest Product @ $2.99(Costs $1.49)\n")) {
            numOfFailedTests++;

            System.out.println("\nTEST 3 FAILED: toString() did not return the correct store information.");
            System.out.println("\tEXPECTED: \"JADE\nTest Product @ $2.99(Costs $1.49)\n\"");
            System.out.println("\tRETURNED: \"" + storeString + "\"");
        }
        
        //Print Summary
        if (numOfFailedTests > 0) {
            System.out.println("\n" + numOfFailedTests + " TESTS FAILED");

            System.exit(1);
        }
    }
}