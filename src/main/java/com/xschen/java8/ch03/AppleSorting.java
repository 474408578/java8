package com.xschen.java8.ch03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xschen
 */


public class AppleSorting {
    public static void main(String[] args) {
        List<Apple> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(
                new Apple(Color.GREEN, 80),
                new Apple(Color.RED, 120),
                new Apple(Color.GREEN, 155)
        ));

        inventory.sort(new AppleComparator());
        System.out.println(inventory);

        inventory.set(0, new Apple(Color.GREEN, 90));
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight() - o2.getWeight();
            }
        });
        System.out.println(inventory);

        inventory.set(0, new Apple(Color.GREEN, 80));
        inventory.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
        System.out.println(inventory);

        inventory.set(1, new Apple(Color.RED, 200));
        inventory.sort(Comparator.comparing(Apple::getWeight));
        System.out.println(inventory);

    }

    static class AppleComparator implements Comparator<Apple> {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }
}
