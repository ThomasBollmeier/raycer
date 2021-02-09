package de.tbollmeier.raycer.core

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class ColorTest {

    @BeforeEach
    fun setUp() {
    }

    @AfterEach
    fun tearDown() {
    }

    @Test
    fun plus() {

        val c1 = Color(0.9, 0.6, 0.75)
        val c2 = Color(0.7, 0.1, 0.25)
        val act = c1 + c2
        val exp = Color(1.6, 0.7, 1.0)

        assertTrue(exp.isEqualTo(act))

    }

    @Test
    fun subtract() {

        val c1 = Color(0.9, 0.6, 0.75)
        val c2 = Color(0.7, 0.1, 0.25)
        val act = c1 - c2
        val exp = Color(0.2, 0.5, 0.5)

        assertTrue(exp.isEqualTo(act))

    }

    @Test
    fun multiply() {

        val c = Color(0.9, 0.6, 0.75)
        val act1 = c * 2.0
        val act2 = 2.0 * c
        val exp = Color(1.8, 1.2, 1.5)

        assertTrue(exp.isEqualTo(act1))
        assertTrue(exp.isEqualTo(act2))

    }
}