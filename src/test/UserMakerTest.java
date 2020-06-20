package test;

import controller.UserMaker;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserMakerTest {

    @Test
    void checkEmail() {
        UserMaker um = new UserMaker();
        assertTrue(um.checkEmail("88dydfuf@naver.com"));
        assertTrue(um.checkEmail("under_bar@naver.com"));
        assertTrue(um.checkEmail("88dydfuf@naver.net"));
        assertFalse(um.checkEmail("spa ce bar@naver.com"));
        assertFalse(um.checkEmail("spa ce bar@naver.com"));
        assertFalse(um.checkEmail("noat.com"));
        assertTrue(um.checkEmail("no@dotcom"));
    }

    @Test
    void checkPhoneNumber() {
    }
}