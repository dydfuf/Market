package view;

import controller.BookControl;
import controller.UserControl;

import java.io.IOException;
import java.util.Scanner;

public class View {

    public View() {
    }

    public static Scanner scanner = new Scanner(System.in);

    public static String LoginUserName;

    public void LoginView() throws IOException {
        boolean login = true;

        while(login){
            scanner.reset();
            System.out.println("----------로그인----------");
            System.out.println("1. 로그인 2. 회원가입 3. 종료");

            String menuNum = scanner.nextLine();
            UserControl us = new UserControl();

            switch(menuNum){
                case "1":
                    LoginUserName = us.Login();
                    if(LoginUserName.equals("admin")){
                        AdminView();
                        login = false;
                    }
                    else if(LoginUserName.isEmpty()){
                        //why this state need?
                        System.out.println("로그인 에러");
                    }
                    else{
                        GeneralUserView();
                    }
                    //goto GeneralUserView or AdminView
                    break;
                case "2":
                    RegisterView();
                    //goto RegisterView
                    break;
                case "3":
                    System.out.println("프로그램을 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("1~3사이의 숫자를 입력하시기 바랍니다.");
                    break;
            }
        }
    }

    public void RegisterView() throws IOException {
        System.out.println("회원가입 창");
        UserControl uc = new UserControl();
        int a = uc.RegistUser();
        if(a == 0){
            System.out.println("가입한 ID로 로그인 하시기 바랍니다.\n");
        }
        else if(a==2){
            RegisterView();
        }
        //register
    }

    public void GeneralUserView() throws IOException {
        while(true){
            System.out.println("일반유저 창\n" + "User name : " + LoginUserName);
            System.out.println("1.등록된 책 전부 보기 2.책 검색하기 3.내가 등록한 책 보기 4.책 등록하기 5.이전으로 가기 6.종료");
            scanner.reset();
            String menuNum = scanner.nextLine();
            BookControl bc = new BookControl();
            switch(menuNum){
                case "1":
                    //view all books
                    bc.ShowBookList();
                    //BookControl.ShowBookList();
                    TradeBookView();
                    //goto TradeBookView
                    break;
                case "2":
                    //Search and view books
                    if(SearchBookView() == 0) TradeBookView();
                    //goto SearchBooksView
                    break;
                case "3":
                    //view what I registered book
                    bc.SearchBook(LoginUserName, "seller");
                    UpdateMyBook(LoginUserName);
                    //goto ReviseMyBookView
                    break;
                case "4":
                    bc.AddBook(LoginUserName);
                    //Register Book
                    //goto RegisterBookView
                    break;
                case "5":
                    LoginView();
                    //goto LoginView
                case "6":
                    System.exit(0);
                    //exit
                default:
                    System.out.println("1~6사이의 숫자를 입력하시기 바랍니다.");
                    break;
            }
        }
    }

    public void AdminView() throws IOException {

        BookControl bc = new BookControl();
        UserControl uc = new UserControl();

        while (true){
            System.out.println("관리자 창");
            System.out.println("1.등록된 책 전부 보기 2.책 검색하기 3.등록된 유저 전부 보기 4.이전으로 가기 5.종료");
            String menuNum = scanner.nextLine();
            switch(menuNum){
                case "1":
                    //show all books
                    bc.ShowBookList();
                    RemoveBookView();
                    break;
                case "2":
                    //Search books
                    if (SearchBookView() == 0) RemoveBookView();
                    //goto DeleteBooks
                    break;
                case "3":
                    //view AllUsers
                    uc.ShowUserList();
                    ReviseUsersView();
                    //goto ReviseUser
                    break;
                case "4":
                    LoginView();
                    //goto LoginView
                    break;
                case "5":
                    System.exit(0);
                    //exit
                    break;
                default:
                    System.out.println("1~6사이의 숫자를 입력하시기 바랍니다.");
                    break;
            }
        }

    }

    public int SearchBookView() throws IOException {
        System.out.println("책 검색창");
        int ret = 0;
        boolean power = true;
        BookControl bc = new BookControl();
        while(power){
            scanner.reset();
            System.out.println("1.책제목 2.ISBN번호 3.저자 4.판매자 5.출판사 6.출판년도 7.뒤로가기");

            String menuNum = scanner.nextLine();
            int a;
            switch (menuNum){
                case "1":
                    //search by title
                    System.out.print("책이름 : ");
                    String title = scanner.next();
                    a = bc.SearchBook(title, "title");
                    if(a == 0) power = false;
                    break;
                case "2":
                    //search by isbn
                    System.out.print("ISBN : ");
                    String isbn = scanner.next();
                    a = bc.SearchBook(isbn, "ISBN");
                    if(a == 0) power = false;
                    break;
                case "3":
                    //search by author
                    System.out.print("Author : ");
                    String author = scanner.next();
                    a = bc.SearchBook(author, "author");
                    if(a == 0) power = false;
                    break;
                case "4":
                    //search by seller
                    System.out.print("Seller : ");
                    String seller = scanner.next();
                    a = bc.SearchBook(seller, "seller");
                    if(a == 0) power = false;
                    break;
                case "5":
                    //search by publisher
                    System.out.print("Publisher : ");
                    String publisher = scanner.next();
                    a = bc.SearchBook(publisher, "publisher");
                    if(a == 0) power = false;
                    break;
                case "6":
                    //search by publication year
                    System.out.print("Publication Year : ");
                    String publicationYear = scanner.next();
                    a = bc.SearchBook(publicationYear, "publicationYear");
                    if(a == 0) power = false;
                    break;
                case "7":
                    //go back to general user
                    power = false;
                    ret = 1;
                    break;
                default:
                    System.out.println("1~7사이의 숫자를 입력하시기 바랍니다.");
                    break;
            }
        }
        return ret;
    }

    public void UpdateMyBook(String username) throws IOException {
        System.out.println("내 책 정보를 수정 하시겠습니까?");
        boolean power = true;
        BookControl bc = new BookControl();
        while(power){
            scanner.reset();
            System.out.println("1.수정 2.삭제 3.이전으로");
            String id;
            String menuNum = scanner.nextLine();
            switch (menuNum){
                case "1":
                    //update book
                    scanner.reset();
                    System.out.print("수정할 책의 Identify Number를 입력해 주세요 : ");
                    id = scanner.nextLine();

                    bc.UpdateBook(username, Integer.parseInt(id));
                    break;
                case "2":
                    scanner.reset();
                    System.out.print("삭제할 책의 Identify Number를 입력해 주세요 : ");
                    id = scanner.nextLine();
                    bc.RemoveBook(username, Integer.parseInt(id));
                    //delete book
                    break;
                case "3":
                    power = false;
                    break;
                default:
                    System.out.println("1~3사이의 숫자를 입력하시기 바랍니다.");
                    break;

            }
        }
    }

    public void TradeBookView() throws IOException {
        System.out.println("등록된 책 중 구매하실 책이 있습니까?");
        boolean power = true;
        String id;
        BookControl bc = new BookControl();
        while(power){
            scanner.reset();
            System.out.println("1.있음 2.없음");
            String menuNum = scanner.nextLine();
            switch (menuNum){
                case "1":
                    scanner.reset();
                    //update book
                    System.out.print("구매하실 책의 Identify Number를 입력해 주세요 : ");
                    id = scanner.nextLine();
                    bc.TradeBook(LoginUserName, Integer.parseInt(id));
                    power = false;
                    break;
                case "2":
                    power = false;
                    System.out.println("이전으로...");
                    break;
                default:
                    System.out.println("1~2사이의 숫자를 입력하시기 바랍니다.");
                    break;

            }
        }
    }

    public void RemoveBookView() throws IOException {
        System.out.println("검색된 책 중 삭제할 책이 있습니까?");
        boolean power = true;
        String id;
        BookControl bc = new BookControl();
        while(power){
            scanner.reset();
            System.out.println("1.있음 2.없음");
            String menuNum = scanner.nextLine();
            switch (menuNum){
                case "1":
                    scanner.reset();
                    //update book
                    System.out.print("삭제 할 책의 Identify Number를 입력해 주세요 : ");
                    id = scanner.nextLine();
                    bc.RemoveBook("admin", Integer.parseInt(id));
                    power = false;
                    break;
                case "2":
                    power = false;
                    System.out.println("이전으로...");
                    break;
                default:
                    System.out.println("1~2사이의 숫자를 입력하시기 바랍니다.");
                    break;
            }
        }
    }


    public void ReviseUsersView() throws IOException {
        System.out.println("Revise Users");
        System.out.println("검색된 유저중 삭제 또는 활성/비활성화할 유저가 있습니까?");
        boolean power = true;
        UserControl uc = new UserControl();
        String id;
        while(power){
            scanner.reset();
            System.out.println("1.삭제 2.활성/비활성화 3.없음");
            String menuNum = scanner.nextLine();
            switch (menuNum){
                case "1":
                    scanner.reset();
                    //update book
                    System.out.print("삭제 할 유저의 Id를 입력해 주세요 : ");
                    id = scanner.nextLine();
                    uc.RemoveUser(id);
                    power = false;
                    break;
                case "2":
                    scanner.reset();
                    //update book
                    System.out.print("활성/비활성화 할 유저의 Id를 입력해 주세요 : ");
                    id = scanner.nextLine();
                    System.out.println("활성화 : 0, 비활성화 : 1");
                    String active = scanner.nextLine();
                    uc.ActivateUser(id, Integer.parseInt(active));
                    power = false;
                    break;
                case "3":
                    power = false;
                    System.out.println("이전으로...");
                    break;
                default:
                    System.out.println("1~2사이의 숫자를 입력하시기 바랍니다.");
                    break;
            }
        }
    }
}
