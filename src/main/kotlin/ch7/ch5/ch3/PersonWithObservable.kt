package ch7.ch5.ch3

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class PersonWithObservable(
    val name: String, age: Int, salary: Int
): PropertyChangeAware() {

    // onChange adapter
    private val observer: (KProperty<*>, Int, Int) -> Unit = {
        prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}