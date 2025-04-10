import java.util.Scanner;

import controller.CitizenController;

public class App {
    static CitizenController citizenController = new CitizenController();

    public static void main(String[] args) throws Exception {
        launch();
    }

    public static void launch(){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("********* Welcome to the Voting Management System ********* ");
            System.out.println("Please select the actions you need. ");
            System.out.println("1. Register Citizen. ");
            System.out.println("2. View All Registered Citizens");
            System.out.print("What's your choice?");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    citizenController.registerCitizen();
                    break;
                case 2:
                    citizenController.retrieveAllCitizens();
                    break;
                default:
                    System.out.println("bye");
                    break;
            }
        }
    }
}
