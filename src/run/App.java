package run;

import model.Account;
import service.AccountService;
import util.InputMethods;

public class App {
    private static AccountService accountService = new AccountService();
    public static void main(String[] args) {
        int check = 0;
        while (true){
            System.out.println("============ **** MENU **** ============");
            System.out.println("1.Login\n" + "2.Register\n" + "3.Exit");
            System.out.println("Nhap lua chon cua ban : ");
            check = InputMethods.getInteger();
            switch (check) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void login() {
        System.out.println("======= *** LOGIN *** ======");
        while (true){
            boolean flag = true;
            System.out.println("UserName : ");
            String userName = InputMethods.getString();
            System.out.println("Password : ");
            String password = InputMethods.getString();
            if(accountService.login(userName, password)) {
                System.out.println("=====> Login success! ****");
                while (true) {
                    System.out.println("Ban co muon Logout khong ? y/n ");
                    char check = InputMethods.getString().charAt(0);
                    if(check == 'y'){
                        flag = false;
                        break;
                    }
                }

            } else {
                System.out.println("Username hoac Password chua dung, vui long nhap lai!");
            }
            if(flag) {
                continue;
            } else {
                break;
            }

        }

    }
    public static void register() {
        System.out.println("===== *** REGISTER *** =====");
        Account account = new Account();
        while (true) {
            System.out.println("UserName : ");
            String userName = InputMethods.getString();
            if(accountService.checkExist(userName)){
                System.out.println("UserName da ton tai vui long nhap UserName khac");
            } else {
                account.setUserName(userName);
                break;
            }
        }
        while (true) {
            System.out.println("Email : ");
            String email = InputMethods.getString();
            if(accountService.checkEmail(email)){
                account.setEmail(email);
                break;
            } else {
                System.out.println("Email chua hop le, vui long nhap lai");
            }
        }
        while (true) {
            System.out.println("Password : ");
            String password = InputMethods.getString();
            if(password.length() < 6){
                System.out.println("Password can it nhat 6 ky tu!");

            } else {
                account.setPassword(password);
                break;
            }
        }
        while (true) {
            System.out.println("Password Confirm : ");
            String confirmPassword = InputMethods.getString();
            if(confirmPassword.equals(account.getPassword())){
                break;
            } else {
                System.out.println("Password Confirm chua chinh xac, vui long nhap lai!");
            }
        }
        if(accountService.addUser(account)) {
            System.out.println("Register success!");
        }
        login();
    }

}
