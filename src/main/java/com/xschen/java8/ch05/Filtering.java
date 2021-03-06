package com.xschen.java8.ch05;

import com.xschen.java8.ch04.Dish;
import com.xschen.java8.ch04.Type;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author xschen
 */


public class Filtering {

    public static void main(String[] args) {
        //  Filtering with predicate
        System.out.println("Filtering with predicate");
        List<Dish> vegetarianMenu = Dish.menu.stream()
                .filter(Dish::isVegetarian)
                .collect(toList());
        vegetarianMenu.forEach(System.out::println);

        System.out.println("Filtering unique elements:");
        List<Integer> numbers = Arrays.asList(1, 2, 1, 3, 3, 2, 4);
        numbers.stream()
                .filter(i -> i % 2 == 0)
                .distinct()
                .forEach(System.out::println);

        // Slicing a stream
        // This list is sorted in ascending order of number of calories!
        List<Dish> specialMenu = Arrays.asList(
                new Dish("season fruit", true, 120, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER));
        System.out.println("Filtered sorted menu:");
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() < 320)
                .collect(toList());
        filteredMenu.forEach(System.out::println);

        // jdk1.9可用
//        System.out.println("Sorted menu sliced with takeWhile():");
//        List<Dish> sliceMenu1 = specialMenu.stream()
//                .takeWhile(dish -> dish.getCalories() < 320)
//                .collect(toList());
//        sliceMenu1.forEach(System.out::println);

        // jdk1.9可用
//        System.out.println("Sorted menu sliced with dropWhile():");
//        List<Dish> slicedMenu2 = specialMenu.stream()
//                .dropWhile(dish -> dish.getCalories() < 320)
//                .collect(toList());
//        slicedMenu2.forEach(System.out::println);

        List<Dish> dishesLimit3 = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .limit(3)
                .collect(toList());
        System.out.println("Truncating a stream:");
        dishesLimit3.forEach(System.out::println);

        // Skipping elements
        List<Dish> dishesSkip2 = Dish.menu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .collect(toList());
        System.out.println("Skipping elements:");
        dishesSkip2.forEach(System.out::println);



    }
}
