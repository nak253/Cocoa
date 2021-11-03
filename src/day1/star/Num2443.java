package day1.star;

import java.util.Scanner;

public class Num2443 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		for(int i =num; i>0;i--) {
			for(int j=0;j<num-i;j++) {
				System.out.print(" ");
			}
			for(int k=0;k<2*i-1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		scanner.close();
	}
}
