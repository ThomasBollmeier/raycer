package de.tbollmeier.raycer.core

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

internal class CanvasImplTest {

    private lateinit var cut: Canvas

    @BeforeEach
    fun setUp() {
        cut = CanvasImpl.create(10,20)
    }

    @Test
    fun getWidth() {
        assertEquals(10, cut.getWidth())
    }

    @Test
    fun getHeight() {
        assertEquals(20, cut.getHeight())
    }

    @Test
    fun getPixel() {
        val h = cut.getHeight()
        val w = cut.getWidth()
        val black = Color(0.0, 0.0, 0.0)
        for (y in 0 until h) {
            for (x in 0 until w) {
                assertTrue(cut.getPixel(x, y).isEqualTo(black))
            }
        }
    }

    @Test
    fun setPixel() {
        val h = cut.getHeight()
        val w = cut.getWidth()
        val red = Color(1.0, 0.0, 0.0)
        val black = Color(0.0, 0.0, 0.0)
        cut.setPixel(2, 3, red)
        for (y in 0 until h) {
            for (x in 0 until w) {
                if (x != 2 || y != 3) {
                    assertTrue(cut.getPixel(x, y).isEqualTo(black))
                } else {
                    assertTrue(cut.getPixel(x, y).isEqualTo(red))
                }
            }
        }
    }

    @Test
    fun setBackground() {

        val blue = Color(blue = 1.0)
        cut.setBackground(blue)

        val h = cut.getHeight()
        val w = cut.getWidth()

        for (y in 0 until h) {
            for (x in 0 until w) {
                assertTrue(cut.getPixel(x, y).isEqualTo(blue))
            }
        }



    }
}