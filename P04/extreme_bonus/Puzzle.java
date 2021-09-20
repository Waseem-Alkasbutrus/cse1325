public class Puzzle {
    private final String solution;
    private boolean[] guesses = new boolean[93];

    public Puzzle (String solution) {
        this.solution = solution.toLowerCase();
    }

    public boolean guess(char c) throws IllegalArgumentException {
        if (this.guesses[c - 32] == true) {
            throw new IllegalArgumentException("\'" + c + "\' has already been guessed.");
        } else {
            this.guesses[c - 32] = true;
        }
        return this.solution.contains(Character.toString(c).toLowerCase());
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
            if (this.guesses[this.solution.charAt(i) - 32] || this.solution.charAt(i) == ' ') {
                hiddenSolution = hiddenSolution + Character.toString(this.solution.charAt(i));
            } else {
                hiddenSolution = hiddenSolution + "_";
            }
        }

        return hiddenSolution;
    }
}