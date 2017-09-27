package com.shurikat.algorithms.sort

import com.shurikat.types.Measurable

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
}

object MergeSort : Sorter {
    override fun <T : Comparable<T>> sort(a: Array<T>) {
        mergeSort(a, 0, a.size - 1)
    }

    private fun <T : Comparable<T>> mergeSort(a: Array<T>, p: Int, r: Int) {
        if (p >= r) {
            return
        }
        val q = (p + r) / 2
        mergeSort(a, p, q)
        mergeSort(a, q + 1, r)
        merge(a, p, q, r)
    }

    private fun <T : Comparable<T>> merge(a: Array<T>, p: Int, q: Int, r: Int) {
        val n1 = q - p + 1
        val n2 = r - q
        val left = List(n1 + 1, { i ->
            if (i < n1) Measurable.of(a[p + i])
            else Measurable.posInfinity() // last element is fictive
        })
        val right = List(n2 + 1, { i ->
            if (i < n2) Measurable.of(a[q + 1 + i])
            else Measurable.posInfinity() // last element is fictive
        })
        var i = 0
        var j = 0
        for (k in p..r) {
            if (i < left.size && j < right.size) {
                a[k] = if (left[i] < right[j]) left[i++].value!! else right[j++].value!!
            }
        }
    }
}

object AnotherQuickSort : Sorter {
    override fun <T : Comparable<T>> sort(a: Array<T>) {
        quickSort(a, 0, a.size)
    }

    private fun <T : Comparable<T>> quickSort(a: Array<T>, l: Int, r: Int) {
        if (a.isEmpty()) {
            return
        }
        val cur = (l + r) / 2
        val key = a[cur]
        var i = l
        var j = r - 1
        while (i <= j) {
            while (a[i] < key) ++i
            while (a[j] > key) --j
            if (i <= j) {
                a.swap(i, j)
                ++i
                --j
            }
        }
        if (l < j) quickSort(a, l, j + 1)
        if (i < r) quickSort(a, i, r)
    }
}

object KormenQuickSort : Sorter {
    override fun <T : Comparable<T>> sort(a: Array<T>) {
        quickSort(a, 0, a.size - 1)
    }

    private fun <T : Comparable<T>> quickSort(a: Array<T>, l: Int, r: Int) {
        if (l >= r) {
            return
        }
        val p = partition(a, l, r)
        quickSort(a, l, p - 1)
        quickSort(a, p + 1, r)
    }

    private fun <T : Comparable<T>> partition(a: Array<T>, l: Int, r: Int): Int {
        val pivot = a[r]
        var i = l - 1
        for (j in l until r) {
            if (a[j] <= pivot) {
                a.swap(++i, j)
            }
        }
        a.swap(++i, r)
        return i
    }
}

private fun <T> Array<T>.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}