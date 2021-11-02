package day1.conditional;

import java.util.Scanner;

public class Num2884 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int hour = scanner.nextInt();
		int min = scanner.nextInt()-45;
		
		if(min<0) {
			min=60+min; 		
			if(--hour==-1) {
				hour =23;
			}
		}
		System.out.println(hour+" "+min);
		 scanner.close();
	}
}
