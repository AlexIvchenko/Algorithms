package com.shurikat.algorithms.sort

/**
 * @author Alex Ivchenko
 */
object OrderStatistic {
    fun <T : Comparable<T>> find3Way(a: Array<T>, k1: Int, k2: Int): List<T> {
        val elems = mutableListOf<T>()
        find3Way(elems, a, k1, k2, 0, a.size - 1)
        return elems
    }

    private fun <T : Comparable<T>> find3Way(elems: MutableList<T>, a: Array<T>, k1: Int, k2: Int, left: Int, right: Int) {
        val (less, greater) = triplePartition(a, left, right)
        if (k1 < less) {
            find3Way(elems, a, k1, Math.min(k2, less - 1), left, less - 1)
        }
        for (k in Math.max(less, k1)..Math.min(k2, greater)) {
            elems.add(a[k])
        }
        if (k2 > greater) {
            find3Way(elems, a, Math.max(greater + 1, k1), k2, greater + 1, right)
        }
    }

    fun <T : Comparable<T>> find2Way(a: Array<T>, k: Int): T {
        checkArgs(a, k)
        var left = 0
        var right = a.size - 1
        while (true) {
            val mid = partition(a, left, right)
            if (mid == k) {
                return a[mid]
            }
            if (mid > k) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
    }

    fun <T : Comparable<T>> find3Way(a: Array<T>, k: Int): T {
        var left = 0
        var right = a.size - 1
        while (true) {
            val (less, greater) = triplePartition(a, left, right)
            if (k in less..greater) {
                return a[less]
            }
            if (less > k) {
                right = less - 1
            } else {
                left = greater + 1
            }
        }
    }

    private fun <T : Comparable<T>> checkArgs(a: Array<T>, k: Int) {
        if (k < 0 || k >= a.size) {
            throw IllegalArgumentException("k must be from 0 to array size, a.size = ${a.size}, k = $k")
        }
    }
}