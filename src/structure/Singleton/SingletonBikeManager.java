package structure.Singleton;

import controller.BikeManager;

public class SingletonBikeManager {

    private static BikeManager instance;

    public static BikeManager getInstance() {
        if (instance == null) {
            instance = new BikeManager();
        }
        return instance;
    }
}
