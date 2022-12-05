package controller;

import infrastructure.ExceptionLength;
import infrastructure.ExceptionNumber;
import infrastructure.ExceptionPassNumber;
import model.user.User;

import java.util.ArrayList;
import java.util.Objects;

public class UserManager {
    private ArrayList<User> users = new ArrayList<User>();
    private final int MAX_NUM = 9;

    public UserManager(){
    }

    public ArrayList<User> get(){
        return this.users;
    }

    public ArrayList<User> getByLogin(String login){
        ArrayList<User> selected = new ArrayList<>();

        for(User u : users){
            if(Objects.equals(u.getLogin(), login))
                selected.add(u);
        }
        return selected;
    }

    public boolean post(User u){
        if(this.validateUser(u)) {
            this.users.add(u);
            return true;
        }
        else return false;

    }

    public boolean put(Long id, User u){
        if(this.validateUser(u) && id > 0) {
            users.set(id.intValue(), u);

            return true;
        }
        else return false;

    }

    public User delete(Long id){
        User u = null;

        if(id > 0){
            u = users.get(id.intValue());
            users.remove(id);
        }
        else
            throw new ArrayIndexOutOfBoundsException();

        return u;
    }

    public boolean validateUser(User user){
        boolean response = true;

        response = this.loginValidate(user.getLogin()) &&
                    this.passwordValidate(user.getPassword());

        return response;
    }

    private boolean loginValidate(String login){
        // login string validate
        try {
            if (login.length() > 12 ||
                    login.length() == 0) {
                throw new ExceptionLength(login.length());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            for (char c : login.toCharArray()) {
                for (int i = 0; i <= MAX_NUM; i++) {
                    if (Integer.parseInt(String.valueOf(c)) == i)
                        throw new ExceptionNumber(i);
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
                for (int i = 0; i <= MAX_NUM; i++) {
                    if (Integer.parseInt(String.valueOf(c)) == i)
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
