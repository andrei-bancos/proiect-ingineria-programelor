package com.example.proiectingineriaprogramelor.controllers;

import com.example.proiectingineriaprogramelor.models.Pacient;
import com.example.proiectingineriaprogramelor.models.Programare;
import com.example.proiectingineriaprogramelor.repositories.PacientRepository;
import com.example.proiectingineriaprogramelor.repositories.ProgramareRepository;
import java.util.Objects;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.ResourceBundle;
import javafx.util.StringConverter;

public class ProgramariController implements Initializable {

    @FXML
    private VBox addVBox;
    @FXML
    private Button addBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button deleteBtn;
    @FXML
    private Button saveBtn;
    @FXML
    private TableView<Programare> tableView;

    @FXML
    private TableColumn<Programare, String> idCol;

    @FXML
    private TableColumn<Programare, String> namePacientCol;

    @FXML
    private TableColumn<Programare, String> dataProgramariiCol;
    @FXML
    private TableColumn<Programare, String> observatiiCol;

    @FXML
    private int idPacient;  // Adaugă aceste linii
    @FXML
    private TextField dataProgramariiField;  // Adaugă aceste linii
    @FXML
    private TextField observatiiField;  // Adaugă aceste linii

    @FXML
    private TextField editIdField;  // Adaugă aceste linii
    @FXML
    private TextField editIdPacientField;  // Adaugă aceste linii
    @FXML
    private TextField editDataProgramariiField;  // Adaugă aceste linii
    @FXML
    private TextField editObservatiiField;  // Adaugă aceste linii
    private final ProgramareRepository programareRepository = new ProgramareRepository();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    @FXML
    private Button updateBtn;
    @FXML
    private VBox editVBox;

    @FXML
    private ComboBox<Pacient> nameComboBox;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        idCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(Integer.toString(cellData.getValue().getId())));
        namePacientCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getPacientName()));

        dataProgramariiCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getDataProgramarii().format(formatter)));
        observatiiCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().getObservatii()));

        loadProgramariData();
    }

    private void loadProgramariData() {
        List<Programare> programariList = programareRepository.getProgramari();

        for (Programare programare : programariList) {
            System.out.println("ID Programare: " + programare.getId());
        }

        tableView.getItems().setAll(programariList);
    }

    @FXML
    protected void onAddButtonClick() {
        PacientRepository pacientRepository = new PacientRepository();
        ObservableList<Pacient> pacienti = FXCollections.observableArrayList(
                pacientRepository.getPacienti()
        );

        // Set data to the ComboBox
        nameComboBox.setItems(pacienti);

        nameComboBox.setConverter(new StringConverter<>() {
            @Override
            public String toString(Pacient pacient) {
                return pacient.getNume() + " " + pacient.getPrenume();
            }

            @Override
            public Pacient fromString(String string) {
                // You can implement this if needed
                return null;
            }
        });

        System.out.println("Ai dat click pe add");
        addVBox.setVisible(!addVBox.isVisible());
    }

    @FXML
    private void onSaveButtonClick() {
        try {
            // Obține valorile din câmpurile text
//            String idPacientText = idPacientField.getText();
            String dataProgramariiStr = dataProgramariiField.getText();
            String observatii = observatiiField.getText();
            int idPacientCurent = idPacient;


            // Verifică dacă toate câmpurile sunt completate
            if (Objects.isNull(idPacientCurent) || dataProgramariiStr.isEmpty() || observatii.isEmpty()) {
                System.err.println("Toate câmpurile trebuie completate.");
                // Poți afișa un mesaj de eroare utilizatorului aici, dacă este necesar
                return;
            }

            // Obține valorile convertite
            LocalDateTime dataProgramarii = LocalDateTime.parse(dataProgramariiStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            // Crează o nouă instanță de Programare cu valorile obținute
            Programare newProgramare = new Programare();
            newProgramare.setIdPacient(idPacientCurent);
            newProgramare.setDataProgramarii(dataProgramarii);
            newProgramare.setObservatii(observatii);

            // Adaugă programarea în baza de date
            programareRepository.addProgramare(newProgramare);

            // Ascunde VBox-ul după salvare
            addVBox.setVisible(false);

            // Actualizează TableView-ul după adăugarea noii programări
            loadProgramariData();
        } catch (NumberFormatException e) {
            System.err.println("ID Pacient nu este un număr valid.");
            // Poți adăuga un mesaj de eroare pentru utilizator aici, dacă este necesar
        } catch (DateTimeParseException e) {
            System.err.println("Format de data invalid. Utilizați formatul yyyy-MM-dd HH:mm:ss.");
            // Poți adăuga un mesaj de eroare pentru utilizator aici, dacă este necesar
        }
    }


    //    @FXML
//    protected void onEditButtonClick() {
//        // Obține programarea selectată din tabel
//        Programare selectedProgramare = tableView.getSelectionModel().getSelectedItem();
//
//        if (selectedProgramare != null) {
//            // Setează valorile în câmpurile Vbox-ului pentru editare
//            editIdField.setText(String.valueOf(selectedProgramare.getId()));
//            editIdPacientField.setText(String.valueOf(selectedProgramare.getIdPacient()));
//            editDataProgramariiField.setText(selectedProgramare.getDataProgramarii().format(formatter));
//            editObservatiiField.setText(selectedProgramare.getObservatii());
//
//            // Setează vizibilitatea Vbox-ului pentru adăugare la false
//            addVBox.setVisible(false);
//
//            // Setează vizibilitatea Vbox-ului pentru editare la true
//            editVBox.setVisible(true);
//        } else {
//            System.out.println("Nu a fost selectată nicio programare.");
//        }
//    }
    @FXML
    protected void onEditButtonClick() {
        // Setează vizibilitatea Vbox-ului pentru adăugare la false
        addVBox.setVisible(false);

        // Setează vizibilitatea Vbox-ului pentru editare la true
        editVBox.setVisible(true);
    }

    @FXML
    protected void onUpdateButtonClick() {
        try {
            // Obține ID-ul introdus manual
            int editId = Integer.parseInt(editIdField.getText());

            // Obține programarea selectată din tabel
            Programare selectedProgramare = tableView.getItems().stream()
                    .filter(programare -> programare.getId() == editId)
                    .findFirst()
                    .orElse(null);

            if (selectedProgramare != null) {
                // Actualizează programarea cu valorile introduse manual
                selectedProgramare.setIdPacient(Integer.parseInt(editIdPacientField.getText()));
                // Actualizează și celelalte atribute

                // Ascunde VBox-urile pentru adăugare și editare
                addVBox.setVisible(false);
                editVBox.setVisible(false);

                // Actualizează TableView-ul
                loadProgramariData();
            } else {
                System.out.println("Nu a fost găsită nicio programare cu ID-ul introdus.");
            }
        } catch (NumberFormatException e) {
            System.err.println("ID nu este un număr valid.");
        }
    }



    @FXML
    protected void onDeleteButtonClick() {
        TableView.TableViewSelectionModel<Programare> selectionModel = tableView.getSelectionModel();
        Programare selectedRow = selectionModel.getSelectedItem();

        if (selectedRow != null) {
            ProgramareRepository programareRepository = new ProgramareRepository();

            // Utilizăm ID-ul (sau un alt identificator unic) pentru a identifica în mod unic programarea
            int programareId = selectedRow.getId();

            // Apelăm metoda de ștergere din baza de date
            programareRepository.deleteProgramare(programareId);

            // Ștergem rândul din tabel
            tableView.getItems().remove(selectedRow);
        }
    }


    public void handleComboBoxAction(ActionEvent actionEvent) {
        Pacient pacient = nameComboBox.getSelectionModel().getSelectedItem();
        if (pacient != null) {
            idPacient = pacient.getId();
        }
    }
}