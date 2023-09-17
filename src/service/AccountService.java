package service;

import model.Account;
import util.InputMethods;

import java.util.regex.Pattern;

public class AccountService {
    // co 2 chuc nang dang nhap dang ky
    private static Account[] accounts = new Account[100];
    static  {
        accounts[0] = new Account("Ken", "ken123@gmail.com", "123456");
     }
    public boolean login(String userName, String password) {
        for (Account acc: accounts) {
            if(acc != null && acc.getUserName().equals(userName) && acc.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkExist(String userName){

        for (Account acc: accounts) {
            if(acc != null && acc.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }
    public boolean checkEmail(String email){
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        return Pattern.matches(regex, email);
    }
    public boolean addUser(Account acc) {
        for (int i = 0; i < accounts.length; i++) {
            if(accounts[i] == null) {
                accounts[i] = acc;
                return true;
            }
        }
        return false;
    }
    public void register() {

    }
}
