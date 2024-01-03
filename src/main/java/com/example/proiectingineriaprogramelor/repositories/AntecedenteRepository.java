package com.example.proiectingineriaprogramelor.repositories;

import com.example.proiectingineriaprogramelor.DatabaseConnection;
import com.example.proiectingineriaprogramelor.models.Antecedente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AntecedenteRepository {
    private final DatabaseConnection db = DatabaseConnection.getInstance();
    private final Connection connection = db.getConnection();
    public List<Antecedente> getAlergiByPacient(int pacientId) {
        List<Antecedente> listaAntecedente = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Antecedente WHERE Id_pacient = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pacientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Antecedente antecedente = new Antecedente();
                antecedente.setNume(resultSet.getString("Nume"));
                antecedente.setDescriere(resultSet.getString("Descriere"));
                antecedente.setTip(resultSet.getString("Tip"));
                antecedente.setData(resultSet.getDate("Data"));
                antecedente.setObservatii(resultSet.getString("Observatii"));
                listaAntecedente.add(antecedente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAntecedente;
    }
}
