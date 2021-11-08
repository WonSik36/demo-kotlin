package ch2

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
}

fun main(args: Array<String>) {
    val rect = Rectangle(10, 10)

    println("Rectangle Height: ${rect.height}, Width: ${rect.width}")
    println("is Square: ${rect.isSquare}")
}