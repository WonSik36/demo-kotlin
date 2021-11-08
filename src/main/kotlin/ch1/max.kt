package ch1

fun max1(a: Int, b: Int) : Int {
    if(a > b) {
        return a
    } else {
        return b
    }
}

fun max2(a: Int, b: Int) : Int {

    // if is expression
    return if(a > b) {
        a
    } else {
        b
    }
}

fun max3(a: Int, b: Int) : Int {
    return if(a > b) a else b
}

fun max4(a: Int, b: Int) : Int = if (a > b) a else b

fun max5(a: Int, b: Int) = if (a > b) a else b

fun assignmentIsStatement() {
    var x = 1
    var y = 2
    val z = 3

    // y = z 는 y 를 반환하지 않는다.
    // x = y = z
}