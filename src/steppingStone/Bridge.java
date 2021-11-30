package steppingStone;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bridge {

    private final int WIDTH_OF_BRIDGE = 2;
    private final int LENGTH_OF_BRIDGE = 5;

    private String[][] bridge;
    private List<Glass> gl;
    private Player p;
    private boolean stopped;

    public Bridge() {
        bridge = new String[WIDTH_OF_BRIDGE][LENGTH_OF_BRIDGE];
        p = new Player();
        gl = new ArrayList<>();
        this.setGlass();
    }

    private void setGlass() {
        for (int i = 1; i <= LENGTH_OF_BRIDGE; i++) {
            int random = (int) (Math.random() * WIDTH_OF_BRIDGE);
            gl.add(new Glass(random, i));
        }
        System.out.println("gl = " + gl);
    }

    public void setBridge() {
        Scanner scanner = new Scanner(System.in);
        p.move(scanner);
        p.setPlayerPosition(bridge);
    }

    public void printBridge() {
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < WIDTH_OF_BRIDGE; i++) {
            for (int j = 0; j < LENGTH_OF_BRIDGE; j++) {
                System.out.printf("[%s]", bridge[i][j] == null ? " " : bridge[i][j]);
            }
            System.out.println();
        }
        System.out.println("--------------------------------------------------------");
    }

    public boolean isStop() {
        if(p.isGoal(LENGTH_OF_BRIDGE)){
            System.out.println("다리를 잘 건넜습니다.");
            this.stopped = true;
        }
        return this.stopped;
    }
}

