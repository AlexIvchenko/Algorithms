package com.shurikat.algorithms.sort

/**
 * @author Alex Ivchenko
 */
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
}


fun <T : Comparable<T>> partition(a: Array<T>, l: Int, r: Int): Int {
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

fun <T: Comparable<T>> triplePartition(a: Array<T>, l: Int, r: Int): Pair<Int, Int> {
    var lt = l
    var gt = r
    val v = a[l]
    var i = l
    while (i <= gt) {
        when {
            a[i] < v -> a.swap(lt++, i++)
            a[i] > v -> a.swap(i, gt--)
            else -> i++
        }
    }
    return Pair(lt, gt)
}