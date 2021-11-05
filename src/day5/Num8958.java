package day5;

import java.util.Scanner;

public class Num8958 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        sc.nextLine();
        String str="";

        for (int i = 0; i < num; i++) {
            int sum=0;
            int count=0;
            str = sc.nextLine();
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j)=='O'){
                    sum+=1+count;
                    count++;
                    continue;
                }
                count=0;
            }
            System.out.println(sum);
        }
    }
}