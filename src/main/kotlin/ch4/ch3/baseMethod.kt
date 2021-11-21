package ch4.ch3

class Client1(val name: String, val postalCode: Int) {
    override fun toString() = "Client(name=$name, postalCode=$postalCode)"
    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Client1)
            return false
        return name == other.name && postalCode == other.postalCode
    }
    override fun hashCode(): Int {
        return name.hashCode() * 31 + postalCode
    }
    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = Client1(name, postalCode)
}

fun main(args: Array<String>) {
    val client1 = Client1("Alice", 4122)
    val client2 = Client1("Alice", 4122)

    println(client1)                // toString
    println(client1 == client2)     // equals

    val processed = hashSetOf(Client1("Bob", 4123))
    println(processed.contains(Client1("Bob", 4123)))    // hashCode

    println(client1.copy(name = "Chris"))
}