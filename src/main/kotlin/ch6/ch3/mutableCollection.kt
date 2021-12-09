package ch6.ch3

fun <T: Any> copyElements(source: Collection<out T>, target: MutableCollection<in T>) {
    for (item in source) {
        target.add(item)
    }
}

fun main(args: Array<String>) {
    val source: Collection<Int> = listOf(1, 2, 3)
    val target: MutableCollection<Int> = arrayListOf()  // Not Thread Safe

    copyElements(source, target)

    println(target)
}