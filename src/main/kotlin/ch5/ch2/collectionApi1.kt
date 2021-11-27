package ch5.ch2


/**
 * filter, map
 */
fun main(args: Array<String>) {
    val list = listOf(1,2,3,4)
    println(list.filter { it % 2 == 0 })
    println(list.filter { it % 2 == 0 })

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    println(people.filter { it.age > 30 })
    println(people.map { it.name })
    println(people.map(Person::name))
    println(people.filter { it.age > 30 }.map(Person::age))

    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues{
        val after = it.value.uppercase()
        "before: ${it.value}, after: $after"
    }.mapKeys { it.key + 10 })
}