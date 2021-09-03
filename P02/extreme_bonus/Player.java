public class Player {

    //Field(s)
    private String name;
    private int score = 0;
    private int bonus = 0;

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
}