package day1.conditional;

import java.util.Scanner;

public class Num1330 {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
		 int a = scanner.nextInt();
		 int b = scanner.nextInt();
		 
		 String result = "==";
		 
		 if(-10000<=a&&a<=10000&-10000<=b&&b<=10000) {
			 if(a>b) {
				 result=">";
			 }else if(a<b) {
				 result="<";
			 }
		 }
		 System.out.println(result);
		 
		 scanner.close();
	}

}
