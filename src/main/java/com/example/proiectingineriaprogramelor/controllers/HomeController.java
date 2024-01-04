package com.example.proiectingineriaprogramelor.controllers;

import com.example.proiectingineriaprogramelor.AppState;
import com.example.proiectingineriaprogramelor.models.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    User currentUser = AppState.getInstance().getCurrentUser();
    @FXML
    private VBox heroVBox;
    @FXML
    private Label welcomeMsg;
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

        if(Objects.equals(currentUser.getRol(), "doctor")) {
            welcomeMsg.setText("Bine ai revenit, Dr. " + currentUser.getNume() + " " + currentUser.getPrenume() + "!");
        } else if(Objects.equals(currentUser.getRol(), "asistent")) {
            welcomeMsg.setText("Bine ai revenit, Asist. " + currentUser.getNume() + " " + currentUser.getPrenume() + "!");
        }
    }
}
