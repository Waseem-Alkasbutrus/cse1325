public class Fuse {
    private int time;

    public Fuse(int time) {
        this.time = time;
    }

    public int getTime() {
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
        String fuse;
        if (this.time > 0) {
            fuse = this.time + "  🟥🟥";
            for (int i = 0; i < this.time ; i++) {
                fuse = fuse + "〰️";
            }
            fuse = fuse + "💥";
        } else {
            fuse = "0  💥💥💥";
        }

        return fuse;
    }
}