public class Fuse {
    private int fuseLength;

    public Fuse(int fuseLength) {
        this.fuseLength = fuseLength;
    }

    public int getFuseLength() {
        return this.fuseLength;
    }

    public boolean burn() {
        if (this.fuseLength > 0) {
            this.fuseLength--;
        }

        if (this.fuseLength == 0) {
            return false;
        } else {
            return true;
        }
    }
}