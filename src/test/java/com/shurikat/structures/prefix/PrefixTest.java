package com.shurikat.structures.prefix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Ivchenko
 */
public class PrefixTest {
    private Prefix<Integer> sumPrefix = Prefix.ints(new int[] {1, 2, 3}, MapFunctions.sum());

    @Test
    public void givenIntegerArray_whenSegmentBoundsRight_thenReturnCurrentSum() throws Exception {
        assertEquals(1, sumPrefix.segment(0, 0));
        assertEquals(3, sumPrefix.segment(0, 1));
        assertEquals(5, sumPrefix.segment(1, 2));
        assertEquals(6, sumPrefix.segment(0, 2));
    }

    @Test
    public void givenIntegerArray_whenRightSegmentBoundOverhead_thenReturnSumToLastElement() throws Exception {
        assertEquals(6, sumPrefix.segment(0, 4));
    }

    @Test
    public void givenIntegerArray_whenLeftSegmentBoundLessThanZero_thenReturnSumFromFirstElement() throws Exception {
        assertEquals(6, sumPrefix.segment(-1, 2));
    }

    @Test
    public void givenIntegerArray_whenLeftSegmentBoundGreaterThanRightSegmentBound_thenReturnZero() throws Exception {
        assertEquals(0, sumPrefix.segment(2, 1));
    }

    @Test
    public void givenIntegerArray_whenSegmentBoundsBroaderThanArrayIndexes_thenSumOfAllElements() throws Exception {
        assertEquals(6, sumPrefix.segment(-1, 4));
    }
}