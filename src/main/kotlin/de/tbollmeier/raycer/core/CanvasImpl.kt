package de.tbollmeier.raycer.core

class CanvasImpl private constructor(
    private val width: Int,
    private val height: Int
): Canvas {

    companion object {

        fun create(width: Int, height: Int) : Canvas =
            CanvasImpl(width, height)

    }

    private val pixels: Array<Array<Color>> =
        Array(height) { Array(width) { Color() } }

    override fun getWidth() = width

    override fun getHeight() = height

    override fun getPixel(x: Int, y: Int) = pixels[y][x]

    override fun setPixel(x: Int, y: Int, color: Color) {
        pixels[y][x] = color
    }

    override fun setBackground(color: Color) {
        for (y in 0 until height) {
            for (x in 0 until width) {
                pixels[y][x] = color
            }
        }
    }
}