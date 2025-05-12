package controller;

import sevice.CitizenService;

import java.sql.SQLException;
import java.util.Scanner;

public class CitizenController {
 private Scanner scanner = new Scanner(System.in);
 private CitizenService citizenServices;

    public CitizenController(CitizenService citizenServices) {
        this.citizenServices = citizenServices;
    }

    public void registerCitizen() throws SQLException {
     if(citizenServices.registerCitizenService() != null){
         System.out.println("Registration Successful");
     } else {
         System.out.println("Registration failed");
     }
   }

   public void retrieveCitizens() throws SQLException {
       citizenServices.retrieveCitizenService();
   }


    public void editCitizen() throws SQLException {
        citizenServices.editCitizenService();
    }

}
