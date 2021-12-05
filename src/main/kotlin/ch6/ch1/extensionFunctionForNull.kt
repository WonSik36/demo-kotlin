package ch6.ch1

// 널이 될수 있는 타입에 대해 확장함수를 사용할수 있다.
fun String?.isNullOrBlank(): Boolean = this == null || this.isBlank()
fun verifyInput(property: String, input: String?) {
    if(input.isNullOrBlank()) {
        throw IllegalArgumentException("$property is empty field")
    }
}

fun main(args: Array<String>) {
    try {
        verifyInput("name", null)
    } catch (ex: IllegalArgumentException) {
        println(ex.message)
    }
}