package com.shurikat.algorithms.sort

/**
 * @author Alex Ivchenko
 */
fun <T> Array<T>.swap(i: Int, j: Int) {
    val tmp = this[i]
    this[i] = this[j]
    this[j] = tmp
}