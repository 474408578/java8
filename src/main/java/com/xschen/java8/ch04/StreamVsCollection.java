package com.xschen.java8.ch04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author xschen
 * todo: 和迭代器类似，流只能被遍历一次
 */


public class StreamVsCollection {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Java8", "Lambda", "In", "Action");
        Stream<String> s = names.stream();
        s.forEach(System.out::println);

        // 再次执行会抛异常  java.lang.IllegalStateException
        s.forEach(System.out::println);

    }
}
