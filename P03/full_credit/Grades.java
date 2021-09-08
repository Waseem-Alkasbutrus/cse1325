import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        System.out.printf("Enter student name:\n>> ");
        
        Scanner scan = new Scanner(System.in);
        Student student = new Student(scan.nextLine());

        while(true) {
            int selection = menu();

            if (selection == 2) {
                System.out.printf("\n%s's average is: %.2f\n", student.getName(), student.average());
                
                System.exit(0);
            } else {
                System.out.printf("Enter exame grade:\n>> ");

                student.addExam(scan.nextDouble());
            }
        }
    }

    public static int menu() {
        
        while(true) {
            System.out.println("\nPlease select one:");
            System.out.println("1. Enter an additional exam grade");
            System.out.println("2. Calculate average and exit");
            System.out.printf(">> ");

            Scanner scan = new Scanner(System.in);
            char selection = scan.next().charAt(0);

            if (selection == '1') {
                return 1;
            } else if (selection == '2') {
                return 2;
            } else {
                System.out.println("Invalid selection. Please try again");
            }
        }
    }
}