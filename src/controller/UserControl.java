package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserControl {
    public UserControl() {
    }
    public static UserManager um = new UserManager();
    public static BookManager bm = new BookManager();
    public static Scanner scanner = new Scanner(System.in);

    public static String filepath = "/Users/choeyonglyeol/IdeaProjects/test";
    public static String UserFileName = "UserList.txt";
    public static String filename = "BookList.txt";

    public static void ShowUserList() throws IOException {
        um.setUserList(UserFileUtil.readFile(new File(filepath, UserFileName)));
        um.showAllUser();
    }

    public static String Login() throws IOException {
        um.setUserList(UserFileUtil.readFile(new File(filepath, UserFileName)));
        System.out.printf("ID : ");
        String id = scanner.next();
        System.out.printf("Passwd : ");
        String passwd = scanner.next();
        int ret = um.compareToLogin(id, passwd);
        if(ret == 0) {
            //일반 유저로 로그인
            return id;
        }
        else if(ret == 3){
            //관리자로 로그인
            return id;
        }
        return "";
    }

    public static int RegistUser() throws IOException {
        um.setUserList(UserFileUtil.readFile(new File(filepath, UserFileName)));
        int a = um.addUser(UserMaker.makeUser());
        UserFileUtil.writeFile(filepath, UserFileName, um.getUserList());
        return a;
    }

    public static void ActivateUser(String id, int active) throws IOException {
        um.setUserList(UserFileUtil.readFile(new File(filepath, UserFileName)));
        um.ActivateUser(id,active);
        UserFileUtil.writeFile(filepath, UserFileName, um.getUserList());
    }

    public static void RemoveUser(String id) throws IOException {
        um.setUserList(UserFileUtil.readFile(new File(filepath, UserFileName)));
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));

        if(um.removeUser(id) == 0){
            bm.RemoveBookById(id);
        }

        BookFileUtil.writeFile(filepath, filename, bm.getBookList());
        UserFileUtil.writeFile(filepath, UserFileName, um.getUserList());
    }

}
