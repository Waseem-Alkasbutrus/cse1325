public class Die {

    //Field(s)
    private int faces = 6;

    //Constructor(s)
    public Die(int numOfFaces) {
        faces = numOfFaces;
    }

    //Getter(s)
    public int getFaces() {
        return faces;
    }

    //Method(s)
    public int roll() {
        return (int) (Math.random() * faces) + 1;
    }
}