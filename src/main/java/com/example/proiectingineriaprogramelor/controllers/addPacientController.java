package com.example.proiectingineriaprogramelor.controllers;

import com.example.proiectingineriaprogramelor.models.Pacient;
import com.example.proiectingineriaprogramelor.repositories.PacientRepository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class addPacientController implements Initializable {
    @FXML
    public TextField cnpField;
    @FXML
    public TextField nameField;
    @FXML
    public TextField prenumeField;
    @FXML
    public TextField sexField;
    @FXML
    public DatePicker dataNasteriPicker;
    @FXML
    public CheckBox asiguratCheckBox;
    @FXML
    public TextField nrCardField;
    @FXML
    public TextField emailField;
    @FXML
    public TextField grupaSanguinaField;
    @FXML
    public TextField adresaField;
    @FXML
    public TextField nrTelField;

    public void initialize(URL url, ResourceBundle resourceBundle) {


    }

    @FXML
    private void onAddButtonClick() {
        PacientRepository pacientRepository = new PacientRepository();

        if(cnpField.getText().isEmpty() ||
                nameField.getText().isEmpty() ||
                prenumeField.getText().isEmpty() ||
                sexField.getText().isEmpty() ||
                nrCardField.getText().isEmpty() ||
                adresaField.getText().isEmpty() ||
                nrTelField.getText().isEmpty() ||
                emailField.getText().isEmpty() ||
                dataNasteriPicker.getValue() == null
        ){
            return;
        }

        Pacient pacient = new Pacient();
        pacient.setCnp(cnpField.getText());
        pacient.setNume(nameField.getText());
        pacient.setPrenume(prenumeField.getText());
        pacient.setSex(sexField.getText());
        pacient.setDataNasteri(dataNasteriPicker.getValue().atStartOfDay());
        pacient.setAsigurare(asiguratCheckBox.isSelected());
        pacient.setNr_card(nrCardField.getText());
        pacient.setGrupaSanguina(grupaSanguinaField.getText());
        pacient.setAdresa(adresaField.getText());
        pacient.setNr_tel(nrTelField.getText());
        pacient.setEmail(emailField.getText());

        pacientRepository.addPacient(pacient);

        closeDialog();
    }

    private void closeDialog() {
        Stage stage = (Stage) cnpField.getScene().getWindow();
        stage.close();
    }
}