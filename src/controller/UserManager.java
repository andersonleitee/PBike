package controller;

import model.User.User;
import model.Bike.Bike;
import structure.Adapter.UserValidatorAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class UserManager {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Bike> bikes = new ArrayList<Bike>();
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
            bikes.add(null);
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
            users.remove(id.intValue());
            bikes.remove(id.intValue());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return u;
    }

    public boolean takeBike(Long id, Bike bike) {
        try {
            if (bikes.get(id.intValue()) != null) {
                return false;
            }
            bikes.set(id.intValue(), bike);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public boolean returnBike(Long id) {
        try {
            if (bikes.get(id.intValue()) == null) {
                return false;
            }
            bikes.set(id.intValue(), null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public Bike getBike(Long id) {
        try {
            return bikes.get(id.intValue());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
