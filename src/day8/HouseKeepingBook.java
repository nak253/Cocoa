package day8;

import java.util.ArrayList;
import java.util.List;

public class HouseKeepingBook {

    private User user;
    private List<BookDetail> list ;

    public void init() {
        //User user = new User();
        //user.registerUser();
        list = new ArrayList<>();
    }

    public void start() {
        MainMenu menu = new MainMenu();
        while (true){
            menu.startMenu();
            if(!menu.isContinue()){
                System.out.println("가계부를 종료합니다.");
                break;
            }
            menu.selectMainMenu(list);
        }
    }
}