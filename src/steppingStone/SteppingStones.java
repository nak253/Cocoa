package steppingStone;

public class SteppingStones {

    private Bridge bridge;

    public void init() {
        bridge = new Bridge();
    }

    public void start() {
        while (!bridge.isStop()){
            bridge.setBridge();
            bridge.printBridge();
        }
        System.out.println("게임이 종료되었습니다.");
    }
}
