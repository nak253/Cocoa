package day8;

import java.util.ArrayList;
import java.util.List;

public class HouseKeepingBook {

    private User user;
    private List<BookDetail> list ;

    public void init() {
        User user = new User();
        user.registerUser();
        list = new ArrayList<>();
        System.out.println("user = " + user);
    }

    public void start() {
        Menu menu = new Menu();
        String option="";
        while (true){
            menu.printMainMenu();
            option = menu.selectMenu();
            if (!menu.isContinue(option)){
                break;
            }
            System.out.println(option);
        }
    }


}
