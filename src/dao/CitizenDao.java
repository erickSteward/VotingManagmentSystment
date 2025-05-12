package dao;

import model.Citizen;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CitizenDao {
    //private static List<Citizen> citizens = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addCitizen(Citizen citizen) throws SQLException {
        String sql = "INSERT INTO citizen (birth_certificate_no, first_name, last_name, national_id, location, ward, constituency, county, ethnicity) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        try(Connection conn = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            preparedStatement.setInt(1,    citizen.getBirthCertificateNo());
            preparedStatement.setString(2, citizen.getFirstName());
            preparedStatement.setString(3, citizen.getLastName());
            preparedStatement.setInt(4,    citizen.getNationalId());
            preparedStatement.setString(5, citizen.getLocation());
            preparedStatement.setString(6, citizen.getWard());
            preparedStatement.setString(7, citizen.getConstituency());
            preparedStatement.setString(8, citizen.getCounty());
            preparedStatement.setString(9, citizen.getEthnicity());

            int affectedRow = preparedStatement.executeUpdate();
            if(affectedRow == 0){
                throw new SQLException("Creating citizen failed, no rows affected");
            }


            try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()){
                if(generatedKeys.next()){
                    citizen.setNationalId(generatedKeys.getInt(4));
                } else {
                    throw new SQLException("Creating citizen failed, no National ID was obtained");
                }
            }

            System.out.println("Citizen registered successfully" + citizen);
        }

    }

    public Citizen getByNationalId(int id) throws SQLException {
        String sql = "SELECT * FROM citizen WHERE national_id = ?";

        try(Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);

            try(ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()){
                    return retrieveCitizenFromResultSet(rs);
                }
            }
        }
        return null;
    }

    public Citizen getByName(String name) throws SQLException {
        String sql = "SELECT * FROM citizen WHERE first_name = ? OR last_name = ?";


        try(Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, name);
            try(ResultSet rs = preparedStatement.executeQuery()){
                if(rs.next()){
                    return retrieveCitizenFromResultSet(rs);
                }
            }
        }
        return null;
    }

    public List<Citizen> getAllCitizens() throws SQLException {
        List<Citizen> citizens = new ArrayList<>();

        String sql = "SELECT * FROM citizen";

        try(Connection conn = DatabaseConfiguration.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()){
                citizens.add(retrieveCitizenFromResultSet(resultSet));
            }
        }
        return citizens;
    }

    public void updateCitizen(Citizen citizen) throws SQLException {
        String sql = "UPDATE citizen SET birth_certificate_no = ?, first_name = ? , last_name = ?, national_id = ? , location = ?, ward = ?, constituency = ?, county = ?, ethnicity = ? WHERE national_id = ?";

        try(Connection connection = DatabaseConfiguration.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, citizen.getBirthCertificateNo());
            preparedStatement.setString(2, citizen.getFirstName());
            preparedStatement.setString(3, citizen.getLastName());
            preparedStatement.setInt(4, citizen.getNationalId());
            preparedStatement.setString(5, citizen.getLocation());
            preparedStatement.setString(6, citizen.getWard());
            preparedStatement.setString(7, citizen.getConstituency());
            preparedStatement.setString(8, citizen.getCounty());
            preparedStatement.setString(9, citizen.getEthnicity());

            preparedStatement.setInt(10, citizen.getNationalId());
            int affectedRow = preparedStatement.executeUpdate();
            if(affectedRow == 0){
                throw new SQLException("Updating citizen failed, no rows affected");
            }

            System.out.println("Citizen updated successfully: \n" + citizen);

        }

    }

    private Citizen retrieveCitizenFromResultSet(ResultSet rs) throws SQLException {
        Citizen citizen = new Citizen();
        citizen.setBirthCertificateNo(rs.getInt("birth_certificate_no"));
        citizen.setFirstName(rs.getString("first_name"));
        citizen.setLastName(rs.getString("last_name"));
        citizen.setNationalId(rs.getInt("national_id"));
        citizen.setLocation(rs.getString("location"));
        citizen.setWard(rs.getString("ward"));
        citizen.setConstituency(rs.getString("constituency"));
        citizen.setCounty(rs.getString("county"));
        citizen.setEthnicity(rs.getString("ethnicity"));
        return citizen;

    }


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
        return citizen;
    }

}
