package controller;

import model.Book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BookMaker {
    public BookMaker() {
    }
    public static Scanner scanner = new Scanner(System.in);
    public static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

    public static Book makeBook(String username) throws IOException {
        scanner.reset();
        Book book = new Book();
        System.out.print("Title : ");
        book.setTitle(scanner.next());
        System.out.print("Author : ");
        book.setAuthor(bf.readLine());
        System.out.print("Publisher : ");
        book.setPublisher(bf.readLine());
        System.out.print("Publication Year : ");
        book.setPublication_year(bf.readLine());
        System.out.print("ISBN : ");
        book.setISBN(bf.readLine());
        System.out.print("Price : ");
        book.setPrice(bf.readLine());
        System.out.print("Book Condition : ");
        book.setBook_condition(bf.readLine());
        book.setSeller(username);
        return book;
    }
}
