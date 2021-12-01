package steppingStone;

import java.util.Scanner;

public class Player extends Element{
    private final String upKey="w";
    private final String downKey="s";
    private final int UP =0;
    private final int DOWN =1;

    private int previousX;
    private int previousY;
    private int currentX;
    private int currentY;

    private int numOfSuccesses;

    public Player(Scanner scanner,Validator validator) {
        selectUpOrDown(scanner,validator);
    }

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

    public void move(Scanner scanner, Validator validator) {
        previousX=currentX;
        previousY=currentY;
        selectUpOrDown(scanner,validator);
        currentX++;
    }

    private void selectUpOrDown(Scanner scanner,Validator validator) {
        String input = "";
        while (!validator.correctInput(input)){
            System.out.println("위(W)또는 아래(S)를 입력하세요");
            input = scanner.nextLine();
        }
        switch (input){
            case upKey:
                currentY = UP;
                break;
            case downKey:
                currentY = DOWN;
                break;
        }
    }

    public boolean isGoal(int lengthOfBridge) {
        return currentX == lengthOfBridge;
    }

    @Override
    public String toString() {
        return "P";
    }
}