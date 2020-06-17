package model;

public class Book {

    public Book() { }

    private String title;
    private String author;
    private String publisher;
    private String publication_year;
    private String ISBN;
    private String price;
    private String book_condition;
    private int identifyNumber;
    private String seller;

    public Book(String title, String author, String publisher, String publication_year, String ISBN,
                String price, String book_condition, int identifyNumber, String seller){
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publication_year = publication_year;
        this.ISBN = ISBN;
        this.price = price;
        this.book_condition = book_condition;
        this.identifyNumber = identifyNumber;
        this.seller = seller;
    }

    public Book(String title, String seller){
        this.title = title;
        this.author = null;
        this.publisher = null;
        this.publication_year = null;
        this.ISBN = null;
        this.price = null;
        this.book_condition = null;
        this.seller = seller;
    }

    public String getSeller() { return seller; }

    public int getIdentifyNumber() { return identifyNumber; }

    public String getTitle(){
        return title;
    }

    public String getAuthor(){
        return author;
    }

    public String getPublisher(){
        return publisher;
    }

    public String getPublication_year(){
        return publication_year;
    }

    public String getISBN(){
        return ISBN;
    }

    public String getPrice(){
        return price;
    }

    public String getBook_condition(){ return book_condition; }

    public void setTitle(String title){
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setBook_condition(String book_condition) {
        if(book_condition.equals("")){
            this.book_condition = "Excellent";
        }
        else this.book_condition = book_condition;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublication_year(String publication_year) {
        this.publication_year = publication_year;
    }

    public void setIdentifyNumber(int identifyNumber) { this.identifyNumber = identifyNumber; }

    public void setSeller(String seller) { this.seller = seller; }
}
