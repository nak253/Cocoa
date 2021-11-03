package day3;

import java.util.Scanner;

public class Mission1 {
	
	String[] yearNames= {"�ò�����","Ǫ��","��ο�","������","��ũ��","���","�����ο�","�밨��","��ī�ο�","��� ����"};
	String[] monthNames= {"����","�¾�","��","��","Ȳ��","�Ҳ�","����","�޺�","��","����","�ϴ�","�ٶ�"};
	String[] daysNames= {"��(��) �Բ� ����", "�� ���", "��(��) �׸��� �ӿ�"," "," ",
						" ","�� ȯ��","�� ����"," �Ʒ�����", "��(��) ����",
						"��(��) �뷡�ϴ�", "�� �׸���", "�� �ϰ�", "���� �ѱ�� ����", "�� ����",
						"�� ��", "�� ����", "��(��) ���� ��", "��(��) �ǳ� ���ܴ�", "ó��",
						"�� ����", "�� ����", "��(��) ���� ģ��", "�� �뷡", "�� ����",
						"�� �ļ���", "�� �Ǹ�", "��(��) ���� �糪��", "��(��) ����Ʈ�� ��", "�� ȥ",
						"��(��) ���� ����"};
	
	private String generateName(int year, int month, int day) {
		String name = yearNames[year] +" "+ monthNames[month] + daysNames[day];
		return name.trim();
	}
	private void printName(int year, int month, int day) {
		System.out.println("����� �̸��� "+generateName(year, month, day)+"�Դϴ�.");
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������� �Է��� �ּ���>");
		int year = scanner.nextInt()%10;
		int month = scanner.nextInt()-1;
		int day = scanner.nextInt()-1;
		
		Mission1 mission = new Mission1();
		mission.printName(year,month,day);
		
		scanner.close();
	}
}
