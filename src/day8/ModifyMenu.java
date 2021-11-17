package day8;

public class ModifyMenu extends Menu{

    ModifyMenu(){
        this.menuMinNum =1;
        this.menuMaxNum =5;
    }

    public void printMenu() {
        System.out.println("원하는 수정작업(1-5)을 선택하세요");
        System.out.println("1: 날짜 ");
        System.out.println("2: 적요");
        System.out.println("3: 수입");
        System.out.println("4: 지출");
        System.out.println("5: 지불방식");
        System.out.println("q: 이전 메뉴");
    }
    public void selectModifyMenu(BookDetail bookDetail) {
        switch (this.option){
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
