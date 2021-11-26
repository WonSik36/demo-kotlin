package ch5.ch1

fun salute() = println("Salute!")
fun Person.isAudit() = age >= 21

fun main(args: Array<String>) {
    val getAge1 = {p: Person -> p.age}
    val getAge2 = Person::age

    val people = listOf(Person("alice", 10), Person("bob", 11), Person("chris", 12))
    println(people.maxByOrNull(getAge1))
    println(people.maxByOrNull(getAge2))
    println(people.maxByOrNull(Person::age))

    run(::salute)
    val predicate = Person::isAudit
    val p = Person("Dmitry", 34)
    val dmitryAgeFunction = p::age
    println(dmitryAgeFunction())
}
