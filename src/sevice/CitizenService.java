package sevice;
import dao.CitizenDao;
import model.Citizen;


import java.sql.SQLException;
import java.util.Scanner;

public class CitizenService {


  private Citizen citizen;
  private Scanner scanner;
  private CitizenDao citizenDao;

  public CitizenService(Scanner scanner, CitizenDao citizenDao) {
    this.scanner = scanner;
    this.citizenDao = citizenDao;
  }

  
  public Citizen registerCitizenService() {
      System.out.println("Please register the following citizen details as prompted : ");


      int birthCertificateNo = getIntInput("Birth Certificate Number : ");
      String fistName = getStringInput("First Name : ");
      String lastName = getStringInput("Last Name : ");
      int nationalId = getIntInput("National ID : ");
      String location = getStringInput("Location : ");
      String ward = getStringInput("Ward : ");
      String constituency = getStringInput("Constituency : ");
      String county = getStringInput("County : ");
      String ethnicity = getStringInput("Ethnicity : ");

    if(birthCertificateNo != 0 && !fistName.isEmpty() && !lastName.isEmpty() && nationalId != 0 && !location.isEmpty() && !ward.isEmpty() && !constituency.isEmpty() && !county.isEmpty() && !ethnicity.isEmpty()) {
      citizen = new Citizen(birthCertificateNo, fistName, lastName, nationalId, location, ward, constituency, county, ethnicity);
        try {
            citizenDao.addCitizen(citizen);
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("No sasa Mambo unafanya! : " + e.getStackTrace());
        }
    } else {
      System.out.println("Please Enter the details appropriately");
    }
      return  citizenDao.createCitizen(citizen);
  }


  public void retrieveCitizenService() throws SQLException {
      System.out.println("How do you want to Retrieve Citizen's Details.");
      System.out.println("1. Retrieve All Citizens");
      System.out.println("2. Retrieve a Citizen by national ID");
      System.out.println("3. Retrieve a citizen by Name.");
      System.out.println("4. Back");
      int choice = getIntInput("Enter the option service you need : ");

      switch(choice){
          case 1 -> {
              retrieveAllCitizenService();
              retrieveCitizenService();
          }
          case 2 -> {
              if(!retrieveCitizenByNationalIDService()){
                  System.out.println("Records not found");
              }

              retrieveCitizenService();
          }
          case 3 -> {
              if(!retrieveCitizenByNameService()){
                  System.out.println("Records not found");
              }
              retrieveCitizenService();
          }

      }

  }

  private boolean retrieveCitizenByNationalIDService() throws SQLException {
      int nationalId = getIntInput("Enter Citizen national ID: ");

      citizen = citizenDao.getByNationalId(nationalId);

      if(citizen != null) {
          System.out.println(citizen);
          return true;
      }
      return false;
  }

  private void retrieveAllCitizenService() throws SQLException {
      System.out.println("Retrieving service");
      if(citizenDao.getAllCitizens() != null){
          System.out.println("Here are all the citizens in the database");
          for (Citizen citizen : citizenDao.getAllCitizens()){
              System.out.println(citizen);
          }
      } else {
          System.out.println("No records found.");
      }
  }

  private boolean retrieveCitizenByNameService() throws SQLException {
      System.out.println();
      System.out.println("To search a citizen by name, input first or last name.");
      String name = getStringInput("Enter First or Last name of Citizen to search : ");
      citizen = citizenDao.getByName(name);
      if(citizen != null){
          System.out.println(citizen);
          return true;
      } else {
          System.out.println("Something went wrong with the search. ");
          return false;
      }
  }

    public void editCitizenService() throws SQLException {
        int nationalId = getIntInput("Enter national ID to edit citizen: ");

        Citizen citizen = citizenDao.getByNationalId(nationalId);
        if (nationalId <= 0 || citizen == null) {
            System.out.println("Citizen not found with the given National ID.");
            return;
        }

        System.out.println("Editing details for: " + citizen.getFirstName() + " " + citizen.getLastName());

        boolean editing = true;
        while (editing) {
            System.out.println("\nWhat do you want to edit?");
            System.out.println("1. Birth Certificate Number");
            System.out.println("2. First Name");
            System.out.println("3. Last Name");
            System.out.println("4. National ID");
            System.out.println("5. Location");
            System.out.println("6. Ward");
            System.out.println("7. Constituency");
            System.out.println("8. County");
            System.out.println("9. Ethnicity");
            System.out.println("0. Finish and Save");

            int choice = getIntInput("Enter the number corresponding to the field to edit: ");

            switch (choice) {
                case 1 -> editCitizenBirthCertificateService(citizen);
                case 2 -> editCitizenFirstNameService(citizen);
                case 3 -> editCitizenLastNameService(citizen);
                case 4 -> editCitizenNationalIdService(citizen);
                case 5 -> editCitizenLocationService(citizen);
                case 6 -> editCitizenWardService(citizen);
                case 7 -> editCitizenConstituencyService(citizen);
                case 8 -> editCitizenCountyService(citizen);
                case 9 -> editCitizenEthnicityService(citizen);
                case 0 -> editing = false;
                default -> System.out.println("Invalid choice. Please select from 0 to 9.");
            }
        }

        // Save the changes after all edits
        citizenDao.updateCitizen(citizen);
        System.out.println("Citizen information updated successfully.");
    }


    private void editCitizenBirthCertificateService(Citizen citizen) {
        int editedBirthCertificateNumber = getIntInput("Type new birth certificate number : ");
        citizen.setBirthCertificateNo(editedBirthCertificateNumber);
        System.out.println("Birth Certificate Number edited to : " + citizen.getBirthCertificateNo());
    }

    private void editCitizenNationalIdService(Citizen citizen) {
        int editedNationalID = getIntInput("Type new national id : ");
        citizen.setNationalId(editedNationalID);
        System.out.println("National ID edited to : " + citizen.getNationalId());
    }


    private void editCitizenFirstNameService(Citizen citizen) {
        String editedFirstName = getStringInput("Type new first name : ");
        citizen.setFirstName(editedFirstName);
        System.out.println("First name edited to : " + citizen.getFirstName());
    }

    private void editCitizenLastNameService(Citizen citizen) {
        String editedLastName = getStringInput("Type new last name : ");
        citizen.setLastName(editedLastName);
        System.out.println("Last name edited to : " + citizen.getLastName());
    }

    private void editCitizenLocationService(Citizen citizen){
        String editedLocation = getStringInput("Type new Location : ");
        citizen.setLocation(editedLocation);
        System.out.println("Location edited to : " + citizen.getLocation());
    }

    private void editCitizenWardService (Citizen citizen){
        String editedWard = getStringInput("Type new ward : ");
        citizen.setWard(editedWard);
        System.out.println("Ward edited to : " + citizen.getWard());
    }

    private void editCitizenConstituencyService (Citizen citizen){
        String editedConstituency = getStringInput("Type new Constituency : ");
        citizen.setConstituency(editedConstituency);
        System.out.println("Constituency edited to : " + citizen.getConstituency());
    }

    private void editCitizenCountyService (Citizen citizen){
        String editedCounty = getStringInput("Type new County : ");
        citizen.setCounty(editedCounty);
        System.out.println("County edited to : " + citizen.getCounty());
    }

    private void editCitizenEthnicityService (Citizen citizen){
        String editedEthnicity = getStringInput("Type new Ethnicity : ");
        citizen.setEthnicity(editedEthnicity);
        System.out.println("Ethnicity edited to : " + citizen.getEthnicity());
    }

    private String getStringInput(String prompt){
        String input;
        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            }
        } while (input.isEmpty());
        return input;
    }

    private int getIntInput(String prompt){
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
