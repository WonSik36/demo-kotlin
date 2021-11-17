@file:JvmName("StringBuilderUtils")

package ch3.ch3.extensions

val StringBuilder.firstChar: Char
    get() = get(0)
var StringBuilder.lastChar: Char
    get() = get(length-1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }