package ch4.ch3

class AddressWithEqualsAndHashCode(val a: String, val b: String, val c: String) {
    override fun equals(other: Any?): Boolean {
        if(other !is AddressWithEqualsAndHashCode)
            return false
        return a == other.a && b == other.b && c == other.c
    }

    override fun hashCode(): Int {
        return ((a.hashCode() * 31) + b.hashCode() * 31) + c.hashCode()
    }
}
data class Client3(val name: String, val postalCode: Int, val address: AddressWithEqualsAndHashCode)

class Address(val a: String, val b: String, val c: String)
data class Client4(val name: String, val postalCode: Int, val address: Address)

fun main(args: Array<String>) {
    val address1 = AddressWithEqualsAndHashCode("a", "b", "c")
    val client1 = Client3("Alice", 41024, address1)
    val address2 = AddressWithEqualsAndHashCode("a", "b", "c")
    val client2 = Client3("Alice", 41024, address2)

    println(client1 == client2)
    println("Client1: " + client1.hashCode())
    println("Client2: " + client2.hashCode())
}