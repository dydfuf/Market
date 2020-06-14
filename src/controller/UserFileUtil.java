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
        List<GeneralUser> userList = new ArrayList<GeneralUser>();

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
            for(int idx = 0; idx< userList.size(); idx++){
                String writeStr = userList.get(idx).getId()+","+userList.get(idx).getPasswd()+","+userList.get(idx).getName()
                        +","+userList.get(idx).getPhone_number()+","+userList.get(idx).getMail_address()+","+userList.get(idx).getActivated()
                        +"\n";

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


    public static List<GeneralUser> readReader(Reader input) throws IOException{
        try{
            BufferedReader in = new BufferedReader(input);
            String line;
            List<GeneralUser> userList = new ArrayList<GeneralUser>();

            while((line=in.readLine())!=null){
                String[] writeStr = line.split(",");

                if(writeStr.length != 6)continue;

                GeneralUser user = new GeneralUser();

                user.setId(writeStr[0]);
                user.setPasswd(writeStr[1]);
                user.setName(writeStr[2]);
                user.setPhone_number(writeStr[3]);
                user.setMail_address(writeStr[4]);
                user.setActivated(Integer.parseInt(writeStr[5]));

                userList.add(user);
            }
            return userList;
        }finally {
            input.close();
        }
    }
}
