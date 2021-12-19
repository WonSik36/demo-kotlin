package ch7.ch5.ch3

import java.beans.PropertyChangeSupport
import kotlin.reflect.KProperty

class ObservableProperty <T: PropertyChangeAware, V>(
    var propValue: V,
    val changeSupport: PropertyChangeSupport
) {
    operator fun getValue(target: T, prop: KProperty<*>): V = propValue
    operator fun setValue(target: T, prop: KProperty<*>, newValue: V) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}