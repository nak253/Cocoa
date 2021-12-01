package steppingStone;

public class Com extends Player{

    private int numOfSuccesses;

    public Com() {
        selectUpOrDown();
    }

    public void move() {
        previousX=currentX;
        previousY=currentY;
        selectUpOrDown();
        currentX++;
    }

    private void selectUpOrDown() {
        int num = (int)(Math.random()*2);
        currentY = num;
        try {
            Thread.sleep(1500);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "C";
    }
}
