package ch7.ch3

data class Rectangle(val upperLeft: Point, val lowerRight: Point) {
    operator fun contains(p: Point): Boolean {
        return p.x in upperLeft.x until lowerRight.x    // upperLeft.x <= () < lowerRight.x
                && p.y in upperLeft.y .. lowerRight.y   // upperLeft.x <= () <= lowerRight.x
    }
}

fun main(args: Array<String>) {
    val r = Rectangle(Point(10,20), Point(50, 50))

    println(Point(25,25) in r)
    println(Point(30,50) in r)
    println(Point(50,30) in r)
}