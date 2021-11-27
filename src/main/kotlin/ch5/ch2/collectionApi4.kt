package ch5.ch2


/**
 * flatMap, flatten
 */
fun main(args: Array<String>) {
    val books = listOf(Book("Book1", listOf("author1", "author2")), Book("Book2", listOf("author2", "author3")),)
    val authors = books.flatMap { it.authors }.toSet()
    println(authors)

    val listOfNumbers = listOf(listOf(1,2,3), listOf(2,3,4), listOf(3,4,5))
    val numbers = listOfNumbers.flatten().toSet()
    println(numbers)
}

data class Book(val title: String, val authors: List<String>)
