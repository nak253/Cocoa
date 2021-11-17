package day11;

import java.util.Scanner;

public class ClockAndCal {

    public void start() {
        Menu menu = new MainMenu();
        while (true){
            menu.printMenu();
            menu.selectMenu();
            if(!menu.isContinue()){
                System.out.println("종료합니다.");
                break;
            }
            selectCommand(menu.option);
        }
    }

    private void selectCommand(String option) {
        switch (option){
            case "clock" :
                System.out.println("아직 구현 안됨");
                break;
            case "cal" :
                PrintCalendar printCalendar = new PrintCalendar();
                printCalendar.start();
                break;
        }
    }

}
