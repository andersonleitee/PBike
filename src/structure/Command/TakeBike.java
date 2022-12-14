package structure.Command;

import model.Bike.Bike;
import structure.Singleton.SingletonDockManager;
import structure.Singleton.SingletonUserManager;

public class TakeBike implements Command{
    Long idUser;
    int idDock;

    public TakeBike (Long idUser, int idDock) {
        this.idDock = idDock;
        this.idUser = idUser;
    }

    public boolean execute() {

        try {
            Bike bike = SingletonDockManager.getInstance().removeBike(idDock);
            if (bike != null) {
                return SingletonUserManager.getInstance().takeBike(idUser, bike);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
