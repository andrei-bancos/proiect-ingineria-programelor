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

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User user) {
        this.currentUser = user;
        this.currentUser.setParola("");
    }
}
