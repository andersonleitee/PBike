package controller;

import infrastructure.ExceptionLength;
import infrastructure.ExceptionNumber;
import infrastructure.ExceptionPassNumber;
import model.User.User;
import model.Dock.Dock;
import model.Bike.Bike;

import java.util.ArrayList;
import java.util.Objects;

public class UserManager {
    private ArrayList<User> users = new ArrayList<User>();
    private final int MAX_NUM = 9;
    User u = null;

    public UserManager() {
    }

    public ArrayList<User> get() {
        return this.users;
    }

    public ArrayList<User> getByLogin(String login) {
        ArrayList<User> selected = new ArrayList<>();

        for (User user : users) {
            if (Objects.equals(user.getLogin(), login))
                selected.add(user);
        }
        return selected;
    }

    public boolean post(User user) {
        if (this.validateUser(user)) {
            this.users.add(user);
            return true;
        } else
            return false;

    }

    public boolean put(Long id, User user) {
        if (this.validateUser(user) && id > 0) {
            users.set(id.intValue(), user);

            return true;
        } else
            return false;

    }

    public User delete(Long id) {

        if (id > 0) {
            u = users.get(id.intValue());
            users.remove(id);
        } else
            throw new ArrayIndexOutOfBoundsException();

        return u;
    }

    public boolean validateUser(User user) {
        boolean response = true;

        response = this.loginValidate(user.getLogin()) &&
                this.passwordValidate(user.getPassword());

        return response;
    }

    public boolean takeBike(Long id, Bike bike) {
        try {
            u = users.get(id.intValue());
            if (bike.getTaken()) {
                return false;
            }
            u.setBike(bike);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean returnBike(Long id, Dock dock) {
        try {
            u = users.get(id.intValue());
            if (u.getBike() == null || !dock.addBike(u.getBike())) {
                return false;
            }
            u.setBike(null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean loginValidate(String login) {
        // login string validate
        try {
            if (login.length() > 12 ||
                    login.length() == 0) {
                throw new ExceptionLength(login.length());
            }

            for (char c : login.toCharArray()) {
                for (int i = 0; i <= MAX_NUM; i++) {
                    if (Integer.parseInt(String.valueOf(c)) == i)
                        throw new ExceptionNumber(i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    private boolean passwordValidate(String password) {
        // password string validate
        try {
            if (password.length() > 20 ||
                    password.length() < 8) {
                throw new ExceptionLength(password.length());
            }

            int numbersCount = 0;
            for (char c : password.toCharArray()) {
                for (int i = 0; i <= MAX_NUM; i++) {
                    if (Integer.parseInt(String.valueOf(c)) == i)
                        numbersCount++;
                }
            }
            if (numbersCount < 2)
                throw new ExceptionPassNumber(numbersCount);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
