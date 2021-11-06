package ch1

data class Person(val name: String, val age: Int? = null)

fun main(args: Array<String>) {
    val persons: List<Person> = listOf(
        Person("영희"),
        Person("철수", age = 29)
    )

    val oldest = persons.maxByOrNull { it.age ?: 0 }
    println("나이가 가장 많은 사람: $oldest")
}