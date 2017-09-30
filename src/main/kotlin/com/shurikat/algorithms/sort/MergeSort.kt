package com.shurikat.algorithms.sort

import com.shurikat.types.Measurable

/**
 * @author Alex Ivchenko
 */
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
}

fun <T : Comparable<T>> merge(a: Array<T>, p: Int, q: Int, r: Int) {
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
        a[k] = if (left[i] < right[j]) left[i++].value!! else right[j++].value!!
    }
}