package ch4.ch1

open class RichButton: Clickable {
    fun disable() {}
    open fun animate() {}
    override fun click() {}
    final override fun showOff() {}
}