package structure.Singleton;

import controller.DockManager;

public class SingletonDockManager {
    private static DockManager instance;

    public static DockManager getInstance() {
        if (instance == null) {
            instance = new DockManager();
        }
        return instance;
    }
}
