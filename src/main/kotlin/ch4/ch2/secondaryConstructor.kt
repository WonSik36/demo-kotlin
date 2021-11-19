package ch4.ch2

interface Context
interface AttributeSet

open class View {
    constructor(ctx: Context) {}
    constructor(ctx: Context, attr: AttributeSet){}
}

class MyButton: View {
    constructor(ctx: Context): this(ctx, MyAttributeSet) {}
    constructor(ctx: Context, attr: AttributeSet): super(ctx, attr) {}

    object MyAttributeSet: AttributeSet
}