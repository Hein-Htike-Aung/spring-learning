package com.hha.streams;

import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        new StreamDemo().run();
    }

    private void run() {

        Stream.iterate(2, this::getNext) // unary operator
                .limit(5)
                .map(this::formatNumber)
                .forEach(System.out::println);
    }

    private int getNext(int i) {
        return (int) Math.pow(i, 2);
    }

    private String formatNumber(int n) {
        return String.format("Number = %d" , n);
    }
}
