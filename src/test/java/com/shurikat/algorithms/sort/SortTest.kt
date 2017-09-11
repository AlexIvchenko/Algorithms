package com.shurikat.algorithms.sort

import com.shurikat.utils.SortAssert
import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
 * @author Alex Ivchenko
 */
open class SortTest(private val sorter: Sorter) {
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
        SortAssert.assertSorted(a)
    }
}