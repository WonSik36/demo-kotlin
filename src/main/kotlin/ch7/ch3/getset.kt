package ch7.ch3

data class Point(val x: Int, val y: Int)
operator fun Point.get(index: Int): Int =
    when(index) {
        0 -> x
        1 -> y
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }

data class MutablePoint(var x: Int, var y: Int)
operator fun MutablePoint.set(index: Int, value: Int) =
    when(index) {
        0 -> x = value
        1 -> y = value
        else -> throw IndexOutOfBoundsException("Invalid coordinate $index")
    }

fun main(args: Array<String>) {
    val p = Point(10,20)
    println(p[0])

    val mp = MutablePoint(10, 20)
    mp[0] = 120
    println(mp)
}