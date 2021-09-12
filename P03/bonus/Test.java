public class Test{
    public static void main(String[] args) {
        Student student = new Student("Waseem Alkasbutrus");
        int numOfFailedTests = 0; //0 if all tests passed, otherwise number of failed tests 

        //TEST 1: Verify the name provided to the constructor is correctly returned by the getName) method
        final String studentName = student.getName();

        if (studentName != "Waseem Alkasbutrus") {
            numOfFailedTests++;

            System.out.println("\nTEST 1 FAILED: getName() method did not return name correctly.");
            System.out.println("\tEXPECTED: \"Waseem Alkasbutrus\"");
            System.out.println("\tRETURNED: \"" + studentName + "\"");
        }

        //TEST 2: Verify that if no exam grades have been provided via method addExam(double), method average() returns 100
        final double emptyExamSumAverage = student.average();

        if (emptyExamSumAverage != (double) 100) {
            numOfFailedTests++;

            System.out.println("\nTEST 2 FAILED: average() method did not return a 100 when no grades have been entered using addExam(double) method.");
            System.out.println("\tEXPECTED: 100");
            System.out.println("\tRETURNED: " + emptyExamSumAverage + "");
        }

        //TEST 3:  Verify that when 2 or more exam grades have been provided via method addExam(double), method average() returns the correct average of the exam grades
        student.addExam(100);
        student.addExam(50);
        final double studentAverage = student.average();
        
        if (studentAverage != (double) 75) {
            numOfFailedTests++;

            System.out.println("\nTEST 3 FAILED: average() method did not return the correct average after two non-zero grades have been entered using addExam(double) method.");
            System.out.println("\tEXPECTED: 75");
            System.out.println("\tRETURNED: " + studentAverage + "");
        }

        if (numOfFailedTests > 0) {
            System.out.println("\n" + numOfFailedTests + " TESTS FAILED");

            System.exit(1);
        }
    }
}