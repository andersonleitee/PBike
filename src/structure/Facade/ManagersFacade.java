package structure.Facade;

import controller.BikeManager;
import controller.DockManager;
import controller.UserManager;
import model.Bike.Bike;
import model.Dock.Dock;
import structure.Singleton.SingletonDockManager;
import structure.Singleton.SingletonUserManager;

public class ManagersFacade {
    // Singleton
    private ManagersFacade(){};
    private static final ManagersFacade instance = new ManagersFacade();
    public static synchronized ManagersFacade getInstance() {
        return instance;
    }

    // TODO: get from CLIPrompts?
    public boolean takeBike(Long idUser, int idDock)
    {
        try {
            Bike bike = SingletonDockManager.getInstance().removeBike(idDock);
            if (bike != null)
            {
                return SingletonUserManager.getInstance().takeBike(idUser, bike);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean returnBike(Long idUser, int idDock)
    {
        try {
            Bike bike = SingletonUserManager.getInstance().getBike(idUser);
            if (SingletonDockManager.getInstance().addBike(idDock, bike)) {
                return SingletonUserManager.getInstance().returnBike(idUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
