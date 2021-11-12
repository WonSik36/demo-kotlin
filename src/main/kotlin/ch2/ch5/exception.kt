package ch2.ch5

import java.io.BufferedReader
import java.lang.IllegalArgumentException

fun percentage(number: Int) =
    if (number in (0..100) as Iterable<Int>)
        number
    else
        throw IllegalArgumentException("퍼센트는 0 과 100 사이의 수여야 한다.: $number")

fun readNumber1(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (ex: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

fun readNumber2(reader: BufferedReader) =
    try {
        Integer.parseInt(reader.readLine())
    } catch (ex: NumberFormatException) {
        null
    } finally {
        reader.close()
    }
