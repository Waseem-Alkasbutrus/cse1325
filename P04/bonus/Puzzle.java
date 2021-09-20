public class Puzzle {
    private final String solution;
    private boolean[] guesses;

    public Puzzle (String solution) {
        this.solution = solution.toLowerCase();
        this.guesses = new boolean[this.solution.length()];
    }

    public boolean guess(char c) {
        if (this.solution.contains(Character.toString(c).toLowerCase())) {
            for (int i = 0; i < this.solution.length(); i++) {
                if (c == this.solution.charAt(i)) {
                    this.guesses[i] = true;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean solve(String proposedSolution) {
        return this.solution.contains(proposedSolution.toLowerCase());
    }   

    public String getSolution() {
        return this.solution;
    }

    @Override
    public String toString() {
        String hiddenSolution = "";

        for (int i = 0; i < this.solution.length(); i++) {
            if (this.guesses[i] || this.solution.charAt(i) == ' ') {
                hiddenSolution = hiddenSolution + Character.toString(this.solution.charAt(i));
            } else {
                hiddenSolution = hiddenSolution + "_";
            }
        }

        return hiddenSolution;
    }
}