package day3;

import java.util.Arrays;
import java.util.Scanner;

public class Mission2 {

	final int WORLD_SIZE = 5;
	String[][] world = new String[WORLD_SIZE][WORLD_SIZE];
	String arrowKey = "";
	int charactorRowIndex;
	int charactorColumnIndex;
	int charactorNextRowIndex;
	int charactorNextColumnIndex;

	int bombRowIndex;
	int bombColumnIndex;
	
	int monsterRowIndex;
	int monsterColumnIndex;
	
	int point;

	boolean continueGame;
	
	int bombCounter;

	private void createCharactor() {
		charactorRowIndex = WORLD_SIZE/2;
		charactorColumnIndex = WORLD_SIZE/2;
		world[charactorRowIndex][charactorColumnIndex] = "���ΰ�";
		
	}

	private void createBomb() {
		if(bombCounter==1) {
			world[bombRowIndex][bombColumnIndex]=null;
		}
		
		bombRowIndex = (int) (Math.random() * WORLD_SIZE);
		bombColumnIndex = (int) (Math.random() *WORLD_SIZE);
		if(bombRowIndex == charactorRowIndex && bombColumnIndex ==charactorColumnIndex) {
			bombCounter=0;
			createBomb(); //��ź�� ���ΰ���ġ�� ��ĥ ��� ����
		}else {
			world[bombRowIndex][bombColumnIndex] = "��ź";
			bombCounter=1;
		}

		
		
	}
	
	private void createMonster() {

		monsterRowIndex = (int) (Math.random() * WORLD_SIZE);
		monsterColumnIndex = (int) (Math.random() *WORLD_SIZE);
		
		if ((monsterRowIndex == charactorRowIndex && monsterColumnIndex == charactorColumnIndex)
				||( monsterRowIndex == bombRowIndex && monsterColumnIndex == bombColumnIndex)) {
				createMonster(); //������ ���ΰ� �Ǵ� ��ź��ġ�� ��ĥ ��� ����
		}else {
			world[monsterRowIndex][monsterColumnIndex] = "����";
		}
	}


	private void startGame() {
		
		createCharactor();
		createBomb();
		createMonster();
		continueGame = true;

		while (continueGame) {
			System.out.println("����迭�� ���� :"+Arrays.deepToString(world));				
			continueGame = succeedInMoving();
		}
		getPoint();
	}

	private boolean succeedInMoving() {

		
		if(!menu()) {
			return false;
		}
	
		if (charactorNextRowIndex < 0 || charactorNextColumnIndex < 0 || charactorNextRowIndex > 4
				|| charactorNextColumnIndex > 4) {
			System.out.println("�� �̻� �̵��� �� �����ϴ�.");
			return false;
		}
		
		if (isBomb()) {
			return false;
		}
		
		encounterMonster();
		return true;
	}

	private boolean menu() {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("���ϴ� ������ �Է��ϼ��� [w,a,s,d] (����[q])");
		System.out.print(">> ");
		
		arrowKey=scanner.next().toLowerCase();
		System.out.println();
		
		charactorNextRowIndex=charactorRowIndex;
		charactorNextColumnIndex=charactorColumnIndex;
		
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
		case "q": 
			return false;

		}
		return true;
	}

	private void getPoint() {
		System.out.println("����� ������ "+point+"�� �Դϴ�.");	
	}

	private boolean isBomb() {
		if ("��ź".equals(world[charactorNextRowIndex][charactorNextColumnIndex])) {
			System.out.println();
			System.out.println("��ź�� ��ҽ��ϴ�.");
			return true;
		}
		return false;
	}
	
	private void encounterMonster() {
		if ("����".equals(world[charactorNextRowIndex][charactorNextColumnIndex])) {
			moveChractor();	
			System.out.println();
			System.out.println("������ �������ϴ�.");
			System.out.println("������ �����ƽ��ϴ�.");
			System.out.println("��ź�� ������ ���Ӱ� ��ġ�˴ϴ�.");
			System.out.println();
			
			scorePoint();
			createBomb();
			createMonster();
			return;
		}
		moveChractor();	
		return;
	}

	private void scorePoint() {
		point++;
		
	}

	private void moveChractor() {
		world[charactorNextRowIndex][charactorNextColumnIndex] = world[charactorRowIndex][charactorColumnIndex];
		world[charactorRowIndex][charactorColumnIndex] = null;
		charactorRowIndex = charactorNextRowIndex;
		charactorColumnIndex = charactorNextColumnIndex;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Mission2 mission = new Mission2();
		
		System.out.println("������ �����ϰڽ��ϱ�?");
		System.out.println("���ӽ����� ���Ѵٸ� �ƹ���ư�� �����ּ��� (����:q)");
		System.out.print(">> ");
		
		String select = scanner.next();

		
		if (!select.equalsIgnoreCase("q")) {
			System.out.println();
			mission.startGame();
		}
		System.out.println("������ ����Ǿ����ϴ�.");

		scanner.close();
	}

}
