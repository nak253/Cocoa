package steppingStone;

import java.util.Scanner;

public class SteppingStones {

    private final int TOTAL_PLAYER_NUM=9;

    private Scanner scanner;
    private Validator validator;

    private Bridge bridge;
    private Player player;

    private int playerNum;

    public void init() {
        scanner = new Scanner(System.in);
        validator = new Validator();
        bridge = new Bridge();
    }

    public void start() {
        setPlayerNum();
        while (!bridge.isStop()){
            bridge.printBridge();
            bridge.countPlayer();
            player = new Player(scanner,validator);
            crossTheBridge();
        }
        System.out.println("게임이 종료되었습니다.");
    }

    private void setPlayerNum() {
        playerNum = (int)(Math.random()*TOTAL_PLAYER_NUM)+1;
        System.out.println("당신은 "+playerNum+"번 참가자입니다.");
    }
    
    private void crossTheBridge() {
        while (bridge.isPassStep(player)){
            bridge.printBridge();
            player.move(scanner,validator);
        }
    }
}