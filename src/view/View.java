package view;

import controller.BookControl;
import controller.UserControl;

import java.io.IOException;
import java.util.Scanner;

public class View {

    public View() {
    }

    public static Scanner scanner = new Scanner(System.in);

    public static void LoginView() throws IOException {
        boolean login = true;

        while(login){
            scanner.reset();
            System.out.println("----------로그인----------");
            System.out.println("1. 로그인 2. 회원가입 3. 종료");
            int menuNum = scanner.nextInt();

            switch(menuNum){
                case 1:
                    String a = UserControl.Login();
                    if(a.equals("admin")){
                        AdminView();
                        login = false;
                    }
                    else if(a.isEmpty()){
                    }
                    else{
                        GeneralUserView(a);
                    }
                    //goto GeneralUserView or AdminView
                    break;
                case 2:
                    RegisterView();
                    //goto RegisterView
                    break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    login = false;
                    break;
                default:
                    System.out.println("1~3사이의 숫자를 입력하시기 바랍니다.");
                    break;
            }
        }
    }

    public static void RegisterView() throws IOException {
        System.out.println("회원가입 창");
        int a = UserControl.RegistUser();
        if(a == 0){
            System.out.println("가입한 ID로 로그인 하시기 바랍니다.\n");
        }
        else if(a==2){
            RegisterView();
        }
        //register
    }

    public static void GeneralUserView(String username) throws IOException {
        boolean power = true;

        while(power){
            System.out.println("일반유저 창\n" + "User name : " + username);
            System.out.println("1.등록된 책 전부 보기 2.책 검색하기 3.내가 등록한 책 보기 4.책 등록하기 5.이전으로 가기 6.종료");
            scanner.reset();
            int menuNum = scanner.nextInt();
            switch(menuNum){
                case 1:
                    //view all books
                    BookControl.ShowBookList();
                    TradeBookView(username);
                    //goto TradeBookView
                    break;
                case 2:
                    //Search and view books
                    SearchBookView();
                    TradeBookView(username);
                    //goto SearchBooksView
                    break;
                case 3:
                    //view what I registered book
                    BookControl.SearchBook(username, "seller");
                    ReviseMyBook(username);
                    //goto ReviseMyBookView
                    break;
                case 4:
                    BookControl.AddBook(username);
                    //Register Book
                    //goto RegisterBookView
                    break;
                case 5:
                    LoginView();
                    //goto LoginView
                case 6:
                    System.exit(0);
                    //exit
                default:
                    System.out.println("1~6사이의 숫자를 입력하시기 바랍니다.");
                    break;
            }
        }

        //
    }

    public static void AdminView() throws IOException {
        boolean power = true;
        while (power){
            System.out.println("관리자 창");
            System.out.println("1.등록된 책 전부 보기 2.책 검색하기 3.등록된 유저 전부 보기 4.이전으로 가기 5.종료");
            int menuNum = scanner.nextInt();
            switch(menuNum){
                case 1:
                    //show all books
                    BookControl.ShowBookList();
                    RemoveBookView();
                    break;
                case 2:
                    //Search books
                    SearchBookView();
                    RemoveBookView();
                    //goto DeleteBooks
                    break;
                case 3:
                    //view AllUsers
                    UserControl.ShowUserList();
                    ReviseUsersView();
                    //goto ReviseUser
                    break;
                case 4:
                    LoginView();
                    //goto LoginView
                    break;
                case 5:
                    System.exit(0);
                    //exit
                    break;
                default:
                    System.out.println("1~6사이의 숫자를 입력하시기 바랍니다.");
                    break;
            }
        }

    }

    public static void SearchBookView() throws IOException {
        System.out.println("책 검색창");

        boolean power = true;

        while(power){
            scanner.reset();
            System.out.println("1.책제목 2.ISBN번호 3.저자 4.판매자 5.뒤로가기");

            int menuNum = scanner.nextInt();
            int a;
            switch (menuNum){
                case 1:
                    //search by title
                    System.out.printf("책이름 : ");
                    String title = scanner.next();
                    a = BookControl.SearchBook(title, "title");
                    if(a == 0) power = false;
                    break;
                case 2:
                    //search by isbn
                    System.out.printf("ISBN : ");
                    String isbn = scanner.next();
                    a = BookControl.SearchBook(isbn, "ISBN");
                    if(a == 0) power = false;
                    break;
                case 3:
                    //search by author
                    System.out.printf("Author : ");
                    String author = scanner.next();
                    a = BookControl.SearchBook(author, "author");
                    if(a == 0) power = false;
                    break;
                case 4:
                    //search by seller
                    System.out.printf("Seller : ");
                    String seller = scanner.next();
                    a = BookControl.SearchBook(seller, "seller");
                    if(a == 0) power = false;
                    break;
                case 5:
                    //go back to general user
                    power = false;
                    break;
                default:
                    System.out.println("1~5사이의 숫자를 입력하시기 바랍니다.");
                    break;

            }
        }
    }

    public static void ReviseMyBook(String username) throws IOException {
        System.out.println("내 책 정보 수정");
        boolean power = true;

        while(power){
            scanner.reset();
            System.out.println("1.수정 2.삭제 3.이전으로");
            int id;
            int menuNum = scanner.nextInt();
            switch (menuNum){
                case 1:
                    //update book
                    scanner.reset();
                    System.out.printf("수정할 책의 Identify Number를 입력해 주세요 : ");
                    id = scanner.nextInt();
                    BookControl.ReviseBook(username, id);
                    break;
                case 2:
                    scanner.reset();
                    System.out.printf("삭제할 책의 Identify Number를 입력해 주세요 : ");
                    id = scanner.nextInt();
                    BookControl.RemoveBook(username, id);
                    //delete book
                    break;
                case 3:
                    power = false;
                    break;
                default:
                    System.out.println("1~3사이의 숫자를 입력하시기 바랍니다.");
                    break;

            }
        }
    }

    public static void TradeBookView(String username) throws IOException {
        System.out.println("등록된 책 중 구매하실 책이 있습니까?");
        boolean power = true;
        int id;
        while(power){
            scanner.reset();
            System.out.println("1.있음 2.없음");
            int menuNum = scanner.nextInt();
            switch (menuNum){
                case 1:
                    scanner.reset();
                    //update book
                    System.out.print("구매하실 책의 Identify Number를 입력해 주세요 : ");
                    id = scanner.nextInt();
                    BookControl.TradeBook(username, id);
                    power = false;
                    break;
                case 2:
                    power = false;
                    System.out.println("이전으로...");
                    break;
                default:
                    System.out.println("1~2사이의 숫자를 입력하시기 바랍니다.");
                    break;

            }
        }
    }

    public static void RemoveBookView() throws IOException {
        System.out.println("검색된 책 중 삭제할 책이 있습니까?");
        boolean power = true;
        int id;
        while(power){
            scanner.reset();
            System.out.println("1.있음 2.없음");
            int menuNum = scanner.nextInt();
            switch (menuNum){
                case 1:
                    scanner.reset();
                    //update book
                    System.out.print("삭제 할 책의 Identify Number를 입력해 주세요 : ");
                    id = scanner.nextInt();
                    BookControl.RemoveBook("admin", id);
                    power = false;
                    break;
                case 2:
                    power = false;
                    System.out.println("이전으로...");
                    break;
                default:
                    System.out.println("1~2사이의 숫자를 입력하시기 바랍니다.");
                    break;
            }
        }
    }


    public static void ReviseUsersView() throws IOException {
        System.out.println("Revise Users");
        System.out.println("검색된 유저중 삭제 또는 비활성화할 유저가 있습니까?");
        boolean power = true;
        String id;
        while(power){
            scanner.reset();
            System.out.println("1.삭제 2.비활성화 3.없음");
            int menuNum = scanner.nextInt();
            switch (menuNum){
                case 1:
                    scanner.reset();
                    //update book
                    System.out.print("삭제 할 유저의 Id를 입력해 주세요 : ");
                    id = scanner.next();
                    UserControl.RemoveUser(id);
                    power = false;
                    break;
                case 2:
                    scanner.reset();
                    //update book
                    System.out.print("비활성화 할 유저의 Id를 입력해 주세요 : ");
                    id = scanner.next();
                    System.out.println("활성화 : 0, 비활성화 : 1");
                    int active = scanner.nextInt();
                    UserControl.ActivateUser(id, active);
                    power = false;
                    break;
                case 3:
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
