package structure.Singleton;

import controller.UserManager;

public final class SingletonUserManager {
    private static UserManager instance;

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }
}
