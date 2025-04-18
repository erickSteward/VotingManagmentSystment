package sevice;

import java.util.Scanner;

import controller.CitizenController;
import dao.CitizenDao;

public class MenuService {

  private Scanner scanner = new Scanner(System.in);
  CitizenDao citizenDao;
  CitizenService citizenService;

    public MenuService(CitizenDao citizenDao) {
        this.citizenDao = citizenDao;
        this.citizenService = new CitizenService();
    }

    public MenuService() {

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
                    citizenService.citizenRegisterService();
                case 2:
                    citizenService.citizenRetrievalService();
                default:
                    System.out.println("bye");
                    break;
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

       if(citizenDao.createCitizen(birthCertificateNo, fistName, lastName, nationalId, location, ward,constituency, county, ethnicity) != null){
           System.out.println("Registration updated the Citizen List. ");
           doContinue();
           return true;
       } else {
           System.out.println("Registration not updated to the Citizen List");
       }
        return false;
     }


   public boolean doContinue() {
     System.out.println("Do you want to continue? Yes? or No?");
     String action = scanner.next().toLowerCase();

     switch (action) {
       case "yes" -> registerCitizenMenu();
       case "no"-> mainMenu();
       default -> {
         System.out.println("Please type 'Yes' to continue and 'No' to go back to the main menu");
         doContinue();
       }
      
     }
     return false;
   }

    public void getAllCitizensMenu() {
      citizenDao.getAllCitizens();
    }
}
