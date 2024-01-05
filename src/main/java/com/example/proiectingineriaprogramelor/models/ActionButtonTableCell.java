package com.example.proiectingineriaprogramelor.models;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.layout.HBox;

public class ActionButtonTableCell extends TableCell<Programare, String> {

    private final Button editButton = new Button("Editează");
    private final Button deleteButton = new Button("Șterge");

    public ActionButtonTableCell() {
        editButton.setOnAction(event -> {
            // Logica pentru editare
            Programare selectedProgramare = getTableView().getItems().get(getIndex());
            System.out.println("Editează programarea cu ID: " + selectedProgramare.getId());
        });

        deleteButton.setOnAction(event -> {
            // Logica pentru ștergere
            Programare selectedProgramare = getTableView().getItems().get(getIndex());
            System.out.println("Șterge programarea cu ID: " + selectedProgramare.getId());
        });
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);

        if (empty) {
            setGraphic(null);
        } else {
            // Adaugă butoanele în celulă
            setGraphic(new HBox(5, editButton, deleteButton));
        }
    }
}
