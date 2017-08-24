package com.shurikat.structures.prefix;

import java.util.function.Predicate;

/**
 * @author Alex Ivchenko
 */
public class MapFunctions {
    public static MapFunc<Integer> sum() {
        return i -> i;
    }

    public static <T> MapFunc<T> count(Predicate<T> predicate) {
        return i -> predicate.test(i) ? 1 : 0;
    }
}
