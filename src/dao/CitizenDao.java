package dao;

import model.Citizen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CitizenDao {
    private static List<Citizen> citizens = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);



    public Citizen createCitizen(Citizen citizen){
        citizen = new Citizen(
                citizen.getBirthCertificateNo(),
                citizen.getFirstName(),
                citizen.getLastName(),
                citizen.getNationalId(),
                citizen.getLocation(),
                citizen.getWard(),
                citizen.getConstituency(),
                citizen.getCounty(),
                citizen.getEthnicity()
        );
        addCitizen(citizen);
        return citizen;
    }

    private void addCitizen(Citizen citizen){
        citizens.add(citizen);
    }

    public List<Citizen> getAllCitizens() {
        return citizens;
    }

    public Citizen getCitizenById(int nationalID){
        for (Citizen citizen : citizens){
            if(citizen.getNationalId() == nationalID){
                return citizen;
            }
        }
        return null;
    }


    public static Citizen getCitizenByLastName(String lastName) {
        for (Citizen citizen : citizens){
            if(lastName.equalsIgnoreCase(citizen.getLastName())){
                return citizen;
            }
        }
        return null;
    }

    public static Citizen getCitizenByFirstName(String firstName) {
        for (Citizen citizen : citizens){
            if(firstName.equalsIgnoreCase(citizen.getFirstName())){
                return citizen;
            }
        }
        return null;
    }


    public boolean deleteACitizenDao(int deleteCitizenId) {
        Citizen citizen = getCitizenById(deleteCitizenId);
        if(citizen != null){
            citizens.remove(citizen);
        }
        return  false;
    }
}
