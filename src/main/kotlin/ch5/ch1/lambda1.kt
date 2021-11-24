package ch5.ch1

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>): Person? {
    var maxAge = 0
    var theOldest: Person? = null

    for(person in people) {
        if(person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }

    return theOldest
}

fun main(args: Array<String>) {
    val people = listOf(Person("alice", 10), Person("bob", 11), Person("chris", 12))

    val theOldest1 = findTheOldest(people)
    if(theOldest1 is Person) {
        println("the oldest: ${theOldest1.name}")
    }

    val theOldest2 = people.maxByOrNull { it.age }
    if(theOldest2 is Person) {
        println("the oldest: ${theOldest2.name}")
    }

    val nobody: List<Person> = listOf()
    val theOldest3 = nobody.maxByOrNull(Person::age)
    if(theOldest3 is Person) {
        println("the oldest: ${theOldest3.name}")
    }
    println(theOldest3)

    val ageExtractFunc = { x: Person -> x.age}
    val theOldest4 = people.maxByOrNull(ageExtractFunc)
    if(theOldest4 is Person) {
        println("the oldest: ${theOldest4.name}")
    }
}