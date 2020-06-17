package controller;

import model.Book;

import java.io.File;
import java.io.IOException;

public class BookControl {

    public BookControl() {
    }

    public BookManager bm = new BookManager();

    private String filepath = "/Users/choeyonglyeol/IdeaProjects/test";
    private final String filename = "BookList.txt";

    public void ShowBookList() throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        System.out.println("총 몇개의 책? " + bm.getBookList().size());
        bm.showAllBook();
    }

    public void AddBook(String username) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        Book tempBook;
        BookMaker bmaker = new BookMaker();
        tempBook = bmaker.makeBook(username);
        tempBook.setIdentifyNumber(bm.getSize()+1);
        bm.addBook(tempBook);
        BookFileUtil.writeFile(filepath, filename, bm.getBookList());
    }

    public int SearchBook(String choice, String type) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        return bm.SearchBook(choice, type);
    }

    public void ReviseBook(String username, int IdentifyNumber) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        bm.updateBookInfo(username, IdentifyNumber);
        BookFileUtil.writeFile(filepath, filename, bm.getBookList());
    }

    public void RemoveBook(String username, int IdentifyNumber) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        bm.removeBook(username, IdentifyNumber);
        BookFileUtil.writeFile(filepath, filename, bm.getBookList());
    }

    public void TradeBook(String username, int IdentifyNumber) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        bm.tradeBook(username, IdentifyNumber);
        BookFileUtil.writeFile(filepath, filename, bm.getBookList());

    }

}
