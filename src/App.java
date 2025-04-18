import com.sun.jdi.PrimitiveValue;
import controller.CitizenController;
import dao.CitizenDao;
import sevice.CitizenService;
import sevice.MenuService;

import java.util.Scanner;

public class App {
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        launch();
    }

    public static void launch(){
        CitizenDao citizenDao = new CitizenDao();
        MenuService menuService = new MenuService();
        CitizenService citizenServices = new CitizenService(menuService);
        CitizenController citizenController = new CitizenController();

    }

    public void mainMenu() {
        System.out.println("********* Welcome to the Voting Management System ********* ");
        System.out.println("Please select the actions you need. ");
        System.out.println("1. Register Citizen. ");
        System.out.println("2. View All Registered Citizens");
        System.out.print("What's your choice?");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:

            case 2:

            default:
                System.out.println("bye");
                break;
        }
    }
}
