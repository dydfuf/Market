package controller;

import model.Book;

import java.util.Scanner;

public class BookMaker {
    public BookMaker() {
    }
    public static Scanner scanner = new Scanner(System.in);

    public Book makeBook(String username){
        scanner.reset();
        Book book = new Book();
        System.out.print("Title : ");
        String title = scanner.nextLine();
        while(true){
            if(checkTitle(title)){
                book.setTitle(title);
                break;
            }
            else {
                System.out.println("제목은 반드시 입력 해야 합니다.");
                System.out.print("Title : ");
                title = scanner.nextLine();
            }
        }
        System.out.print("Author : ");
        book.setAuthor(scanner.nextLine());
        System.out.print("Publisher : ");
        book.setPublisher(scanner.nextLine());
        System.out.print("Publication Year : ");
        book.setPublication_year(scanner.nextLine());
        System.out.print("ISBN : ");
        book.setISBN(scanner.nextLine());
        System.out.print("Price : ");
        book.setPrice(scanner.nextLine());
        System.out.print("Book Condition(1.Excellent 2.Good 3.Fair) : ");
        book.setBook_condition(checkBookCond(scanner.nextLine()));
        book.setSeller(username);
        return book;
    }

    public boolean checkTitle(String title){
        boolean ret = true;

        if(title.isEmpty()) ret = false;

        return ret;
    }

    public String checkBookCond(String bookCond){
        boolean power = true;
        while(power){
            if(bookCond.isEmpty()){
                bookCond = "Excellent";
                power = false;
            }
            else if(bookCond.equals("1")){
                bookCond = "Excellent";
                power = false;
            }
            else if(bookCond.equals("2")){
                bookCond = "Good";
                power = false;
            }
            else if(bookCond.equals("3")){
                bookCond = "Fair";
                power = false;
            }
            else{
                System.out.println("1~3사이의 숫자를 입력 하세요 Default = Excellent");
                bookCond = scanner.nextLine();
            }
        }
        return bookCond;
    }
}
