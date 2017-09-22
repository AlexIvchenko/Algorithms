package com.shurikat.algorithms.types

import com.shurikat.types.Measurable
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * @author Alex Ivchenko
 */
class MeasurableTest {
    @Test
    fun givenNormalEqualValues_whenCompare_thenMeasurablesAreEqual() {
        val normal1 = Measurable.of(1)
        val normal2 = Measurable.of(1)
        assertTrue { normal1 == normal2 }
        assertTrue { normal2 == normal1 }
        assertEquals(0, normal1.compareTo(normal2))
    }

    @Test
    fun givenTwoPosInfinities_whenCompare_thenMeasurablesAreEqual() {
        val pos1 = Measurable.posInfinity<Int>()
        val pos2 = Measurable.posInfinity<Int>()
        assertTrue { pos1 == pos2 }
        assertTrue { pos1 == pos2 }
        assertEquals(0, pos1.compareTo(pos2))
    }

    @Test
    fun givenTwoNegInfinities_whenCompare_thenMeasurablesAreEqual() {
        val neg1 = Measurable.negInfinity<Int>()
        val neg2 = Measurable.negInfinity<Int>()
        assertTrue { neg1 == neg2 }
        assertTrue { neg2 == neg1 }
        assertTrue { neg1.compareTo(neg2) == 0 }
    }

    @Test
    fun givenNormalUnequalValuesAndFirstOneIsGreater_whenCompare_thenFirstMeasurableIsGreater() {
        val normal1 = Measurable.of(2)
        val normal2 = Measurable.of(1)
        assertTrue { normal1 > normal2 }
        assertTrue { normal2 < normal1 }
    }

    @Test
    fun givenFirstAsPosInfinityAndSecondAsNormalValue_whenCompare_thenFirstMeasurableIsGreater() {
        val pos = Measurable.posInfinity<Int>()
        val normal = Measurable.of(1)
        assertTrue { pos > normal }
        assertTrue { normal < pos }
    }

    @Test
    fun givenFirstAsNegInfinityAndSecondAsNormalValue_whenCompare_thenSecondMeasurableIsGreater() {
        val neg = Measurable.negInfinity<Int>()
        val normal = Measurable.of(1)
        assertTrue { neg < normal }
        assertTrue { normal > neg }
    }

    @Test
    fun givenPosInfinityAndNegInfinity_whenCompare_thenFirstMeasurableIsGreater() {
        val pos = Measurable.posInfinity<Int>()
        val neg = Measurable.negInfinity<Int>()
        assertTrue { pos > neg }
        assertTrue { neg < pos }
    }

    @Test
    fun givenIntValue_whenToString_thenInt() {
        val v = Measurable.of(1)
        assertEquals("1", v.toString())
    }

    @Test
    fun givenPosInfinity_whenToString_thenPosInfinity() {
        val v = Measurable.posInfinity<Int>()
        assertEquals("Positive Infinity", v.toString())
    }

    @Test
    fun givenNegInfinity_whenToString_thenNegInfinity() {
        val v = Measurable.negInfinity<Int>()
        assertEquals("Negative Infinity", v.toString())
    }
}