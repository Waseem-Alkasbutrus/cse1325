public class Fuse {
    private int time;

    public Fuse(int time) {
        this.time = time;
    }

    public int gettime() {
        return this.time;
    }

    public boolean burn() {
        if (this.time > 0) {
            this.time--;
        }

        if (this.time == 0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String toString() {
        
    }
}