package day3;

import java.util.Arrays;
import java.util.Scanner;

public class Mission2 {

    final int WORLD_SIZE = 5;
    String[][] world = new String[WORLD_SIZE][WORLD_SIZE];
    String arrowKey = "";
    int charactorRowIndex;
    int charactorColumnIndex;
    int charactorNextRowIndex;
    int charactorNextColumnIndex;

    int bombRowIndex;
    int bombColumnIndex;

    int monsterRowIndex;
    int monsterColumnIndex;

    int point;

    boolean continueGame;

    int bombCounter;

    private void createCharactor() {
        charactorRowIndex = WORLD_SIZE/2;
        charactorColumnIndex = WORLD_SIZE/2;
        world[charactorRowIndex][charactorColumnIndex] = "주인공";

    }

    private void createBomb() {
        if(bombCounter==1) {
            world[bombRowIndex][bombColumnIndex]=null;
        }

        bombRowIndex = (int) (Math.random() * WORLD_SIZE);
        bombColumnIndex = (int) (Math.random() *WORLD_SIZE);

        if(bombRowIndex == charactorRowIndex && bombColumnIndex ==charactorColumnIndex) {
            bombCounter=0;
            createBomb(); //폭탄과 주인공위치가 겹칠 경우 실행
        }else {
            world[bombRowIndex][bombColumnIndex] = "폭탄";
            bombCounter=1;
        }



    }

    private void createMonster() {

        monsterRowIndex = (int) (Math.random() * WORLD_SIZE);
        monsterColumnIndex = (int) (Math.random() *WORLD_SIZE);

        if ((monsterRowIndex == charactorRowIndex && monsterColumnIndex == charactorColumnIndex)
                ||( monsterRowIndex == bombRowIndex && monsterColumnIndex == bombColumnIndex)) {
            createMonster(); //괴물과 주인공 또는 폭탄위치가 겹칠 경우 실행
        }else {
            world[monsterRowIndex][monsterColumnIndex] = "괴물";
        }
    }


    private void startGame() {

        createCharactor();
        createBomb();
        createMonster();
        continueGame = true;

        while (continueGame) {
            System.out.println("현재배열의 상태 :"+Arrays.deepToString(world));
            continueGame = succeedInMoving();
        }
        getPoint();
    }

    private boolean succeedInMoving() {


        if(!menu()) {
            return false;
        }

        if (charactorNextRowIndex < 0 || charactorNextColumnIndex < 0 || charactorNextRowIndex > 4
                || charactorNextColumnIndex > 4) {
            System.out.println("더 이상 이동할 수 없습니다.");
            return false;
        }

        if (isBomb()) {
            return false;
        }

        encounterMonster();
        return true;
    }

    private boolean menu() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("원하는 방향을 입력하세요 [w,a,s,d] (종료[q])");
        System.out.print(">> ");

        arrowKey=scanner.next().toLowerCase();
        System.out.println();

        charactorNextRowIndex=charactorRowIndex;
        charactorNextColumnIndex=charactorColumnIndex;

        switch(arrowKey) {
            case "w":
                charactorNextRowIndex = charactorRowIndex-1;
                break;
            case "a":
                charactorNextColumnIndex = charactorColumnIndex-1;
                break;
            case "s":
                charactorNextRowIndex = charactorRowIndex+1;
                break;
            case "d":
                charactorNextColumnIndex = charactorColumnIndex+1;
                break;
            case "q":
                return false;
            default :
                System.out.println("잘못된 입력입니다.");
                return false;
        }
        return true;
    }

    private void getPoint() {
        System.out.println("당신의 점수는 "+point+"점 입니다.");
    }

    private boolean isBomb() {
        if ("폭탄".equals(world[charactorNextRowIndex][charactorNextColumnIndex])) {
            System.out.println();
            System.out.println("폭탄을 밟았습니다.");
            return true;
        }
        return false;
    }

    private void encounterMonster() {
        if ("괴물".equals(world[charactorNextRowIndex][charactorNextColumnIndex])) {
            moveChractor();
            System.out.println();
            System.out.println("괴물과 만났습니다.");
            System.out.println("괴물를 물리쳤습니다.");
            System.out.println("폭탄과 괴물이 새롭게 배치됩니다.");
            System.out.println();

            scorePoint();
            createBomb();
            createMonster();
            return;
        }
        moveChractor();
        return;
    }

    private void scorePoint() {
        point++;

    }

    private void moveChractor() {
        world[charactorNextRowIndex][charactorNextColumnIndex] = world[charactorRowIndex][charactorColumnIndex];
        world[charactorRowIndex][charactorColumnIndex] = null;
        charactorRowIndex = charactorNextRowIndex;
        charactorColumnIndex = charactorNextColumnIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Mission2 mission = new Mission2();

        System.out.println("게임을 시작하겠습니까?");
        System.out.println("게임시작을 원한다면 아무버튼을 눌러주세요 (종료:q)");
        System.out.print(">> ");

        String select = scanner.next();


        if (!select.equalsIgnoreCase("q")) {
            System.out.println();
            mission.startGame();
        }
        System.out.println("게임이 종료되었습니다.");

        scanner.close();
    }

}