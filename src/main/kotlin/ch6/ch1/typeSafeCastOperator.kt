package ch6.ch1

class Name(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherName: Name = other as? Name ?: return false

        return firstName == otherName.firstName && lastName == otherName.lastName
    }
}

fun main(args: Array<String>) {
    val name1 = Name("alice", "bob")
    val name2 = null

    println(name1 == name2)
}