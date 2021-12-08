package ch6.ch3

fun addValidNumbers(numbers: List<Int?>) {
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.size}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")
}

fun main(args: Array<String>) {
    val numbers = listOf(1,2,null,4)

    addValidNumbers(numbers)
}