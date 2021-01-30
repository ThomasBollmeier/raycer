package de.tbollmeier.raycer.core

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class PointTest {

    @Test
    fun equality() {

        val p = Point(1.0, 2.0, 3.0)
        val v = Vector(1.0, 2.0, 3.0)
        val p2 = Point(1.0, 2.0, 3.0)
        val v2 = Vector(1.0, 2.0, 3.0)

        assertFalse(p.isEqualTo(v))
        assertTrue(p.isEqualTo(p2))
        assertTrue(v.isEqualTo(v2))
    }

    @Test
    fun plus() {

        val p = Point(2.0, -3.0, 5.0)
        val v = Vector(1.0, 3.0, -4.0)
        val v2 = Vector(2.0, -3.0, 5.0)

        val exp = Point(3.0, 0.0, 1.0)

        assertTrue(exp.isEqualTo(p + v))
        assertTrue(exp.isEqualTo(v + p))
        assertFalse(exp.isEqualTo(v + v2))
    }

    @Test
    fun minus() {
    }

}