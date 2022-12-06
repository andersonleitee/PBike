package controller;

import infrastructure.ExceptionLength;
import infrastructure.ExceptionNumber;
import infrastructure.ExceptionPassNumber;
import model.User;
import model.Dock;
import model.Bike;

import java.util.ArrayList;

public class UserManager {
    private ArrayList<User> users = new ArrayList<User>();
    private final int[] NUMBERS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    User u = null;

    public UserManager(){
    }

    public ArrayList<User> get(){
        return this.users;
    }

    public ArrayList<User> getByName(String name){
        return this.users;
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

    public boolean takeBike(Long id, Bike bike){
        try {
            u = users.get(id.intValue());
            if(bike.getTaken()) {
                return false;
            }
            u.setBike(bike);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean returnBike(Long id, Dock dock){
        try {
            u = users.get(id.intValue());
            if(u.getBike() == null || dock.addBike(u.getBike()) == false) {
                return false;
            }
            u.setBike(null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
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
