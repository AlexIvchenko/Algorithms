package com.shurikat.algorithms.sorted;

import java.util.Comparator;

/**
 * @author Alex Ivchenko
 */
public final class BinarySearch {
    private BinarySearch() {

    }

    public static <T> int search(T[] sorted, T key, Comparator<? super T> cmp) {
        int l = 0;
        int r = sorted.length - 1;
        while (l <= r) {
            int m = (l + r) >>> 1;
            if (cmp.compare(sorted[m], key) == 0) {
                return m;
            }
            if (cmp.compare(sorted[m], key) < 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }

    public static <T> int firstIndex(T[] sorted, T key, Comparator<? super T> cmp) {
        int i = ceiling(sorted, key, cmp);
        if (i < sorted.length && cmp.compare(sorted[i], key) == 0) {
            return i;
        }
        return -1;
    }

    public static <T> int lastIndex(T[] sorted, T key, Comparator<? super T> cmp) {
        int i = floor(sorted, key, cmp);
        if (i >= 0 && cmp.compare(sorted[i], key) == 0) {
            return i;
        }
        return -1;
    }

    public static <T> int ceiling(T[] sorted, T key, Comparator<? super T> cmp) {
        int l = -1;
        int r = sorted.length;
        // invariant: sorted[l] < x, sorted[r] >= x
        while (r > l + 1) {
            int m = (l + r) >>> 1;
            if (cmp.compare(sorted[m], key) < 0) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }

    public static <T> int floor(T[] sorted, T key, Comparator<? super T> cmp) {
        int l = -1;
        int r = sorted.length;
        // invariant: sorted[l] <= x, sorted[r] > x
        while (r > l + 1) {
            int m = (l + r) >>> 1;
            if (cmp.compare(sorted[m], key) <= 0) {
                l = m;
            } else {
                r = m;
            }
        }
        return l;
    }
}
