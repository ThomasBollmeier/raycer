package de.tbollmeier.raycer.core

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.math.abs

internal class VectorTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    operator fun unaryMinus() {

        val v = Vector(1.0, 2.0, 3.0)
        val exp = Vector( -1.0, -2.0, -3.0)

        assertTrue(exp.isEqualTo(-v))
    }

    @Test
    fun plus() {

        val v1 = Vector(1.0, 2.0, 3.0)
        val v2 = -v1
        val act = v1 + v2
        val exp = Vector( 0.0, 0.0, 0.0)

        assertTrue(exp.isEqualTo(act))
    }

    @Test
    fun testPlus() {

        val v = Vector(1.0, 2.0, 3.0)
        val pt = Vector(-1.0, -2.0, -3.0)
        val act = v + pt
        val exp = Vector( 0.0, 0.0, 0.0)

        assertTrue(exp.isEqualTo(act))
    }

    @Test
    fun minus() {

        val v = Vector(1.0, 2.0, 3.0)
        val act = v - v
        val exp = Vector( 0.0, 0.0, 0.0)

        assertTrue(exp.isEqualTo(act))
    }

    @Test
    fun times() {

        val v = Vector(1.0, 2.0, 3.0)
        val act = 2.0 * v
        val exp = Vector( 2.0, 4.0, 6.0)

        assertTrue(exp.isEqualTo(act))
    }

    @Test
    fun div() {

        val v = Vector(1.0, 2.0, 3.0)
        val act = v / -2.0
        val exp = Vector( -0.5, -1.0, -1.5)

        assertTrue(exp.isEqualTo(act))
    }

    @Test
    fun dot() {

        val v1 = Vector(1.0, 0.0, 1.0)
        val v2 = Vector(2.0, 1.0, -1.0)
        val act = v1.dot(v2)
        val exp = 1.0

        assertTrue(abs(exp - act) <= EPS)
    }

    @Test
    fun cross() {

        val v1 = Vector(1.0, 0.0, 0.0)
        val v2 = Vector(0.0, 1.0, 0.0)
        val act = v1.cross(v2)
        val exp = Vector(0.0, 0.0, 1.0)

        assertTrue(exp.isEqualTo(act))
    }

    @Test
    fun normalize() {

        val v = Vector(3.0, 4.0, 0.0)
        val exp = Vector(0.6, 0.8, 0.0)

        assertTrue(exp.isEqualTo(v.norm()))
    }

}