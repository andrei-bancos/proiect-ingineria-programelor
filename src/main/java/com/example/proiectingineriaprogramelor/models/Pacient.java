package com.example.proiectingineriaprogramelor.models;

import java.time.LocalDateTime;
import java.util.Date;

public class Pacient {
    private int id;
    private String nume;
    private String prenume;
    private String cnp;
    private String sex;
    private LocalDateTime dataNasteri;
    private String grupaSanguina;
    private String nr_card;
    private boolean asigurare;
    private String email;
    private String nr_tel;

    public int getId() {
        return id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public LocalDateTime getDataNasteri() {
        return dataNasteri;
    }

    public void setDataNasteri(LocalDateTime dataNasteri) {
        this.dataNasteri = dataNasteri;
    }

    public String getGrupaSanguina() {
        return grupaSanguina;
    }

    public void setGrupaSanguina(String grupaSanguina) {
        this.grupaSanguina = grupaSanguina;
    }

    public String getNr_card() {
        return nr_card;
    }

    public void setNr_card(String nr_card) {
        this.nr_card = nr_card;
    }

    public boolean isAsigurare() {
        return asigurare;
    }

    public void setAsigurare(boolean asigurare) {
        this.asigurare = asigurare;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNr_tel() {
        return nr_tel;
    }

    public void setNr_tel(String nr_tel) {
        this.nr_tel = nr_tel;
    }
}
