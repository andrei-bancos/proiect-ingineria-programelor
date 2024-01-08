package com.example.proiectingineriaprogramelor.controllers;
import com.example.proiectingineriaprogramelor.AppState;
import com.example.proiectingineriaprogramelor.MainApplication;
import com.example.proiectingineriaprogramelor.models.User;
import com.example.proiectingineriaprogramelor.screens.LoginScreen;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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
    @FXML
    private Label currentUserLabel;
    private Label selectedNavLabel;
    private Parent currentContent;
    private Parent homeContent;
    private Parent settingsContent;
    private Parent pacientContent;
    private Parent programariContent;
    private final FXMLLoader homeLoader = new FXMLLoader(MainApplication.class.getResource("home-view.fxml"));
    private final FXMLLoader settingsLoader = new FXMLLoader(MainApplication.class.getResource("settings-view.fxml"));
    private final FXMLLoader pacientLoader = new FXMLLoader(MainApplication.class.getResource("pacienti-view.fxml"));
    private final FXMLLoader programariLoader = new FXMLLoader(MainApplication.class.getResource("VizualizeazaProgramariView.fxml"));
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // load all screen content
            homeContent = homeLoader.load();
            settingsContent = settingsLoader.load();
            pacientContent = pacientLoader.load();
            programariContent = programariLoader.load();
            // set default content view
            currentContent = homeContent;
            selectedNavLabel = acasaLabel;
            // set vertical grow for contents
            containerVBox.setVgrow(homeContent, Priority.ALWAYS);
            containerVBox.setVgrow(settingsContent, Priority.ALWAYS);
            containerVBox.setVgrow(pacientContent, Priority.ALWAYS);
            User currentUser = AppState.getInstance().getCurrentUser();
            if(Objects.equals(currentUser.getRol(), "doctor")) {
                currentUserLabel.setText("Dr. " + currentUser.getNume() + " " + currentUser.getPrenume());
            } else {
                currentUserLabel.setText("Assist. " + currentUser.getNume() + " " + currentUser.getPrenume());
            }
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
        changeCurrentContent(pacientContent);
        changeSelectedNavLabel(pacientLabel);
    }
    @FXML
    public void onProgramariLabelClick() {
        changeCurrentContent(programariContent);
        changeSelectedNavLabel(programariLabel);
    }
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
}