package functinal_programming;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Predicate_Main {

    public static void main(String[] args) {

        List<Apple> appleList = List.of(
                new Apple("Green", 30),
                new Apple("Green", 30),
                new Apple("Green", 23),
                new Apple("Red", 20),
                new Apple("Red", 30),
                new Apple("Red", 20)
        );

        List<Apple> greenApples = search(appleList, (apple -> apple.getColor().equals("Green")));
        List<Apple> redApples = search(appleList, (apple -> apple.getColor().equals("Red")));

        List<Apple> greenApplesWithSize30 = search(appleList, (apple -> {
            return apple.getColor().equals("Green") && apple.getSize() == 30;
        }));

//        System.out.println(greenApples);
//        System.out.println(redApples);
//        System.out.println(greenApplesWithSize30);

        System.out.println(searchWithPredicate(appleList, apple -> apple.getColor().equals("Green")));
    }

    public static List<Apple> search(List<Apple> list, Predicate<Apple> predicate) {

        List<Apple> appleList = new ArrayList<>();
        for (Apple apple : list) {
            if (predicate.test(apple)) {
                appleList.add(apple);
            }
        }
        return appleList;
    }

    public static <T> List<T> searchWithPredicate(List<T> list, Predicate<T> predicate) {

        List<T> arrayList = new ArrayList<>();
        for (T t : list) {
            if (predicate.test(t)) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }
}
