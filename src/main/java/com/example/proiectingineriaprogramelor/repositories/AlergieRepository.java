package com.example.proiectingineriaprogramelor.repositories;

import com.example.proiectingineriaprogramelor.DatabaseConnection;
import com.example.proiectingineriaprogramelor.PasswordManager;
import com.example.proiectingineriaprogramelor.models.Alergie;
import com.example.proiectingineriaprogramelor.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlergieRepository {
    private final DatabaseConnection db = DatabaseConnection.getInstance();
    private final Connection connection = db.getConnection();
    public List<Alergie> getAlergiByPacient(int pacientId) {
        List<Alergie> listaAlergi = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Alergie WHERE Id_pacient = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pacientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Alergie alergie = new Alergie();
                alergie.setAlergie(resultSet.getString("Alergie"));
                listaAlergi.add(alergie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAlergi;
    }
    public void addAlergie(Alergie alergie) {
        try {
            String sql = "INSERT INTO Alergie (Id_pacient, Alergie) VALUE (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, alergie.getIdPacient());
            preparedStatement.setString(2, alergie.getAlergie());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
