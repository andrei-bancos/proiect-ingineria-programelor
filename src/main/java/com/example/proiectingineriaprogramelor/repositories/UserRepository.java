package com.example.proiectingineriaprogramelor.repositories;

import com.example.proiectingineriaprogramelor.DatabaseConnection;
import com.example.proiectingineriaprogramelor.PasswordManager;
import com.example.proiectingineriaprogramelor.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserRepository {
    private final DatabaseConnection db = DatabaseConnection.getInstance();
    private final Connection connection = db.getConnection();

    public User getUser(String email) {
        try {
            String sql = " SELECT * FROM users WHERE Email = ? ";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                User user = new User();
                user.setNume(resultSet.getString("nume"));
                user.setPrenume(resultSet.getString("prenume"));
                user.setCnp(resultSet.getString("cnp"));
                user.setEmail(resultSet.getString("email"));
                user.setParola(resultSet.getString("parola"));
                user.setNrTel(resultSet.getString("nr_tel"));
                user.setRol(resultSet.getString("rol"));
                user.setAdresa(resultSet.getString("adresa"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public User checkLoginData(String email, String password) {
        User user = getUser(email);
        String hashPassword = PasswordManager.encryptSHA256(password);
        if(user != null && Objects.equals(user.getParola(), hashPassword)) {
            return user;
        }
        return null;
    }

    public List<User> getAllUsers() {
        try {
            List<User> userList = new ArrayList<>();
            String sql = "SELECT * FROM users";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user = new User();
                user.setNume(resultSet.getString("nume"));
                user.setPrenume(resultSet.getString("prenume"));
                user.setCnp(resultSet.getString("cnp"));
                user.setEmail(resultSet.getString("email"));
                user.setNrTel(resultSet.getString("nr_tel"));
                user.setRol(resultSet.getString("rol"));
                user.setAdresa(resultSet.getString("adresa"));
                userList.add(user);
                return userList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addUser(User user) {
        try {
            String passwordHash = PasswordManager.encryptSHA256(user.getParola());
            String sql = "INSERT INTO users (Nume, Prenume, CNP, Email, Parola, Nr_tel, Rol, Adresa)" +
                            "VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getNume());
            preparedStatement.setString(2, user.getPrenume());
            preparedStatement.setString(3, user.getCnp());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, passwordHash);
            preparedStatement.setString(6, user.getNrTel());
            preparedStatement.setString(7, user.getRol());
            preparedStatement.setString(8, user.getAdresa());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateEmail(String oldEmail, String newEmail) {
        try {
            String sql = "UPDATE users SET Email = ? WHERE Email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, newEmail);
            preparedStatement.setString(2, oldEmail);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePassword(String email, String newPassword) {
        try {
            String hashPassword = PasswordManager.encryptSHA256(newPassword);
            String sql = "UPDATE users SET Parola = ? WHERE Email = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, hashPassword);
            preparedStatement.setString(2, email);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int userId) {
        try {
            String sql = "DELETE FROM users WHERE Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
