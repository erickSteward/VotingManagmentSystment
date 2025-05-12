import controller.CitizenController;
import dao.CitizenDao;
import sevice.CitizenService;

import java.sql.SQLException;
import java.util.Scanner;

public class VotingManger {

    private Scanner scanner = new Scanner(System.in);
    public  CitizenDao citizenDao = new CitizenDao();
    public  CitizenService citizenServices = new CitizenService(scanner, citizenDao);
    public  CitizenController citizenController = new CitizenController(citizenServices);

    public void run() throws SQLException {
        System.out.println("Welcome mate.");
        System.out.println("Please choice the service you want.");
        System.out.println("1. Citizen Electoral Service.");
        System.out.println("2. Voter Electoral service.");
        System.out.println("3. Candidate Electoral Service.");
        int choice = getIntInput("Enter the number here : ");

        switch (choice){
            case 1 -> {
                printCitizenElectoralMenu();
                run();
            }

            case 2 -> {
                printVoterElectoralMenu();
                run();
            }

            case 3 -> {
                printCandidateElectoralMenu();
                run();
            }
        }

    }


    public void printCitizenElectoralMenu() throws SQLException {
        System.out.println("\nPlease, Choose What action you want to do: ");
        System.out.println("1. Register Citizen ");
        System.out.println("2. View Citizens ");
        System.out.println("3. Edit Citizen ");
        System.out.println("4. Delete Citizen ");
        System.out.print("Make your choice : ");
        String choose = scanner.nextLine().toLowerCase().trim();

        switch (choose){
            case "1" -> {
                citizenController.registerCitizen();
                printCitizenElectoralMenu();
            }
            case "2" -> {
                citizenController.retrieveCitizens();
                printCitizenElectoralMenu();
            }
            case "3" -> {
                citizenController.editCitizen();
                printCitizenElectoralMenu();
            }

            case "4" -> {
                //citizenController.deleteCitizen();
                printCitizenElectoralMenu();
            }
            default -> {
                System.out.println("Please choose the appropriate number in the menu select.");
                printCitizenElectoralMenu();
            }
        }
    }

    private void printVoterElectoralMenu() {
    }

    private void printCandidateElectoralMenu() {
    }

    public String getStringInput(String prompt){
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int getIntInput(String prompt){
        while(true){
            try{
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException exception){
                System.out.println("Invalid input. Please enter a number. ");
            }
        }
    }

}
