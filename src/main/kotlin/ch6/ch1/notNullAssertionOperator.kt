package ch6.ch1

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!  // NPE 발생 가능 지점

    println(sNotNull.length)
}

fun main(args: Array<String>) {
    ignoreNulls(null)
}