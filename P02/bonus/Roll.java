import java.util.Arrays;

public class Roll {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("usage: java Roll [#dice] [#sides]");

            System.exit(1);
        }

        Die die = new Die(Integer.parseInt(args[1]));
        int[] diceRolls = new int[Integer.parseInt(args[0])];
        int rollSum = 0;
        
        for (int i = 0; i < diceRolls.length; i++) {
            diceRolls[i] = die.roll();
            rollSum += diceRolls[i];
        }

        Arrays.sort(diceRolls);

        for (int i = 0; i < diceRolls.length; i++) {
            System.out.printf("%d ", diceRolls[i]);
        }
        System.out.printf("|| %d %.2f\n", rollSum, (float) rollSum/diceRolls.length);
    }
}