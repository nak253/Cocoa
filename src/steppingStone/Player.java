package steppingStone;

public abstract class Player extends Element {
    int previousX;
    int previousY;
    int currentX;
    int currentY;

    public int getPreviousX() {
        return previousX;
    }

    public int getPreviousY() {
        return previousY;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }

    abstract public void move();

}
