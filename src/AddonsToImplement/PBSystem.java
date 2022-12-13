
package AddonsToImplement;

import model.User.User;


import java.util.ArrayList;

public class PBSystem {
    private final ArrayList<User> logged_users = new ArrayList<>();

    public PBSystem(){}

    public void addLoggedUser(User u) {
        logged_users.add(u);
    }

    public ArrayList<String> getLoggedUsers(){
        ArrayList<String> out = new ArrayList<>();

        for(User u : this.logged_users){
            String userS = u.getLogin() + "\n";

            out.add(userS);
        }


        return out;
    }
}