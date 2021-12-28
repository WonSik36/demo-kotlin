package ch8.ch3

data class Person(val name: String, val age: Int)

fun lookForAliceByForLoop(people: List<Person>) {
    for (person in people) {
        if(person.name == "Alice") {
            println("Found")
            return
        }
    }

    println("Alice is not Found")
}

fun lookForAliceByForEach(people: List<Person>) {
    // inline function
    people.forEach {
        if (it.name == "Alice") {
            println("Found!")
            return
        }
    }

    println("Alice is not Found")
}

fun lookForAliceByForEachWithLabel(people: List<Person>) {
    // inline function
    people.forEach label@{
        if (it.name == "Alice") {
            println("Found!")
            return@label
        }
    }

    println("Alice might be somewhere")
}

fun lookForAliceByForEachNotInline(people: List<Person>) {
    // inline function
    people.forEachNotInline {
        if (it.name == "Alice") {
            println("Found!")

            // 'return' is not allowed here
            // return

            return@forEachNotInline
        }
    }

    println("Alice is not Found")
}

private fun <Person> List<Person>.forEachNotInline(action: (Person) -> Unit) {
    for (p in this) {
        action(p)
    }
}

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    lookForAliceByForLoop(people)    // 예상대로 동작

    lookForAliceByForEach(people)    // 예상대로 동작

    lookForAliceByForEachNotInline(people)  // 람다에 대해서만 리턴

    lookForAliceByForEachWithLabel(people)  // 람다에 대해서만 리턴
}