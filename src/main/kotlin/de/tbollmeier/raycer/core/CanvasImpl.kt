package de.tbollmeier.raycer.core

class CanvasImpl private constructor(
    private val height: Int,
    private val width: Int
): Canvas {

    companion object {

        fun create(height: Int, width: Int) : Canvas =
            CanvasImpl(height, width)

    }

    private val pixels: Array<Array<Color>> =
        Array(height) { Array(width) { Color(0.0, 0.0, 0.0)} }

    override fun getWidth() = width

    override fun getHeight() = height

    override fun getPixel(x: Int, y: Int) = pixels[y][x]

    override fun setPixel(x: Int, y: Int, color: Color) {
        pixels[y][x] = color
    }

}