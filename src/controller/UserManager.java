package controller;

import model.GeneralUser;

import java.util.ArrayList;
import java.util.List;

public class UserManager {

    private List<GeneralUser> UserList = new ArrayList<>();

    public List<GeneralUser> getUserList() { return this.UserList; }

    public void setUserList(List<GeneralUser> UserList) {this.UserList = UserList;}

    public int addUser(GeneralUser User){
        int ret = 0;
        int dup = 0;
        try{
            for (GeneralUser tempUser : this.UserList) {
                if (tempUser.getId().equals(User.getId())) {
                    dup = 1;
                    break;
                }
            }
            if(dup == 1){
                System.out.println("중복된 ID입니다. 다시 시도해 주세요.");
                ret = 2;
            }
            else if(User.getId().equals("admin")){
                System.out.println("ID를 admin으로 만들 수 없습니다.");
                ret = 2;
            }
            else{
                this.UserList.add(User);
                System.out.println("회원 가입 성공!");
            }
        } catch(Exception e){
            System.out.println("유저 추가 중 에러가 발생 했습니다." + "\n" + e.getMessage());
            ret = 1;
        }
        return ret;
    }

    public int removeUser(String id){
        int ret = 0;

        try{
            for(int idx = 0; idx<this.UserList.size(); idx++){
                GeneralUser tempUser = this.UserList.get(idx);

                if(id.equals(tempUser.getId())){
                    if(tempUser.getActivated() == 1){
                        this.UserList.remove(idx);
                        break;
                    }
                    else if(tempUser.getActivated() == 0){
                        System.out.println("활성화된 유저 입니다. 먼저 비활성화 해주세요.");
                        ret = 2;
                        break;
                    }
                }

                if(idx == this.UserList.size()-1){
                    System.out.println("해당 유저가 없습니다.");
                    ret = 2;
                }
            }
        } catch(Exception e){
            System.out.println("유저 삭제중 에러가 발생 했습니다." + "\n" + e.getMessage());
            ret = 1;
        }
        return ret;
    }

    public int compareToLogin(String id, String passwd){
        int ret = 0;
        try{
            for(int idx = 0; idx<this.UserList.size(); idx++){
                GeneralUser tempUser = this.UserList.get(idx);
                if(id.equals(tempUser.getId()) && passwd.equals(tempUser.getPasswd())){
                    if(tempUser.getActivated() == 0){
                        System.out.println("로그인 성공");
                        break;
                    }
                    else if(tempUser.getActivated() == 1){
                        System.out.println("비활성화된 유저 입니다. 관리자에게 문의하세요.");
                        ret = 2;
                        break;
                    }

                }
                else if(id.equals("admin") && passwd.equals("nayana")){
                    System.out.println("관리자로 로그인");
                    ret = 3;
                    break;
                }
                if(idx == this.UserList.size()-1) {
                    System.out.println("해당 유저가 없습니다.");
                    ret = 2;
                }
            }
        } catch(Exception e){
            System.out.println("로그인 중 에러가 발생 했습니다." + "\n" + e.getMessage());
            ret = 1;
        }
        return ret;
    }

    public void showAllUser(){
        for (GeneralUser generalUser : this.UserList) {
            System.out.println("-------------------------------");
            System.out.println(
                            String.format("%-12s", "ID") + " : " + generalUser.getId() + "\n" +
                            String.format("%-12s", "Password") + " : " + generalUser.getPasswd() + "\n" +
                            String.format("%-12s", "Name") + " : " + generalUser.getName() + "\n" +
                            String.format("%-12s", "E-mail") + " : " + generalUser.getMailAddress() + "\n" +
                            String.format("%-12s", "Phone Number") + " : " + generalUser.getPhoneNumber() + "\n" +
                            String.format("%-12s", "Activate") + " : " + generalUser.getActivated()
            );
            System.out.println("-------------------------------");
        }
    }

    public void ActivateUser(String id, int active){
        GeneralUser temp = new GeneralUser();
        for(int idx = 0; idx<this.UserList.size(); idx++){
            GeneralUser tempUser = this.UserList.get(idx);

            if(id.equals(tempUser.getId())){
                if(tempUser.getActivated() == active){
                    if(active == 0) System.out.println("이미 활성화된 유저 입니다.");
                    else if(active == 1) System.out.println("이미 비활성화된 유저 입니다.");
                }
                else{
                    temp.setId(tempUser.getId());
                    temp.setPasswd(tempUser.getPasswd());
                    temp.setName(tempUser.getName());
                    temp.setMailAddress(tempUser.getMailAddress());
                    temp.setPhoneNumber(tempUser.getPhoneNumber());
                    temp.setActivated(active);
                    this.UserList.remove(idx);
                    this.UserList.add(idx, temp);
                    if(active == 0) System.out.println("활성화 완료!");
                    else if(active == 1) System.out.println("비활성화 완료!");
                }
                break;
            }

            if(idx == this.UserList.size()-1){
                System.out.println("해당 유저가 없습니다.");
            }
        }
    }

    public String getEmail(String id){
        for(int idx = 0; idx<this.UserList.size(); idx++){
            GeneralUser tempUser = this.UserList.get(idx);

            if(id.equals(tempUser.getId())){
                return tempUser.getMailAddress();
            }

            if(idx == this.UserList.size()-1){
                System.out.println("해당 유저가 없습니다.");
            }
        }
        return "";
    }
}
