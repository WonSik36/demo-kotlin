package ch10.ch1

import ru.yole.jkid.CustomSerializer
import ru.yole.jkid.DeserializeInterface
import ru.yole.jkid.ValueSerializer
import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.serialization.serialize
import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
    @MyAnnotation("Number")
    val number = 1

    @MyAnnotation(name = "Name")
    val name = "alice"

    // Using Class to Annotation Parameter
    val person3Str = """{ "name": "alice", "company": { "name": "apple" } }"""
    val p3 = deserialize<Person3>(person3Str)
    println(p3)

    // Using Generic Class to Annotation Parameter
    val person4 = Person4("Bob", LocalDate.now())
    val person4Str = serialize(person4)
    println(person4Str)

    val p4 = deserialize<Person4>(person4Str)
    println(p4)
}

@Retention  // default kotlin annotation is AnnotationRetention.RUNTIME
@Target(AnnotationTarget.LOCAL_VARIABLE)
annotation class MyAnnotation(val name: String)

interface Company {
    val name: String
}

data class CompanyImpl(override val name: String) : Company

data class Person3 (
    val name: String,
    //  @Target(AnnotationTarget.PROPERTY)
    //  annotation class DeserializeInterface(val targetClass: KClass<out Any>)
    @DeserializeInterface(CompanyImpl::class) val company: Company
)

data class Person4 (
    val name: String,
    //  @Target(AnnotationTarget.PROPERTY)
    //  annotation class CustomSerializer(val serializerClass: KClass<out ValueSerializer<*>>)
    @CustomSerializer(LocalDateSerializer::class) val birthDate: LocalDate
)

class LocalDateSerializer: ValueSerializer<LocalDate> {
    private val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    override fun toJsonValue(value: LocalDate): Any? {
        return value.format(dateFormat)
    }

    override fun fromJsonValue(jsonValue: Any?): LocalDate {
        return LocalDate.parse(jsonValue as String, dateFormat)
    }
}