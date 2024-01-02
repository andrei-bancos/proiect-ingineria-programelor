package com.example.proiectingineriaprogramelor.models;

import java.util.Date;

public class Consultatie {
    private int id;
    private int idPacient;
    private Date data;
    private String diagnostic;
    private String observatii;

    public int getId() {
        return id;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public String getObservatii() {
        return observatii;
    }

    public void setObservatii(String observatii) {
        this.observatii = observatii;
    }
}
