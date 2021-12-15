package ch7.ch4


fun printEntries(map: Map<String, String>) {
    for((key, value) in map) {
        println("$key -> $value")
    }
}

fun printEntries2(map: Map<String, String>) {
    for(entry in map.entries) {
        println("${entry.component1()} -> ${entry.component2()}")
    }
}

fun main(args: Array<String>) {
    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
    printEntries(map)
    printEntries2(map)
}