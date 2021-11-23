package ch4.ch4

interface HaveName {
    fun getName(): String
}
fun printName(haveName: HaveName) = println("Hello, ${haveName.getName()}")

fun interface DecorateString {
    fun apply(str: String): String
}
fun applyFunction(str: String, strFunc: DecorateString) = strFunc.apply(str)

fun main(args: Array<String>) {
    printName(object: HaveName {
        override fun getName(): String {
            return "alice"
        }
    })

    println(applyFunction("bob", object: DecorateString{
        override fun apply(str: String): String = "Hello, $str"
    }))
    println(applyFunction("bob"){ "Hello, $it" })
}
