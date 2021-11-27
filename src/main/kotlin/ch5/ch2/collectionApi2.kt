package ch5.ch2


/**
 * all, any, count, find
 */
fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 27), Person("Bob", 31))

    val canBeInClub27: (Person) -> Boolean = { p: Person -> p.age <= 27 }
    println(people.all(canBeInClub27))
    println(people.any(canBeInClub27))
    println(people.count(canBeInClub27))
    println(people.find(canBeInClub27))
    println(people.firstOrNull(canBeInClub27))
}