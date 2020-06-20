package controller;

import model.GeneralUser;

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

public class UserFileUtil {

    public static List<GeneralUser> readFile(File file) throws IOException{
        FileReader fileReader = null;
        List<GeneralUser> userList;

        try{
            fileReader = new FileReader(file);
            userList = readReader(fileReader);
        } finally {
            if(fileReader != null){
                fileReader.close();
            }
        }
        return userList;
    }

    public static void writeFile(String dir, String name, List<GeneralUser> userList) throws IOException{
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
            for (GeneralUser generalUser : userList) {
                String writeStr = generalUser.getId() + "," + generalUser.getPasswd() + "," + generalUser.getName()
                        + "," + generalUser.getPhoneNumber() + "," + generalUser.getMailAddress() + "," + generalUser.getActivated()
                        + "\n";

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
                System.out.println(e.getMessage());
            }
        }
    }


    public static List<GeneralUser> readReader(Reader input) throws IOException{
        try (input) {
            BufferedReader in = new BufferedReader(input);
            String line;
            List<GeneralUser> userList = new ArrayList<>();

            while ((line = in.readLine()) != null) {
                String[] writeStr = line.split(",");

                if (writeStr.length != 6) continue;

                GeneralUser user = new GeneralUser();

                user.setId(writeStr[0]);
                user.setPasswd(writeStr[1]);
                user.setName(writeStr[2]);
                user.setPhoneNumber(writeStr[3]);
                user.setMailAddress(writeStr[4]);
                user.setActivated(Integer.parseInt(writeStr[5]));

                userList.add(user);
            }
            return userList;
        }
    }
}
