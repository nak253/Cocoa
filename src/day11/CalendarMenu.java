package day11;

import java.util.Scanner;

public class CalendarMenu extends Menu {
    int menuMinNum ;
    int menuMaxNum ;

    public CalendarMenu() {
        this.menuMinNum = 1;
        this.menuMaxNum = 1;
    }

    public void printMenu() {
        System.out.println("원하는 작업을 입력하세요.");
        System.out.println("1: 다른 년월의 달력을 출력");
        System.out.println("q: 뒤로");
    }
    public  void selectMenu(){
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        isContinue = true;

        ValidationCheck vc = new ValidationCheck();
        if(vc.isQuit(option) || !vc.isCorrectInput(option,menuMinNum,menuMaxNum)){
            isContinue = false;
            return;
        }
        this.option = option;
    }
}
