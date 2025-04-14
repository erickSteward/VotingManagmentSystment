package sevice;

import java.util.Scanner;

import controller.CitizenController;

public class MenuService {

  private Scanner scanner = new Scanner(System.in);
  CitizenService citizenServices = new CitizenService();
  CitizenController citizenController = new CitizenController();

  public void mainMenu() {
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

  public boolean registerCitizenMenu() {
      System.out.println("Please register the following citizen details as prompted : ");

      System.out.print("Birth Certificate Number : ");
      int birthCertificateNo = scanner.nextInt();

      System.out.print("First Name : ");
      String fistName = scanner.next();

      System.out.print("Last Name : ");
      String lastName = scanner.next();

      System.out.print("National ID : ");
      int nationalId = scanner.nextInt();

      System.out.print("Location : ");
      String location = scanner.next();

      System.out.print("Ward : ");
      String ward = scanner.next();

      System.out.print("Constituency : ");
      String constituency = scanner.next();

      System.out.print("County : ");
      String county = scanner.next();

      System.out.print("Ethnicity : ");
      String ethnicity = scanner.next();

      if (citizenServices.createCitizen(birthCertificateNo, fistName, lastName, nationalId, location, ward,
          constituency, county, ethnicity)) {
        doContinue();
      }
      System.out.println("Please key in all the details of the Citizen Properly. ");
      return false;
    }


  public boolean doContinue() {
    System.out.println("Do you want to continue? Yes? or No?");
    String action = scanner.next().toLowerCase();

    switch (action) {
      case "yes" -> registerCitizenMenu();
      case "no"-> mainMenu();
      default -> {
        
      }
      System.out.println("Please type 'Yes' to continue and 'No' to go back to the main menu");
        doContinue();
        break;
    }
    return false;
  }
}
