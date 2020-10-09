package com.xschen.java8.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author xschen
 * Lambda表达式学习
 * 函数式接口：只定义一个抽象方法的接口
 * 函数式接口：Java中已经定义了几个函数式接口，如Comparator，Runnable，Callable
 * Java8的库设计师在java.util.function包中引入了几个新的函数式接口：
 * Predicate，Consumer，Function
 * Predicate：接受一个泛型对象，并返回一个boolean值，test方法。
 * Consumer：接受一个泛型对象，不返回值，accept方法。
 * Function：接受一个泛型对象，并返回一个泛型R对象，apply方法。
 */



public class Lambdas {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(Color.GREEN, 120),
                new Apple(Color.RED, 180),
                new Apple(Color.GREEN, 160)
        );

        List<Apple> greenApples = Lambdas.filter(inventory,
                (Apple apple) -> apple.getColor() == Color.GREEN);
        System.out.println(greenApples);

        Comparator<Apple> comparator =
                (apple1, apple2) -> apple1.getWeight().compareTo(apple2.getWeight());
        inventory.sort(comparator);
        System.out.println(inventory);

        // 使用方法引用，倒序排序
        inventory.sort(Comparator.comparing(Apple::getWeight).reversed());
        System.out.println(inventory);

    }

    public static List<Apple> filter(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }
}


