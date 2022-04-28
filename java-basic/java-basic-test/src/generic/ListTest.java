package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class A {

}

class B extends A {

}

class C extends B {

}

public class ListTest {

    public static void main(String[] args) {

        List<Integer> immutableList = List.of(1, 2, 3);
        List<String> fixSizedArray = Arrays.asList("Hello", "Xiaoting");

//        printList(immutableList);
//        printList(fixSizedArray);

        printNumber(immutableList);
        printString(fixSizedArray);


    }

    public void upperBound() {

        List<? extends B> list = new ArrayList<>();
//        list.add(new B());

        testUpperBound(new ArrayList<B>() {
        });

    }

    public void lowerBound() {

        List<? super B> list = new ArrayList<>();
        list.add(new B());
        list.add(new C());

        testLowerBound(new ArrayList<B>() {
        });

    }

    public void testUpperBoundAndLowerBound() {

        List<A> listA = List.of();
        List<B> listB = List.of();
        List<C> listC = List.of();

        testUpperBound(listB);
        testUpperBound(listC);

        testLowerBound(listA);
        testLowerBound(listB);

        System.out.println(listB.getClass().equals(listA.getClass())); // Generic Only takes place in Compile time
    }

    public static void testUpperBound(List<? extends B> list) {

    }

    public static void testLowerBound(List<? super B> list) {

    }

    public static void printList(List<Object> list) {
        list.forEach(System.out::println);
    }

    public static void printNumber(List<? extends Number> list) { // ? is undefined type // upper bound
        list.forEach(System.out::println);
    }

    public static void printString(List<? super String> list) { // lower bound
        list.forEach(System.out::println);
    }


    public <T> void list(List<T> list) { // T is universal Type

    }
}

