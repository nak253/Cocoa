package day1.conditional;

import java.util.Scanner;

public class Num14681 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 int a = scanner.nextInt();
		 int b = scanner.nextInt();
		 
		 System.out.println((a>0&&b>0)? 1 : (a<0&&b>0)? 2:(a<0&&b<0)? 3:4);
		 
		 scanner.close();
	}
	
}
