@file:JvmName("UsingAnnotationKt")

package ch10.ch1

import ru.yole.jkid.JsonExclude
import ru.yole.jkid.JsonName
import ru.yole.jkid.deserialization.deserialize
import ru.yole.jkid.serialization.serialize
import kotlin.reflect.KClass

const val SOME_VALUE: String = "Some Static Value"

data class Person1(val name: String, val age: Int) {

    @Deprecated(
        "Use someMethod2",
        ReplaceWith("someMethod2()")    // annotation 안에 annotation 사용
    )
    fun someMethod() {}

    @KotlinAnnotation(
        clazz = Int::class,  // class
        string = SOME_VALUE, // 상수
        numbers = [1, 2, 3], // annotation 에서는 [] 사용 가능
    )
    @JavaAnnotationWithArrayValue("123", "456", "789")  // value array 에 대해서 varargs 로 사용 가능
    fun someMethod2() {}
}

@Target(
    AnnotationTarget.CLASS,
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY,
    AnnotationTarget.ANNOTATION_CLASS,
    AnnotationTarget.CONSTRUCTOR,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.TYPEALIAS
)
annotation class KotlinAnnotation(
    val clazz: KClass<*>,
    val string: String,
    val numbers: IntArray
)

data class Person2(
    @property:JsonName("alias") val name: String,
    @property:JsonExclude val age: Int? = null
)

fun main(args: Array<String>) {
    val p1 = Person1("alice", 29)
    p1.someMethod()

    val p2 = Person2("alice", 29)
    val str = serialize(p2)
    println(str)

    val p3 = deserialize<Person2>(str)
    println(p3)
}