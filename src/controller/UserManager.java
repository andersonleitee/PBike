package view;

import model.User;

import java.util.ArrayList;
import java.util.Scanner;

public class UserManager {
    private ArrayList<User> users = new ArrayList<User>();
    private final int[] NUMBERS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

    public ArrayList<User> HttpRequest_GET(){
        return this.users;
    }

    public ArrayList<User> HttpRequest_GETBYNAME(String name){
        return this.users;
    }

    public boolean HttpRequest_POST(User u){
        if(this.validateUser(u)) {
            this.users.add(u);
            return true;
        }
        else return false;

    }

    public boolean HttpRequest_PUT(Long id, User u){
        if(this.validateUser(u) && id > 0) {
            users.set(id.intValue(), u);

            return true;
        }
        else return false;

    }

    public User HttpRequest_DELETE(Long id){
        User u = null;

        if(id > 0){
            u = users.get(id.intValue());
            users.remove(id);
        }
        else
            throw new ArrayIndexOutOfBoundsException();

        return u;
    }

    private boolean validateUser(User user){
        return this.userValidate(user);
    }

    public User createUser(){
        Scanner scanner = new Scanner(System.in);
        String login, password;

        System.out.println("Type here the user login: ");
        login = scanner.nextLine();

        System.out.println("Type here the user password: ");
        password = scanner.nextLine();

        return new User(login, password);
    }

    public boolean userValidate(User user){
        boolean response = true;

        response = this.loginValidate(user.getLogin()) &&
                    this.passwordValidate(user.getPassword());

        return response;
    }

    private boolean loginValidate(String login){
        // login string validate
        try {
            if (login.length() > 12 ||
                    login.length() <= 0) {
                throw new ExceptionLength(login.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for (char c : login.toCharArray()) {
                for (int n : NUMBERS) {
                    if (Integer.parseInt(String.valueOf(c)) == n)
                        throw new ExceptionNumber(n);
                }
            }
        } catch (NumberFormatException | ExceptionNumber e) {
            e.printStackTrace();
        }

        return true;
    }

    private boolean passwordValidate(String password){
        // password string validate
        try {
            if (password.length() > 20 ||
                    password.length() < 8) {
                throw new ExceptionLength(password.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            int numbersCount = 0;
            for (char c : password.toCharArray()) {
                for (int n : NUMBERS) {
                    if (Integer.parseInt(String.valueOf(c)) == n)
                        numbersCount++;
                }
            }
            if (numbersCount < 2)
                throw new ExceptionPassNumber(numbersCount);
        } catch (NumberFormatException | ExceptionPassNumber e) {
            e.printStackTrace();
        }
        return true;
    }
}
