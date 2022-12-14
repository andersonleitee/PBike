package structure.Facade;

import controller.BikeManager;
import controller.DockManager;
import controller.UserManager;
import structure.Command.Command;
import structure.Singleton.SingletonBikeManager;
import structure.Singleton.SingletonDockManager;
import structure.Singleton.SingletonUserManager;

public class ManagersFacade {
    public Command command;
    private ManagersFacade(){};

    public ManagersFacade(Command c){
        this.command = c;
    };
    // Singleton
    private static final ManagersFacade instance = new ManagersFacade();
    public static synchronized ManagersFacade getInstance() {
        return instance;
    }

    // TODO: get instance from singleton manager
    private final UserManager userManager = SingletonUserManager.getInstance();
    private final DockManager dockManager = SingletonDockManager.getInstance();
    private final BikeManager bikeManager = SingletonBikeManager.getInstance();

    public void execute(){
        this.command.execute();
    }

}
