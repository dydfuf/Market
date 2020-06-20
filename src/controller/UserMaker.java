package controller;

import model.GeneralUser;

import java.util.Scanner;

public class UserMaker {
    public UserMaker() {
    }
    public static Scanner scanner = new Scanner(System.in);

    public GeneralUser makeUser(){

        scanner.reset();
        GeneralUser user = new GeneralUser();

        System.out.print("Id : ");
        user.setId(scanner.nextLine());

        System.out.print("Passwd : ");
        user.setPasswd(scanner.nextLine());

        System.out.print("Name : ");
        user.setName(scanner.nextLine());

        System.out.print("E-mail : ");
        String email = scanner.nextLine();
        while(true){
            if(checkEmail(email)){
                user.setMailAddress(email);
                break;
            }
            else {
                System.out.println("유효한 이메일 주소를 입력해 주세요 (ex. xxx@xxx.xxx)");
                System.out.print("E-mail : ");
                email = scanner.nextLine();
            }
        }

        System.out.print("Phone Number : ");
        String PhoneNumber = scanner.nextLine();
        while(true){
            if(checkPhoneNumber(PhoneNumber)){
                user.setPhoneNumber(PhoneNumber);
                break;
            }
            else {
                System.out.println("유효한 전화번호를 입력해 주세요 (ex. 01x-xxxx-xxxx)");
                System.out.print("Phone Number : ");
                PhoneNumber = scanner.nextLine();
            }
        }

        user.setActivated(0);

        return user;
    }

    public boolean checkEmail(String email){
        return email.matches("^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$");
    }

    public boolean checkPhoneNumber(String PNumber){
        return PNumber.matches("^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-](\\d{4})$");
    }
}
