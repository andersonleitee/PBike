
package AddonsToImplement;

import model.User.User;


import java.util.ArrayList;

public class PBSystem {
    private final ArrayList<User> logged_users = new ArrayList<>();

    public PBSystem(){}

    public void addLoggedUser(User u) {
        logged_users.add(u);
    }

    public ArrayList<User> getLoggedUsers(){
        return this.logged_users;
    }
}