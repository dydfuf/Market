package controller;

import model.GeneralUser;

import java.util.Scanner;

public class UserMaker {
    public UserMaker() {
    }
    public static Scanner scanner = new Scanner(System.in);
    final private String EmailPattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
    final private String PhoneNumberPattern = "^01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-](\\d{4})$";

    public GeneralUser makeUser(){

        scanner.reset();
        GeneralUser user = new GeneralUser();

        System.out.printf("Id : ");
        user.setId(scanner.next());

        System.out.printf("Passwd : ");
        user.setPasswd(scanner.next());

        System.out.printf("Name : ");
        user.setName(scanner.next());

        System.out.printf("E-mail : ");
        user.setMail_address(checkEmail(scanner.next()));

        System.out.printf("Phone Number : ");
        user.setPhone_number(checkPhoneNumber(scanner.next()));

        user.setActivated(0);

        return user;
    }

    public String checkEmail(String email){
        boolean valid;
        boolean power = true;
        while(power){
            valid = email.matches(EmailPattern);
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
            valid = PNumber.matches(PhoneNumberPattern);
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
