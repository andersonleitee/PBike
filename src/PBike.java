import model.User.User;
import structure.Singleton.SingletonPBSystem;
import structure.Singleton.SingletonUserManager;
import view.CLIPrompts;
import view.UserPrompts;

import java.util.ArrayList;

public class PBike {
    public static void main(String[] args) {
        falseUserData();
    }

    public static void falseUserData(){
        String[] names = {"Gabriel", "Lara", "Anderson", "Jayanne", "Carol"};
        String[] passwords = {"123456789", "987654312", "147258369", "963852741", "1597532486"};
        UserPrompts userPrompts = new UserPrompts();

        for(int i = 0; i < 5; i++){
            SingletonUserManager.getInstance().post(new User(names[i], passwords[i]));
            userPrompts.testUserLogin(names[i], passwords[i]);
        }

        String out = SingletonPBSystem.getInstance().getLoggedUsers();
        System.out.println(out);
    }
}

