package steppingStone;

public class Glass {
    private int x;
    private int y;
    private boolean breaked;

    public Glass(){}

    public Glass(int x, int y) {
        this.x =x;
        this.y =y;
    }

    @Override
    public String toString() {
        return "["+ x +"," + y +"]";
    }
}
