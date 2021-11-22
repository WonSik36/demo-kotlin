package ch4.ch4

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

/* Using Companion Object As Object */
@Serializable
class Person2(val name: String) {
    companion object Loader {
        fun fromJson(jsonText: String): Person2 = Json.decodeFromString(jsonText)
    }
}

/* Using Companion Object As Interface */
interface JsonFactory<T> {
    fun fromJson(jsonText: String): T
}
@Serializable
class Person3(val name: String) {
    companion object Loader: JsonFactory<Person3> {
        override fun fromJson(jsonText: String): Person3 = Json.decodeFromString(jsonText)
    }
}
fun <T> loadFromJson(factory: JsonFactory<T>, jsonText: String): T = factory.fromJson(jsonText)

/* extend Companion Object */
@Serializable
class Person4(val name: String) {
    companion object {
    }
}
fun Person4.Companion.fromJson(jsonText: String): Person4 = Json.decodeFromString(jsonText)

fun main(args: Array<String>) {
    val person1 = Person2.Loader.fromJson("""{"name": "Dmitry"}""")
    println(person1.name)

    val person2 = loadFromJson(Person3  /* as interface */, """{"name": "Alice"}""")
    println(person2.name)

    val person3 = Person4.fromJson("""{"name": "Bob"}""")
    println(person3.name)
}