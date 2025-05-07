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

  
  public Citizen registerCitizenService() throws SQLException {
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

//  public void retrievalAllCitizenService(){
//     // if(!citizenDao.getAllCitizens().isEmpty())
//          for (Citizen citizen1 : citizenDao.getAllCitizens()) {
//              System.out.println(citizen1);
//          }
//      else
//          System.out.println("Records Found. ");
//  }

  public void retrieveCitizenService(){
      System.out.println("How do you want to Retrieve Citizen's Details.");
      System.out.println("1. Retrieve All Citizens");
      System.out.println("2. Retrieve a Citizen by national ID");
      System.out.println("3. Retrieve a citizen by Name.");

      int choice = scanner.nextInt();

  }

  public boolean retrieveCitizenByNationalIDService() throws SQLException {
      int nationalId = getIntInput("Enter Citizen national ID: ");

      if(citizenDao.getByNationalId(nationalId) != null) {
          citizen = citizenDao.getByNationalId(nationalId);
          System.out.println(citizen);
          return true;
      }
      return false;
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

    public void editCitizenService() {
      int nationalId = getIntInput("Enter national ID to Edit Citizen : ");
     // citizen = citizenDao.getCitizenById(nationalId);
      if(nationalId > 0 && citizen != null){
          System.out.println("What do you want to edit " + citizen.getFirstName() + "'s details");
          System.out.println("1. Birth Certificate Number.");
          System.out.println("2. First Name.");
          System.out.println("3. Last Name. ");
          System.out.println("4. National ID.");
          System.out.println("5. Location.");
          System.out.println("6. Ward.");
          System.out.println("7. Constituency.");
          System.out.println("8. County.");
          System.out.println("9. ethnicity");
          int choice = getIntInput("Enter number that you need to edit : ");

          switch (choice){
              case 1 -> editCitizenBirthCertificateService(citizen);
              case 2 -> editCitizenFirstNameService(citizen);
              case 3 -> editCitizenLastNameService(citizen);
              case 4 -> editCitizenNationalIdService(citizen);
              case 5 -> editCitizenLocationService(citizen);
              case 6 -> editCitizenWardService(citizen);
              case 7 -> editCitizenConstituencyService(citizen);
              case 8 -> editCitizenCountyService(citizen);
              case 9 -> editCitizenEthnicityService(citizen);
              default -> {
                  System.out.println("Please select select within the above (1-9) to edit : ");
                  editCitizenService();
              }
          }
      }
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

//    public void deleteACitizenService() {
//      int deleteCitizenId = getIntInput("Enter National ID to delete Citizen : ");
//      if(citizenDao.deleteACitizenDao(deleteCitizenId)){
//          System.out.println("Citizen successfully deleted");
//      } else {
//          System.out.println("There seem to be a problem. Please check you Id");
//      }
//    }
}
