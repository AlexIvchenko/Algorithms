package com.shurikat.utils

/**
 * @author Alex Ivchenko
 */
fun <T : Comparable<T>> assertSorted(a: Array<T>) {
    (1 until a.size)
            .filter { a[it] < a[it - 1] }
            .forEach { throw AssertionError("not sorted ${it - 1}, $it: (${a[it - 1]}, ${a[it]})") }
}