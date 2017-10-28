package com.shurikat.algorithms.sorted;

import org.junit.Test;

import static java.util.Comparator.naturalOrder;
import static org.junit.Assert.assertEquals;

/**
 * @author Alex Ivchenko
 */
public class BinarySearchTest {
    @Test
    public void givenArray_whenFindFirstPositionOfSmallestKey_thenReturnZero() throws Exception {
        Integer[] sorted = new Integer[] {
                1, 2, 2, 2, 3
        };
        int firstIndex = BinarySearch.firstIndex(sorted, 1, naturalOrder());
        int lastIndex = BinarySearch.lastIndex(sorted, 1, naturalOrder());
        assertEquals(0, firstIndex);
        assertEquals(0, lastIndex);
    }

    @Test
    public void givenArrayWithRepeatableKeys_whenFindFirstPositionOfKey_thenReturnFirstPositionOfKey() throws Exception {
        Integer[] sorted = new Integer[] {
                1, 2, 2, 2, 3
        };
        int foundIndex = BinarySearch.firstIndex(sorted, 2, naturalOrder());
        assertEquals(1, foundIndex);
    }

    @Test
    public void givenArrayWithRepeatableKeys_whenFindLastPositionOfKey_thenReturnLastPositionOfKey() throws Exception {
        Integer[] sorted = new Integer[] {
                1, 2, 2, 2, 3
        };
        int foundIndex = BinarySearch.lastIndex(sorted, 2, naturalOrder());
        assertEquals(3, foundIndex);
    }


    @Test
    public void givenArrayNotContainsKey_whenFindKey_thenReturnMinusOne() throws Exception {
        Integer[] sorted = new Integer[] {
                1, 3
        };
        int anyIndex = BinarySearch.search(sorted, 2, naturalOrder());
        int firstIndex = BinarySearch.firstIndex(sorted, 2, naturalOrder());
        int lastIndex = BinarySearch.lastIndex(sorted, 2, naturalOrder());
        assertEquals(-1, anyIndex);
        assertEquals(-1, firstIndex);
        assertEquals(-1, lastIndex);
    }

    @Test
    public void givenEmptyArray_whenFindKey_thenReturnMinusOne() throws Exception {
        Integer[] empty = new Integer[0];
        int anyIndex = BinarySearch.search(empty, 0, naturalOrder());
        int firstIndex = BinarySearch.firstIndex(empty, 0, naturalOrder());
        int lastIndex = BinarySearch.lastIndex(empty, 0, naturalOrder());

        assertEquals(-1, anyIndex);
        assertEquals(-1, firstIndex);
        assertEquals(-1, lastIndex);
    }

    @Test
    public void givenSingletonArrayWithAKey_whenFindKey_thenReturnPositionOfKey() throws Exception {
        Integer[] singleton = new Integer[] {
                1
        };
        int anyIndex = BinarySearch.search(singleton, 1, naturalOrder());
        int firstIndex = BinarySearch.firstIndex(singleton, 1, naturalOrder());
        int lastIndex = BinarySearch.lastIndex(singleton, 1, naturalOrder());

        assertEquals(0, anyIndex);
        assertEquals(0, firstIndex);
        assertEquals(0, lastIndex);
    }

    @Test
    public void givenArrayNotContainsKey_whenCeiling_thenReturnPositionOfFirstElementWhichGreaterThanKey() throws Exception {
        Integer[] sorted = new Integer[] {
                1, 2, 2, 2, 4
        };
        int ceil = BinarySearch.ceiling(sorted, 3, naturalOrder());
        assertEquals(4, ceil);
    }

    @Test
    public void givenArrayNotContainsKeyAndAllElementsLessThanKey_whenCeiling_thenReturnSizeOfArray() throws Exception {
        Integer[] sorted = new Integer[] {
                2, 3
        };
        int ceil = BinarySearch.ceiling(sorted, 4, naturalOrder());
        assertEquals(2, ceil);
    }

    @Test
    public void givenArrayNotContainsKey_whenFloor_thenReturnPositionOfLastElementWhichLessThanKey() throws Exception {
        Integer[] sorted = new Integer[] {
                1, 2, 2, 2, 4
        };
        int floor = BinarySearch.floor(sorted, 3, naturalOrder());
        assertEquals(3, floor);
    }

    @Test
    public void givenArrayNotContainsKeyAndAllElementsGreaterThanKey_whenFloor_thenReturnMinusOne() throws Exception {
        Integer[] sorted = new Integer[] {
                2, 3
        };
        int floor = BinarySearch.floor(sorted, 1, naturalOrder());
        assertEquals(-1, floor);
    }

    @Test
    public void givenCreatingBinarySearchObjectFromUnsortedIntArray_whenFind_thenReturnIndexInSortedArray() throws Exception {
        BinarySearch<Integer> sorted = BinarySearch.from(new int[] {4, 3, 3, 2});
        assertEquals(0, sorted.search(2));
        assertEquals(1, sorted.firstIndex(3));
        assertEquals(2, sorted.lastIndex(3));
        assertEquals(0, sorted.floor(2));
        assertEquals(3, sorted.ceiling(4));
        int elem = sorted.get(1);
        assertEquals(3, elem);
    }
}