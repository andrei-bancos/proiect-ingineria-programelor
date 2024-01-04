package com.example.proiectingineriaprogramelor.controllers;

import com.example.proiectingineriaprogramelor.AppState;
import com.example.proiectingineriaprogramelor.models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

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

    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameLabel.setText(currentUser.getNume() + " " + currentUser.getPrenume());
        emailLabel.setText(currentUser.getEmail());
        roleLabel.setText(currentUser.getRol());
    }
}
