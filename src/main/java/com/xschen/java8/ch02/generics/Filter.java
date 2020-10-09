package com.xschen.java8.ch02.generics;

import com.xschen.java8.ch02.Apple;
import com.xschen.java8.ch02.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xschen
 *
 * 使用泛型
 */


public class Filter {
    public static void main(String[] args) {

        List<com.xschen.java8.ch02.Apple> inventory = Arrays.asList(
                new com.xschen.java8.ch02.Apple(Color.GREEN, 120),
                new com.xschen.java8.ch02.Apple(Color.RED, 180),
                new Apple(Color.GREEN, 160)
        );
        List<Apple> redApples = filter(inventory,
                (Apple apple) -> Color.RED.equals(apple.getColor()));
        System.out.println(redApples);
    }

    public static <T> List<T> filter(List<T> list,
                                     Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T e : list) {
            if (predicate.test(e)) {
                result.add(e);
            }
        }
        return result;
    }
}
