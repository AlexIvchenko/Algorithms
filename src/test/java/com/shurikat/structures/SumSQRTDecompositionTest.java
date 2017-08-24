package com.shurikat.structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Alex Ivchenko
 */
public class SumSQRTDecompositionTest {
    @Test
    public void givenCorrectBoundaries_whenSegmentSumChecked_thenReturnCurrentSegmentSum() throws Exception {
        SumSQRTDecomposition sqrtDecomposition = new SumSQRTDecomposition(new int[] {1, 2, 3});
        assertEquals(3, sqrtDecomposition.sum(0, 1));
        assertEquals(6, sqrtDecomposition.sum(0, 2));
        assertEquals(5, sqrtDecomposition.sum(1, 2));
        assertEquals(1, sqrtDecomposition.sum(0, 0));
        assertEquals(2, sqrtDecomposition.sum(1, 1));
        assertEquals(3, sqrtDecomposition.sum(2, 2));
    }

    @Test
    public void givenArray_whenFullSumChecked_thenReturnSumOfAllElements() throws Exception {
        SumSQRTDecomposition sqrtDecomposition = new SumSQRTDecomposition(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        assertEquals(45, sqrtDecomposition.sum(0, 8));
    }

    @Test
    public void givenIncreaseAllElements_whenFullSumChecked_thenReturnSumOfAllElements() throws Exception {
        SumSQRTDecomposition sqrtDecomposition = new SumSQRTDecomposition(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        sqrtDecomposition.increase(0, 8, 1);
        assertEquals(54, sqrtDecomposition.sum(0, 8));
    }

    @Test
    public void givenChangeElement_whenSegmentSumChecked_thenElementChanged() throws Exception {
        SumSQRTDecomposition sqrtDecomposition = new SumSQRTDecomposition(new int[] {1, 2, 3});
        sqrtDecomposition.set(0, 3);
        assertEquals(8, sqrtDecomposition.sum(0, 2));
        assertEquals(3, sqrtDecomposition.get(0));
    }

    @Test
    public void givenIncreaseElements_whenSegmentSumChecked_thenElementsChanged() throws Exception {
        SumSQRTDecomposition sqrtDecomposition = new SumSQRTDecomposition(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        sqrtDecomposition.increase(0, 5, 3);
        assertEquals(15, sqrtDecomposition.sum(0, 2));
        assertEquals(4, sqrtDecomposition.get(0));
        assertEquals(5, sqrtDecomposition.get(1));
        assertEquals(6, sqrtDecomposition.get(2));
    }

    @Test
    public void givenIncreaseElement_whenSegmentSumChecked_thenElementsChanged() throws Exception {
        SumSQRTDecomposition sqrtDecomposition = new SumSQRTDecomposition(new int[] {1, 2, 3});
        sqrtDecomposition.increase(0, 0, 3);
        assertEquals(4, sqrtDecomposition.get(0));
        assertEquals(9, sqrtDecomposition.sum(0, 2));
    }
}