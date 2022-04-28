package com.hha.demo;

public class Main {

    public static void main(String[] args) {

        TwoString twoString = new TwoString();

        MyThread myThread = new MyThread("Xiaoting", "is pretty", twoString);
        MyThread myThread1 = new MyThread("Xiaoting", "is pretty", twoString);
        MyThread myThread2 = new MyThread("Xiaoting", "is pretty", twoString);
        MyThread myThread3 = new MyThread("Xiaoting", "is pretty", twoString);



    }
}
