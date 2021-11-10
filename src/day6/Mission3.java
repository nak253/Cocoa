package day6;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Mission3 {
    static Map<String,String> user;
    static List<ArrayList> list = new ArrayList<ArrayList>();
    static Scanner s = new Scanner(System.in);

    public void startHouseKeepingBook(){
        String menu ="";
        user = registerUser();

        while (!menu.equals("q")){
            printMenu();
            menu = selectMenu();
            s.nextLine();
        }
    }

    private HashMap<String,String> registerUser() {

        HashMap<String,String> user = new HashMap<String,String>();

        System.out.println("사용자 이름을 입력하세요.");
        user.put("userName",s.nextLine());
        System.out.println("비밀번호를 입력하세요.");
        user.put("password",s.nextLine());

        return user;
    }

    private void printMenu() {
        System.out.println("원하는 작업(1-4)을 선택하세요");
        System.out.println("1: 입력 ");
        System.out.println("2: 삭제");
        System.out.println("3: 수정");
        System.out.println("4: 가계부 보기");
        System.out.println("q: 종료");
    }

    private String selectMenu() {
        String menu = s.nextLine();
        switch (menu.toLowerCase()){
            case "1":
                inputData();
                break;
            case "2":
                deleteData();
                break;
            case "3":
                modifyData();
                break;
            case "4":
                printHouseKeepingBook();
                break;
            case "q":
                System.out.println("가계부를 종료합니다.");
                break;
            default:
                break;
        }
        return menu;
    }

    private void inputData() {
        ArrayList item = new ArrayList();

        item.add(enterDate());
        item.add(enterNote());
        item.add(enterRevenue());
        item.add(enterExpenditure());

        calculateBalance(item);

        list.add(item);
    }

    private String enterDate() {

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
        return df.format(d);
    }

    private String enterNote() {
        System.out.println("적요를 입력하세요");
        return s.nextLine();
    }

    private int enterRevenue() {
        System.out.println("수입을 입력하세요");
        return s.nextInt();
    }

    private int enterExpenditure() {
        System.out.println("지출을 입력하세요");
        return s.nextInt();
    }

    private void calculateBalance(ArrayList item) {
        int revenue =(Integer)item.get(2);
        int expenditure =(Integer)item.get(3);

        item.add(item.size(),revenue-expenditure);
    }

    private void deleteData() {

        System.out.println("삭제할 순번을 입력하세요");
        int index = s.nextInt()-1;

        if(!checkNum(index,list)){
            return;
        }
        list.remove(index);
        System.out.println(index+1+"번이 삭제되었습니다. ");
    }

    private void modifyData() {
        System.out.println("수정할 순번을 입력하세요");
        int index = s.nextInt()-1;
        s.nextLine();
        String menu = "";

        if(!checkNum(index,list)){
          return;
        }

        System.out.println("원하는 수정작업(1-4)을 선택하세요");

        System.out.println("1: 날짜 ");
        System.out.println("2: 적요");
        System.out.println("3: 수입");
        System.out.println("4: 지출");

        modifyItem(list.get(index));
    }

    private void modifyItem(ArrayList item) {

        int index = s.nextInt()-1;
        s.nextLine();

        if(!checkNum(index,item)){
            return;
        }
        item.remove(index);
        switch (index){
            case 0 :
                item.add(index,enterDate());
                break;
            case 1:
                item.add(index,enterNote());
                break;
            case 2:
                item.add(index,enterRevenue());
                item.remove(item.size()-1);
                calculateBalance(item);
                break;
            case 3:
                item.add(index,enterExpenditure());
                item.remove(item.size()-1);
                calculateBalance(item);
                break;
            default:
                System.out.println("해당 목록이 존재하지 않습니다.");
                break;
        }
    }

    private boolean checkNum(int index,List list){
        if(list.isEmpty()){
            System.out.println("가계부가 존재하지 않습니다.");
            return false;
        }
        if(list.size()-1<index||index<0) {
            System.out.println("해당 목록이 존재하지 않습니다.");
            return false;
        }
        return true;
    }

    private void printHouseKeepingBook() {
        int balance =0;
        System.out.printf("%10s %15s %15s %15s %15s %15s%n","순번","날짜","적요","수입","지출","합계");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%10s",i+1+"");
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.printf("%15s ",list.get(i).get(j).toString());
            }
            balance += (Integer) (list.get(i).get(list.get(i).size()-1));
            System.out.println();
        }
        System.out.println("=================================================================");
        System.out.printf("잔액 : %10d%n",balance);
    }

    public static void main(String[] args) {
        Mission3 m = new Mission3();
        m.startHouseKeepingBook();
        s.close();
    }
}
