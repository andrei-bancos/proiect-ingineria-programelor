package com.example.proiectingineriaprogramelor.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PacientiController {
    @FXML
    private Button addBtn;
    @FXML
    private Button editBtn;
    @FXML
    private Button deleteBtn;

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