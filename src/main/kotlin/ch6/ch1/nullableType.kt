package ch6.ch1


fun strLen(s: String): Int = s.length
// fun strLenSafe1(s: String?): Int = s.length /* Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type String? */
fun strLenSafe1(s: String?): Int = if(s != null) s.length else 0
fun strLenSafe2(s: String?): Int = s?.length ?: 0   // Elvis Operator
fun strLenSafe3(s: String?): Int = s!!.length       // Not-null assertion operator


fun main(args: Array<String>) {
    // strLen(null) /* Null can not be a value of a non-null type String */

    println(strLenSafe1("abc"))
    println(strLenSafe1(null))

    println(strLenSafe2("abc"))
    println(strLenSafe2(null))

    println(strLenSafe3("abc"))
    println(strLenSafe3(null))
}