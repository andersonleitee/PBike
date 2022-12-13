package structure.Singleton;


import AddonsToImplement.PBSystem;

public class SingletonPBSystem {
    private static PBSystem instance;

    public static PBSystem getInstance() {
        if (instance == null) {
            instance = new PBSystem();
        }
        return instance;
    }
}
