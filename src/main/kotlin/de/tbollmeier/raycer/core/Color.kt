package de.tbollmeier.raycer.core

import kotlin.math.abs

class Color(val red: Double, val green: Double, val blue: Double) {

    fun isEqualTo(other: Color): Boolean {
        return abs(red - other.red) <= EPS && abs(green - other.green) <= EPS && abs(blue - other.blue) <= EPS
    }

    operator fun plus(other: Color) : Color {
        return Color(red + other.red, green + other.green, blue + other.blue)
    }

    operator fun minus(other: Color) : Color {
        return Color(red - other.red, green - other.green, blue - other.blue)
    }

    operator fun times(factor: Double) : Color {
        return Color(factor * red, factor * green, factor * blue)
    }

    fun hadamardProduct(other: Color) : Color {
        return Color(red * other.red, green * other.green, blue * other.blue)
    }

}

operator fun Double.times(color: Color) =
    Color(this * color.red, this * color.green, this * color.blue)
