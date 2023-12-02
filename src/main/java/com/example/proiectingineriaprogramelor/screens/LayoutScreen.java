package com.example.proiectingineriaprogramelor.screens;

import com.example.proiectingineriaprogramelor.MainApplication;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LayoutScreen {

    private final Stage currentStage;

    public LayoutScreen(Stage currentStage) {
        this.currentStage = currentStage;
    }

    public void show() throws IOException {
        FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("layout-view.fxml"));
        Scene layoutScene = new Scene(loader.load(), 800, 500);

        currentStage.setTitle("Medical application");
        currentStage.setScene(layoutScene);

    }
}
