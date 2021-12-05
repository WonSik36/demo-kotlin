package ch6.ch1

// T 는 nullable 을 포함한다.
fun <T> printHashCode1(t: T) {
    // null 에 대한 핸들링
    println(t?.hashCode())
}
fun <T: Any> printHashCode2(t: T) {
    // null 에 대한 핸들링
    println(t.hashCode())
}

fun main(args: Array<String>) {
    printHashCode1(null)
    //  printHashCode2(null)    // Null can not be a value of a non-null type TypeVariable(T)
}
