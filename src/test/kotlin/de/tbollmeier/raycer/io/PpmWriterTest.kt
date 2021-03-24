package de.tbollmeier.raycer.io

import de.tbollmeier.raycer.core.CanvasImpl
import de.tbollmeier.raycer.core.Color
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class PpmWriterTest {

    @Test
    fun createFileContent() {

        val writer = PpmWriter()
        val canvas = CanvasImpl.create(10, 2)
        canvas.setBackground(Color(1.0, 0.8, 0.6))

        val exp = """
            P3
            10 2
            255
            255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204
            153 255 204 153 255 204 153 255 204 153 255 204 153
            255 204 153 255 204 153 255 204 153 255 204 153 255 204 153 255 204
            153 255 204 153 255 204 153 255 204 153 255 204 153
            """.trimIndent()

        val act = writer.createFileContent(canvas).joinToString("\n")

        assertEquals(exp, act)
    }
}