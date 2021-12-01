package steppingStone;

import java.util.Scanner;

public class SteppingStones {

    private Scanner scanner;
    private Validator validator;

    private Bridge bridge;
    private Player player;

    public void init() {
        scanner = new Scanner(System.in);
        validator = new Validator();
        bridge = new Bridge();
    }

    public void start() {
        while (!bridge.isStop()){
            bridge.printBridge();
            bridge.countPlayer();
            player = new Player(scanner,validator);
            crossTheBridge();
        }
        System.out.println("게임이 종료되었습니다.");
    }

    private void crossTheBridge() {
        while (bridge.isPassStep(player)){
            bridge.printBridge();
            player.move(scanner,validator);
        }
    }
}