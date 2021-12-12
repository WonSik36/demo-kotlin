package ch7.ch1

operator fun <T> ArrayList<T>.plusAssign(element: T) {
    this.add(element)
}

fun main(args: Array<String>) {
    // arithmetic operator overloading
    val origin = Point(1,2)

    var point = origin
    point += Point(3, 4)    // point = point + Point(3, 4)

    println(origin)
    println(point)

    // compound assignment operator overloading
    val numbers = ArrayList<Int>()
    numbers += 42
    println(numbers[0])

    // kotlin collection compound assignment operator overloading
    val mutableList: MutableList<Int> = arrayListOf(1,2)
    mutableList += 3    // add
    println(mutableList)

    var immutableList: List<Int> = arrayListOf(1,2)
    immutableList += 3  // make new List
    println(immutableList)

    val newList = mutableList + listOf(4, 5)
    println(newList)
}
