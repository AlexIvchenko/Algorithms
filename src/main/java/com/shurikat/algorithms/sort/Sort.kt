package com.shurikat.algorithms.sort

/**
 * @author Alex Ivchenko
 */
interface Sorter {
    fun <T : Comparable<T>> sort(a: Array<T>)
}

object InsertionSort : Sorter {
    override fun <T : Comparable<T>> sort(a: Array<T>) {
        val n = a.size
        for (j in 0 until n) {
            val key = a[j]
            var i = j
            while (i > 0 && a[i] < a[i - 1]) {
                a[i] = a[i - 1]
                --i
            }
            a[i] = key
        }
    }
}

object SelectionSort : Sorter {
    override fun <T : Comparable<T>> sort(a: Array<T>) {
        val n = a.size
        for (j in 0 until n - 1) {
            var minI = j
            for (i in j + 1 until n) {
                if (a[i] < a[minI]) {
                    minI = i
                }
            }
            val t = a[j]
            a[j] = a[minI]
            a[minI] = t
        }
    }
}