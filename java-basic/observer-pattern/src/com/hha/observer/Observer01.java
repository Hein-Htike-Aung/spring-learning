package com.hha.observer;

import com.hha.Subject;

public class Observer01 extends Observer {

    public Observer01() {

    }

    public Observer01(Subject subject) {
        super(subject);
        subject.addObserver(this);
    }

    @Override
    public void showMessage(String message) {
        System.out.println("Observer 01 received message -> " + message);
    }
}
