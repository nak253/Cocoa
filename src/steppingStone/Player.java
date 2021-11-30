package steppingStone;

import java.util.Scanner;

public class Player {
    private final String upKey="w";
    private final String downKey="s";

    private int previousX;
    private int previousY;
    private int currentX;
    private int currentY;

    public Player() {}

    public void move(Scanner scanner) {
        this.previousX = this.currentX;
        this.previousY = this.currentY;

        System.out.println("위 또는 아래를 입력하세요");
        String input = scanner.nextLine();
        switch (input.toLowerCase()){
            case upKey:
                this.currentX=0;
                break;
            case downKey:
                this.currentX=1;
                break;
        }
        this.currentY++;
    }

    public void setPlayerPosition(String[][] bridge) {
        bridge[this.previousX][this.previousY] = null;
        bridge[this.currentX][this.currentY] = "*";
    }

    public boolean isGoal(int goal) {
        return this.currentY+1 == goal;
    }
}
