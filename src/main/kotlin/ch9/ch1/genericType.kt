package ch9.ch1

import java.lang.Appendable

val <T> List<T>.penultimate: T
    get() = this[size - 2]

fun main(args: Array<String>) {
    // 9.1 Generic Type Inference
    val authors = listOf("Alice", "Bob")
    val readers1: MutableList<String> = mutableListOf()
    val readers2 = mutableListOf<String>()

    // 9.1.1 Generic Function & Property
    // fun <T> List<T>.slice(indices: IntRange): List<T>
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))
    println(letters.slice(10..12))

    println(letters.penultimate)

    // 9.1.2 Generic Type Declaration
    //class StringList: List<String> {}
    //class ChildList<T>: List<T> {}

    // 9.1.3 Type Parameter Constraint
    // fun <T: Number> List<T>.sum(): T
    val helloWorldByKotlin = StringBuilder("Hello world")
    ensureTrailingPeriod(helloWorldByKotlin)
    println(helloWorldByKotlin)

    val helloWorldByJava = StringBuilder("Hello world")
    Chapter3.ensureTrailingPeriod(helloWorldByJava)
    println(helloWorldByJava)
}

fun <T> ensureTrailingPeriod(seq: T): Unit where T: CharSequence, T: Appendable {
    if(!seq.endsWith(".")) {
        seq.append(".")
    }
}

// 9.1.4 Type Parameter can be Null
class Processor1<T> {   // same with class Processor1<T: Any?>
    fun process(value: T): Int {
        return value?.hashCode() ?: 0
    }
}

class Processor2<T: Any> {
    fun process(value: T): Int {
        return value.hashCode()
    }
}
