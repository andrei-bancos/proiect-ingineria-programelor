package com.example.proiectingineriaprogramelor.screens;

import com.example.proiectingineriaprogramelor.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginScreen {
    private final Stage currentStage;

    public LoginScreen(Stage currentStage) {
        this.currentStage = currentStage;
    }

    /**
     * Incarca si afiseaza fereastra - login
     * @throws IOException
     */
    public void show() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        currentStage.setMinWidth(800);
        currentStage.setMinHeight(500);
        currentStage.setTitle("Login");
        currentStage.setScene(scene);
        currentStage.show();
    }
}
