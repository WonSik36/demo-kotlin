package ch7.ch5

import kotlin.reflect.KProperty

/**
 * @see ch4.ch3.DelegatingCollection2
 */

class Foo {
    var p: Int by Delegate()
}

/**
 *  compile like this
 *
 *  class Foo {
 *      private val delegate = Delegate()
 *      var p: Int
 *          set(value: Int) = delegate.setValue()
 *          get() = delegate.getValue()
 *  }
 *
*/

class Delegate {
    private var v = 0

    operator fun getValue(foo: Foo, property: KProperty<*>): Int {
        return v
    }

    operator fun setValue(foo: Foo, property: KProperty<*>, i: Int) {
        v = i
    }
}

fun main(args: Array<String>) {
    val foo = Foo()

    println(foo.p)

    foo.p = 123
    println(foo.p)
}