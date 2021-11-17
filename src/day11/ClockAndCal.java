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
                HangleClock hangleClock = new HangleClock();
                HangleClock.start();
                break;
            case "cal" :
                PrintCalendar printCalendar = new PrintCalendar();
                printCalendar.start();
                break;
        }
    }

}
