package com.xschen.java8.ch05;

import java.util.stream.Stream;

/**
 * @author xschen
 */


public class BuildingStreams {

    public static void main(String[] args) {
        // Stream.of
        Stream<String> stream = Stream.of("Java 8", "Lambdas", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);
    }
}
