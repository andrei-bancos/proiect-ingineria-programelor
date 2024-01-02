package com.example.proiectingineriaprogramelor.repositories;

import com.example.proiectingineriaprogramelor.DatabaseConnection;
import com.example.proiectingineriaprogramelor.models.Pacient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacientRepository {
    private final DatabaseConnection db = DatabaseConnection.getInstance();
    private final Connection connection = db.getConnection();

    public List<Pacient> getPacienti() {
        try {
            List<Pacient> pacientiList = new ArrayList<>();
            String sql = "SELECT * FROM pacient";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pacient pacient = new Pacient();
                Timestamp dataNasteri = resultSet.getTimestamp("data_nasterii");

                pacient.setNume(resultSet.getString("nume"));
                pacient.setPrenume(resultSet.getString("prenume"));
                pacient.setCnp(resultSet.getString("cnp"));
                pacient.setSex(resultSet.getString("sex"));
                pacient.setDataNasteri(dataNasteri.toLocalDateTime());
                pacient.setGrupaSanguina(resultSet.getString("grupa_sanguina"));
                pacient.setNr_card(resultSet.getString("nr_card"));
                pacient.setAsigurare(resultSet.getBoolean("asigurare"));
                pacient.setEmail(resultSet.getString("email"));
                pacient.setNr_tel(resultSet.getString("nr_tel"));

                pacientiList.add(pacient);
            }
            return pacientiList;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Pacient getPacient(int pacientId) {
        try {
            String sql = "SELECT * from pacient WHERE Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pacientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                Pacient pacient = new Pacient();
                Timestamp dataNasteri = resultSet.getTimestamp("data_nasterii");

                pacient.setNume(resultSet.getString("nume"));
                pacient.setPrenume(resultSet.getString("prenume"));
                pacient.setCnp(resultSet.getString("cnp"));
                pacient.setSex(resultSet.getString("sex"));
                pacient.setDataNasteri(dataNasteri.toLocalDateTime());
                pacient.setGrupaSanguina(resultSet.getString("grupa_sanguina"));
                pacient.setNr_card(resultSet.getString("nr_card"));
                pacient.setAsigurare(resultSet.getBoolean("asigurare"));
                pacient.setEmail(resultSet.getString("email"));
                pacient.setNr_tel(resultSet.getString("nr_tel"));
                return pacient;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addPacient(Pacient pacient) {
        try {
            String sql = "INSERT INTO pacient (Nume, Prenume, CNP, Sex, Data_nasterii, Grupa_sanguina, Nr_card," +
                         "Asigurare, Email, Nr_tel) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, pacient.getNume());
            preparedStatement.setString(2, pacient.getPrenume());
            preparedStatement.setString(3, pacient.getCnp());
            preparedStatement.setString(4, pacient.getSex());
            preparedStatement.setObject(5, pacient.getDataNasteri());
            preparedStatement.setObject(6, pacient.getGrupaSanguina());
            preparedStatement.setString(7, pacient.getNr_card());
            preparedStatement.setBoolean(8, pacient.isAsigurare());
            preparedStatement.setString(9, pacient.getEmail());
            preparedStatement.setString(10, pacient.getNr_tel());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deletePacient(int pacientId) {
        try {
            String sql = "DELETE pacient FROM pacient WHERE Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pacientId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
