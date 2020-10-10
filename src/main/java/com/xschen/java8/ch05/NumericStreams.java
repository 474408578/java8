package com.xschen.java8.ch05;

import com.xschen.java8.ch04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author xschen
 */


public class NumericStreams {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);

        Arrays.stream(numbers.toArray())
                .forEach(System.out::println);

        // sum有个默认值为0，所以不需要使用OptionalInt
        int calories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .sum();
        System.out.println("Number of calories: " + calories);


        // max and OptionalInt
        OptionalInt maxCalories = Dish.menu.stream()
                .mapToInt(Dish::getCalories)
                .max();

        int max;
        if (maxCalories.isPresent()) {
            max = maxCalories.getAsInt();
        } else {
            // we can choose a default value
            max = 1;
        }
        System.out.println(max);

        // numeric ranges
        IntStream eventNumbers = IntStream.rangeClosed(1, 100)
                .filter(n -> n % 2 == 0);
        System.out.println(eventNumbers.count());

        // boxed将原始流转换为一般流
        Stream<int[]> pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0).boxed()
                        .map(b -> new int[] {a, b, (int) Math.sqrt(a * a + b * b)}));
        pythagoreanTriples.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        Stream<int[]> pythagoreanTriples2 = IntStream.rangeClosed(1, 100).boxed()
                .flatMap(a -> IntStream.rangeClosed(a, 100)
                        .mapToObj(b -> new double[] {a, b, Math.sqrt(a * a + b * b)})
                        .filter(t -> t[2] % 1 == 0))
                .map(array -> Arrays.stream(array).mapToInt(a -> (int) a).toArray());
        pythagoreanTriples2.forEach(t -> System.out.println(t[0] + ", " + t[1] + ", " + t[2]));


    }
}
