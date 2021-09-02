import java.util.Arrays;

public class Roller {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("usage: java Roller [#dice] [#sides]");

            System.exit(1);
        }

        int numOfDice = Integer.parseInt(args[0]);
        int numOfSides = Integer.parseInt(args[1]);
        int sumOfRolls = 0;

        int[] diceRolls = new int[numOfDice];

        for (int i = 0; i < numOfDice; i++) {
            diceRolls[i] = (int) (Math.random() * numOfSides) + 1;
            sumOfRolls += diceRolls[i];
        }

        Arrays.sort(diceRolls);


        for (int i = 0; i < numOfDice; i++) {
            System.out.printf("%d ", diceRolls[i]);
        }
        System.out.printf("|| %d %.2f\n", sumOfRolls,  ((float) sumOfRolls/ (float) numOfDice));
    }
}