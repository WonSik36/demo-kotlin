package ch9.ch2

fun main(args: Array<String>) {
    /* Type erasure in Generics */
    val list = listOf("a", "b", "c")

    // if(list is List<Char>) // Cannot check for instance of erased type: List<Char>
    if(list is List<*>) {
        println(list)
    }

    // Base Type is same but Type Parameter is different
    val list2: List<Int> = list as? List<Int> ?: throw IllegalStateException()
    println(list2)

    /* reified type parameter */
    println(isA<String>("A"))
    println(isA<String>(1))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())

    /* Using reified type parameter in Adapter which use Class<T> */
    // val serviceImpl = ServiceLoader.load(Service::class.java)    // public val <T> KClass<T>.java: Class<T>
    // val serviceImpl = loadService<Service>()
}

/**
 * 컴파일러는 실체화한 타입 인지를 사용해 인라인 함수를 호출하는 각 부분의 정확한 인자를 알 수 있다.
 * 컴파일러는 타입 인자로 쓰인 구체적인 클래스를 참조하는 바이트 코드를 생성해 삽입할 수 있다.
 *
 * 자바 코드에서는 reified 타입 파라미터를 사용하는 inline 함수를 호출할 수 없다.
 * 왜냐하면 자바에서는 코틀린 인라인 함수를 다른 보통 함수처럼 호출한다.
 */
inline fun <reified T> isA(value: Any) = value is T
