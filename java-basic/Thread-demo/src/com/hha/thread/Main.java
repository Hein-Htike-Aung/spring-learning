package com.hha.thread;

public class Main {

    public static void main(String[] args) {

        MyThread myThread = new MyThread("XX");
        MyThread myThread2 = new MyThread("KK");
        MyThread myThread3 = new MyThread("WW");

        // Go to Running state
        myThread.start();
        myThread2.start();
        myThread3.start();


        System.out.println(myThread.getName() + " is Alive() -> " + myThread.isAlive());
        System.out.println(myThread2.getName() + " is Alive() -> " + myThread2.isAlive());
        System.out.println(myThread3.getName() + " is Alive() -> " + myThread3.isAlive());

        try {
            myThread.join();
            myThread2.join();
            myThread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Go to Dead State
        System.out.println(myThread.getName() + " is Alive() After join() -> " + myThread.isAlive());
        System.out.println(myThread2.getName() + " is Alive() After join() -> " + myThread2.isAlive());
        System.out.println(myThread3.getName() + " is Alive() After join() -> " + myThread3.isAlive());

    }
}
