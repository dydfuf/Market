package model;

public class Admin extends User{

    public Admin(String id, String passwd) {
        super(id, passwd);
        this.setId("admin");
        this.setPasswd("nayana");
    }
}
