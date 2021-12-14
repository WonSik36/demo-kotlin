package ch7.ch3

import java.time.LocalDate

fun main(args: Array<String>) {
    val now = LocalDate.now()
    val vacation: ClosedRange<LocalDate> = now..now.plusDays(10)    // public operator fun <T : Comparable<T>> T.rangeTo(that: T): ClosedRange<T>

    println(now.plusDays(7) in vacation)

    val n = 9
    (0..n).forEach { println(it) }
}