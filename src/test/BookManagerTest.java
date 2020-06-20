package test;

import controller.BookManager;
import controller.UserManager;
import model.Book;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BookManagerTest {

    @Test
    void addBook() {
        List<Book> BookList = new ArrayList<>();
        BookManager bm = new BookManager();
        Book book = new Book();
        bm.setBookList(BookList);

        bm.addBook(book);
        assertEquals(1,BookList.size());

        bm.addBook(book);
        assertEquals(2,bm.getSize());
    }

    @Test
    void removeBook() {
        List<Book> BookList = new ArrayList<>();
        BookManager bm = new BookManager();
        Book book = new Book();

        bm.setBookList(BookList);

        book.setTitle("TestTitle");
        book.setSeller("TestUser");
        book.setIdentifyNumber(1);

        bm.addBook(book);

        assertEquals(0,bm.removeBook("TestUser",1));

        bm.addBook(book);

        assertEquals(2,bm.removeBook("TestUser",2));

        assertEquals(3,bm.removeBook("User",1));

    }

    @Test
    void updateBookInfo() {
        List<Book> BookList = new ArrayList<>();
        BookManager bm = new BookManager();
        Book book = new Book();

        bm.setBookList(BookList);

        book.setTitle("TestTitle");
        book.setSeller("TestUser");
        book.setIdentifyNumber(1);

        bm.addBook(book);

        assertEquals(3,bm.updateBookInfo("OtherUser",1));
        assertEquals(2,bm.updateBookInfo("TestUser",2));
    }

    @Test
    void searchBook() {
        List<Book> BookList = new ArrayList<>();
        BookManager bm = new BookManager();
        Book book = new Book();

        bm.setBookList(BookList);

        book.setTitle("TestTitle");
        book.setAuthor("TestAuthor");
        book.setPublisher("TestPublisher");
        book.setPublication_year("TestPY");
        book.setISBN("TestISBN");
        book.setSeller("TestUser");
        book.setIdentifyNumber(1);

        bm.addBook(book);

        assertEquals(0,bm.SearchBook("Test", "title"));
        assertEquals(1,bm.SearchBook("NotEqual","title"));
        assertEquals(0,bm.SearchBook("Test", "author"));
        assertEquals(1,bm.SearchBook("NotEqual","author"));
        assertEquals(0,bm.SearchBook("Test", "publisher"));
        assertEquals(1,bm.SearchBook("NotEqual","publisher"));
        assertEquals(0,bm.SearchBook("Test", "publicationYear"));
        assertEquals(1,bm.SearchBook("NotEqual","publicationYear"));
        assertEquals(0,bm.SearchBook("Test", "seller"));
        assertEquals(1,bm.SearchBook("NotEqual","seller"));
    }

    @Test
    void removeBookById() {
        List<Book> BookList = new ArrayList<>();
        BookManager bm = new BookManager();
        Book book = new Book();

        bm.setBookList(BookList);

        book.setTitle("TestTitle");
        book.setAuthor("TestAuthor");
        book.setPublisher("TestPublisher");
        book.setPublication_year("TestPY");
        book.setISBN("TestISBN");
        book.setSeller("TestUser");
        book.setIdentifyNumber(1);

        bm.addBook(book);

        bm.RemoveBookById("TestUser");

        assertEquals(0,bm.getSize());

    }
}