package com.shurikat.structures.prefix;

/**
 * @author Alex Ivchenko
 */
public class Prefix<T> {
    private final int n;
    private final long[] prefix;

    public Prefix(T[] a, MapFunc<T> map) {
        this.n = a.length;
        prefix = new long[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            prefix[i + 1] = prefix[i] + map.delta(a[i]);
        }
    }

    public static Prefix<Integer> ints(int[] array, MapFunc<Integer> mapFunc) {
        Integer[] converted = new Integer[array.length];
        for (int i = 0; i < array.length; i++) {
            converted[i] = array[i];
        }
        return new Prefix<>(converted, mapFunc);
    }

    public long segment(int l, int r) {
        if (r < l) {
            return 0;
        }
        if (l < 0) {
            if (r <= n) {
                return prefix[r + 1];
            } else {
                return prefix[n];
            }
        } else {
            if (r <= n) {
                return prefix[r + 1] - prefix[l];
            } else {
                return prefix[n] - prefix[l];
            }
        }
    }
}
