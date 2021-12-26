package ch9.ch2

fun main(args: Array<String>) {
    /* Type erasure in Generics */
    val list = listOf("a", "b", "c")

    // if(list is List<Char>) // Cannot check for instance of erased type: List<Char>
    if(list is List<*>) {
        println(list)
    }

    // Base Type is same but Type Parameter is different
    val list2: List<Int> = list as? List<Int> ?: throw IllegalStateException()
    println(list2)

    /* reified type parameter */
    println(isA<String>("A"))
    println(isA<String>(1))
}

inline fun <reified T> isA(value: Any) = value is T
