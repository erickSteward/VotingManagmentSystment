import controller.CitizenController;
import dao.CitizenDao;
import sevice.CitizenService;

import java.util.Scanner;

public class VotingManger {

    private Scanner scanner = new Scanner(System.in);
    public  CitizenDao citizenDao = new CitizenDao();
    public  CitizenService citizenServices = new CitizenService(scanner, citizenDao);
    public  CitizenController citizenController = new CitizenController(citizenServices);

    public void run(){
        System.out.println("\nPlease, Choose What action you want to do: ");
        System.out.println("1. Register Citizen ");
        System.out.println("2. View All Citizens ");
        System.out.println("3. View a Citizen ");
        System.out.println("4. Edit a Citizen ");
        System.out.println("5. Delete a Citizen ");
        System.out.println("6. Delete all Citizens");
        System.out.print("Make you choice : ");
        String choose = scanner.nextLine().toLowerCase().trim();

        switch (choose){
            case "1" -> {
                citizenController.registerCitizen();
                run();
            }
            case "2" -> {
                citizenController.retrieveAllCitizens();
                run();
            }
            case "3" -> {
                citizenController.retrieveACitizen();
                run();
            }

            case "4" -> {
                citizenController.editCitizen();
                run();
            }
            default -> {
                System.out.println("Please choose the appropriate number in the menu select.");
                run();
            }
        }
    }

}
