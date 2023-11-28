package com.example.proiectingineriaprogramelor.controllers;

import com.example.proiectingineriaprogramelor.screens.HomeScreen;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class LoginController {
    @FXML
    private Label error;

    @FXML
    private Button login;

    @FXML
    private TextField emailAddressField;

    @FXML
    private PasswordField passwordField;

    @FXML
    protected void onLoginButtonClick() throws IOException {
        error.setVisible(true);
        error.setManaged(true);

        if(Objects.equals(emailAddressField.getText().trim(), "")
           || Objects.equals(passwordField.getText().trim(), "")) {
            error.setText("Introdu datele cerute");
            return;
        }

        // get current stage
        Scene scene = login.getScene();
        Stage currentStage = (Stage) scene.getWindow();

        // show home screen
        HomeScreen homeScreen = new HomeScreen(currentStage);
        homeScreen.show();
    }
}