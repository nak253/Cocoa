package day8;

import java.util.List;
import java.util.Scanner;

public class Menu {
    final int MAIN_MENU_MIN_NUM =1;
    final int MAIN_MENU_MAX_NUM =4;
    final int MODIFY_MENU_MIN_NUM =1;
    final int MODIFY_MENU_MAX_NUM =5;
    private boolean isContinue;
    private String option;

    public void inputMenuOption() {
        Scanner s = new Scanner(System.in);
        this.option = s.nextLine();
    }

    public boolean isContinue(){
        return this.isContinue;
    }

    public void startMainMenu() {
        ValidationCheck vc = new ValidationCheck();
        while (true){
            printMainMenu();
            inputMenuOption();
            if(vc.isQuit(option)){
                isContinue = false;
                break;
            }
            if (vc.isCorrectInput(option,MAIN_MENU_MIN_NUM,MAIN_MENU_MAX_NUM)) {
                isContinue = true;
                break;
            }
        }
    }

    public void startModifyMenu() {
        ValidationCheck vc = new ValidationCheck();
        while (true){
            printModifyMenu();
            inputMenuOption();
            if (vc.isCorrectInput(option,MODIFY_MENU_MIN_NUM,MODIFY_MENU_MAX_NUM)) {
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

    public void printModifyMenu() {
        System.out.println("원하는 수정작업(1-5)을 선택하세요");
        System.out.println("1: 날짜 ");
        System.out.println("2: 적요");
        System.out.println("3: 수입");
        System.out.println("4: 지출");
        System.out.println("5: 지불방식");
    }

    public void selectMainMenu(List<BookDetail> list) {
        BookData bookData = new BookData();
        switch (option){
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
    public void selectModifyMenu(BookDetail bookDetail) {
        BookData bookData = new BookData();
        switch (option){
            case "1" :
                bookDetail.enterDate();
                break;
            case "2":
                bookDetail.enterNote();
                break;
            case "3":
                bookDetail.enterRevenue();
                break;
            case "4":
                bookDetail.enterExpenditure();
                break;
            case "5":
                bookDetail.enterFormsOfPayment();
                break;
        }
    }
}