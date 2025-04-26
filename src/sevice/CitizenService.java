package sevice;
import dao.CitizenDao;
import model.Citizen;


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
    } else {
      System.out.println("Please Enter the details appropriately");
    }
      return  citizenDao.createCitizen(citizen);
  }

  public void retrievalAllCitizenService(){
      if(!citizenDao.getAllCitizens().isEmpty())
          for (Citizen citizen1 : citizenDao.getAllCitizens()) {
              System.out.println(citizen1);
          }
      else
          System.out.println("Records Found. ");
  }

  public void retrieveACitizenService(){
      int nationalId = getIntInput("Enter Citizen national ID: ");
      if(!citizenDao.getCitizenById(nationalId).isEmpty()){
          System.out.println(citizenDao.getCitizenById(nationalId));
      } else {
          System.out.println("Opp, No Such citizen");
      }
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
