package com.xschen.java8.ch02.comparator;

import com.xschen.java8.ch02.Apple;
import com.xschen.java8.ch02.Color;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xschen
 * 使用Comparator来排序List
 */


public class SortApple {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(Color.GREEN, 120),
                new Apple(Color.RED, 180),
                new Apple(Color.GREEN, 160)
        );

        /**
         * 使用匿名类
         */
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                // 从小到大
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });

        System.out.println(inventory);

        /**
         * 使用Lambda重写，从大到小
         */
        inventory.sort((Apple a1, Apple a2) ->
            a2.getWeight().compareTo(a1.getWeight())
        );

        System.out.println(inventory);

    }
}
