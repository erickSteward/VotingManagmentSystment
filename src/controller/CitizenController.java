package controller;

// import java.util.Date;
import java.util.Scanner;

import sevice.CitizenService;
import sevice.MenuService;

public class CitizenController {
  private Scanner scanner = new Scanner(System.in);
  private CitizenService citizenServices = new CitizenService();
  private MenuService menuService = new MenuService();

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
