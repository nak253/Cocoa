package day3;

import java.util.Scanner;

public class Mission1 {
	
	String[] yearNames= {"시끄러운","푸른","어두운","조용한","웅크린","백색","지혜로운","용감한","날카로운","욕심 많은"};
	String[] monthNames= {"늑대","태양","양","매","황소","불꽃","나무","달빛","말","돼지","하늘","바람"};
	String[] daysNames= {"와(과) 함께 춤을", "의 기상", "은(는) 그림자 속에"," "," ",
						" ","의 환생","의 죽음"," 아래에서", "를(을) 보라",
						"이(가) 노래하다", "의 그림자", "의 일격", "에게 쫓기는 남자", "의 행진",
						"의 왕", "의 유령", "을(를) 죽인 자", "은(는) 맨날 잠잔다", "처럼",
						"의 고향", "의 전사", "은(는) 나의 친구", "의 노래", "의 정령",
						"의 파수꾼", "의 악마", "와(과) 같은 사나이", "를(을) 쓰러트린 자", "의 혼",
						"은(는) 말이 없다"};
	
	private String generateName(int year, int month, int day) {
		String name = yearNames[year] +" "+ monthNames[month] + daysNames[day];
		return name.trim();
	}
	private void printName(int year, int month, int day) {
		System.out.println("당신의 이름은 "+generateName(year, month, day)+"입니다.");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("생년월일을 입력해 주세요>");
		int year = scanner.nextInt()%10;
		int month = scanner.nextInt()-1;
		int day = scanner.nextInt()-1;
		
		Mission1 mission = new Mission1();
		mission.printName(year,month,day);
		
		scanner.close();
	}
}
