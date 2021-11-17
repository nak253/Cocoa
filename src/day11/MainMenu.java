package day11;

import java.util.Scanner;

public class MainMenu extends Menu{

    String[] correctCommand = new String[]{"clock","cal"};

    public void printMenu() {
        System.out.println("원하는 명령을 입력하세요. (clock: 시계출력, cal: 달력출력 q: 종료)");
    }

    public void selectMenu() {
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        isContinue = true;

        ValidationCheck vc = new ValidationCheck();
        if(vc.isQuit(option)||!vc.isCorrectCommand(option,correctCommand)){
            isContinue = false;
            return;
        }
        this.option = option.toLowerCase();
    }
}
