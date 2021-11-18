package day11;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Test {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    static String[] koreanHour = new String[]{"열","한", "두", "세", "네", "다섯", "여섯", "일곱", "여덟", "아홉"};
    static String[] koreanMin = new String[]{"십","일","이","삼","사","오","육","칠","팔","구"};

    public static String highlight(String content){
        return ANSI_RED + content + ANSI_RESET;
    }

    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        String hour = "";
        String min = "";

        if((localTime.getHour()/10)>=1){
            hour += koreanHour[0];
        }
        if((localTime.getHour()%10)!=0){
            hour += koreanHour[localTime.getHour()%10];
        }
        hour +="시";

        if((localTime.getMinute()/10)!=0){
            min +=koreanMin[localTime.getMinute()/10];
            min +=koreanMin[0];
        }
        if((localTime.getMinute()%10)!=0){
            min += koreanMin[localTime.getMinute()%10];
        }
        min +="분";
//        LocalTime localTime = LocalTime.of(24,0);
//
//
        System.out.println("hour = " +hour);
        System.out.println("min = " + min);
//
//        PrintCalendar printCalendar = new PrintCalendar();
//        printCalendar.start();
//
//        Scanner scanner = new Scanner(System.in);
//        printCalendar.start(scanner);



    }


}
