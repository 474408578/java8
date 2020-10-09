package com.xschen.java8.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xschen
 */


public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(Color.GREEN, 120),
                new Apple(Color.RED, 180),
                new Apple(Color.GREEN, 160)
        );

        /**
         * 使用匿名内部类的方式
         */
        List<Apple> redAndHeavyApples = FilteringApples.filterApples(inventory,
                new ApplePredicate() {
                    @Override
                    public boolean test(Apple apple) {
                        return Color.RED.equals(apple.getColor())
                                && apple.getWeight() > 150;
                    }
                });
        System.out.println(redAndHeavyApples);

        /**
         * 使用Lambda表达式重写。
         */
        List<Apple> heavyApples = FilteringApples.filterApples(inventory,
                (Apple apple) -> apple.getWeight() > 150);
        System.out.println(heavyApples);


    }
    public static List<Apple> filterApples(List<Apple> inventory,
                                           ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}
