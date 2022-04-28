package com.hha;

import com.hha.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observerList = new ArrayList<>();

    private String message;

    public void setMessage(String message) {
        this.message = message;
        notifyObserver();
    }

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }

    private void notifyObserver() {
        observerList.forEach(observer -> observer.showMessage(message));
    }
}
