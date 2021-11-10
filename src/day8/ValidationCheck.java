package day8;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ValidationCheck {

    public boolean isQuit(String option) {
        if(option.equalsIgnoreCase("q")){
            return true;
        }
        return false;
    }

    public boolean isCorrectInput(String option, int min, int max){
        char charMin = (char)(min+'0');
        char charMax =(char)(max+'0');

        if(option.length()!=1){
            System.out.println("올바른 값을 입력하세요.");
            return false;
        }

        if(!(charMin<=option.charAt(0)&&option.charAt(0)<=charMax)){
            System.out.println("올바른 값을 입력하세요.");
            return false;
        }
        return true;
    }

    public int inputListIndex(List<BookDetail> list) {
        Scanner s = new Scanner(System.in);
        int index =0;
        try{
            index = s.nextInt()-1;
        }catch (InputMismatchException e){
            index =-1;
        }
        return index;
    }

    public boolean checkList(List<BookDetail> list, int index){
        if(list.isEmpty()){
            System.out.println("가계부가 존재하지 않습니다.");
            return false;
        }
        if(index<0||list.size()-1<index) {
            System.out.println("해당 목록이 존재하지 않습니다.");
            return false;
        }
        return true;
    }
}