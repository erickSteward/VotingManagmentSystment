package controller;

import sevice.CitizenService;
import sevice.MenuService;

import java.util.Scanner;

public class CitizenController {
 private Scanner scanner = new Scanner(System.in);
 private CitizenService citizenServices;



   public boolean registerCitizen(){
     return citizenServices.citizenRegisterService();
   }

   public void retrieveAllCitizens(){
     citizenServices.citizenRetrievalService();
   }
  
}
