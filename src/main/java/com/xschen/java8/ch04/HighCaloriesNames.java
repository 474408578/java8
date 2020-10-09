package com.xschen.java8.ch04;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * @author xschen
 *
 * todo: 获取三种卡路里大于300的菜肴
 */


public class HighCaloriesNames {
    public static void main(String[] args) {
        List<String> names = Dish.menu.stream()
                .filter(dish -> {
                    System.out.println("filtering: " + dish.getName());
                    return dish.getCalories() > 300;
                })
                .map(dish -> {
                    System.out.println("mapping: " + dish.getName());
                    return dish.getName();
                })
                .limit(3)
                .collect(toList());
        System.out.println(names);
    }
}
