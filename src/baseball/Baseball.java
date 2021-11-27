package baseball;

import java.util.Scanner;

public class Baseball {

    private Answer answer;

    public void init() {
        this.answer = new Answer();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (!answer.isStop()){
            inputAnswer(scanner);
            answer.checkAnswer();
        }
        exit();
    }

    private void inputAnswer(Scanner scanner) {
        System.out.println("숫자를 입력하세요. (ex: 123)");
        System.out.print("> ");
        answer.setUserAnswer(scanner);
    }

    private void exit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임종료");
    }
}
