package model;

abstract class User {
    private String id;
    private String passwd;

    public User() {}

    public User(String id, String passwd) {
        this.id = id;
        this.passwd = passwd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getPasswd() {
        return passwd;
    }
}

