package dao;

import model.Citizen;

import java.util.ArrayList;
import java.util.List;

public class CitizenDao {
    private List<Citizen> citizens = new ArrayList<>();

    public Citizen createCitizen(int birthCertificateNumber,
                                         String firstName,
                                         String lastName,
                                         int nationalId,
                                         String location,
                                         String ward,
                                         String constituency,
                                         String county,
                                         String ethnicity){

        return new Citizen(
                birthCertificateNumber, firstName, lastName, nationalId, location, ward, constituency, county, ethnicity
        );
    }

    public void getAllCitizens() {
        for(Citizen citizen : citizens){
            System.out.println(citizen);
        }
    }
}
