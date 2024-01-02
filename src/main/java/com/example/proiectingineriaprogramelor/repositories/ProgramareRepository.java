package com.example.proiectingineriaprogramelor.repositories;

import com.example.proiectingineriaprogramelor.DatabaseConnection;
import com.example.proiectingineriaprogramelor.models.Programare;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProgramareRepository {
    private final DatabaseConnection db = DatabaseConnection.getInstance();
    private final Connection connection = db.getConnection();

    public List<Programare> getProgramariPacient(int pacientId) {
        try {
            List<Programare> programareList = new ArrayList<>();
            String sql = "SELECT * from programari WHERE Id_pacient = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pacientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Programare programare = new Programare();
                Timestamp dataProgramari = resultSet.getTimestamp("data_programarii");

                programare.setIdPacient(resultSet.getInt("id_pacient"));
                programare.setDataProgramarii(dataProgramari.toLocalDateTime());
                programare.setObservatii(resultSet.getString("observatii"));
                programareList.add(programare);
            }
            return programareList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Programare> getProgramari() {
        try {
            List<Programare> programareList = new ArrayList<>();
            String sql = "SELECT * from programari";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Programare programare = new Programare();
                Timestamp dataProgramari = resultSet.getTimestamp("data_programarii");

                programare.setIdPacient(resultSet.getInt("id_pacient"));
                programare.setDataProgramarii(dataProgramari.toLocalDateTime());
                programare.setObservatii(resultSet.getString("observatii"));
                programareList.add(programare);
            }
            return programareList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addProgramare(Programare programare) {
        try {
            String sql = "INSERT INTO programari (id_pacient, data_programarii, observatii) " +
                         "VALUE (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, programare.getIdPacient());
            preparedStatement.setObject(2, programare.getDataProgramarii());
            preparedStatement.setString(3, programare.getObservatii());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteProgramare(int programareId) {
        try {
            String sql = "DELETE programari from programari where Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, programareId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
