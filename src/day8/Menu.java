package day8;

import java.util.Scanner;

public class Menu {
    final char MIN_MENU_NUM='1';
    final char MAX_MENU_NUM='4';

    public boolean isContinue(String option){
        if(option.equalsIgnoreCase("q")){
            System.out.println("가계부를 종료합니다.");
            return false;
        }
        if(!(MIN_MENU_NUM<=option.charAt(0)&&option.charAt(0)<=MAX_MENU_NUM)){
            System.out.println("올바른 값을 입력하세요.");
            return false;
        }
        return true;
    }

    public void printMainMenu() {
        System.out.println("원하는 작업(1-4)을 선택하세요");
        System.out.println("1: 입력 ");
        System.out.println("2: 삭제");
        System.out.println("3: 수정");
        System.out.println("4: 가계부 보기");
        System.out.println("q: 종료");
    }

    public String selectMenu() {
        Scanner s = new Scanner(System.in);
        return s.next();
    }
}
