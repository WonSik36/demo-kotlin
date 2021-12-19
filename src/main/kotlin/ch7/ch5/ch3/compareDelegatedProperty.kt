package ch7.ch5.ch3

import java.beans.PropertyChangeListener

fun main(args: Array<String>) {
    val eventConsumer = PropertyChangeListener {
        println("Property ${it.propertyName} changed from ${it.oldValue} to ${it.newValue}")
    }

    // Person without delegation
    val p = Person("Alice", 34, 2000)
    p.addPropertyChangeListener(eventConsumer)
    p.age = 35
    p.salary = 2400

    // Person with custom delegation
    val pwh = PersonWithHelper("Bob", 33, 2400)
    pwh.addPropertyChangeListener(eventConsumer)
    pwh.age = 34
    pwh.salary = 2500

    // Person with Delegates.observable
    val pwdo = PersonWithObservable("Chris", 31, 2300)
    pwdo.addPropertyChangeListener(eventConsumer)
    pwdo.age = 32
    pwdo.salary = 2500
}