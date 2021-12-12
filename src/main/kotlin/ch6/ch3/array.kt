package ch6.ch3

fun main(args: Array<String>) {
    val arr: Array<Int> = arrayOf(1, 2, 3)
    for (i in arr.indices) {
        println("arr[$i] = ${arr[i]}")
    }

    val nullArr: Array<Int?> = arrayOfNulls(3)
    println("null array contains ${nullArr.size} nulls")

    val arrayWithLambda: Array<Char> = Array(26) { (it + 'A'.code).toChar() }
    println(arrayWithLambda.joinToString(" "))

    // Collection -> Array
    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))

    // IntArray, ByteArray, CharArray, BooleanArray, DoubleArray -> int[], byte[], char[], boolean[], double[]
    val fiveZeros = IntArray(5)
    val fiveZerosToo = intArrayOf(0, 0, 0, 0, 0)
    val squares = IntArray(5) { (it + 1) * (it + 1) }
    println(squares.joinToString(", "))
}