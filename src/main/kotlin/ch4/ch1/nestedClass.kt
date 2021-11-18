package ch4.ch1

import java.io.Serializable

interface State: Serializable
interface View {
    fun getCurrentState(): State
    fun restoreState(state: State)
}

class Link: View {
    override fun getCurrentState(): State = LinkState()

    override fun restoreState(state: State) {}

    class LinkState: State {}
}

class Outer {
    inner class Inner {
        fun getOuterReference(): Outer = this@Outer
    }
}
