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

}

@Retention  // default kotlin annotation is AnnotationRetention.RUNTIME
@Target(AnnotationTarget.LOCAL_VARIABLE)
annotation class MyAnnotation(val name: String)
