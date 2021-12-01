package steppingStone;

public class Com extends Player {

    Bridge bridge;

    public Com(Bridge bridge) {
        this.bridge = bridge;
    }

    public void firstTurn() {
        selectUpOrDown();
    }

    public void move() {
        previousX = currentX;
        previousY = currentY;
        currentX++;
        selectUpOrDown();
    }

    private void selectUpOrDown() {
        int num = (int) (Math.random() * 2);
        if (bridge.getElement(num, currentX) != null) {
            Glass glass = (Glass) bridge.getElement(num, currentX);
            if (glass.isBroken()) {
                num = (num == 0) ? 1 : 0;
            }
        }
        currentY = num;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "C";
    }
}
