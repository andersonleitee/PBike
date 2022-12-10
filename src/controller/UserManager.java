package controller;

import model.User.User;
import model.Dock.Dock;
import model.Bike.Bike;
import structure.Adapter.UserValidatorAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class UserManager {
    private ArrayList<User> users = new ArrayList<User>();
    UserValidatorAdapter validator = new UserValidatorAdapter();

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
        if (validator.validateUser(user)) {
            this.users.add(user);
            return true;
        } else
            return false;

    }

    public boolean put(Long id, User user) {
        if (validator.validateUser(user) && id > 0) {
            users.set(id.intValue(), user);

            return true;
        } else
            return false;

    }

    public User delete(Long id) {
        User u = null;

        try {
            u = users.get(id.intValue());
            users.remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
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


}
