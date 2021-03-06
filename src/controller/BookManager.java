package controller;

import model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookManager {

    private List<Book> BookList = new ArrayList<>();

    public List<Book> getBookList(){
        return this.BookList;
    }

    public void setBookList(List<Book> bookList) {
        this.BookList = bookList;
    }

    public int addBook(Book book){
        int ret = 0;

        try{
            this.BookList.add(book);
        } catch(Exception e){
            System.out.println("정보 추가 중 에러가 발생 했습니다." + "\n" + e.getMessage());
            ret = 1;
        }
        return ret;
    }

    public int removeBook(String username, int identifyNumber){
        int ret = 0;

        try{
            for(int idx = 0; idx<this.BookList.size(); idx++){
                Book tempBook = this.BookList.get(idx);

                if(identifyNumber == tempBook.getIdentifyNumber()){
                    if(username.equals(tempBook.getSeller()) || username.equals("admin")){
                        this.BookList.remove(idx);
                        System.out.println("삭제 완료!");
                        break;
                    }
                    else{
                        System.out.println("본인의 책만 삭제 가능합니다!");
                        ret = 3;
                        break;
                    }
                }

                if(idx == this.BookList.size()-1){
                    System.out.println("해당 정보가 없습니다.");
                    ret = 2;
                }
            }
        } catch(Exception e){
            System.out.println("정보 삭제중 에러가 발생 했습니다." + "\n" + e.getMessage());
            ret = 1;
        }
        return ret;
    }

    public int updateBookInfo(String username, int identifyNumber){
        int ret = 0;

        try{
            for(int idx =0; idx<this.BookList.size(); idx ++){
                Book tempBook = this.BookList.get(idx);
                BookMaker bm = new BookMaker();
                if(identifyNumber == tempBook.getIdentifyNumber()){
                    if(username.equals(tempBook.getSeller())){
                        System.out.println("----------수정할 책의 정보를 입력해 주세요----------");
                        Book book = bm.makeBook(tempBook.getSeller());
                        book.setIdentifyNumber(identifyNumber);

                        this.BookList.remove(idx);
                        this.BookList.add(idx, book);
                        System.out.println("수정 완료 !");
                        break;
                    }
                    else{
                        System.out.println("본인의 책만 수정 가능합니다!");
                        ret = 3;
                        break;
                    }
                }

                if(idx == this.BookList.size()-1){
                    System.out.println("해당 정보를 찾을 수 없습니다.");
                    ret = 2;
                }
            }
        } catch(Exception e){
            System.out.println("정보 수정 중 에러가 발생 했습니다." + "\n" + e.getMessage());
            ret = 1;
        }
        return  ret;
    }

    public int SearchBook(String choice, String Searchby){
        int ret = 0;
        List<Book> tempBookList = new ArrayList<>();
        BookManager TempBM = new BookManager();
        switch(Searchby){
            case "title":
                for (Book tempBook : this.BookList) {
                    if (tempBook.getTitle().contains(choice)) {
                        tempBookList.add(tempBook);
                    }
                }
                if(tempBookList.isEmpty()){
                    System.out.println("title 정보 없음");
                    ret = 1;
                }
                break;
            case "ISBN":
                for (Book tempBook : this.BookList) {
                    if (choice.equals(tempBook.getISBN())) {
                        tempBookList.add(tempBook);
                    }
                }
                if(tempBookList.isEmpty()){
                    System.out.println("isbn 정보 없음");
                    ret = 1;
                }
                break;
            case "author":
                for (Book tempBook : this.BookList) {
                    if (tempBook.getAuthor().contains(choice)) {
                        tempBookList.add(tempBook);
                    }
                }
                if(tempBookList.isEmpty()){
                    System.out.println("author 정보 없음");
                    ret = 1;
                }
                break;
            case "seller":
                for (Book tempBook : this.BookList) {
                    if (tempBook.getSeller().contains(choice)) {
                        tempBookList.add(tempBook);
                    }
                }
                if(tempBookList.isEmpty()){
                    System.out.println("seller 정보 없음");
                    ret = 1;
                }
                break;
            case "publisher":
                for (Book tempBook : this.BookList) {
                    if (tempBook.getPublisher().contains(choice)) {
                        tempBookList.add(tempBook);
                    }
                }
                if(tempBookList.isEmpty()){
                    System.out.println("Publisher 정보 없음");
                    ret = 1;
                }
                break;
            case "publicationYear":
                for (Book tempBook : this.BookList) {
                    if (tempBook.getPublication_year().contains(choice)) {
                        tempBookList.add(tempBook);
                    }
                }
                if(tempBookList.isEmpty()){
                    System.out.println("Publication Year 정보 없음");
                    ret = 1;
                }
                break;

            default:
                System.out.println("Search Type error!!");
                break;
        }

        TempBM.setBookList(tempBookList);
        TempBM.showAllBook();

        return ret;
    }

    public void showAllBook(){
        for (Book book : this.BookList) {
            System.out.println("-------------------------------");
            System.out.println(
                            String.format("%-16s", "Identify Number") + " : " + book.getIdentifyNumber() + "\n" +
                            String.format("%-16s", "Title") + " : " + book.getTitle() + "\n" +
                            String.format("%-16s", "Author") + " : " + book.getAuthor() + "\n" +
                            String.format("%-16s", "Publisher") + " : " + book.getPublisher() + "\n" +
                            String.format("%-16s", "Publication Year") + " : " + book.getPublication_year() + "\n" +
                            String.format("%-16s", "ISBN") + " : " + book.getISBN() + "\n" +
                            String.format("%-16s", "Price") + " : " + book.getPrice() + "\n" +
                            String.format("%-16s", "Book Condition") + " : " + book.getBook_condition() + "\n" +
                            String.format("%-16s", "Seller") + " : " + book.getSeller()
            );
            System.out.println("-------------------------------");
        }
    }

    public String tradeBook(String username, int identifyNumber){
        String ret = "";
        for(int idx =0; idx<this.BookList.size(); idx ++){
            Book tempBook = this.BookList.get(idx);

            if(identifyNumber == tempBook.getIdentifyNumber()){
                if(username.equals(tempBook.getSeller())){
                    System.out.println("본인의 책은 구매할 수 없습니다.");
                    break;
                }
                else{
                    ret = tempBook.getSeller();
                }
                break;
            }
            if(idx == this.BookList.size()-1){
                System.out.println("해당 정보를 찾을 수 없습니다.");
            }
        }
        return ret;
    }

    public void RemoveBookById(String id){

        int temp = this.BookList.size();

        this.BookList.removeIf(books -> books.getSeller().equals(id));

        System.out.println((temp - this.BookList.size()) + "개 삭제 완료");
    }

    public int getSize(){
        return this.BookList.size();
    }
}
