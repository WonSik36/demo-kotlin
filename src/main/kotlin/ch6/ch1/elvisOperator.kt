package ch6.ch1

fun shippingLabel(person: Person): String {
    val address = person.company?.address ?: throw IllegalArgumentException("No Address")
    return with(address) {
        "$streetAddress\n$zipCode $city, $country"
    }
}
