package controller;

import model.Book;

import java.io.File;
import java.io.IOException;

public class BookControl {

    public BookControl() {
    }

    public BookManager bm = new BookManager();
    public UserManager um = new UserManager();

    private final String filepath = "/Users/choeyonglyeol/IdeaProjects/test";
    private final String filename = "BookList.txt";
    private final String UserFileName = "UserList.txt";

    public void ShowBookList() throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        System.out.println("총 "+ bm.getBookList().size() + "개의 책이 있습니다. ");
        bm.showAllBook();
    }

    public void AddBook(String username) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        Book tempBook;
        BookMaker bmaker = new BookMaker();
        tempBook = bmaker.makeBook(username);
        tempBook.setIdentifyNumber(bm.getSize()+1);
        bm.addBook(tempBook);
        BookFileUtil.writeFile(filepath, filename, bm.getBookList());
    }

    public int SearchBook(String choice, String type) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        return bm.SearchBook(choice, type);
    }

    public void UpdateBook(String username, int IdentifyNumber) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        bm.updateBookInfo(username, IdentifyNumber);
        BookFileUtil.writeFile(filepath, filename, bm.getBookList());
    }

    public void RemoveBook(String username, int IdentifyNumber) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        bm.removeBook(username, IdentifyNumber);
        BookFileUtil.writeFile(filepath, filename, bm.getBookList());
    }

    public void TradeBook(String username, int IdentifyNumber) throws IOException {
        bm.setBookList(BookFileUtil.readFile(new File(filepath, filename)));
        um.setUserList(UserFileUtil.readFile(new File(filepath, UserFileName)));
        String seller = bm.tradeBook(username, IdentifyNumber);
        if(!seller.isEmpty()){
            System.out.println("----------Trade----------");
            System.out.println("Buyer's Email : " + um.getEmail(username));
            System.out.println("Seller's Email : " + um.getEmail(seller));
            System.out.println("E-mail sended to Seller !!");
            System.out.println("-------------------------");
        }
        BookFileUtil.writeFile(filepath, filename, bm.getBookList());
    }

}
