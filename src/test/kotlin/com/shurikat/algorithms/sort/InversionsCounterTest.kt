package com.shurikat.algorithms.sort

import org.junit.Test
import kotlin.test.assertEquals

/**
 * @author Alex Ivchenko
 */
class InversionsCounterTest {
    @Test
    fun givenEmptyArray_whenCountInversions_thenZero() {
        val a = arrayOf<Int>()
        assertEquals(0, InversionsCounter.inversions(a))
    }

    @Test
    fun givenSingletonArray_whenCountInversions_thenZero() {
        val a = arrayOf(1)
        assertEquals(0, InversionsCounter.inversions(a))
    }

    @Test
    fun givenSortedArray_whenCountInversions_thenZero() {
        val a = arrayOf(1, 2, 3)
        assertEquals(0, InversionsCounter.inversions(a))
    }

    @Test
    fun givenNotSortedArray_whenCountInversions_thenReturnCorrectValue() {
        val a = arrayOf(3, 2, 1)
        assertEquals(3, InversionsCounter.inversions(a))
    }
}