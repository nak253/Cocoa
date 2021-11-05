package day5;

import java.util.Scanner;

public class Num2920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result ="mixed";
        String str = sc.nextLine().replaceAll(" ","");

        if(str.equals("12345678")){
            result="ascending";
        }else if(str.equals("87654321")){
            result="descending";
        }
        System.out.println(result);
        sc.close();
    }
}