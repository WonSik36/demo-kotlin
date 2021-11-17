package ch3.ch3

fun main(args: Array<String>) {
    /* Collection API */
    val strings: List<String> = listOf("first", "second", "fourteenth")
    println(strings.last())

    val numbers: Collection<Int> = setOf(1, 14, 2)
    println(numbers.maxOrNull())

    /* Variable Argument */
    println(strListOf1("Hello", "Java"))
    println(strListOf2(arrayOf("Hello", "Kotlin")))

    /* Infix call */
    println(1.to("one"))
    println(1 to "one")

    /* Destructing Declaration */
    val (number, name) = 1 to "one"
    println("$number $name")
}

fun strListOf1(vararg values: String): List<String> = listOf(*values)
fun strListOf2(values: Array<String>): List<String> = listOf(*values)