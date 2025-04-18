package sevice;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import model.Citizen;

public class CitizenService {


  private Citizen citizen;
  private MenuService menuService;



  public CitizenService(MenuService menuService){
    this.menuService = menuService;
  }

  
  public boolean citizenRegisterService(){
    if(menuService.registerCitizenMenu()){
      System.out.println("Registration Service Successful. ");
      return true;
    } else {
      System.out.println("Registration Service failed.");
    }
    return false;
  }

  public void citizenRetrievalService(){
    menuService.getAllCitizensMenu();
  }
}
