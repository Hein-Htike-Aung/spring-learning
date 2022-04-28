package com.hha.observer;

import com.hha.Subject;

public class Observer02 extends Observer {

    public Observer02() {
    }

    public Observer02(Subject subject) {
        super(subject);
        subject.addObserver(this);
    }

    @Override
    public void showMessage(String message) {
        System.out.println("Observer 02 received message ->  " + message);
    }
}
