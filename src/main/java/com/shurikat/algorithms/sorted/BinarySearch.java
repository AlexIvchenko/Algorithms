package com.shurikat.algorithms.sorted;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.naturalOrder;

/**
 * @author Alex Ivchenko
 */
public final class BinarySearch<T> {
    private final T[] data;
    private final Comparator<T> comparator;

    private BinarySearch(T[] data, Comparator<T> comparator) {
        this.data = data;
        this.comparator = comparator;
        List<T> list = Arrays.asList(data);
        list.sort(comparator);
        data = Arrays.copyOf(data, data.length);
        list.toArray(data);
    }

    public static <T> BinarySearch<T> of(T[] data, Comparator<T> comparator) {
        return new BinarySearch<>(data, comparator);
    }

    public static BinarySearch<Integer> from(int[] array) {
        Integer[] converted = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            converted[i] = array[i];
        }
        return new BinarySearch<>(converted, naturalOrder());
    }

    public T get(int idx) {
        return data[idx];
    }

    public int search(T key) {
        return search(data, key, comparator);
    }

    public int firstIndex(T key) {
        return firstIndex(data, key, comparator);
    }

    public int lastIndex(T key) {
        return lastIndex(data, key, comparator);
    }

    public int ceiling(T key) {
        return ceiling(data, key, comparator);
    }

    public int floor(T key) {
        return floor(data, key, comparator);
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
