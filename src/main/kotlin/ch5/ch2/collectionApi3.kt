package ch5.ch2


/**
 * groupBy
 */
fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 31), Person("Bob", 29), Person("Chris", 31))

    val groupByAge = people.groupBy { it.age }
    println(groupByAge)
}