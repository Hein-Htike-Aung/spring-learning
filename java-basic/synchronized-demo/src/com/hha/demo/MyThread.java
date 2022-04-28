package com.hha.demo;

public class MyThread implements Runnable {

    private TwoString twoString;
    private String str1;
    private String str2;


    public MyThread(String str1, String str2, TwoString twoString) {
        this.str1 = str1;
        this.str2 = str2;
        this.twoString = twoString;

        Thread thread = new Thread(this);
        thread.start();
    }

    public TwoString getTwoString() {
        return twoString;
    }

    @Override
    public void run() {
//        twoString.print(str1, str2);

//        twoString.print1(str1, str2);

        synchronized (twoString) {
            twoString.print2(str1, str2);
        }
    }

}
