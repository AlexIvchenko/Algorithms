package com.shurikat.algorithms.sort

import java.util.*

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
            while (i > 0 && a[i - 1] > key) {
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

object QuickSort : Sorter {
    override fun <T : Comparable<T>> sort(a: Array<T>) {
        quickSort(a, 0, a.size)
    }

    private fun <T : Comparable<T>> quickSort(a: Array<T>, l: Int, r: Int) {
        if (l >= r) {
            return
        }
        val p = partition(a, l, r)
        quickSort(a, l, p)
        quickSort(a, p + 1, r)
    }

    private fun <T : Comparable<T>> partition(a: Array<T>, l: Int, r: Int): Int {
        val key = a[l]
        var bound = l
        for (i in l + 1 until r) {
            if (a[i] <= key) {
                a.swap(i, bound + 1)
                a.swap(bound, bound + 1)
                bound++
            }
        }
        return bound
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val a = arrayOf(3, 2, 1, 2, 3)
        QuickSort.quickSort(a, 0, a.size)
        println(Arrays.toString(a))
    }
}

private fun <T> Array<T>.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}