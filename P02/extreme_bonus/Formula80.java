import java.util.Scanner;

public class Formula80 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("usage: java Formula80 [Player1] [Player2]");

            System.exit(1);
        } else {
            clearTerminal();

            System.out.println("Welcome " + args[0] + " , " + args[1] + "! Let's see which one of you is the better driver 😄");
            System.out.println("This race will challenge your skills across 80 miles of roads 😃");
            System.out.println("Make sure you are familiar with the rules before starting 😊");
            System.out.println("Ready...Steady...");
        }

        waitForEnter("GO! 🏁");
        clearTerminal();

        Player player1 = new Player(args[0]);
        Player player2 = new Player(args[1]);

        boolean isPlayer1Turn = true;//true if it's player1's turn, false if it's player2's turn
        int winner = 0;//1 for player1, 2 for player2, and 0 if no winner is found yet

        while(winner == 0) {
            if (isPlayer1Turn) {
                playTurn(player1, player2);
            } else {
                playTurn(player2, player1);
            }

            if (player1.getScore() >= 80) {
                winner = 1;
                System.out.println(player1.getName() + " crossed the finish line first and defeated " + player2.getName() + "!!");
            } else if (player2.getScore() >= 80) {
                winner = 2;
                System.out.println(player2.getName() + " crossed the finish line first and defeated " + player1.getName() + "!!");
            } else {
                isPlayer1Turn = !isPlayer1Turn;

                waitForEnter("end turn");
                clearTerminal();
            }
        }
        
        System.out.println("Congratulations!! you proved yourself as the top driver here today!");
        System.out.println("I can tell you have a bright future ahead of you");
        System.out.println("Good luck!");

        waitForEnter("end game");
        clearTerminal();
    }

    private static void playTurn(Player currentPlayer, Player otherPlayer) {      
        System.out.println(currentPlayer.getName() + "'s turn:\n");

        printScore(currentPlayer);
        printScore(otherPlayer);

        waitForEnter("roll");
        clearTerminal();

        boolean rolledDoubles = currentPlayer.rollDice();
        currentPlayer.incrementScore(currentPlayer.getDie(0) + currentPlayer.getDie(1));
        System.out.println(currentPlayer.getName() + "'s turn:\n");

        printScore(currentPlayer);
        printScore(otherPlayer);

        if (rolledDoubles) {
            System.out.println("\n" + currentPlayer.getName() + " rolled a double " + currentPlayer.getDie(0) + "!");
        } else {
            System.out.println("\n" + currentPlayer.getName() + " rolled a " + currentPlayer.getDie(0) + " and a " + currentPlayer.getDie(1));
        }
    }

    private static void printScore(Player player) {
        System.out.println(player.getName() + ": " + player.getScore() + "\\80");
        for(int i = 0; i < 80; i++) {
            if (i <= player.getScore() && player.getScore() != 0) {
                System.out.printf("🟩");
            } else {
                System.out.printf("🟥");
            }
        }
        System.out.println();
    }

    private static void waitForEnter(String action) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\n[Press ENTER to " + action + "]");
        String temp = scan.nextLine();
    }

    private static void clearTerminal() {
        System.out.print("\033[H\033[2J");
    }
}