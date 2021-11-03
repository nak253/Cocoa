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
		world[2][2] = "���ΰ�";
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
		System.out.println("���ΰ��� ���� ("+charactorRowIndex+","+charactorColumnIndex+")�� ��ġ�ϰ� �ֽ��ϴ�.");
		System.out.println(Arrays.deepToString(world));
		System.out.println("���ϴ� ������ �Է��ϼ���(w,a,s,d)");
		
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
			System.out.println("�� �̻� �̵��� �� �����ϴ�.");
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
		
		System.out.println("������ �����ϰڽ��ϱ�?");
		System.out.println("���ӽ����� ���Ѵٸ� �ƹ���ư�� �����ּ��� (����:q)");
		System.out.print(">> ");
		
		String select = scanner.next();
		
		if(!select.equalsIgnoreCase("q")) {
			mission.continueGame = true;
			mission.createCharactor();
			mission.startGame();
		}
		System.out.println("������ ����Ǿ����ϴ�.");
			
		scanner.close();
	}

}
