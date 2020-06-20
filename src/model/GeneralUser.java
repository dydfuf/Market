package model;

public class GeneralUser extends User {
    private String Name;
    private String PhoneNumber;
    private String MailAddress;
    private int Activated; // 0 : activated, 1 : no activated

    public GeneralUser() {}

    public GeneralUser(String id, String passwd, String name, String PhoneNumber, String MailAddress) {
        super(id, passwd);
        this.Name = name;
        this.PhoneNumber = PhoneNumber;
        this.MailAddress = MailAddress;
        this.Activated = 0;
    }

    public int getActivated() {
        return Activated;
    }

    public void setActivated(int activated) {
        this.Activated = activated;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.PhoneNumber = phoneNumber;
    }

    public void setMailAddress(String mailAddress) {
        this.MailAddress = mailAddress;
    }

    public String getName() {
        return Name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getMailAddress() {
        return MailAddress;
    }

}
