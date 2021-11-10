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
        Menu menu = new Menu();
        while (true){
            menu.startMainMenu();
            if(!menu.isContinue()){
                break;
            }
            menu.selectMainMenu(list);
        }
    }
}