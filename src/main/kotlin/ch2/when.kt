package ch2.usingWhen

import ch2.Color2
import ch2.Color2.*
import java.lang.Exception

fun main(args: Array<String>) {
    println("Green: ${getMnemonic(GREEN)}")
    println("Orange: ${getWarmth(ORANGE)}")
    println("RED + YELLOW = ${mix(RED, YELLOW)}")
    println("YELLOW + BLUE = ${mixOptimized(YELLOW, BLUE)}")

    try {
        mix(RED, BLUE)
    } catch (ex: Exception) {
        assert(ex.message == "Dirty Color")
        println("RED + BLUE = ${ex.message}")
    }
}

fun getMnemonic(color: Color2) =
    when (color) {
        RED -> "Richard"
        Color2.ORANGE -> "Of"
        YELLOW -> "York"
        Color2.GREEN -> "Gave"
        Color2.BLUE -> "Battle"
        Color2.INDIGO -> "In"
        Color2.VIOLET -> "Vain"
    }

fun getWarmth(color: Color2) =
    when (color) {
        RED, ORANGE, YELLOW -> "warm"
        GREEN -> "neutral"
        BLUE, INDIGO, VIOLET -> "cold"
    }

fun mix(c1: Color2, c2: Color2) =
    when (val mixed = setOf(c1,c2)) {
        setOf(RED, YELLOW) -> ORANGE
        setOf(YELLOW, BLUE) -> GREEN
        setOf(BLUE, VIOLET) -> INDIGO
        else -> throw Exception("Dirty Color")
    }

fun mixOptimized(c1: Color2, c2: Color2) =
    when {
        (c1 == RED && c2 == YELLOW) || (c1 == YELLOW && c2 == RED) -> ORANGE
        (c1 == YELLOW && c2 == BLUE) || (c1 == BLUE && c2 == YELLOW) -> GREEN
        (c1 == VIOLET && c2 == BLUE) || (c1 == BLUE && c2 == VIOLET) -> INDIGO
        else -> throw Exception("Dirty Color")
    }