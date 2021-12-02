package ch5.ch5

fun alphabet3(): String = StringBuilder().apply {
    for (letter in 'A'..'Z') {
        this.append(letter)
    }

    // 람다식을 확장 함수로 적용하여 public 멤버만 접근 가능
    // this.writeObject(java.io.ObjectOutputStream s) 는 private 이므로 동작 안함 

    append("\nNow I know alphabet!")    // return StringBuilder
}.toString()

fun alphabet4() = buildString {
    for (letter in 'A'..'Z') {
        append(letter)
    }
    append("\nNow I know alphabet!")
}

fun main(args: Array<String>) {
    println(alphabet3())
    println(alphabet4())
}
