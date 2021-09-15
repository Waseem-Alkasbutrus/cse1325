public class Puzzle {
    private final String solution;
    private boolean[] guesses;

    public Puzzle (String solution) {
        this.solution = solution.toLowerCase();
    }


    public boolean guess(char c) {
        return this.solution.contains(Character.toString(c).toLowerCase());
    }

    public boolean solve(String proposedSolution) {
        return this.solution.contains(proposedSolution.toLowerCase());
    }   

    public String getSolution() {
        return this.solution;
    }

    //@Override
    //public void toString() {
        //TODO: Override this function
    //}
}