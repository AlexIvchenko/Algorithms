package com.shurikat.algorithms.sort

import com.shurikat.types.Measurable

/**
 * @author Alex Ivchenko
 */
object InversionsCounter {
    fun <T: Comparable<T>> inversions(a: Array<T>): Int {
        return mergeSortWithCountInversions(a.copyOf(), 0, a.size - 1)
    }

    private fun <T : Comparable<T>> mergeSortWithCountInversions(a: Array<T>, p: Int, r: Int): Int {
        if (p >= r) {
            return 0
        }
        val q = (p + r) / 2
        var inversions = 0
        inversions += mergeSortWithCountInversions(a, p, q)
        inversions += mergeSortWithCountInversions(a, q + 1, r)
        inversions += mergeAndCountInversions(a, p, q, r)
        return inversions
    }
}

fun <T : Comparable<T>> mergeAndCountInversions(a: Array<T>, p: Int, q: Int, r: Int): Int {
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
    var inversions = 0
    for (k in p..r) {
        if (left[i] < right[j]) {
            a[k] = left[i++].value!!
        } else {
            a[k] = right[j++].value!!
            inversions += left.size - 1 - i
        }
    }
    return inversions
}