package com.example.proiectingineriaprogramelor.controllers;

import com.example.proiectingineriaprogramelor.AppState;
import com.example.proiectingineriaprogramelor.MainApplication;
import com.example.proiectingineriaprogramelor.models.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private Parent currentContent;
    private Label selectedNavLabel;
    @FXML
    private Label programariLabel;
    @FXML
    private VBox containerVBox;
    User currentUser = AppState.getInstance().getCurrentUser();
    @FXML
    private VBox heroVBox;
    @FXML
    private Label welcomeMsg;
    private void changeSelectedNavLabel(Label label) {
        selectedNavLabel.setTextFill(Color.web("#111111"));
        selectedNavLabel = label;
        selectedNavLabel.setTextFill(Color.web("#FB4545"));
    }

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
    @FXML
    private Button veziProgramariButton;



    @FXML
    public void onVeziProgramariButtonClick() {
        try {
            // Încarcă pagina de vizualizare a programărilor
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("VizualizeazaProgramariView.fxml"));
            Parent vizualizeazaProgramariView = loader.load();

            // Setează controllerul pentru VizualizeazaProgramariView, dacă este necesar
            // VizualizeazaProgramariController controller = loader.getController();
            // controller.setSomeData(data); // Dacă aveți nevoie să trimiteți date către controller

            // Obține scena curentă și setează noul conținut
            Scene currentScene = veziProgramariButton.getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.setScene(new Scene(vizualizeazaProgramariView));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    private LayoutController layoutController;




}
