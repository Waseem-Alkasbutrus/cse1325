public class TestStore {
    Store store = new Store("JADE");
    int numOfFailedTests = 0;

    //TEST 1: Test storeName() returns correct store name
    String final storeName = store.storeName();
    
    if (!storeName.equals("Jade")) {
        numOfFailedTests++;

        System.out.println("\nTEST 1 FAILED: storeName() method did not return name correctly.");
        System.out.println("\tEXPECTED: \"JADE\"");
        System.out.println("\tRETURNED: \"" + storeName + "\"");
    }

    //Test 2: Test addProduct(Product) adds a product correctly
    //Test 3: Test numberOfProducts() returns the correct count
    //Test 4: Test toString(int) prints the correct product info
    //Test 5: Test toString() prints the correct information
}