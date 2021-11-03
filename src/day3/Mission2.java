package day3;

import java.util.Arrays;
import java.util.Scanner;

public class Mission2 {
	
	 String[][] world = new String[5][5];
	 String arrowKey ="";
	 int charactorRowIndex ;
	 int charactorColumnIndex ;
	 int charactorNextRowIndex ;
	 int charactorNextColumnIndex ;
	 boolean continueGame;
	
	private void createCharactor() {
		world[2][2] = "주인공";
		charactorRowIndex=2;
		charactorColumnIndex=2;
	}
	
	private void startGame() {
		while(continueGame) {
			continueGame=moveCharactor();
		}
	}
	
	private boolean moveCharactor() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("주인공은 현재 ("+charactorRowIndex+","+charactorColumnIndex+")에 위치하고 있습니다.");
		System.out.println(Arrays.deepToString(world));
		System.out.println("원하는 방향을 입력하세요(w,a,s,d)");
		
		charactorNextRowIndex=charactorRowIndex;
		charactorNextColumnIndex=charactorColumnIndex;
		
		arrowKey=scanner.next().toLowerCase();
		switch(arrowKey) {
		case "w": 
			charactorNextRowIndex = charactorRowIndex-1;
			break;
		case "a": 
			charactorNextColumnIndex = charactorColumnIndex-1;
			break;
		case "s": 
			charactorNextRowIndex = charactorRowIndex+1;	
			break;
		case "d": 
			charactorNextColumnIndex = charactorColumnIndex+1;
			break;
		}
		
		if(charactorNextRowIndex<0||charactorNextColumnIndex<0||charactorNextRowIndex>4||charactorNextColumnIndex>4) {
			System.out.println("더 이상 이동할 수 없습니다.");
			return false;
		}
		
		world[charactorNextRowIndex][charactorNextColumnIndex] = world[charactorRowIndex][charactorColumnIndex];
		world[charactorRowIndex][charactorColumnIndex] = null;
		charactorRowIndex=charactorNextRowIndex;
		charactorColumnIndex=charactorNextColumnIndex;

		
		return true;	
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Mission2 mission = new Mission2();
		
		System.out.println("게임을 시작하겠습니까?");
		System.out.println("게임시작을 원한다면 아무버튼을 눌러주세요 (종료:q)");
		System.out.print(">> ");
		
		String select = scanner.next();
		
		if(!select.equalsIgnoreCase("q")) {
			mission.continueGame = true;
			mission.createCharactor();
			mission.startGame();
		}
		System.out.println("게임이 종료되었습니다.");
			
		scanner.close();
	}

}
