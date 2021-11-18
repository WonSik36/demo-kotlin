package ch4.ch1

sealed class Expr {}
class Num(val value: Int): Expr()
class Sum(val left: Expr, val right: Expr): Expr()

fun eval(e: Expr): Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
    }

fun main(args: Array<String>) {
    val expr = Sum(Sum(Num(1), Num(2)), Num(5))

    println(eval(expr))
}