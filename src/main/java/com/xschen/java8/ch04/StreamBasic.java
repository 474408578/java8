package com.xschen.java8.ch04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xschen
 * 筛选低能量的菜肴，并按能量排序返回
 */


public class StreamBasic {
    public static void main(String[] args) {
        getLowCaloriesDishesInJava7(Dish.menu).forEach(System.out::println);

        System.out.println("-------------------------------------------");

        getLowCaloriesDishesInJava8(Dish.menu).forEach(System.out::println);

    }

    public static List<String> getLowCaloriesDishesInJava7(List<Dish> dishes) {
        List<Dish> lowCaloriesDishes = new ArrayList<>();
        for (Dish dish : dishes) {
            if (dish.getCalories() < 400) {
                lowCaloriesDishes.add(dish);
            }
        }

        lowCaloriesDishes.sort(new Comparator<Dish>() {
            @Override
            public int compare(Dish o1, Dish o2) {
                return o1.getCalories() - o2.getCalories();
            }
        });

        List<String> lowCaloriesDishesNames = new ArrayList<>();
        for (Dish lowCaloriesDish : lowCaloriesDishes) {
            lowCaloriesDishesNames.add(lowCaloriesDish.getName());
        }
        return lowCaloriesDishesNames;
    }

    public static List<String> getLowCaloriesDishesInJava8(List<Dish> dishes) {
        return dishes.stream()
                .filter(dish -> dish.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());
    }
}
