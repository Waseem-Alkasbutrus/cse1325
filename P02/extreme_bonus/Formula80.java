import java.util.Scanner;

public class Formula80 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("usage: java Formula80 [Player1] [Player2]");

            System.exit(1);
        } else {
            clearTerminal();

            System.out.println("Welcome " + args[0] + ", " + args[1] + "! Let's see which one of you is the better driver 😄");
            System.out.println("This race will challenge your skills across 80 miles of roads 😃");
            System.out.println("Make sure you are familiar with the rules before starting 😊");
            System.out.println("Ready...Steady...");
        }

        waitForEnter("GO! 🏁");
        clearTerminal();

        Player[] players = {new Player(args[0]), new Player(args[1])};

        boolean isPlayer1Turn = true;//true if it's player1's turn, false if it's player2's turn
        int winner = -1;//0 for player1, 1 for player2, and -1 if no winner is found yet

        while(winner == -1) {
            if (isPlayer1Turn) {
                playTurn(players, 0);    
            } else {
                playTurn(players, 1);
            }

            if (players[0].getScore() >= 80) {
                winner = 0;
            } else if (players[1].getScore() >= 80) {
                winner = 1;
            } else {
                isPlayer1Turn = !isPlayer1Turn;

                waitForEnter("end turn");
                clearTerminal();
            }
        }
        
        System.out.println("\n" + players[winner].getName() + " crossed the finish line first and defeated the other racer!!");
        System.out.println("Congratulations "+ players[winner].getName() +"!! you proved yourself as the top driver here today!");
        System.out.println("I can tell you have a bright future ahead of you");
        System.out.println("Good luck!");

        waitForEnter("end game");
    }

    private static void playTurn(Player[] players, int currentPlayer) {      
        System.out.println(players[currentPlayer].getName() + "'s turn:\n");

        printScore(players[0]);
        printScore(players[1]);

        waitForEnter("roll");
        clearTerminal();

        boolean rolledDoubles = players[currentPlayer].rollDice();
        players[currentPlayer].incrementScore(players[currentPlayer].getDie(0) + players[currentPlayer].getDie(1));
        System.out.println(players[currentPlayer].getName() + "'s turn:\n");

        printScore(players[0]);
        printScore(players[1]);

        if (rolledDoubles) {
            System.out.println("\n" + players[currentPlayer].getName() + " rolled a double " + players[currentPlayer].getDie(0) + "!");
        } else {
            System.out.println("\n" + players[currentPlayer].getName() + " rolled a " + players[currentPlayer].getDie(0) + " and a " + players[currentPlayer].getDie(1));
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