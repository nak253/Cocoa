package day8;

public class ValidationCheck {

    public boolean isQuit(String option) {
        if(option.equalsIgnoreCase("q")){
            System.out.println("가계부를 종료합니다.");
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
}
