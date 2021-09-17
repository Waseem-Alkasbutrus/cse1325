import java.util.Scanner;


public class Boom {

    private static Puzzle puzzle;
    private static Fuse fuse;

    public Boom (String solution, int lives) {
        this.puzzle = new Puzzle(solution);
        this.fuse = new Fuse(lives);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.printf("Please enter the solution:\n>> ");
        String solution = scan.nextLine();

        System.out.printf("Please enter the number of lives:\n>>");
        int lives = scan.nextInt();
        System.out.println();

        Boom boom = new Boom(solution, lives);

        cli();
    }

    private static void cli() {
        Scanner scan = new Scanner(System.in);
        int gameStatus = 0;//0 if game in progress, 1 if player won, -1 if player lost

        Menu menu = new Menu("Select your next move:");
        menu.appendOption("Guess a character");
        menu.appendOption("Guess the solution");
        menu.appendOption("Exit");


        while (gameStatus == 0) {
            //TODO: make an int hasWon that is checked at the end of each itteration, if 1 player has won, -1 player has lost, 0 game is still going
            
            System.out.println(fuse + "\n\nSolution: " + puzzle + "\n");
            int selection = menu.input();

            switch(selection) {
                case 1:
                    System.out.printf("Enter your guess:\n>> ");
                    boolean isGuessCorrect = puzzle.guess(scan.nextLine().charAt(0));

                    if (!isGuessCorrect) {
                        if (!fuse.burn()) {
                            System.out.println("\n" + fuse + "\nLooks like you ran of time...\nBetter luck next time\nThe solution was \'" + puzzle.getSolution() + "\'\n");
                            gameStatus = -1;//set game status to loss
                        }
                    }

                    break;
                case 2:
                    System.out.printf("Enter your solution:\n>> ");
                    boolean isSolutionCorrect = puzzle.solve(scan.nextLine());

                    if (isSolutionCorrect) {
                        System.out.println("\nYou Solved the puzzle!\nGreat job!\nThe solution was \'" + puzzle.getSolution() + "\'\n");
                        gameStatus = 1;//set game status to victory
                    } else {
                        System.out.println("\nYour solution was incorrect...\nBetter luck next time\n\nThe solution was \'" + puzzle.getSolution() + "\'\n");
                        gameStatus = -1;//set game status to loss
                    }

                    break;
                case 3:
                    System.exit(0);
            }
        }
    }
}