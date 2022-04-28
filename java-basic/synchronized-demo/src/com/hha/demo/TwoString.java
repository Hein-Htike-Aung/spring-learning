package com.hha.demo;

public class TwoString {

    // Has Race Condition
//    public static synchronized void print(String str1, String str2) {
//        System.out.print(str1);
//
//        try {
//
//            Thread.sleep(1000);
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(" " + str2);
//    }

    /*
    * synchronized makes Thread safe
    * */
    public static synchronized void print(String str1, String str2) {
        System.out.print(str1);

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" " + str2);
    }

    /*
    The only one instance's synchronized
    each other instances have nothing to do with synchronized
    One Object is One Threat
    * */
    public synchronized void print1(String str1, String str2) {
        System.out.print(str1);

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" " + str2);
    }

    public void print2(String str1, String str2) {
        System.out.print(str1);

        try {

            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" " + str2);
    }


}
