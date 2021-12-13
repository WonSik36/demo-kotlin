package ch7.ch2

fun main(args: Array<String>) {
    val p1 = Person("Alice", "Smith")
    val p2 = Person("Bob", "Smith")

    println(p1 > p2)
    println(p1.compareTo(p2) > 0)
}

class Person(val firstName: String, val lastName: String): Comparable<Person> {
    override fun compareTo(other: Person): Int {
        return compareValuesBy(this, other, Person::lastName, Person::firstName)
    }
}