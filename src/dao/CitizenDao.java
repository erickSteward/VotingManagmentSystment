package dao;

import model.Citizen;

import java.util.ArrayList;
import java.util.List;

public class CitizenDao {
    private List<Citizen> citizens = new ArrayList<>();

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

    public String getCitizenById(int nationalID){
        for (Citizen citizen : citizens){
            if(citizen.getNationalId() == nationalID){
                return citizen.toString();
            }
        }
        return "Citizen not Found";
    }


}
