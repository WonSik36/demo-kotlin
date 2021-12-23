package ch8.ch1

data class Person (
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

class ContactListFilters{
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (Person) -> Boolean {
        val startsWithPrefix: (Person) -> Boolean
                = { p -> p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix) }

        if(!onlyWithPhoneNumber) {
            return startsWithPrefix
        }

        return { startsWithPrefix(it) && it.phoneNumber != null }
    }
}

fun main(args: Array<String>) {
    val contacts = listOf(
        Person("Dmitry", "Jemerov", "123-456-789"),
        Person("Alice", "Bob", null)
    )

    val contactListFilters = ContactListFilters()
    with(contactListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }

    println(contacts.filter(contactListFilters.getPredicate()))
}