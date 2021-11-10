package day8;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class BookDetail {
    final int PAYMENT_MIN_NUM =1;
    final int PAYMENT_MAX_NUM =2;

    String date;
    String note;
    int revenue;
    int expenditure;
    String formsOfPayment;
    int sum;

    public void enterDate() {
        date = "";
        Scanner s = new Scanner(System.in);
        String pattern ="MM/dd";
        DateFormat df = new SimpleDateFormat(pattern);
        Date d = null;
        System.out.println("날짜를 "+pattern+"형식으로 입력하세요.");
        while (s.hasNextLine()){
            try{
                d=df.parse(s.nextLine());
                break;
            }catch (Exception e){
                System.out.println("날짜를 "+pattern+"형식으로 다시 입력하세요.");
            }
        }
        date = df.format(d);
    }

    public void enterNote() {
        note ="";
        Scanner s = new Scanner(System.in);
        System.out.println("적요를 입력하세요");
        note = s.nextLine();
    }

    public void enterRevenue() {
        revenue = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("수입을 입력하세요");
        revenue = s.nextInt();
    }

    public void enterExpenditure() {
        expenditure =0;
        Scanner s = new Scanner(System.in);
        System.out.println("지출을 입력하세요");
        expenditure = s.nextInt();
    }

    public void enterFormsOfPayment() {
        formsOfPayment="";
        Scanner s = new Scanner(System.in);
        ValidationCheck vc = new ValidationCheck();
        String option ="";
        while(true){
            System.out.println("지불방식을 선택하세요");
            System.out.println("1: 카드");
            System.out.println("2: 현금");
            option = s.nextLine();
            if(vc.isCorrectInput(option,PAYMENT_MIN_NUM,PAYMENT_MAX_NUM)){
                break;
            }
        }
        selectFormsOfPayment(option);
    }

    private void selectFormsOfPayment(String option) {
        formsOfPayment ="카드";
        if(option.equals("2")){
            formsOfPayment ="현금";
        }
    }

    @Override
    public String toString() {
        return "날짜=" +date+ ", 적요=" +note+", 수입=" + revenue +
                ", 지출=" + expenditure +
                ", 지불방식=" + formsOfPayment ;
    }
}