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

    public void printAccountBook(List<BookDetail> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.printf(" "+(i+1)+" : ");
            System.out.println(list.get(i));
        }
    }
}
