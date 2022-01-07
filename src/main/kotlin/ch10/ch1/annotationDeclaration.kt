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