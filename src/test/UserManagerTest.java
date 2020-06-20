package test;

import controller.UserManager;
import model.GeneralUser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserManagerTest {

    @Test
    void addUser() {
        List<GeneralUser> UserList = new ArrayList<>();
        UserManager um = new UserManager();
        GeneralUser user = new GeneralUser();
        um.setUserList(UserList);
        user.setId("Test");

        assertEquals(0, um.addUser(user));
        assertEquals(2, um.addUser(user));
        assertEquals(1,UserList.size());
    }

    @Test
    void removeUser() {
        List<GeneralUser> UserList = new ArrayList<>();
        UserManager um = new UserManager();
        GeneralUser user = new GeneralUser();
        um.setUserList(UserList);
        user.setId("Test");

        assertEquals(0, um.addUser(user));
        assertEquals(2,um.removeUser("Test"));

        user.setActivated(1);
        assertEquals(0,um.removeUser("Test"));
    }

    @Test
    void compareToLogin() {
        List<GeneralUser> UserList = new ArrayList<>();
        UserManager um = new UserManager();
        GeneralUser user = new GeneralUser();
        um.setUserList(UserList);

        user.setId("TestId");
        user.setPasswd("TestPassword");

        um.addUser(user);

        assertEquals(0,um.compareToLogin("TestId","TestPassword"));
        user.setActivated(1);
        assertEquals(2,um.compareToLogin("TestId","TestPassword"));
        assertEquals(2,um.compareToLogin("NoId","NoPassword"));
    }

    @Test
    void getEmail() {
        List<GeneralUser> UserList = new ArrayList<>();
        UserManager um = new UserManager();
        GeneralUser user = new GeneralUser();
        um.setUserList(UserList);

        user.setId("TestId");
        user.setPasswd("TestPassword");
        user.setMailAddress("88dydfuf@naver.com");

        um.addUser(user);

        assertEquals("88dydfuf@naver.com", um.getEmail("TestId"));
        assertEquals("", um.getEmail("NoId"));

    }
}