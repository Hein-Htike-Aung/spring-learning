package com.hha;

import com.hha.observer.Observer;
import com.hha.observer.Observer01;
import com.hha.observer.Observer02;

public class Main {
    public static void main(String[] args) {

        Subject subject = new Subject();

//        Observer observer01 = new Observer01();
//        Observer observer02 = new Observer02();
//        subject.addObserver(observer01);
//        subject.addObserver(observer02);

        Observer observer01 = new Observer01(subject);
        Observer observer02 = new Observer02(subject);

        subject.setMessage("Hello All!!");

        subject.removeObserver(observer02);

        subject.setMessage("My Name!!");
    }
}
