package day8;

import java.util.List;
import java.util.Scanner;

public class Menu {
    final int MAIN_MENU_MIN_NUM =1;
    final int MAIN_MENU_MAX_NUM =4;
    private boolean isContinue;
    private String mainMenuOption;

    public void startMainMenu() {
        ValidationCheck vc = new ValidationCheck();
        while (true){
            printMainMenu();
            inputMenuOption();
            if(vc.isQuit(mainMenuOption)){
                isContinue = false;
                break;
            }
            if (vc.isCorrectInput(mainMenuOption,MAIN_MENU_MIN_NUM,MAIN_MENU_MAX_NUM)) {
                isContinue = true;
                break;
            }
        }
    }

    public void printMainMenu() {
        System.out.println("원하는 작업(1-4)을 선택하세요");
        System.out.println("1: 입력 ");
        System.out.println("2: 삭제");
        System.out.println("3: 수정");
        System.out.println("4: 가계부 보기");
        System.out.println("q: 종료");
    }

    public void inputMenuOption() {
        Scanner s = new Scanner(System.in);
        this.mainMenuOption = s.nextLine();
    }

    public boolean isContinue(){
        return this.isContinue;
    }

    public void selectMainMenu(List<BookDetail> list) {
        BookData bookData = new BookData();
        switch (mainMenuOption){
            case "1":
                bookData.inputData(list);
                break;
//            case "2":
//                deleteData(list);
//                break;
//            case "3":
//                modifyData(list;
//                break;
            case "4":
                bookData.printAccountBook(list);
                break;
        }
    }
}
