import controller.CitizenController;
import dao.CitizenDao;
import sevice.CitizenService;
import sevice.MenuService;

import java.util.Scanner;

public class AppMain {
    private static Scanner scanner = new Scanner(System.in);
    public  static CitizenDao citizenDao = new CitizenDao();
    public  static MenuService menuService = new MenuService(citizenDao);
    public  static CitizenService citizenServices = new CitizenService(menuService);
    public  static CitizenController citizenController = new CitizenController(citizenServices);


    public static void main(String[] args) throws Exception {
        launch();
    }

    public static void launch(){
        menuService.mainMenu();
    }


}
