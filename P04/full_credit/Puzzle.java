public class Puzzle {
    private final String solution;
    private boolean[] guesses;

    public Puzzle (String solution) {
        //TODO: Control the case before assigning it
        this.solution = solution;
    }


    public boolean guess(char c) {
        //TODO: return true of c is part of solution, false if not. Update guesses to contain this guess. Remember to control the case.
    }

    public boolean solve(String proposedSolution) {
        //TODO: return true if proposedSolution is the same as the solution, false if not. Remember to control the case.
    }   

    public String getSolution() {
        return this.solution;
    }

    @Override
    public void toString() {

    }
}