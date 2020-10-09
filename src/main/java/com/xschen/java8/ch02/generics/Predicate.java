package com.xschen.java8.ch02.generics;

/**
 * @author xschen
 */


public interface Predicate<T> {
    boolean test(T t);
}
