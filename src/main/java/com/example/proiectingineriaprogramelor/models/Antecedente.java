package com.example.proiectingineriaprogramelor.models;

import java.util.Date;

public class Antecedente {
    private int id;
    private int idPacient;
    private String nume;
    private String descriere;
    private String tip;
    private Date data;
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

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getDescriere() {
        return descriere;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservatii() {
        return observatii;
    }

    public void setObservatii(String observatii) {
        this.observatii = observatii;
    }
}
