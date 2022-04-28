package com.hha.demo;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {


        Optional<Double> optionalDouble = avg();
        Optional<Double> optionalDouble1 = avg(10, 56);
        Optional<Double> optionalDouble2 = avg(10, 56, 90);

//        if(optionalDouble.isPresent()) {
//            System.out.println(optionalDouble.get());
//        }else{
//            System.out.println("Optional");
//        }
//        if(optionalDouble1.isPresent()) {
//            System.out.println(optionalDouble1.get());
//        }
//        if(optionalDouble2.isPresent()) {
//            System.out.println(optionalDouble2.get());
//        }


//        System.out.println(optionalDouble.or(() -> Optional.empty()));
//        System.out.println(optionalDouble.or(Optional::empty)); // Method Reference

//        System.out.println(optionalDouble.orElse(Double.NaN));
//        System.out.println(optionalDouble.orElseGet(Math::random));
//        System.out.println(optionalDouble.orElseThrow(RuntimeException::new));

//        optionalDouble2.ifPresent(value -> {
//            value.intValue();
//            System.out.println(value);
//        });
//
//        optionalDouble.ifPresentOrElse(value -> {
//            System.out.println(value.intValue());
//
//        }, OptionalDemo::print);

        String str = null;
        System.out.println(Optional.ofNullable(str));


    }

    public static void print(){
        System.out.println("Xiaoting");
    }


    public static Optional<Double> avg(int... num) {

        if (num.length <= 0) {
            return Optional.empty();
        }
        double sum = 0;

        for (int i : num) {
            sum += i;
        }

        return Optional.of(sum / num.length);
    }

}
