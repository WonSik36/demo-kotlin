package ch5.ch3

fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 27), Person("Bob", 31))

    val somePeople = people.asSequence()
        .map(Person::name)
        .filter { it.startsWith("A") }
        .toList()
    println(somePeople)

    // 이터레이션 하거나 리스트로 변환해야 실제 변환이 호출
    listOf(1,2,3,4).asSequence()
        .map { print("map($it) "); it*it }
        .filter { print("filter($it) "); it%2 == 0 }
    println()

    listOf(1,2,3,4).asSequence()
        .map { print("map($it) "); it*it }
        .filter { print("filter($it) "); it%2 == 0 }
        .toList()
    println()

    // 한 원소에 대해 모든 연산 수행후, 다음 원소 진행
    val people2 = listOf(Person("Alice", 27), Person("Bob", 31), Person("Chris", 27), Person("Dan", 31))
    people2.asSequence()
        .map { print("map($it) "); it.name }
        .filter { print("filter($it) "); it.length < 4 }
        .toList()
    println()

    people2.asSequence()
        .filter { print("filter($it) "); it.name.length < 4 }
        .map { print("map($it) "); it.name }
        .toList()
    println()

    // generateSequence
    val naturalNumbers  = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())
}