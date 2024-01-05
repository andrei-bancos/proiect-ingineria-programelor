package com.example.proiectingineriaprogramelor.models;

import java.time.LocalDateTime;

public class Programare {
    private int id;
    private int idPacient;
    private LocalDateTime dataProgramarii;
    private String observatii;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public LocalDateTime getDataProgramarii() {
        return dataProgramarii;
    }

    public void setDataProgramarii(LocalDateTime dataProgramarii) {
        this.dataProgramarii = dataProgramarii;
    }

    public String getObservatii() {
        return observatii;
    }

    public void setObservatii(String observatii) {
        this.observatii = observatii;
    }
}

