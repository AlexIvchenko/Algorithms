package com.shurikat.algorithms.sort

import java.util.*

/**
 * @author Alex Ivchenko
 */
object CountingSort {
    fun <T> sort(unsorted: Array<T>, keyExtractor: (T) -> Int): Array<T> {
        if (unsorted.isEmpty()) {
            return Arrays.copyOf(unsorted, 0)
        }
        val n = unsorted.size
        var min = keyExtractor(unsorted[0])
        var max = keyExtractor(unsorted[0])
        for (i in 1 until unsorted.size) {
            if (keyExtractor(unsorted[i]) < min) {
                min = keyExtractor(unsorted[i])
            }
            if (keyExtractor(unsorted[i]) > max) {
                max = keyExtractor(unsorted[i])
            }
        }
        val count = IntArray(max - min + 1)
        for (i in 0 until n) {
            count[keyExtractor(unsorted[i]) - min]++
        }
        for (i in 1 until max - min + 1) {
            count[i] += count[i - 1]
        }
        val sorted = Arrays.copyOf(unsorted, n)
        for (i in n - 1 downTo 0) {
            val key = keyExtractor(unsorted[i])
            sorted[count[key - min] - 1] = unsorted[i]
            count[key - min]--
        }
        return sorted
    }
}