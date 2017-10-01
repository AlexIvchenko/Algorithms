package com.shurikat.algorithms.sort

import com.shurikat.utils.assertSorted
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
 * @author Alex Ivchenko
 */
class CountingSortTest {
    @Test
    fun givenEmptyArray_whenSort_thenNoExceptions() {
        val a = arrayOf<Int>()
        CountingSort.sort(a, { e -> e })
    }

    @Test
    fun givenSingletonArray_whenSort_thenNoExceptions() {
        val a = arrayOf(1)
        val sorted = CountingSort.sort(a, { e -> e })
        assertEquals(1, sorted[0])
    }

    @Test
    fun givenArray_whenSort_thenSorted() {
        val a = arrayOf(10, -10)
        val sorted = CountingSort.sort(a, { e -> e })
        assertEquals(-10, sorted[0])
        assertEquals(10, sorted[1])
    }

    @Test
    fun givenBigAscSortedArray_whenSort_thenArrayAscSorted() {
        val a = Array(1000, { i -> i })
        val sorted = CountingSort.sort(a, { i -> i })
        assertSorted(sorted)
    }

    @Test
    fun givenBigDescSortedArray_whenSort_thenArrayAscSorted() {
        val a = Array(1000, { i -> 1000 - i })
        val sorted = CountingSort.sort(a, { i -> i })
        assertSorted(sorted)
    }

    @Test
    fun givenBigRandomArray_whenSort_thenArrayAscSorted() {
        val random = Random(0)
        val a = Array(1000, { _ -> random.nextInt(10000) })
        val sorted = CountingSort.sort(a, { i -> i })
        assertSorted(sorted)
    }

    @Test
    fun givenArrayWithEqualItems_whenSort_thenArraySorted() {
        val a = arrayOf(1, 1, 1)
        val sorted = CountingSort.sort(a, { i -> i })
        assertSorted(sorted)
    }
}