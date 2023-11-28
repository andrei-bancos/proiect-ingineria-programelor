package com.example.proiectingineriaprogramelor.screens;

import com.example.proiectingineriaprogramelor.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeScreen {

    private final Stage currentStage;

    public HomeScreen(Stage currentStage) {
        this.currentStage = currentStage;
    }

    public void show() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("home-view.fxml"));
        Scene homeScene = new Scene(loader.load(), 800, 500);
        currentStage.setTitle("Acasă");
        currentStage.setScene(homeScene);
    }
}
