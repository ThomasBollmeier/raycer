package de.tbollmeier.raycer.core

interface Canvas {

    fun getWidth(): Int
    fun getHeight(): Int
    fun getPixel(x: Int, y: Int): Color
    fun setPixel(x: Int, y: Int, color: Color)

}