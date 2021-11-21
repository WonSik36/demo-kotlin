package ch4.ch3

data class Client2(val name: String, val postalCode: Int)

fun main(args: Array<String>) {
    val client1 = Client2("Alice", 4122)
    val client2 = Client2("Alice", 4122)

    println(client1)                // toString
    println(client1 == client2)     // equals

    val processed = hashSetOf(Client2("Bob", 4123))
    println(processed.contains(Client2("Bob", 4123)))    // hashCode

    val copied = client2.copy(name = "Chris")   // copy
    println(copied)
}