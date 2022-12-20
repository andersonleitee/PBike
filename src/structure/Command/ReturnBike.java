package structure.Command;

import model.Bike.Bike;
import structure.Singleton.SingletonDockManager;
import structure.Singleton.SingletonUserManager;

public class ReturnBike implements Command {
    Long idUser;
    int idDock;

    public ReturnBike (Long idUser, int idDock) {
        this.idDock = idDock;
        this.idUser = idUser;

    }
    
    public boolean execute() {
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
