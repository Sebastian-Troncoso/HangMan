package app;

import controller.HangManController;
import dao.HMDao;
import dao.HMDaoImpl;
import dao.HangManPersistenceException;
import service.HMServiceLayer;
import service.HMServiceLayerImpl;
import view.HMView;
import view.UserIO;
import view.UserIOImpl;

public class App {
    public static void main(String[] args) throws HangManPersistenceException {
        HMDao dao = new HMDaoImpl();
        UserIO io = new UserIOImpl();
        HMView view = new HMView(io);
        HMServiceLayer service = new HMServiceLayerImpl(dao);
        HangManController controller = new HangManController(service, view);
        controller.run();
    }
}
