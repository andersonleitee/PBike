package structural;

import controller.BikeManager;
import controller.DockManager;
import controller.UserManager;
import model.Bike;
import model.Dock;
public class ManagersFacade {
    // Singleton
    private ManagersFacade(){};
    private static ManagersFacade instance = new ManagersFacade();
    public static synchronized ManagersFacade getInstance() {
        return instance;
    }

    // TODO: get from CLIPrompts?
    private UserManager userManager;
    private DockManager dockManager;
    private BikeManager bikeManager;

    public boolean takeBike(Long idUser, int idDock)
    {
        try {
            Dock dock = dockManager.getById(idDock); // can throw ArrayIndexOutOfBoundsException
            if (dock.getBikesSize() > 0)
            {
                Bike bike = dock.getBikes().get(0);
                return userManager.takeBike(idUser, bike);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean returnBike(Long idUser, int idDock)
    {
        try {
            Dock dock = dockManager.getById(idDock); // can throw ArrayIndexOutOfBoundsException
            return userManager.returnBike(idUser, dock);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
