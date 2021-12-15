package ch7.ch4


data class DataPoint(val x: Int, val y: Int)
class Point(val x: Int, val y: Int) {
    operator fun component1(): Int = x
    operator fun component2(): Int = y
}

fun main(args: Array<String>) {
    // data class
    val dp = DataPoint(10, 20)

    val (dx, dy) = dp
    val da = dp.component1()
    val db = dp.component2()

    println(dx == da)
    println(dy == db)

    // class with component
    val p = DataPoint(10, 20)

    val (x, y) = p
    val a = dp.component1()
    val b = dp.component2()

    println(x == a)
    println(y == b)

    // destructuring declaration of collection
    val arr = intArrayOf(1,2,3,4,5,6,7)
    val (a1,a2,a3,a4,a5) = arr
    println("$a1 $a2 $a3 $a4 $a5")
}