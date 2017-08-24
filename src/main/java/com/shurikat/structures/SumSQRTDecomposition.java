package com.shurikat.structures;

import static java.lang.Math.sqrt;
import static java.util.Arrays.copyOf;

/**
 * @author Alex Ivchenko
 */
public class SumSQRTDecomposition {
    private final long[] sums;
    private final int[] deltas;
    private final int[] array;
    private final int len;

    public SumSQRTDecomposition(int[] array) {
        this.array = copyOf(array, array.length);
        this.len = (int) sqrt(array.length) + 1;
        this.sums = new long[len];
        this.deltas = new int[len];
        for (int i = 0; i < array.length; i++) {
            sums[i / len] += array[i];
        }
    }

    public void set(int i, int value) {
        int old = array[i];
        array[i] = value;
        sums[i / len] += value - old;
    }

    public void increase(int left, int right, int delta) {
        int leftSegment = left / len;
        int rightSegment = right / len;
        if (leftSegment == rightSegment) {
            for (int i = left; i <= right; i++) {
                array[i] += delta;
            }
            return;
        }

        for (int i = left, end = (leftSegment + 1) * len - 1; i <= end; ++i) {
            array[i] += delta;
        }

        for (int segment = leftSegment + 1; segment <= rightSegment - 1; ++segment) {
            deltas[segment] = delta;
        }

        for (int i = rightSegment * len; i <= right; ++i) {
            array[i] += delta;
        }
    }

    public int get(int i) {
        return array[i] + deltas[i / len];
    }

    public long sum(int left, int right) {
        long sum = 0;
        int leftSegment = left / len;
        int rightSegment = right / len;
        if (leftSegment == rightSegment) {
            for (int i = left; i <= right; i++) {
                sum += array[i];
            }
            return sum;
        }

        for (int i = left, end = (leftSegment + 1) * len - 1; i <= end; ++i) {
            sum += array[i] + deltas[leftSegment];
        }

        for (int segment = leftSegment + 1; segment <= rightSegment - 1; ++segment) {
            int segmentLength = segment != len - 1 ? len : array.length - (len - 1) * len;
            sum += sums[segment] + segmentLength * deltas[segment];
        }

        for (int i = rightSegment * len; i <= right; ++i) {
            sum += array[i] + deltas[rightSegment];
        }

        return sum;
    }
}
