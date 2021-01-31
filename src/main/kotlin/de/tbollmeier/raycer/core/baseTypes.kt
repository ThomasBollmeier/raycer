package de.tbollmeier.raycer.core

import kotlin.math.abs
import kotlin.math.sqrt

open class Tuple3D(val x: Double, val y: Double, val z: Double) {

    fun isEqualTo(other: Any?): Boolean {

        return if (other != null) {
            if (other::class == this::class) {
                val tuple = other as Tuple3D
                abs(x - tuple.x) <= EPS && abs(y - tuple.y) <= EPS && abs(z - tuple.z) <= EPS
            } else {
                false
            }
        } else {
            false
        }
    }

}

class Point(x: Double, y: Double, z: Double) : Tuple3D(x, y, z) {

    operator fun unaryMinus() = Point(-x, -y, -z)

    operator fun plus(v: Vector) = Point(x + v.x, y + v.y, z + v.z)

    operator fun minus(pt: Point) = Vector(x - pt.x, y - pt.y, z - pt.z)

}

class Vector(x: Double, y: Double, z: Double) : Tuple3D(x, y, z) {

    operator fun unaryMinus() = Vector(-x, -y, -z)

    operator fun plus(pt: Point) = Point(x + pt.x, y + pt.y, z + pt.z)

    operator fun plus(v: Vector) = Vector(x + v.x, y + v.y, z + v.z)

    operator fun minus(v: Vector) = Vector(x - v.x, y - v.y, z - v.z)

    operator fun times(factor: Double) = Vector(factor * x, factor * y, factor * z)

    operator fun div(quot: Double) = Vector( x / quot, y / quot, z / quot)

    fun dot(v: Vector) = x * v.x + y * v.y + z * v.z

    fun cross(v: Vector) = Vector(y * v.z - z * v.y, z * v.x - x * v.z, x * v.y - y * v.x)

    fun length() = sqrt(x * x + y * y + z * z)

    fun norm() = this / length()

}

operator fun Double.times(v: Vector) = Vector(this * v.x, this * v.y, this * v.z)