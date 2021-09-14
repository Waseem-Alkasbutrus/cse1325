public class Boom {
    public static void main(String[] args) {
        Fuse fuse = new Fuse(5);
        
        for (int i = 0 ; i <= 5; i++) {
            System.out.println(fuse);
            fuse.burn();
        }
    }
}