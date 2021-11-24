package ch5.ch1

fun main(args: Array<String>) {
    // declaration lambda
    val sum1: (Int,Int) -> Int = {x: Int, y: Int -> x + y}
    println(sum1(1,2));

    val sum2: (Int,Int) -> Int = {x: Int, y: Int ->
        println("Computing the sum of $x and $y")
        x + y
    }
    println(sum2(1,2));

    // call lambda
    { println(32) }()
    run { println(32) }

    // lambda grammar
    val people = listOf(Person("alice", 10), Person("bob", 11), Person("chris", 12))
    println(people.maxByOrNull({ p: Person -> p.age }))
    println(people.maxByOrNull({ p -> p.age }))
    println(people.maxByOrNull(){ p -> p.age })
    println(people.maxByOrNull{ p -> p.age })
    println(people.maxByOrNull{ it.age })

    println(people.joinToString(separator = " ", transform = { it.name }))
    println(people.joinToString(" "){ it.name })
    println(people.joinToString(separator = " ", limit = 2){ it.name })
}

fun functionParameterAndReturn(x:Int, y: Int, f: (Int,Int) -> Int): () -> Unit {
    return {println(f(x,y))}
}