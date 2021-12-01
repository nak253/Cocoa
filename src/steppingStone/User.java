package steppingStone;

import java.util.Scanner;

public class User extends Player{
    private final String upKey="w";
    private final String downKey="s";
    private final int UP =0;
    private final int DOWN =1;

    private Scanner scanner;
    private Validator validator;

    private int numOfSuccesses;

    public User() {
        scanner = new Scanner(System.in);
        validator = new Validator();
        selectUpOrDown();
    }

    public void move() {
        previousX=currentX;
        previousY=currentY;
        selectUpOrDown();
        currentX++;
    }

    private void selectUpOrDown() {
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


    @Override
    public String toString() {
        return "P";
    }
}