package day3;

import java.util.Arrays;
import java.util.Scanner;

public class Mission0 {
	
	private String[] memberList = {"BC","호두마루","Dave","Barney","meatsby","mong","Jun","Phil","Dike"};
	
	public String[] shuffle(String[] Array) {
		String temp ="";
		int random=0;
		for(int i =0; i<Array.length;i++) {
			random = (int)(Math.random()*Array.length);
			temp=Array[i];
			Array[i]=Array[random];
			Array[random]=temp;
		}
		return Array;
	}
	
	public String[] selectMember(int num) {
		return Arrays.copyOf(shuffle(memberList), num);
	}
	
	public void printRandomMember(int num) {
		if(memberList.length<num||num<1) {
			System.out.println("다시 입력해주세요");
			return;
		}
		System.out.println(Arrays.toString(selectMember(num)));
	}
	
	public static void main(String[] args) {
		Mission0 mission = new Mission0();
		Scanner scanner = new Scanner(System.in);
		System.out.print("몇 명인가요? ");
		
		int num =scanner.nextInt();
		
		mission.printRandomMember(num); 
		scanner.close();
	}

}
