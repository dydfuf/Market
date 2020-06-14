package controller;

import model.GeneralUser;

import java.util.Scanner;

public class UserMaker {
    public UserMaker() {
    }
    public static Scanner scanner = new Scanner(System.in);

    public static GeneralUser makeUser(){

        scanner.reset();
        GeneralUser user = new GeneralUser();

        System.out.printf("Id : ");
        user.setId(scanner.next());

        System.out.printf("Passwd : ");
        user.setPasswd(scanner.next());

        System.out.printf("Name : ");
        user.setName(scanner.next());

        System.out.printf("E-mail : ");
        user.setMail_address(scanner.next());

        System.out.printf("Phone Number : ");
        user.setPhone_number(scanner.next());

        user.setActivated(0);

        return user;
    }
}
