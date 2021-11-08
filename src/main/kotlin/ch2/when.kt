package ch2.usingWhen

import ch2.Color2
import ch2.Color2.*

fun main(args: Array<String>) {
    println("Green: ${getMnemonic(GREEN)}")
    println("Orange: ${getWarmth(ORANGE)}")
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