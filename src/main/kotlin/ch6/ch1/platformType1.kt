package ch6.ch1


// platform type: 코틀린이 널 관련 정보를 알수 없는 타입 (_!)
fun yellAt1(person: JavaPersonWithoutNullInfo) {
    println("${person.name.uppercase()} !!!")
}
fun yellAt2(person: JavaPersonWithoutNullInfo) {
    println("${(person.name ?: "Anyone").uppercase()} !!!")
}
fun yellAt3(person: JavaPersonWithNullInfo) {
    println("${person.name.uppercase()} !!!")
}

fun main(args: Array<String>) {
    val personWithPlatformType = JavaPersonWithoutNullInfo(null)
    try {
        yellAt1(personWithPlatformType)
    } catch (ex: NullPointerException) {
        println(ex.message)
    }

    yellAt2(personWithPlatformType)
    //  val i: Int = personWithPlatformType.name // Type mismatch. Required: Int Found: String! !: nullable 여부를 알수 없음
    try {
        val name1: String = personWithPlatformType.name
    } catch (ex: NullPointerException) {
        println(ex.message)
    }

    // val person = JavaPersonWithNullInfo(null) // Null can not be a value of a non-null type String
    val person = JavaPersonWithNullInfo("Alice")
    yellAt3(person)
}