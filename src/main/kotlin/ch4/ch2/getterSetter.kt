package ch4.ch2

class User8(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""Address was changed for $name: from $field to $value""")
            field = value
        }
}

class User9 {
    val name: String
        get() {
            return "no name"
        }

    var address: String // No backing field -> 컴파일시, 해당 프로퍼티가 존재하지 않음
        get() {
            println("Address is empty")
            return "empty address"
        }
        set(value: String) {
            println("Address was try to set $value. But address is empty")
        }
}

fun main(args: Array<String>) {
    val user1 = User8("Alice")
    user1.address = "Elsenheimerstrasse 47"

    val user2 = User9()
    println("Before: ${user2.address}")

    user2.address = "New Address"
    println("After: ${user2.address}")
}