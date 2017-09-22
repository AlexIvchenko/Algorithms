package com.shurikat.types

/**
 * @author Alex Ivchenko
 */
class Measurable<T : Comparable<T>> private constructor(public val value: T?, private val state: State) : Comparable<Measurable<T>> {
    private enum class State {
        POS_INFINITY, NEG_INFINITY, NORMAL;

        override fun toString(): String {
            if (this == POS_INFINITY) {
                return "Positive Infinity"
            }
            if (this == NEG_INFINITY) {
                return "Negative Infinity"
            }
            if (this == NORMAL) {
                return "Normal Value"
            }
            throw UnsupportedOperationException("method toString is not supported for ${this.name}")
        }
    }

    override fun compareTo(other: Measurable<T>): Int {
        if (state == other.state && state != State.NORMAL) {
            return 0
        }
        if (this.state == State.POS_INFINITY || other.state == State.NEG_INFINITY) {
            return 1
        }
        if (this.state == State.NEG_INFINITY || other.state == State.POS_INFINITY) {
            return -1
        }
        return this.value!!.compareTo(other.value!!)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Measurable<*>

        if (value != other.value) return false
        if (state != other.state) return false

        return true
    }

    override fun hashCode(): Int {
        var result = value?.hashCode() ?: 0
        result = 31 * result + state.hashCode()
        return result
    }

    companion object {
        fun <P : Comparable<P>> of(priority: P): Measurable<P> {
            return Measurable(priority, State.NORMAL)
        }

        fun <P : Comparable<P>> posInfinity(): Measurable<P> {
            return Measurable(null, State.POS_INFINITY)
        }

        fun <P : Comparable<P>> negInfinity(): Measurable<P> {
            return Measurable(null, State.NEG_INFINITY)
        }
    }

    override fun toString(): String {
        return if (state == State.NORMAL) "$value" else state.toString()
    }
}