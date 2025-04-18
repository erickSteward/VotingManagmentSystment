package sevice;

import java.util.Scanner;

import controller.CitizenController;
import dao.CitizenDao;

public class MenuService {

  private Scanner scanner = new Scanner(System.in);
  CitizenDao citizenDao;

    public MenuService(CitizenDao citizenDao) {
        this.citizenDao = citizenDao;
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
         break;
       }
      
     }
     return false;
   }

    public void getAllCitizensMenu() {
      citizenDao.getAllCitizens();
    }
}
