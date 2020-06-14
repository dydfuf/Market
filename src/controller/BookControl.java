package controller;

import model.Book;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class BookControl {

    public BookControl() {
    }

    public static BookManager bm = new BookManager();
    public static Scanner scanner = new Scanner(System.in);

    public static String filepath = "/Users/choeyonglyeol/IdeaProjects/test";
    public static String filename = "BookList.txt";

    public static void ShowBookList() throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        System.out.println("총 몇개의 책? " + bm.getBookList().size());
        bm.showAllBook();
    }

    public static void AddBook(String username) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        Book tempBook = new Book();
        tempBook = BookMaker.makeBook(username);
        tempBook.setIdentifyNumber(bm.getSize()+1);
        bm.addBook(tempBook);
        BookFileUtil.writeFile(filepath, filename, bm.getBookList());
    }

    public static int SearchBook(String choice, String type) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        return bm.SearchBook(choice, type);
    }

    public static void ReviseBook(String username, int IdentifyNumber) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        bm.updateBookInfo(username, IdentifyNumber);
        BookFileUtil.writeFile(filepath, filename, bm.getBookList());
    }

    public static void RemoveBook(String username, int IdentifyNumber) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        bm.removeBook(username, IdentifyNumber);
        BookFileUtil.writeFile(filepath, filename, bm.getBookList());
    }

    public static void TradeBook(String username, int IdentifyNumber) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        bm.tradeBook(username, IdentifyNumber);
        BookFileUtil.writeFile(filepath, filename, bm.getBookList());

    }

}
