package ch4.ch2

class StringLengthCounter(_word: String = "") {
    var word: String = ""   // custom setter 에서 field 에 접근하기 위해 초기화 되어있어야함
        set(value) {
            counter = value.length
            field = value
        }
    var counter: Int = 0
        private set

    init {
        word = _word
    }

    fun addWord(word: String) {
        counter += word.length
        this.word += word
    }
}

fun main(args: Array<String>) {
    val lengthCounter = StringLengthCounter("First, ")
    println("count: ${lengthCounter.counter}")
    println("word: ${lengthCounter.word}")

    lengthCounter.addWord("Second, ")
    println("count: ${lengthCounter.counter}")
    println("word: ${lengthCounter.word}")
}