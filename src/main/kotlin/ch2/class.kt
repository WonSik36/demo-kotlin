package ch2

class Person(val name: String, var isMarried: Boolean)

fun main(args: Array<String>) {
    val person = Person("Bob", false)
    println("Name: ${person.name}, isMarried: ${person.isMarried}")

    person.isMarried = true
    println("Name: ${person.name}, isMarried: ${person.isMarried}")
}
