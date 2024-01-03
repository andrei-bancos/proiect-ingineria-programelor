package com.example.proiectingineriaprogramelor.repositories;

import com.example.proiectingineriaprogramelor.DatabaseConnection;
import com.example.proiectingineriaprogramelor.models.Alergie;
import com.example.proiectingineriaprogramelor.models.Antecedente;

import java.sql.*;
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
                Timestamp data= resultSet.getTimestamp("Data");
                antecedente.setNume(resultSet.getString("Nume"));
                antecedente.setDescriere(resultSet.getString("Descriere"));
                antecedente.setTip(resultSet.getString("Tip"));
                antecedente.setData(data.toLocalDateTime());
                antecedente.setObservatii(resultSet.getString("Observatii"));
                listaAntecedente.add(antecedente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAntecedente;
    }

    public void addAntecedent(Antecedente antecedente) {
        try {
            String sql = "INSERT INTO Antecedente (Id_pacient, Nume, Descriere, Tip, Data, Observatii) VALUE (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, antecedente.getIdPacient());
            preparedStatement.setString(2, antecedente.getNume());
            preparedStatement.setString(3, antecedente.getDescriere());
            preparedStatement.setString(4, antecedente.getTip());
            preparedStatement.setObject(5, antecedente.getData());
            preparedStatement.setString(6, antecedente.getObservatii());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
