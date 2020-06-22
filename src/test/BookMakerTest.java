package test;

import controller.BookMaker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookMakerTest {

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

    @Test
    void checkISBN(){
        BookMaker bm = new BookMaker();
        assertTrue(bm.checkISBN("1234567890123"));
        assertFalse(bm.checkISBN("12345678901234"));
    }

    @Test
    void checkPublicationYear(){
        BookMaker bm = new BookMaker();
        assertTrue(bm.checkPublicationYear("1997"));
        assertFalse(bm.checkPublicationYear("19970319"));
    }

    @Test
    void checkPrice(){
        BookMaker bm = new BookMaker();
        assertTrue(bm.checkPrice("10000"));
        assertTrue(bm.checkPrice("0"));
        assertFalse(bm.checkPrice("오천원"));
    }
}