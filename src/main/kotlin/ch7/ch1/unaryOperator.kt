package ch7.ch1

import java.math.BigDecimal

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE

fun main(args: Array<String>) {
    val p = Point(10, 20)

    val minusP = -p
    println(minusP)

    var bd = BigDecimal.ZERO
    println(bd++)
    println(++bd)
    println(bd)
}
