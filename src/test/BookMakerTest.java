package test;

import controller.BookMaker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookMakerTest {

    @Test
    void makeBook(){
        BookMaker bm = new BookMaker();
        bm.makeBook("TestUser");
    }


    @Test
    void checkTitle() {
        BookMaker bm = new BookMaker();
        assertTrue(bm.checkTitle("title"));
        assertFalse(bm.checkTitle(""));
    }

    @Test
    void checkBookCond() {
        BookMaker bm = new BookMaker();
        assertEquals("Excellent",bm.checkBookCond("1"));
        assertEquals("Good",bm.checkBookCond("2"));
        assertEquals("Fair",bm.checkBookCond("3"));
        assertEquals("Excellent",bm.checkBookCond(""));
    }
}