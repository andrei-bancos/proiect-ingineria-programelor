package com.example.proiectingineriaprogramelor.repositories;

import com.example.proiectingineriaprogramelor.DatabaseConnection;
import com.example.proiectingineriaprogramelor.models.User;
import com.example.proiectingineriaprogramelor.models.Vaccin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                vaccin.setNume(resultSet.getString("Nume"));
                vaccin.setData(resultSet.getDate("Data"));
                listaVaccinuri.add(vaccin);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaVaccinuri;
    }


}
