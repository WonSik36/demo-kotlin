package ch6.ch2

fun main(args: Array<String>) {
    val x: Int = 1;         // int      null 이 아닌 primitive type -> primitive or wrapper type
    x.compareTo(2)          // Int can call method

    val y: Int? = null;     // Integer  nullable primitive type -> wrapper type
    val z: List<Int> = listOf(1,2,3)    // List<Integer>

    val w: Long = x.toLong()            // 자동 변환 허용 X
    x.toLong() in listOf(1L, 2L, 3L)    // 명시적으로 타입을 변환해야 함
}