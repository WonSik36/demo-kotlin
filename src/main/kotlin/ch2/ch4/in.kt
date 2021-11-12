package ch2.ch4

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isDigit(c: Char) = c in '0'..'9'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun recognize1(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know.."
}

fun recognize2(c: Char) = when {
    c in '0'..'9' -> "It's a digit!"
    c in 'a'..'z'|| c in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know.."
}

fun recognize3(c: Char) = when {
    isDigit(c) -> "It's a digit!"
    isLetter(c) -> "It's a letter!"
    else -> "I don't know.."
}

fun main(args: Array<String>) {
    println(recognize1('8'))
    println(recognize2('c'))
    println(recognize3('*'))

    println("Kotlin" in "Java".."Scala")
    println("Kotlin" >= "Java" && "Kotlin" <= "Scala")

    println("Kotlin" in setOf("Java", "Scala"))
    println("Kotlin".equals("Java") || "Kotlin" == "Scala")
}