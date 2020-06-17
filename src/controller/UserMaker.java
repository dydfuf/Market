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
        user.setId(scanner.next());

        System.out.print("Passwd : ");
        user.setPasswd(scanner.next());

        System.out.print("Name : ");
        user.setName(scanner.next());

        System.out.print("E-mail : ");
        user.setMail_address(checkEmail(scanner.next()));

        System.out.print("Phone Number : ");
        user.setPhone_number(checkPhoneNumber(scanner.next()));

        user.setActivated(0);

        return user;
    }

    public String checkEmail(String email){
        boolean valid;
        boolean power = true;
        while(power){
            String emailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
            valid = email.matches(emailPattern);
            if(valid){
                power = false;
            }
            else {
                System.out.println("유효한 이메일 주소를 입력해 주세요 (ex. xxx@xxx.xxx)");
                email = scanner.next();
            }
        }
        return email;
    }

    public String checkPhoneNumber(String PNumber){
        boolean valid;
        boolean power = true;
        while(power){
            String phoneNumberPattern = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-](\\d{4})$";
            valid = PNumber.matches(phoneNumberPattern);
            if(valid){
                power = false;
            }
            else {
                System.out.println("유효한 전화번호를 입력해 주세요 (ex. 01x-xxxx-xxxx)");
                PNumber = scanner.next();
            }
        }
        return PNumber;
    }
}
