package sevice;


import java.util.ArrayList;
import java.util.List;

import model.Citizen;

public class CitizenService {

  private List<Citizen> citizens = new ArrayList<>();
  private Citizen citizen;

  
  public boolean createCitizen(int birthCertificateNo, String firstName, String lastName,  int nationalId, String location, String ward, String constituency, String county, String ethnicity){
    
    while(true){
      if(birthCertificateNo != 0 || !firstName.isEmpty() || !lastName.isEmpty() || nationalId != 0 || !location.isEmpty() || !ward.isEmpty() || !constituency.isEmpty() || !county.isEmpty() || !ethnicity.isEmpty() ){
        citizen = new Citizen(birthCertificateNo, firstName, lastName, nationalId, location, ward, constituency, county, ethnicity);
        citizens.add(citizen);
        System.out.println("Registration Successfull");
        return true;
      } else {
        System.out.println("All fields must be fill with the proper details");
      }
      return false;
    }
      
  }

  public void getAllCitizens(){
    if(citizens != null){
      for (Citizen ctzn : citizens) {
        System.out.println(ctzn);
      }
    } else {
      System.out.println("No Citizens Registered");
    }
  }
}
