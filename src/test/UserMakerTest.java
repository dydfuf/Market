package test;

import controller.UserMaker;
import org.junit.Before;
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
        assertFalse(um.checkEmail("noat.com"));
    }

    @Test
    void checkPhoneNumber() {
        UserMaker um = new UserMaker();
        assertTrue(um.checkPhoneNumber("010-4661-8276"));
        assertTrue(um.checkPhoneNumber("010-461-8276"));
        assertTrue(um.checkPhoneNumber("017-4661-8286"));


    }
}