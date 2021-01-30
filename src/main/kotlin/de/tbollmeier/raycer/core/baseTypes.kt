package de.tbollmeier.raycer.core

import kotlin.math.abs

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

    operator fun plus(t: Tuple3D) = Point(x + t.x, y + t.y, z + t.z)

    operator fun minus(pt: Point) = Point(x - pt.x, y - pt.y, z - pt.z)

}

class Vector(x: Double, y: Double, z: Double) : Tuple3D(x, y, z) {

    operator fun plus(pt: Point) = Point(x + pt.x, y + pt.y, z + pt.z)

    operator fun plus(vec: Vector) = Vector(x + vec.x, y + vec.y, z + vec.z)

    operator fun minus(vec: Vector) = Vector(x - vec.x, y - vec.y, z - vec.z)

}