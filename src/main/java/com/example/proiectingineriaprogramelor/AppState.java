package com.example.proiectingineriaprogramelor;

import com.example.proiectingineriaprogramelor.models.User;

public class AppState {
    private static AppState instance;
    private User currentUser;

    private AppState() {}

    public static synchronized AppState getInstance() {
        if(instance == null) {
            instance = new AppState();
        }
        return instance;
    }

    /**
     *
     * @return Returneaza utilizatorul conectat in aplicatie
     */
    public User getCurrentUser() {
        return currentUser;
    }

    /**
     * Seteaza utilizatorul curent care s-a conectat in aplicatie
     * @param user
     */
    public void setCurrentUser(User user) {
        this.currentUser = user;
        this.currentUser.setParola("");
    }
}
