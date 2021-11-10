package day8;

import java.util.Scanner;

public class User {

    private String userName;
    private String password;

    public void registerUser() {

        Scanner s = new Scanner(System.in);

        System.out.println("사용자 이름을 입력하세요.");
        this.userName = s.nextLine();
        System.out.println("비밀번호를 입력하세요.");
        this.password = s.nextLine();

    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
