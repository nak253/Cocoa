package day11;

import java.util.Scanner;

public abstract class Menu {
    boolean isContinue;
    String option;

    public abstract void printMenu();

    public abstract void selectMenu();

    public boolean isContinue() {
        return this.isContinue;
    }
}
