package ch3.ch5

fun main(args: Array<String>) {

    println("12.345-6.A".split("\\.|-".toRegex()))
    println("12.345-6.A".split(".", "-"))

    println(parsePathByExtension("/Users/yole/kotlin-book/chapter.adoc"))
    println(parsePathByRegex("/Users/yole/kotlin-book/chapter.adoc"))

    println(parsePathByExtension("Unmatched Value"))
    println(parsePathByRegex("Unmatched Value"))
}

fun parsePathByExtension(path: String): File {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    return File(directory, fileName, extension)
}

fun parsePathByRegex(path: String): File {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)

    if(matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured
        return File(directory, fileName, extension)
    }

    return File()
}

data class File(val directory: String, val fileName: String, val extension: String) {
    constructor(): this("", "", "")
}