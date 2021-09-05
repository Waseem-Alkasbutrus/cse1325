public class Player {

    //Field(s)
    private String name;
    private int score = 0;
    private int bonus = 0;
    private int[] diceRolls = new int[2];

    //Constructor(s)
    public Player (String playerName) {
        name = playerName;
    }

    //Methods
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore(int increment) {
        score += increment;
    }

    public void decrementScore(int decrement) {
        score -= decrement;
    }

    public int getBonus() {
        return bonus;
    }

    public void incrementBonus() {
        bonus++;
    }

    public boolean rollDice() {
        Die die = new Die(6);
        
        diceRolls[0] = die.roll();
        diceRolls[1] = die.roll();

        return diceRolls[0] == diceRolls[1];
    }

    public int getDie(int index) {
        return diceRolls[index];
    }
}