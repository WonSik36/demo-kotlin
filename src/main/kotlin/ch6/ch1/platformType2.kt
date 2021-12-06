package ch6.ch1

// 상속,구현시 플랫폼 타입 메서드의 nullable 여부를 개발자가 책임져야한다.
class StringProcessorImpl1: StringProcessor {
    override fun process(value: String) {
        println(value)
    }
}
class StringProcessorImpl2: StringProcessor {
    override fun process(value: String?) {
        println(value ?: "NULL!!")
    }
}

fun main(args: Array<String>) {
    val stringProcessor1: StringProcessor = StringProcessorImpl1()

    try {
        stringProcessor1.process(null)
    } catch (ex: NullPointerException) {
        println(ex.message)
    }


    val stringProcessor2: StringProcessor = StringProcessorImpl2()
    stringProcessor2.process(null)
}