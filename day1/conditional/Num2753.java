package day1.conditional;

import java.util.Scanner;

public class Num2753 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		int result =0;
		if(year%4==0) {
			if(year%100!=0 ||year%400==0 ) {
				result =1;
			}
		}
		System.out.println(result);
		 scanner.close();
	}
}
