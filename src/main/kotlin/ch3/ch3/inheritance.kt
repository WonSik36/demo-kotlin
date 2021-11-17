package ch3.ch3

open class View {
    open fun click() = "View clicked"
}

class Button: View() {
    override fun click() = "Button clicked"
}

fun View.showOff() = "I'm a view!"
fun Button.showOff() = "I'm a button!"

fun View.usingDynamic() = "View: " + click()
fun Button.usingDynamic() = "Button: " + click()
