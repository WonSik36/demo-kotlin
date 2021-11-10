package ch2

interface Expr
class Num(val value: Int): Expr
class Sum(val left: Expr, val right: Expr): Expr

fun evalWithJavaStyle(e: Expr): Int {
    if (e is Num) {
        return e.value
    }

    if (e is Sum) {
        return evalWithJavaStyle(e.left) + evalWithJavaStyle(e.right)
    }

    throw IllegalArgumentException("Unknown expression")
}

fun main(args: Array<String>) {

    val expr = Sum(Sum(Num(1), Num(2)), Num(3))

    val result1 = evalWithJavaStyle(expr)
    println("Result: $result1")

    val result2 = evalWithKotlinStyle(expr)
    println("Result: $result2")

    val result3 = evalWithWhen1(expr)
    println("Result: $result3")

    val result4 = evalWithWhen2(expr)
    println("Result: $result4")

    val result5 = evalWithLogging(expr)
    println("Result: $result5")
}

fun evalWithKotlinStyle(e: Expr): Int =
    if (e is Num) {
        e.value
    } else if (e is Sum) {
        evalWithKotlinStyle(e.left) + evalWithKotlinStyle(e.right)
    } else {
        throw IllegalArgumentException("Unknown expression")
    }

fun evalWithWhen1(e: Expr): Int =
    when (e) {
        is Num -> e.value
        is Sum -> evalWithWhen1(e.left) + evalWithWhen1(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun evalWithWhen2(e: Expr): Int =
    when {
        e is Num -> e.value
        e is Sum -> evalWithWhen2(e.left) + evalWithWhen2(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

fun evalWithLogging(e: Expr): Int =
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            left + right
        }
        else -> throw IllegalArgumentException("Unknown expression")
    }