package ch6.ch2

import ch6.ch1.Address
import ch6.ch1.Company

fun main(args: Array<String>) {
    /* Any -> Object */
    val answer: Any = 42
    val obj: Any? = null
    val javaObject = answer as java.lang.Object
    //  javaObject.wait()
    //  javaObject.notify()

    /* Unit -> Void */
    // Java 의 경우 Processor<Void 가 되는데 return null 을 해야함
    class NoResultProcessor: Processor<Unit> {
        override fun process() {
        }
    }

    /* Nothing -> 정상적으로 끝나지 않는 함수 */
    val company = Company("Jetbrains", null)
    try {
        val address: Address = company.address ?: fail("No Address")
    } catch (ex: IllegalStateException) {
        println(ex.message)
    }
}

interface Processor<T> {
    fun process(): T
}


fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}
