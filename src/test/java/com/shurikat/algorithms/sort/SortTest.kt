package com.shurikat.algorithms.sort

import com.shurikat.utils.assertSorted
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
 * @author Alex Ivchenko
 */
class InsertionSortTest : SortTest(InsertionSort)

class SelectionSortTest : SortTest(SelectionSort)

class QuickSortTest : SortTest(QuickSort)

abstract class SortTest(private val sorter: Sorter) {
    @Test
    fun givenEmptyArray_WhenSort_thenNoExceptions() {
        val a = Array(0, {_ -> 0})
        sorter.sort(a)
    }

    @Test
    fun givenSingletonArray_WhenSort_thenNoExceptions() {
        val a = Array(1, {_ -> 0})
        sorter.sort(a)
        assertEquals(a[0], 0)
    }

    @Test
    fun givenArray_WhenSort_thenArraySorted() {
        val a = arrayOf(1, 3, 2)
        sorter.sort(a)
        println(Arrays.toString(a))
        assertSorted(a)
    }

    @Test
    fun givenBigAscSortedArray_whenSort_thenArrayAscSorted() {
        val a = Array(1000, { i -> i })
        sorter.sort(a)
        assertSorted(a)
    }

    @Test
    fun givenBigDescSortedArray_whenSort_thenArrayAscSorted() {
        val a = Array(1000, { i -> 1000 - i })
        sorter.sort(a)
        assertSorted(a)
    }

    @Test
    fun givenBigRandomArray_whenSort_thenArrayAscSorted() {
        val random = Random(0)
        val a = Array(1000, { _ ->  random.nextInt() })
        sorter.sort(a)
        assertSorted(a)
    }

    @Test
    fun givenArrayWithEqualItems_whenSort_thenArraySorted() {
        val a = arrayOf(1, 1, 1)
        sorter.sort(a)
        assertSorted(a)
    }
}