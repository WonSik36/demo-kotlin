package ch4.ch4

import kotlin.Comparator

object CaseInsensitiveStringComparator: Comparator<String> {
    override fun compare(o1: String, o2: String): Int {
        return o1.compareTo(o2, ignoreCase = true)
    }
}

data class Person1(val name: String) {
    object NameComparator: Comparator<Person1> {
        override fun compare(p1: Person1, p2: Person1): Int {
            return p1.name.compareTo(p2.name)
        }
    }
}

fun main(args: Array<String>) {
    val strs = listOf("Darick", "chris", "Bob", "alice")

    println(strs.sorted())
    println(strs.sortedWith(CaseInsensitiveStringComparator))

    val persons = listOf(
        Person1("chris"), Person1("bob"), Person1("darick"), Person1("alice")
    )
    println(persons.sortedWith(Person1.NameComparator))
}