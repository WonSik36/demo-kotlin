package ch7.ch2

fun main(args: Array<String>) {
    println("== -> a?.equals(b) ?: (b == null)")
    val a = "ab"
    var b = "a"
    b += "b"

    println(a == b)     // true
    println(a?.equals(b) ?: (b == null))    // == 은 null check 도 수행한다.
    println(a === b)    // false
    println()

    // override equals
    println("override equals")
    println(Point(10,20) == Point(10,20))
    println(null == Point(10,20))
    println(Point(10,20) != Point(10,20))
    println(Point(10,20) != Point(20,30))
}

class Point(val x: Int, val y: Int) {

    /* public open operator fun equals(other: Any?): Boolean */
    override fun equals(other: Any?): Boolean {
        if(other === this) return true
        if(other !is Point) return false

        return x == other.x && y == other.y
    }
}