package com.example.proiectingineriaprogramelor.repositories;

import com.example.proiectingineriaprogramelor.DatabaseConnection;
import com.example.proiectingineriaprogramelor.models.Antecedente;
import com.example.proiectingineriaprogramelor.models.Consultatie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConsultatieRepository {private final DatabaseConnection db = DatabaseConnection.getInstance();
    private final Connection connection = db.getConnection();
    public List<Consultatie> getConsultatieByPacient(int pacientId) {
        List<Consultatie> listaConsultatie = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Consultatii WHERE Id_pacient = ?";
            //
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pacientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Consultatie consultatie = new Consultatie();
                consultatie.setData(resultSet.getTimestamp("Data"));
                consultatie.setDiagnostic(resultSet.getString("Diagnostic"));
                consultatie.setObservatii(resultSet.getString("Observatii"));
                listaConsultatie.add(consultatie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaConsultatie;
    }

    public void addConsultatie(Consultatie consultatie) {
        try {
            String sql = "INSERT INTO Antecedente (Id_pacient, Data, Diagnostic, Observatii) VALUE (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, consultatie.getIdPacient());
            preparedStatement.setObject(2, consultatie.getData());
            preparedStatement.setString(3, consultatie.getDiagnostic());
            preparedStatement.setString(4, consultatie.getObservatii());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
