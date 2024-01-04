package com.example.proiectingineriaprogramelor.controllers;

import com.example.proiectingineriaprogramelor.models.Pacient;
import com.example.proiectingineriaprogramelor.repositories.PacientRepository;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

public class PacientiController implements Initializable {
    @FXML
    private Button addBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button deleteBtn;

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
    protected void onAddButtonClick() {
        System.out.println("Ai dat click pe add");
    }

    @FXML
    protected void onEditButtonClick() {
        System.out.println("Ai dat click pe edit");
    }

    @FXML
    protected void onDeleteButtonClick() {
        System.out.println("Ai dat click pe delete");
    }
}