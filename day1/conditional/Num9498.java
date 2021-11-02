package day1.conditional;

import java.util.Scanner;

public class Num9498 {
	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        int result = scanner.nextInt();
	        String grade = "F";
	        if (90 <= result && result <= 100) {
	            grade = "A";
	        } else if (80 <= result && result <= 89) {
	            grade = "B";
	        } else if (70 <= result && result <= 79) {
	            grade = "C";
	        }else if (60 <= result && result <= 69) {
	            grade = "D";
	        }
	        System.out.println(grade);
	        scanner.close();
	}
}
