package com.shurikat.algorithms.sort

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

/**
 * @author Alex Ivchenko
 */
class OrderStatisticKtTest {
    @Test(expected = IllegalArgumentException::class)
    fun givenOrderLessThanZero_whenFindOrderStatistic_thenException() {
        val a = arrayOf(3, 2, 1)
        OrderStatistic.find2Way(a, -1)
        OrderStatistic.find3Way(a, -1)
    }

    @Test(expected = IllegalArgumentException::class)
    fun givenOrderGreaterThanArraySize_whenFindOrderStatistic_thenException() {
        val a = arrayOf(3, 2, 1)
        OrderStatistic.find2Way(a, 3)
        OrderStatistic.find3Way(a, 3)
    }

    @Test
    fun givenSingletonArray_whenFindOrderStatistic_thenReturnCorrectElement() {
        val a = arrayOf(1)
        assertEquals(1, OrderStatistic.find2Way(a, 0))
        assertEquals(1, OrderStatistic.find3Way(a, 0))
    }

    @Test
    fun givenArray_whenFindOrderStatisticForEveryOrder_thenReturnAllCorrectElements() {
        val random = Random(0)
        val size = 1000
        val unsorted = Array(size, { _ ->  random.nextInt() })
        val sorted = Arrays.copyOf(unsorted, size)
        Arrays.sort(sorted)
        for (k in 0 until size) {
            assertEquals(sorted[k], OrderStatistic.find3Way(unsorted, k))
            assertEquals(sorted[k], OrderStatistic.find3Way(unsorted, k))
        }
    }

    @Test
    fun givenArray_whenFindOrderStatisticOnSegment_thenReturnCorrectElements() {
        val unsorted = generate(1000)
        val sorted = copy(unsorted)
        Arrays.sort(sorted)
        val elems = OrderStatistic.find3Way(unsorted, 100, 300)
        for (i in 0 until elems.size) {
            assertEquals(sorted[100 + i], elems[i])
        }
    }

    private fun copy(a: Array<Int>): Array<Int> {
        return Arrays.copyOf(a, a.size)
    }

    private fun generate(n: Int): Array<Int> {
        val random = Random(0)
        return Array(n, { _ ->  random.nextInt() })
    }
}