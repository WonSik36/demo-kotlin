package ch6.ch1

data class Employee(val name: String, val manager: Employee?)
fun managerName(employee: Employee): String? = employee.manager?.name

data class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
data class Company(val name: String, val address: Address?)
data class Person(val name: String, val company: Company?)
fun Person.countryName(): String {
    val country = this.company?.address?.country
    return if(country != null) country else "Unknown"
}

fun main(args: Array<String>) {
    val ceo = Employee("Da Boss", null)
    val developer = Employee("Bob Smith", ceo)

    println(managerName(developer))
    println(managerName(ceo))

    /* Chaining Safe Calls */
    val alice = Person("Alice", Company("NewComp", null))
    println(alice.countryName())
}