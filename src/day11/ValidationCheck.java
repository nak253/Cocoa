package day11;

public class ValidationCheck {

    public boolean isQuit(String option) {
        if(option.equalsIgnoreCase("q")){
            return true;
        }
        return false;
    }

    public boolean isCorrectInput(String option,int min,int max) {
        char charMin = (char)(min+'0');
        char charMax = (char)(max+'0');

        if(option.length()!=1){
            System.out.println("올바른 값을 입력하세요.");
            return false;
        }
        if(!(charMin<=option.charAt(0)&&option.charAt(0)<=charMax)){
            System.out.println("올바른 메뉴를 입력하세요.");
            return false;
        }
        return true;
    }
    public boolean isCorrectCommand(String option,String[] correctCommand) {
        for (String command: correctCommand) {
            if(option.equalsIgnoreCase(command)){
                return true;
            }
        }
     return false;
    }
}
