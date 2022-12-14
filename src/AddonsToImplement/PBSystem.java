
package AddonsToImplement;

import model.User.User;


import java.util.ArrayList;

public class PBSystem {
    private final ArrayList<User> logged_users = new ArrayList<>();

    public PBSystem(){}

    public void addLoggedUser(User u) {
        logged_users.add(u);
    }

    public String getLoggedUsers(){
        StringBuilder out = new StringBuilder();

        for(User u : this.logged_users){
            String userS = u.getLogin() + "\n";

            out.append(userS);
        }

        return out.toString();
    }
}