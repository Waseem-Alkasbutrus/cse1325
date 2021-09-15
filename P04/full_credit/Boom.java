public class Boom {
    public static void main(String[] args) {
        Fuse fuse = new Fuse(5);
        Puzzle puzzle = new Puzzle("Java is awesome!");
       
        System.out.println(puzzle.guess('z') + " " + puzzle.guess('W'));
        System.out.println("Guess 'java is aweSoMe!' is " + puzzle.solve("Java is aweSoMe!"));
        System.out.println("The solution was: '" + puzzle + "'");


        for (int i = 0 ; i <= 5; i++) {
            System.out.println(fuse);
            fuse.burn();
        }
    }
}