package controller;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UserControl {
    public UserControl() {
    }
    public UserManager um = new UserManager();
    public BookManager bm = new BookManager();
    public Scanner scanner = new Scanner(System.in);

    private final String filepath = "/Users/choeyonglyeol/IdeaProjects/test";
    private final String UserFileName = "UserList.txt";
    private final String filename = "BookList.txt";

    public void ShowUserList() throws IOException {
        um.setUserList(UserFileUtil.readFile(new File(filepath, UserFileName)));
        um.showAllUser();
    }

    public String Login() throws IOException {
        um.setUserList(UserFileUtil.readFile(new File(filepath, UserFileName)));
        System.out.print("ID : ");
        String id = scanner.next();
        System.out.print("Passwd : ");
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

    public int RegistUser() throws IOException {
        um.setUserList(UserFileUtil.readFile(new File(filepath, UserFileName)));
        UserMaker umaker = new UserMaker();
        int a = um.addUser(umaker.makeUser());
        UserFileUtil.writeFile(filepath, UserFileName, um.getUserList());
        return a;
    }

    public void ActivateUser(String id, int active) throws IOException {
        um.setUserList(UserFileUtil.readFile(new File(filepath, UserFileName)));
        um.ActivateUser(id,active);
        UserFileUtil.writeFile(filepath, UserFileName, um.getUserList());
    }

    public void RemoveUser(String id) throws IOException {
        um.setUserList(UserFileUtil.readFile(new File(filepath, UserFileName)));
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));

        if(um.removeUser(id) == 0){
            bm.RemoveBookById(id);
        }

        BookFileUtil.writeFile(filepath, filename, bm.getBookList());
        UserFileUtil.writeFile(filepath, UserFileName, um.getUserList());
    }

}
