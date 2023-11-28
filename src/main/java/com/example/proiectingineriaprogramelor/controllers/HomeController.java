package com.example.proiectingineriaprogramelor.controllers;

import com.example.proiectingineriaprogramelor.screens.LoginScreen;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML
    private VBox heroVBox;

    @FXML
    private Hyperlink logoutLink;

    @FXML
    public void initialize(URL location, ResourceBundle resourceBundle) {
        Image imageHeroVBox = new Image(Objects.requireNonNull(HomeController.class
                                        .getResourceAsStream("/images/hero.png")));

        BackgroundImage bgImageHeroVBox = new BackgroundImage(
          imageHeroVBox,
          BackgroundRepeat.NO_REPEAT,
          BackgroundRepeat.NO_REPEAT,
          BackgroundPosition.DEFAULT,
          new BackgroundSize(1.0, 1.0, true, true, true, true)
        );

        heroVBox.setBackground(new Background(bgImageHeroVBox));
    }

    @FXML
    public void logout() throws IOException {
        Scene scene = logoutLink.getScene();
        Stage currentStage = (Stage) scene.getWindow();

        LoginScreen loginScreen = new LoginScreen(currentStage);
        loginScreen.show();
    }
}
