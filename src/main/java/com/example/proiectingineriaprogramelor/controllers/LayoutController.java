package com.example.proiectingineriaprogramelor.controllers;

import com.example.proiectingineriaprogramelor.MainApplication;
import com.example.proiectingineriaprogramelor.screens.LoginScreen;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LayoutController implements Initializable {
    @FXML
    private VBox containerVBox;
    @FXML
    private Hyperlink logoutLink;
    @FXML
    private Label acasaLabel;
    @FXML
    private Label pacientLabel;
    @FXML
    private Label programariLabel;
    @FXML
    private Label setariLabel;

    private Label selectedNavLabel;
    private Parent currentContent;
    private Parent homeContent;
    private Parent settingsContent;
    private final FXMLLoader homeLoader = new FXMLLoader(MainApplication.class.getResource("home-view.fxml"));
    private final FXMLLoader settingsLoader = new FXMLLoader(MainApplication.class.getResource("settings-view.fxml"));

    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // load all screen content
            homeContent = homeLoader.load();
            settingsContent = settingsLoader.load();

            // set default content view
            currentContent = homeContent;
            selectedNavLabel = acasaLabel;

            // set vertical grow for contents
            containerVBox.setVgrow(homeContent, Priority.ALWAYS);
            containerVBox.setVgrow(settingsContent, Priority.ALWAYS);

            containerVBox.getChildren().add(currentContent);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void changeSelectedNavLabel(Label label) {
        selectedNavLabel.setTextFill(Color.web("#111111"));
        selectedNavLabel = label;
        selectedNavLabel.setTextFill(Color.web("#FB4545"));
    }

    private void changeCurrentContent(Parent content) {
        containerVBox.getChildren().remove(currentContent);
        currentContent = content;
        containerVBox.getChildren().add(currentContent);
    }

    @FXML
    public void onHomeLabelClick() {
        changeCurrentContent(homeContent);
        changeSelectedNavLabel(acasaLabel);
    }

    @FXML
    public void onPacientLabelClick() {
        containerVBox.getChildren().remove(currentContent);
        changeSelectedNavLabel(pacientLabel);
    }

//    @FXML
//    public void onProgramariLabelClick() {
//        containerVBox.getChildren().remove(currentContent);
//        changeSelectedNavLabel(programariLabel);
//    }

    @FXML
    public void onSetariLabelClick() {
        changeCurrentContent(settingsContent);
        changeSelectedNavLabel(setariLabel);
    }

    @FXML
    public void logout() throws IOException {
        Scene currentScene = logoutLink.getScene();
        Stage currentStage = (Stage) currentScene.getWindow();
        LoginScreen loginScreen = new LoginScreen(currentStage);
        loginScreen.show();
    }

    // Adăugați această metodă în LayoutController pentru a deschide fereastra Adaugă Programare
    @FXML
    public void onAdaugaProgramareLabelClick() {
        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("AdaugaProgramareView.fxml"));
            Parent adaugaProgramareView = loader.load();

            Stage adaugaProgramareStage = new Stage();
            adaugaProgramareStage.initModality(Modality.APPLICATION_MODAL);
            adaugaProgramareStage.setTitle("Adaugă Programare");
            adaugaProgramareStage.setScene(new Scene(adaugaProgramareView));

            adaugaProgramareStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Adăugați această metodă în LayoutController pentru a deschide fereastra Vizualizează Programări
    @FXML
    public void onVizualizeazaProgramariLabelClick() {

        try {
            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("VizualizeazaProgramariView.fxml"));
            Parent vizualizeazaProgramariView = loader.load();

            Stage vizualizeazaProgramariStage = new Stage();
            vizualizeazaProgramariStage.initModality(Modality.APPLICATION_MODAL);
            vizualizeazaProgramariStage.setTitle("Vizualizează Programări");
            vizualizeazaProgramariStage.setScene(new Scene(vizualizeazaProgramariView));

            // Aici puteți adăuga cod pentru a popula TableView cu datele programărilor din baza de date

            vizualizeazaProgramariStage.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void onProgramariLabelClick() {
        try {
            containerVBox.getChildren().remove(currentContent);
            changeSelectedNavLabel(programariLabel);

            FXMLLoader loader = new FXMLLoader(MainApplication.class.getResource("VizualizeazaProgramariView.fxml"));
            Parent vizualizeazaProgramariView = loader.load();

            // Setează controllerul pentru VizualizeazaProgramariView, dacă este necesar
            // VizualizeazaProgramariController controller = loader.getController();
            // controller.setSomeData(data); // Dacă aveți nevoie să trimiteți date către controller

            currentContent = vizualizeazaProgramariView;
            containerVBox.getChildren().add(currentContent);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
