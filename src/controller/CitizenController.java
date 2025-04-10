package controller;

// import java.util.Date;
import java.util.Scanner;

import sevice.CitizenService;

public class CitizenController {
  private Scanner scanner = new Scanner(System.in);
  private CitizenService citizenServices = new CitizenService();

  public void registerCitizen(){
    while(true){
    System.out.println("Please register the following citizen details as prompted : ");

    System.out.print("Birth Certificate Number : ");
    int birthCertificateNo = scanner.nextInt();

    System.out.print("First Name : ");
    String fistName = scanner.next();

    System.out.print("Last Name : ");
    String lastName = scanner.next();

    // System.out.println("Date Of Birth");
    // Date dateOfBirth = scanner.;

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

    citizenServices.createCitizen(birthCertificateNo, fistName, lastName, nationalId, location, ward, constituency, county, ethnicity);

    System.out.println("y to continue : ");
    }

  }

  public void retrieveAllCitizens(){
    citizenServices.getAllCitizens();
  }
  
}
