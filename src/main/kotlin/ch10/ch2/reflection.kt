@file:JvmName("ReflectionDemoKt")

package ch10.ch2

import kotlin.reflect.*
import kotlin.reflect.full.memberProperties

class Person1(val name: String, val age: Int)

fun foo(x: Int) = println(x)
fun sum(x: Int, y: Int) = x + y
val rootProperty = 100
var counter = 0

fun main(args: Array<String>) {
    /* KClass */
    val person = Person1("Alice", 29)
    val kClass = person.javaClass.kotlin

    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) }

    /* KFunction */
    val kFunction: KFunction<Unit> = ::foo
    kFunction.call(42)

    // synthetic compiler-generated type
    val kFunction2: KFunction2<Int, Int, Int> = ::sum
    // kFunction2.call(1)  // IllegalArgumentException: Callable expects 2 arguments, but 1 were provided.
    kFunction.call(kFunction2.call(1, 2))
    kFunction.call(kFunction2.invoke(3, 4))
    kFunction.call(kFunction2(5, 6))

    /* KProperty */
    val property: KProperty<Int> = ::rootProperty
    val property0: KProperty0<Int> = ::rootProperty
    val mutableProperty0: KMutableProperty0<Int> = ::counter

    println(property.call())

    println(property0.call())
    println(property0.getter.invoke())

    mutableProperty0.set(1)
    println(mutableProperty0.get())

    /* KParameter */
    val kParameter: KParameter = kFunction.parameters.firstOrNull()!!
    println(kParameter.name)
    println(kParameter.kind)
}