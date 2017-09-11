package com.shurikat.utils;

import org.junit.Assert;

/**
 * @author Alex Ivchenko
 */
public class SortAssert extends Assert {
    public static <T extends Comparable<? super T>> void assertSorted(T[] a) {
        for (int i = 1; i < a.length; ++i) {
            if (a[i].compareTo(a[i - 1]) < 0) {
                throw new AssertionError("not sorted");
            }
        }
    }
}
