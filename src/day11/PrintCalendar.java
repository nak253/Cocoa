package day11;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;
import java.util.Scanner;

public class PrintCalendar {

    private static int year;
    private static int month;

    public PrintCalendar() {
        LocalDate date = LocalDate.now();
        this.year = date.getYear();
        this.month = date.getMonthValue();
    }

    public void start() {
        Menu menu = new CalendarMenu();
        PrintCalendar();
        while (true){
            menu.printMenu();
            menu.selectMenu();
            if(!menu.isContinue()){
                break;
            }
            selectCommand(menu.option);
        }
    }

    public void InputYearAndMonth() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("년도를 입력하세요 > ");
        this.year = scanner.nextInt();
        System.out.print("월을 입력하세요 > ");
        this.month = scanner.nextInt();
        scanner.nextLine();
        this.start();
    }

    private void selectCommand(String option) {
        switch (option){
            case "1" :
                InputYearAndMonth();
                PrintCalendar();
                break;
        }
    }

    private void PrintCalendar(){
        LocalDate startDate = LocalDate.of(this.year,this.month,1);
        LocalDate endDate =  LocalDate.of(this.year,this.month,startDate.lengthOfMonth());

        int startDayOfWeek = startDate.getDayOfWeek().getValue();
        int lastDayOfMonth = endDate.getDayOfMonth();
        System.out.printf("%4s %s%n",this.year,this.month);
        printDayOfWeek();
        printDay(startDayOfWeek,lastDayOfMonth);
    }

    private static void printDayOfWeek() {
        for(DayOfWeek dayOfWeek : DayOfWeek.values()){
            System.out.printf("%4s",dayOfWeek.getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        }
        System.out.println();
    }


    private static void printDay(int startDayOfWeek,int lastDayOfMonth) {
        for (int i = 1; i < startDayOfWeek; i++) {
            System.out.printf("%4s"," ");
        }
        for (int i = 1, n =startDayOfWeek; i <=lastDayOfMonth; i++,n++) {
            System.out.printf("%4s",i);
            if(n%7==0){
                System.out.println();
            }
        }
        System.out.println();
    }

}
