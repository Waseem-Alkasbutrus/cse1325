import java.util.ArrayList;
import java.util.Scanner;

public class Gradebook {
    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<Student>();
        Menu menu = new Menu("Select one of the following:", 4);

        menu.appendOption("Add new students");
        menu.appendOption("Add exam grades");
        menu.appendOption("List all averages");
        menu.appendOption("Exit");

        while (true) {
            int menuSelection = menu.input();
            
            switch (menuSelection) {
                case 1:
                    addNewStudents(studentList);
                    break;
                case 2:
                    if (studentList.size() == 0) {
                        System.out.println("\nNo students have been added yet. Try adding some first\n");
                    } else {
                        addNewGrades(studentList);
                    }
                    break;
                case 3: 
                    if (studentList.size() == 0) {
                        System.out.println("\nNo students have been added yet. Try adding some first\n");
                    } else {
                        listAllAverages(studentList);
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
                default: 
                    System.err.println("Invalid return from Menu.input()");
                    System.exit(1);
            }
        }
    }

    private static void addNewStudents(ArrayList<Student> studentList) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println();
        
        while (true) {
            System.out.printf("Enter new student's name\n>> ");
            String studentNameInput = scan.nextLine();
            
            if (studentNameInput.equals("")) {
                break;
            } else {
                studentList.add(new Student(studentNameInput));
            }
        }

        System.out.println();
    }

    private static void addNewGrades(ArrayList<Student> studentList) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println();

        for (int i = 0; i < studentList.size(); i++) {
            System.out.printf("Enter %s's grade\n>> ", studentList.get(i).getName());
            double studentGradeInput = 0;
            try {
                studentGradeInput = scan.nextDouble();
            } catch (Exception e) {
                System.err.println("Invalid double. Please try again.");
                i--;
                continue;
            }
            
            studentList.get(i).addExam(studentGradeInput);
        }

        System.out.println();
    }

    private static void listAllAverages(ArrayList<Student> studentList) {
        System.out.printf("\n%15s%10s\n", "Student Name", "Average");
        for(int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }
        System.out.println();
    }
}