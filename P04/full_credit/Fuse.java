public class Fuse {
    private int time;

    public Fuse(int time) {
        this.time = time;
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

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        String fuse;
        if (this.time > 0) {
            fuse = "🟥🟥";
            for (int i = 0; i < this.time ; i++) {
                fuse = fuse + "〰️";
            }
            fuse = fuse + "💥";
        } else {
            fuse = "💥💥💥 BOOM 💥💥💥";
        }

        return fuse;
    }
}