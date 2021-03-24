package de.tbollmeier.raycer.io

import de.tbollmeier.raycer.core.Canvas
import de.tbollmeier.raycer.core.Color
import java.io.File

class PpmWriter {

    companion object {
        const val MAX_COLOR_VALUE = 255
        const val MAX_LINE_SIZE = 70
    }

    fun writePpmFile(filePath: String, canvas: Canvas) {

        File(filePath).printWriter().use {
            val lines = createFileContent(canvas)
            for (line in lines) {
                it.println(line)
            }
        }

    }

    fun createFileContent(canvas: Canvas): List<String> {

        val ret = mutableListOf<String>()
        val width = canvas.getWidth()
        val height = canvas.getHeight()

        ret.add("P3")
        ret.add("$width $height")
        ret.add("$MAX_COLOR_VALUE")

        var line = ""

        for (y in 0 until height) {
            for (x in 0 until width) {
                val (red, green, blue) = colorStrings(canvas.getPixel(x, y))
                line = addToLine(line, " $red", ret)
                line = addToLine(line, " $green", ret)
                line = addToLine(line, " $blue", ret)
            }
            if (line.isNotEmpty()) {
                ret.add(line)
                line = ""
            }
        }

        return ret
    }

    private fun addToLine(line: String, newContent: String, lines: MutableList<String>) : String {
        return if ((line + newContent).length <= MAX_LINE_SIZE) {
            if (line.isNotEmpty())
                line + newContent
            else
                newContent.trimStart(' ')
        } else {
            lines.add(line)
            newContent.trimStart(' ')
        }
    }

    private fun colorStrings(c: Color) : List<String> {
        return listOf(
            colorString(c.red),
            colorString(c.green),
            colorString(c.blue)
        )
    }

    private fun colorString(colorValue: Double): String {
        return when {
            colorValue < 0.0 -> {
                "0"
            }
            colorValue > 1.0 -> {
                "$MAX_COLOR_VALUE"
            }
            else -> {
                "${(colorValue * MAX_COLOR_VALUE).toInt()}"
            }
        }
    }

}