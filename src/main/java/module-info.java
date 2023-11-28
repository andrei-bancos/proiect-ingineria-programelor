module com.example.proiectingineriaprogramelor {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.proiectingineriaprogramelor to javafx.fxml;
    exports com.example.proiectingineriaprogramelor;
    exports com.example.proiectingineriaprogramelor.controllers;
    opens com.example.proiectingineriaprogramelor.controllers to javafx.fxml;
}