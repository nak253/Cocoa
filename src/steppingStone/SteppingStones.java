package steppingStone;

public class SteppingStones {

    private final int TOTAL_PLAYER_NUM = 9;

    private Bridge bridge;
    private User user;
    private Com com;

    private int playerNum;
    private int count;
    private boolean stopped;

    public void init() {
        bridge = new Bridge();
    }

    public void start() {
        setPlayerNum();
        while (!stopped&&!isPlayerTurn()){
            comStart();
        }
        if(!stopped){
            playerStart();
        }
        System.out.println("게임이 종료되었습니다.");
    }

    private boolean isPlayerTurn() {
        return count == playerNum;
    }

    private void comStart() {
        bridge.printBridge();
        printPlayerNum();
        Com com = new Com();
        crossTheBridge(com);
    }

    private void playerStart() {
        bridge.printBridge();
        printPlayerNum();
        user = new User();
        crossTheBridge(user);
        stopped = true;
    }

    private void printPlayerNum() {
        System.out.println(count + 1 + "번 참가자가 입장합니다.");
    }
    private void setPlayerNum() {
        playerNum = (int) (Math.random() * TOTAL_PLAYER_NUM);
        System.out.println("당신은 " + (playerNum + 1) + "번 참가자입니다.");
    }

    private void crossTheBridge(Player player) {
        while (bridge.isPassStep(player)) {
            bridge.printBridge();
            player.move();
        }
        if(bridge.isGoal()){
            System.out.println(count+ 1 +"번 참가자가 무사히 건넜습니다.");
            stopped = true;
        }
        count++;
    }
}