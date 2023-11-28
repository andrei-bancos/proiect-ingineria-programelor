package com.example.proiectingineriaprogramelor;

import com.example.proiectingineriaprogramelor.screens.LoginScreen;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class MainApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // set application icon
        Image applicationIcon = new Image(Objects.requireNonNull(MainApplication.class
                                          .getResourceAsStream("/images/logo.png")));
        stage.getIcons().add(applicationIcon);

        LoginScreen loginScreen = new LoginScreen(stage);
        loginScreen.show();
    }

    public static void main(String[] args) {
        launch();
    }
}