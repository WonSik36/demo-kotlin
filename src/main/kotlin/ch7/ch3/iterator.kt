package ch7.ch3

import java.time.LocalDate

operator fun ClosedRange<LocalDate>.iterator(): Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current = start

        override fun hasNext(): Boolean {
            return current <= endInclusive
        }

        override fun next(): LocalDate {
            return current.apply { current = plusDays(1) }
        }

    }

fun main(args: Array<String>) {
    for(c in "abc") {
        println(c)
    }

    val newYear = LocalDate.ofYearDay(2022, 1)
    val dayOff = newYear.minusDays(1)..newYear
    for(day in dayOff) {
        println(day)
    }
}