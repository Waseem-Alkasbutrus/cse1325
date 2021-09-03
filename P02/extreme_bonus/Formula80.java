public class Formula80 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("usage: java Formula80 [Player1] [Player2]");

            System.exit(1);
        } else {
            System.out.println("Welcome " + args[0] + " , " + args[1] + "! Let's see which one of you is the better driver 😄");
            System.out.println("This race will challenge your skills across 80 miles of roads 😃");
            System.out.println("Make sure you are familiar with the rules before starting 😊");
            System.out.println("Ready...Steady..GO! 🏁");
        }

        Die die = new Die(4);

        Player player1 = new Player(args[0]);
        Player player2 = new Player(args[1]);
        
        //Player[] players = {new Player(args[0]), new Player(args[1])};
        boolean turnOfPlayer1 = true;
        int winner = 0;
        int roundNumber = 0;
        while(winner == 0) {
            for (int i = 0; i < 2; i++) {
                //Roll 2 dice
                int rollTotal = die.roll();
                rollTotal += die.roll();

                //if double 0 playerX can pick an option
                if (rollTotal == 0) {

                //if double 4 playerX can pick an option
                } else if (rollTotal == 8) {

                //else increment playerX normally
                } else {

                }
                    if (turnOfPlayer1) {
                        player1.incrementScore(rollTotal);

                        turnOfPlayer1 = false;
                    } else {
                        player2.incrementScore(rollTotal);

                        turnOfPlayer1 = true;
                    }

                if (player1.getScore() >= 80) {
                    winner = 1;
                } else if (player1.getScore() >= 80) {
                    winner = 2;
                }
            }
            
            roundNumber++;

            System.out.println("===========================================================");
            System.out.println("Round " + roundNumber);
            printBoard(player1.getName(), player1.getScore());
            printBoard(player2.getName(), player2.getScore());
        }
    }

    private static void printBoard(String playerName, int progress) {
        System.out.printf("\n%s: %d/80\n", playerName, progress);
        for(int i = 0; i < 80; i++) {
            if (i <= progress && progress != 0) {
                System.out.printf("🟩");
            } else {
                System.out.printf("🟥");
            }
        }
        System.out.println();
    }
}