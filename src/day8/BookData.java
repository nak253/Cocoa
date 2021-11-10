package day8;

import java.util.List;

public class BookData {

    public void inputData(List<BookDetail> list) {
        BookDetail bookDetail = new BookDetail();

        bookDetail.enterDate();
        bookDetail.enterNote();
        bookDetail.enterRevenue();
        bookDetail.enterExpenditure();
        bookDetail.enterFormsOfPayment();

        list.add(bookDetail);
    }

    public void deleteData(List<BookDetail> list) {
        ValidationCheck vc = new ValidationCheck();
        System.out.println("삭제할 순번을 입력하세요");
        int index = vc.inputListIndex(list);
        if(!vc.checkList(list,index)){
            return;
        }
        list.remove(index);
        System.out.println(index+1+"번이 삭제되었습니다. ");
    }

    public void modifyData(List<BookDetail> list) {
        ValidationCheck vc = new ValidationCheck();
        System.out.println("수정할 순번을 입력하세요");
        int index = vc.inputListIndex(list);
        if(!vc.checkList(list,index)){
            return;
        }
        modifyBookDetail(list.get(index));
    }

    private void modifyBookDetail(BookDetail bookDetail) {
        Menu menu = new Menu();

        menu.startModifyMenu();
        menu.selectModifyMenu(bookDetail);
    }

    public void printAccountBook(List<BookDetail> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(" "+(i+1)+" : ");
            System.out.println(list.get(i));
        }
    }
}