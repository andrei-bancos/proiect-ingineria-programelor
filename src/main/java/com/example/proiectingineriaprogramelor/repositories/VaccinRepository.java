package com.example.proiectingineriaprogramelor.repositories;

import com.example.proiectingineriaprogramelor.DatabaseConnection;
import com.example.proiectingineriaprogramelor.models.Alergie;
import com.example.proiectingineriaprogramelor.models.User;
import com.example.proiectingineriaprogramelor.models.Vaccin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VaccinRepository {
    private final DatabaseConnection db = DatabaseConnection.getInstance();
    private final Connection connection = db.getConnection();
    public List<Vaccin> getVaccinuriByPacient(int pacientId) {
        List<Vaccin> listaVaccinuri = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Vaccin WHERE Id_pacient = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pacientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vaccin vaccin = new Vaccin();
                Timestamp data= resultSet.getTimestamp("Data");

                vaccin.setNume(resultSet.getString("Nume"));
                vaccin.setData(data.toLocalDateTime());
                listaVaccinuri.add(vaccin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaVaccinuri;
    }

    public void addVaccin(Vaccin vaccin) {
        try {
            String sql = "INSERT INTO Vaccin (Id_pacient, Nume, Data) VALUE (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, vaccin.getIdPacient());
            preparedStatement.setString(2, vaccin.getNume());
            preparedStatement.setObject(3, vaccin.getData());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
