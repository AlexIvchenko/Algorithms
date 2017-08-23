package com.shurikat.algorithms.sorted;

import org.junit.Test;

import static java.util.Comparator.naturalOrder;
import static org.junit.Assert.assertEquals;

/**
 * @author Alex Ivchenko
 */
public class BinarySearchTest {
    @Test
    public void givenArrayWithRepeatableKeys_WhenFindFirstPositionOfKey_ThenReturnFirstPositionOfKey() throws Exception {
        Integer[] sorted = new Integer[] {
                1, 2, 2, 2, 3
        };
        int foundIndex = BinarySearch.firstIndex(sorted, 2, naturalOrder());
        assertEquals(1, foundIndex);
    }

    @Test
    public void givenArrayWithRepeatableKeys_WhenFindLastPositionOfKey_ThenReturnLastPositionOfKey() throws Exception {
        Integer[] sorted = new Integer[] {
                1, 2, 2, 2, 3
        };
        int foundIndex = BinarySearch.lastIndex(sorted, 2, naturalOrder());
        assertEquals(3, foundIndex);
    }


    @Test
    public void givenArrayNotContainsKey_WhenFindKey_ThenReturnMinusOne() throws Exception {
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
    public void givenEmptyArray_WhenFindKey_ThenReturnMinusOne() throws Exception {
        Integer[] empty = new Integer[0];
        int anyIndex = BinarySearch.search(empty, 0, naturalOrder());
        int firstIndex = BinarySearch.firstIndex(empty, 0, naturalOrder());
        int lastIndex = BinarySearch.lastIndex(empty, 0, naturalOrder());

        assertEquals(-1, anyIndex);
        assertEquals(-1, firstIndex);
        assertEquals(-1, lastIndex);
    }

    @Test
    public void givenSingletonArrayWithAKey_WhenFindKey_ThenReturnPositionOfKey() throws Exception {
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
    public void givenArrayNotContainsKey_WhenCeiling_ThenReturnPositionOfFirstElementWhichGreaterThanKey() throws Exception {
        Integer[] sorted = new Integer[] {
                1, 2, 2, 2, 4
        };
        int ceil = BinarySearch.ceiling(sorted, 3, naturalOrder());
        assertEquals(4, ceil);
    }

    @Test
    public void givenArrayNotContainsKeyAndAllElementsLessThanKey_WhenCeiling_ThenReturnSizeOfArray() throws Exception {
        Integer[] sorted = new Integer[] {
                2, 3
        };
        int ceil = BinarySearch.ceiling(sorted, 4, naturalOrder());
        assertEquals(2, ceil);
    }

    @Test
    public void givenArrayNotContainsKey_WhenFloor_ThenReturnPositionOfLastElementWhichLessThanKey() throws Exception {
        Integer[] sorted = new Integer[] {
                1, 2, 2, 2, 4
        };
        int floor = BinarySearch.floor(sorted, 3, naturalOrder());
        assertEquals(3, floor);
    }

    @Test
    public void givenArrayNotContainsKeyAndAllElementsGreaterThanKey_WhenFloor_ThenReturnMinusOne() throws Exception {
        Integer[] sorted = new Integer[] {
                2, 3
        };
        int floor = BinarySearch.floor(sorted, 1, naturalOrder());
        assertEquals(-1, floor);
    }
}