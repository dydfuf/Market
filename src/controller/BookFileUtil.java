package controller;

import model.Book;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class BookFileUtil {

    public static List<Book> readFile(File file) throws IOException{
        FileReader filereader = null;
        List<Book> bookList = new ArrayList<Book>();

        try{
            filereader = new FileReader(file);
            bookList = readReader(filereader);
        } finally {
            if(filereader != null)
                filereader.close();
        }
        return bookList;
    }

    public static void writeFile(String dir, String name, List<Book> bookList) throws IOException{
        OutputStream out = null;
        try{
            File dirent = new File(dir);

            if(!dirent.exists()){
                dirent.mkdir();
            }

            File outFile = new File(dir, name);

            if(outFile.exists()){
                outFile.delete();
            }

            out = new BufferedOutputStream(new FileOutputStream(outFile));
            for(int idx = 0; idx< bookList.size(); idx++){
                String writeStr = bookList.get(idx).getTitle()+","+bookList.get(idx).getAuthor()+","+bookList.get(idx).getPublisher()
                        +","+bookList.get(idx).getPublication_year()+","+bookList.get(idx).getISBN()+","+bookList.get(idx).getPrice()
                        +","+bookList.get(idx).getBook_condition()+","+(idx+1)
                        +","+bookList.get(idx).getSeller()+"\n";

                byte[] b = writeStr.getBytes();

                out.write(b);
            }
        } catch(IOException ioe){
            ioe.printStackTrace();
            throw ioe;
        } finally {
            try{
                if(out != null) out.close();
            } catch(Exception e){
        }
        }
    }

    public static List<Book> readReader(Reader input) throws IOException{
        try{
            BufferedReader in = new BufferedReader(input);
            String line;
            List<Book> bookList = new ArrayList<Book>();

            while((line=in.readLine())!=null){
                String[] writeStr = line.split(",");

                if(writeStr.length != 9)continue;

                Book book = new Book();

                book.setTitle(writeStr[0]);
                book.setAuthor(writeStr[1]);
                book.setPublisher(writeStr[2]);
                book.setPublication_year(writeStr[3]);
                book.setISBN(writeStr[4]);
                book.setPrice(writeStr[5]);
                book.setBook_condition(writeStr[6]);
                book.setIdentifyNumber(Integer.parseInt(writeStr[7]));
                book.setSeller(writeStr[8]);

                bookList.add(book);
            }
            return bookList;
        }finally {
            input.close();
        }
    }
}
