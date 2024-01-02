package com.example.proiectingineriaprogramelor.models;

public class Alergie {
    private int id;
    private int idPacient;
    private String alergie;

    public int getId() {
        return id;
    }

    public int getIdPacient() {
        return idPacient;
    }

    public void setIdPacient(int idPacient) {
        this.idPacient = idPacient;
    }

    public String getAlergie() {
        return alergie;
    }

    public void setAlergie(String alergie) {
        this.alergie = alergie;
    }
}
