package com.xschen.java8.ch05;

import com.xschen.java8.ch04.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author xschen
 */


public class Reducing {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 4, 5, 1, 2);
        // 设置初始值为1
        int sum = numbers.stream().reduce(1, (a, b) -> a + b);
        System.out.println(sum);

        int sum2 = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum2);

        Optional<Integer> max = numbers.stream().reduce(Integer::max);
        System.out.println(max.get());

        int max2 = numbers.stream().reduce(0, (a, b) -> Integer.max(a, b));
        System.out.println(max2);

        // 求最小值，初始值设置为Integer.MAX_VALUE
        int min = numbers.stream().reduce(Integer.MAX_VALUE, (a, b) -> Integer.min(a, b));
        System.out.println(min);

        Optional<Integer> min2 = numbers.stream().reduce(Integer::min);
        min2.ifPresent(System.out::println);

        int calories = Dish.menu.stream()
                .map(Dish::getCalories)
                .reduce(0, Integer::sum);
        System.out.println("Number of calories:" + calories);
    }


}
