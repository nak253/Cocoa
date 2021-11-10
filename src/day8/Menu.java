package day8;

import java.util.List;
import java.util.Scanner;

public abstract class Menu {
    int menuMinNum ;
    int menuMaxNum ;
    boolean isContinue;
    String option;

    public void inputMenuOption() {
        Scanner s = new Scanner(System.in);
        this.option = s.nextLine();
    }

    public boolean isContinue(){
        return this.isContinue;
    }

    public void startMenu() {
        ValidationCheck vc = new ValidationCheck();
        while (true){
            printMenu();
            inputMenuOption();
            if(vc.isQuit(option)){
                isContinue = false;
                break;
            }
            if (vc.isCorrectInput(option,menuMinNum,menuMaxNum)) {
                isContinue = true;
                break;
            }
        }
    }

    public abstract void printMenu();

}