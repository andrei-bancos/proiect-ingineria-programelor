package com.example.proiectingineriaprogramelor.controllers;

import com.example.proiectingineriaprogramelor.AppState;
import com.example.proiectingineriaprogramelor.models.User;
import com.example.proiectingineriaprogramelor.repositories.UserRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SetariController implements Initializable {
    private final User currentUser = AppState.getInstance().getCurrentUser();
    @FXML
    private Label nameLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label roleLabel;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldPass;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(currentUser.getNume() + " " + currentUser.getPrenume());
        emailLabel.setText(currentUser.getEmail());
        roleLabel.setText(currentUser.getRol());
    }

    /**
     * Modifica emailul sau parola utilizatorului care este conectat
     */
    @FXML
    private void onSaveButtonClick(){
        UserRepository userRepository = new UserRepository();
        if(!textFieldEmail.getText().isEmpty()) {
            String newEmail = textFieldEmail.getText();
            String oldEmail = emailLabel.getText();
            userRepository.updateEmail(oldEmail, newEmail);
            emailLabel.setText(newEmail);
            textFieldEmail.setText("");
        }
        if(!textFieldPass.getText().isEmpty()) {
            userRepository.updatePassword(emailLabel.getText(), textFieldPass.getText());
            textFieldPass.setText("");
        }

    }

}
