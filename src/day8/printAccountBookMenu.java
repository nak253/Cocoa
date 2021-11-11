package day8;

import java.util.List;

public class printAccountBookMenu extends Menu {

    printAccountBookMenu(){
        this.menuMinNum =1;
        this.menuMaxNum =4;
    }

    @Override
    public void printMenu() {
        System.out.println("원하는 작업(1-4)을 선택하세요");
        System.out.println("1: 입력 순서대로 보기 ");
        System.out.println("2: 날짜 순서대로 보기");
        System.out.println("3: 금액 오름차순으로 보기");
        System.out.println("4: 금액 내림차순으로 보기");
        System.out.println("q: 이전으로");
    }

    public void selectPrintMenu(List<BookDetail> list) {
        switch (this.option) {
            case "1":
                normalPrint(list);
                break;
            case "2":
                break;
            case "3":
                break;
            case "4":
                break;
        }
    }

    public void normalPrint(List<BookDetail> list){
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(" "+(i+1)+" : ");
            System.out.println(list.get(i));
        }
    }
}

