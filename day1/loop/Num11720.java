package day1.loop;

import java.util.Scanner;

public class Num11720 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		scanner.nextLine(); //개행문자 제거
		String str = scanner.nextLine();
		int sum=0;
		
		for(int i =0;i<num;i++) {	
			sum +=str.charAt(i)-'0';
		}
		System.out.println(sum);
		
		 scanner.close();
	}
}
