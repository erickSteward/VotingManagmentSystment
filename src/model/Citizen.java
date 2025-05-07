package model;

import java.util.List;

public class Citizen {
  
  private int birthCertificateNo;
  private String firstName;
  private String lastName;
  private int nationalId;
  private String location;
  private String ward;
  private String constituency;
  private String county;
  private String ethnicity;

  private List<Citizen> citizenList;


  public Citizen() {
    
  }

  public Citizen(List citizenList){
    for(Object citizen : citizenList){
      System.out.println(citizen);
    }
  }


  public Citizen(int birthCertificateNo, String firstName, String lastName, int nationalId,
      String location, String ward, String constituency, String county, String ethnicity) {
    this.birthCertificateNo = birthCertificateNo;
    this.firstName = firstName;
    this.lastName = lastName;
    this.nationalId = nationalId;
    this.location = location;
    this.ward = ward;
    this.constituency = constituency;
    this.county = county;
    this.ethnicity = ethnicity;
  }




  public int getBirthCertificateNo() {
    return birthCertificateNo;
  }


  public void setBirthCertificateNo(int birthCertificateNo) {
    this.birthCertificateNo = birthCertificateNo;
  }


  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public int getNationalId() {
    return nationalId;
  }


  public void setNationalId(int nationalId) {
    this.nationalId = nationalId;
  }


  public String getLocation() {
    return location;
  }


  public void setLocation(String location) {
    this.location = location;
  }


  public String getWard() {
    return ward;
  }


  public void setWard(String ward) {
    this.ward = ward;
  }


  public String getConstituency() {
    return constituency;
  }


  public void setConstituency(String constituency) {
    this.constituency = constituency;
  }


  public String getCounty() {
    return county;
  }


  public void setCounty(String county) {
    this.county = county;
  }


  public String getEthnicity() {
    return ethnicity;
  }


  public void setEthnicity(String ethnicity) {
    this.ethnicity = ethnicity;
  }


  @Override
  public String toString() {
    return "[Detail for " + firstName + " " + lastName + "birthCertificateNo = " + birthCertificateNo + "First Name = " + firstName + "Last Name = " + lastName + "National ID = " + nationalId + "Location = " + location + "Ward = " + ward
        + "Constituency = " + constituency + "County = " + county + "Ethnicity = " + ethnicity + "]";
  }

}
