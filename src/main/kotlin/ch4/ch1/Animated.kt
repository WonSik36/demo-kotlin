package ch4.ch1

abstract class Animated {
    abstract fun animate()

    open fun stopAnimating() {}

    fun animateTwice() {}
}