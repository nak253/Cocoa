package day1.star;

import java.util.Scanner;

public class Num2441 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		
		for(int i=0;i<num;i++) {
			for(int j=0;j<i;j++) {
				System.out.print(" ");
			}
			for(int k=num;k>i;k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		scanner.close();
	}

}
