package steppingStone;

public class Bridge {
    private final int WIDTH_OF_BRIDGE = 2;
    private final int LENGTH_OF_BRIDGE = 9;

    private Element[][] elements;


    public Bridge() {
        elements = new Element[WIDTH_OF_BRIDGE][LENGTH_OF_BRIDGE];
        setGlass();
    }

    private void setGlass() {
        for (int i = 0; i < LENGTH_OF_BRIDGE; i++) {
            int random = (int) (Math.random() * WIDTH_OF_BRIDGE);
            elements[random][i] = new Glass();
        }
    }

    public void printBridge() {
        for (int i = 0; i < WIDTH_OF_BRIDGE; i++) {
            for (int j = 0; j < LENGTH_OF_BRIDGE; j++) {
                System.out.printf("[%s]", elements[i][j] == null ? " " : elements[i][j]);
            }
            System.out.println();
        }
    }

    public boolean isPassStep(Player player) {
        elements[player.getPreviousY()][player.getPreviousX()] = null;

        if (isGoal(player)) {
            System.out.println("참가자가 무사히 도착하였습니다.");
            return false;
        }

        if (elements[player.getCurrentY()][player.getCurrentX()] != null) {
            Glass glass = (Glass) (elements[player.getCurrentY()][player.getCurrentX()]);
            glass.breakGlass();
            System.out.println("실패하였습니다.");
            return false;
        }

        if (elements[player.getCurrentY()][player.getCurrentX()] != null) {
            Glass glass = (Glass) (elements[player.getCurrentY()][player.getCurrentX()]);
            glass.breakGlass();
            System.out.println("실패하였습니다.");
            return false;
        }

        elements[player.getCurrentY()][player.getCurrentX()] = player;
        return true;
    }
    public boolean isGoal(Player player) {
        return player.getCurrentX()== LENGTH_OF_BRIDGE;
    }


}