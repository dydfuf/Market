package controller;

import model.Book;

import java.util.Scanner;

public class BookMaker {
    public BookMaker() {
    }
    public static Scanner scanner = new Scanner(System.in);

    public static Book makeBook(String username){
        scanner.reset();
        Book book = new Book();
        System.out.print("Title : ");
        book.setTitle(scanner.next());
        System.out.print("Author : ");
        book.setAuthor(scanner.next());
        System.out.print("Publisher : ");
        book.setPublisher(scanner.next());
        System.out.print("Publication Year : ");
        book.setPublication_year(scanner.next());
        System.out.print("ISBN : ");
        book.setISBN(scanner.nextInt());
        System.out.print("Price : ");
        book.setPrice(scanner.nextInt());
        System.out.print("Book Condition : ");
        book.setBook_condition((Book.Book_cond.valueOf(scanner.next())));
        book.setSeller(username);
        return book;
    }
}
