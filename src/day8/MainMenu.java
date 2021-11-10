package day8;

import java.util.List;

public class MainMenu extends Menu{

    MainMenu(){
        this.menuMinNum =1;
        this.menuMaxNum =4;
    }

    public void printMenu() {
        System.out.println("원하는 작업(1-4)을 선택하세요");
        System.out.println("1: 입력 ");
        System.out.println("2: 삭제");
        System.out.println("3: 수정");
        System.out.println("4: 가계부 보기");
        System.out.println("q: 종료");
    }
    public void selectMainMenu(List<BookDetail> list) {
        BookData bookData = new BookData();
        switch (this.option){
            case "1":
                bookData.inputData(list);
                break;
            case "2":
                bookData.deleteData(list);
                break;
            case "3":
                bookData.modifyData(list);
                break;
            case "4":
                bookData.printAccountBook(list);
                break;
        }
    }
}
