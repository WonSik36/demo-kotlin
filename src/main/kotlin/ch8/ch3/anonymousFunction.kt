package ch8.ch3

fun lookForAliceByAnonymousFunction(people: List<Person>) {
    people.forEach(fun (person) {
        if (person.name == "Alice")
            return  // return anonymous function

        println("${person.name} is not Alice")
    })
}

fun lookForAliceByAnonymousFunctionWithLabel(people: List<Person>) {
    people.forEach(fun (person) {
        if (person.name == "Alice")
            return@forEach

        println("${person.name} is not Alice")
    })
}

fun lookForAliceByAnonymousFunctionReturnRootFunction(people: List<Person>) {
    people.forEach(fun (person) {
        if (person.name == "Alice")
            return@lookForAliceByAnonymousFunctionReturnRootFunction

        println("${person.name} is not Alice")
    })
}

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))

    lookForAliceByAnonymousFunction(people) // 무명 함수에 대해서만 리턴

    lookForAliceByAnonymousFunctionWithLabel(people)    // forEach 에 대해서 리턴

    lookForAliceByAnonymousFunctionReturnRootFunction(people)   // 최상위 함수 리턴
}