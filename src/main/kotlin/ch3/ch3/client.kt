package ch3.ch3

import ch3.ch3.extensions.firstChar
import ch3.ch3.extensions.join
import ch3.ch3.extensions.joinToString
import ch3.ch3.extensions.lastChar as last

fun main(args: Array<String>) {
    /* StringUtils */
    println("StringUtils")

    val str = "Kotlin"
    println(str.firstChar())
    println(str.last())

    val list = listOf(1,2,3)
    println(list.joinToString(separator = "; ", prefix = "(", postfix = ")"))
//    println(list.join())    // receiver type mismatch

    val list2 = listOf("Hello", "Kotlin")
    println(list2.join())


    /* StringBuilderUtils */
    println("StringBuilderUtils")

    val sb = StringBuilder("Kotlin?")
    sb.last = '!'

    println("First: ${sb.firstChar}, Last: ${sb.last}")
}