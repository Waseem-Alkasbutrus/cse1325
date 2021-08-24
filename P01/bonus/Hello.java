import java.util.Scanner;

public class Hello{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("Enter your name:\n>> ");
        String name = scan.nextLine();

        System.out.printf("\nHello, %s!\n", name);
    }
}