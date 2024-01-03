package com.example.proiectingineriaprogramelor.controllers;

import com.example.proiectingineriaprogramelor.PasswordManager;
import com.example.proiectingineriaprogramelor.repositories.UserRepository;
import com.example.proiectingineriaprogramelor.screens.LayoutScreen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    private Label error;

    @FXML
    private Button login;

    @FXML
    private TextField emailAddressField;

    @FXML
    private PasswordField passwordField;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        emailAddressField.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                try {
                    onLoginButtonClick();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });

        passwordField.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                try {
                    onLoginButtonClick();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        });
    }

    @FXML
    protected void onLoginButtonClick() throws IOException {
        error.setVisible(true);
        error.setManaged(true);
        String Email = emailAddressField.getText();
        String Parola = passwordField.getText();

        if(Objects.equals(emailAddressField.getText().trim(), "")
           || Objects.equals(passwordField.getText().trim(), "")) {
            error.setText("Introduceti datele cerute");
            return;
        }
        else
        {
            UserRepository userRepository = new UserRepository();
            int user_id = userRepository.checkUser(Email);
            if(user_id >= 0){
                PasswordManager passwordManager = new PasswordManager();
                String HashParola = passwordManager.encryptSHA256(Parola);
                if(userRepository.checkPassword(HashParola,user_id)){
                    // get current stage
                    Scene scene = login.getScene();
                    Stage currentStage = (Stage) scene.getWindow();

                    // show home screen
                    LayoutScreen layoutScreen = new LayoutScreen(currentStage);
                    layoutScreen.show();
                }
            }
        }
    }
}