package ch5.ch5

fun alphabet1(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know alphabet!")
    return result.toString()
}

fun alphabet2(): String = with(StringBuilder()) {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }
    append("\nNow I know alphabet!")
    this.toString() // return
}

fun main(args: Array<String>) {
    println(alphabet1())
    println(alphabet2())
}
