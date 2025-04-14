package controller;

import sevice.CitizenService;
import sevice.MenuService;

import java.util.Scanner;

public class CitizenController {
 private Scanner scanner = new Scanner(System.in);
 private CitizenService citizenServices;
 private MenuService menuService;

  public void run(){
    menuService.mainMenu();
  }

   public boolean registerCitizen(){
     if(menuService.registerCitizenMenu()){
       System.out.println("Citizen Register Successfully! ");
       return true;
     }
     System.out.println("Failed to register.");
     menuService.doContinue();
     return false;
   }

   public void retrieveAllCitizens(){
     citizenServices.getAllCitizens();
   }
  
}
