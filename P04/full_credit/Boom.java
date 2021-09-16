import java.util.Scanner;


public class Boom {

    private static Puzzle puzzle;
    private static Fuse fuse;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("Please enter the solution:\n>> ");
        String solution = scan.nextLine();

        System.out.printf("Please enter the number of lives:\n>>");
        int lives = scan.nextInt();
        System.out.println();

        puzzle = new Puzzle(solution);
        fuse = new Fuse(lives);

        cli();
    }

    private static void cli() {
        Scanner scan = new Scanner(System.in);

        Menu menu = new Menu("Select your next move:");
        menu.appendOption("Guess a character");
        menu.appendOption("Guess the solution");

        System.out.println(puzzle + "\n" + fuse);
        int selection = menu.input();

        switch(selection) {
            case 1:
                System.out.printf("Enter your guess:\n>> ");
                boolean isGuessCorrect = puzzle.guess(scan.nextLine().charAt(0));

                System.out.println("Your guess is: " + isGuessCorrect);
                break;
            case 2:
                System.out.printf("Enter your solution:\n>> ");
                puzzle.solve(scan.nextLine());
                break;
        }

        System.out.println(puzzle);
    }
}