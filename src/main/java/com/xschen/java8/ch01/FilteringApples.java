package com.xschen.java8.ch01;

import java.util.*;
import java.util.function.Predicate;

/**
 * @author xschen
 * predicate: 谓词，接受一个参数值，并返回true或者false
 *
 */


public class FilteringApples {
    public static void main(String[] args) {

        List<Apple> inventory = Arrays.asList(
                new Apple("green", 80),
                new Apple("green", 90),
                new Apple("red", 120)
        );

        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);
    }

    public static List<Apple> filterApples(List<Apple> inventory,
                                           Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            // 方法作为Predicate参数p传递进去，苹果符合p所代表的条件吗？
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static boolean isGreenApple(Apple apple) {
        return "Green".equalsIgnoreCase(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 100;
    }
}
