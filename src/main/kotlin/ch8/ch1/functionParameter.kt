package ch8.ch1

fun <T: Any> Collection<T>.joinToString1(
    separator: String = ",",
    prefix: String = "",
    postfix: String = "",
    transform: (T) -> String = { it.toString() }
): String {
    val result = StringBuilder(prefix)

    for((index, element) in withIndex()) {
        if(index > 0)
            result.append(separator)
        result.append(transform(element))
    }

    result.append(postfix)

    return result.toString()
}

fun <T: Any> Collection<T>.joinToString2(
    separator: String = ",",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null
): String {
    val result = StringBuilder(prefix)

    for((index, element) in withIndex()) {
        if(index > 0)
            result.append(separator)
        val str = transform?.invoke(element) ?: element.toString()

        result.append(str)
    }

    result.append(postfix)

    return result.toString()
}

fun main(args: Array<String>) {
    val letters = listOf("Alpha", "Beta")
    println(letters.joinToString1())
    println(letters.joinToString2())

    println(letters.joinToString1 { it.lowercase() })
    println(letters.joinToString2 { it.lowercase() })

    println(letters.joinToString1(separator = "! ", postfix = "! ") { it.uppercase() })
    println(letters.joinToString2(separator = "! ", postfix = "! ") { it.uppercase() })
}