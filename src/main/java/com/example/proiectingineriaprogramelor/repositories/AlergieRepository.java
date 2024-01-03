package com.example.proiectingineriaprogramelor.repositories;

import com.example.proiectingineriaprogramelor.DatabaseConnection;
import com.example.proiectingineriaprogramelor.models.Alergie;

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


}
