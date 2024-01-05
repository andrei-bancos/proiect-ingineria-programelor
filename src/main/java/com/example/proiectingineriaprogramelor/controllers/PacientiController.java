package com.example.proiectingineriaprogramelor.controllers;

import com.example.proiectingineriaprogramelor.MainApplication;
import com.example.proiectingineriaprogramelor.models.Pacient;
import com.example.proiectingineriaprogramelor.repositories.PacientRepository;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class PacientiController implements Initializable {
    @FXML
    private TableView<Pacient> tableView;

    @FXML
    private TableColumn<Pacient, String> cnpCol;

    @FXML
    private TableColumn<Pacient, String> numeCol;

    @FXML
    private TableColumn<Pacient, String> prenumeCol;

    @FXML
    private TableColumn<Pacient, String> sexCol;

    @FXML
    private TableColumn<Pacient, String> dataNasteriCol;

    @FXML
    private TableColumn<Pacient, Boolean> asiguratCol;

    @FXML
    private TableColumn<Pacient, String> nrCardCol;

    @FXML
    private TableColumn<Pacient, String> grupaSanguinaCol;

    @FXML
    private TableColumn<Pacient, String> adresaCol;

    @FXML
    private TableColumn<Pacient, String> nrTelCol;

    @FXML
    private TableColumn<Pacient, String> emailCol;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        PacientRepository repositoryPacient = new PacientRepository();
        List<Pacient> pacientList = repositoryPacient.getPacienti();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        cnpCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCnp()));
        numeCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNume()));
        prenumeCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getPrenume()));
        sexCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getSex()));
        dataNasteriCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(
                cellData.getValue().getDataNasteri().format(formatter)
        ));
        asiguratCol.setCellValueFactory(cellData -> new ReadOnlyBooleanWrapper(cellData.getValue().isAsigurare()));
        nrCardCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNr_card()));
        grupaSanguinaCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getGrupaSanguina()));
        adresaCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getAdresa()));
        nrTelCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNr_tel()));
        emailCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getEmail()));

        tableView.getItems().addAll(pacientList);
    }

    @FXML
    private void reloadTable() {
        PacientRepository repositoryPacient = new PacientRepository();
        List<Pacient> pacientList = repositoryPacient.getPacienti();

        tableView.getItems().clear();

        tableView.getItems().addAll(pacientList);
    }

    @FXML
    protected void onAddButtonClick() throws IOException {
        Dialog<Void> addDialog = new Dialog<>();
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("addPacient-view.fxml"));
        addDialog.setTitle("Adaugare pacient");
        addDialog.getDialogPane().setContent(fxmlLoader.load());
        addDialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
        addDialog.showAndWait();
        reloadTable();
    }

    @FXML
    protected void onEditButtonClick() throws IOException {
        TableView.TableViewSelectionModel<Pacient> selectionModel = tableView.getSelectionModel();
        Pacient selectedRow = selectionModel.getSelectedItem();
        PacientRepository pacientRepository = new PacientRepository();

        if (selectedRow != null) {
            Dialog<Void> addDialog = new Dialog<>();
            FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("editPacient-view.fxml"));
            addDialog.setTitle("Modificare pacient");
            addDialog.getDialogPane().setContent(fxmlLoader.load());
            addDialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);
            editPacientController controller = fxmlLoader.getController();
            controller.selectedPacient = selectedRow;
            controller.nameField.setText(selectedRow.getNume());
            controller.prenumeField.setText(selectedRow.getPrenume());
            controller.cnpField.setText(selectedRow.getCnp());
            controller.adresaField.setText(selectedRow.getAdresa());
            controller.emailField.setText(selectedRow.getEmail());
            controller.nrCardField.setText(selectedRow.getNr_card());
            controller.nrTelField.setText(selectedRow.getNr_tel());
            controller.grupaSanguinaField.setText(selectedRow.getGrupaSanguina());
            controller.sexField.setText(selectedRow.getSex());
            addDialog.showAndWait();
            reloadTable();
        }

    }

    @FXML
    protected void onDeleteButtonClick() {
        TableView.TableViewSelectionModel<Pacient> selectionModel = tableView.getSelectionModel();
        Pacient selectedRow = selectionModel.getSelectedItem();
        PacientRepository pacientRepository = new PacientRepository();

        if (selectedRow != null) {
            pacientRepository.deletePacient(selectedRow.getEmail());
            tableView.getItems().remove(selectedRow);
        }
    }
}