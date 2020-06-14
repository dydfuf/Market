package model;

public class GeneralUser extends User {
    private String name;
    private String phone_number;
    private String mail_address;
    private int activated; // 0 : activated, 1 : no activated

    public GeneralUser() {}

    public GeneralUser(String id, String passwd, String name, String phone_number, String mail_address) {
        super(id, passwd);
        this.name = name;
        this.phone_number = phone_number;
        this.mail_address = mail_address;
        this.activated = 0;
    }

    public int getActivated() {
        return activated;
    }

    public void setActivated(int activated) {
        this.activated = activated;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setMail_address(String mail_address) {
        this.mail_address = mail_address;
    }

    public String getName() {
        return name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public String getMail_address() {
        return mail_address;
    }

}
