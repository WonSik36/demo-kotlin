package ch2

fun main(args: Array<String>) {
    val question = "answer to life the universe and everything"
    val answer = 42
    val answer2: Int = 42
    val yearsToCompute = 7.5e6
    val answer3: Int
    answer3 = 42

    var answer4 = 42
    // answer4 = "hello" // Type mismatch
    answer4 = 43

    val name = if (args.isNotEmpty()) args[0] else "Kotlin"
    println("Hello, $name")
    println("Hello, ${if (args.isNotEmpty()) args[0] else "Kotlin"}")
}