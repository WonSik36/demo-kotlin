package ch8.ch1

fun main(args: Array<String>) {
    // Declaration
    val sum: (Int, Int) -> Int = { x, y -> x + y }
    val action: () -> Unit = { println(42) }
    val canReturnNull: (Int, Int) -> Int? = { x, y -> null }
    val funOrNull: ((Int,Int) -> Int)? = null

    // Call
    twoAndThree { x, y -> x + y }
    twoAndThree { x, y -> x * y }
    println("ab1c".filter { it in 'a'..'z' })
}

fun twoAndThree(operation: (Int,Int) -> Int) {
    val result = operation(2,3)
    println("The result is $result")
}
fun String.filter(predicate: (Char) -> Boolean): String {
    val sb = StringBuilder()

    for(index in indices) {
        val element = get(index)

        if(predicate(element))
            sb.append(element)
    }

    return sb.toString()
}