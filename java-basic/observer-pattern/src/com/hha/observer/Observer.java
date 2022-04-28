package com.hha.observer;

import com.hha.Subject;

public abstract class Observer {

    protected Subject subject;

    public Observer() {
    }

    public Observer(Subject subject) {
        this.subject = subject;
    }

    public abstract void showMessage(String message);
}
