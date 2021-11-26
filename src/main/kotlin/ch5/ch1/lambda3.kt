package ch5.ch1

// 람다 영역 밖에 있는 변수 조회
fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach{
        println("$prefix $it")
    }
}

// 람다 영역 밖에 있는 변수 조회 및 변경
fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0

    responses.forEach{
        if(it.startsWith("4")) {
            clientErrors++
        } else if(it.startsWith("5")) {
            serverErrors++
        }
    }

    println("$clientErrors client errors, $serverErrors server errors")
}

fun main(args: Array<String>) {
    val errors = listOf("403 Forbidden", "404 Not Found")
    printMessageWithPrefix(errors, "Error: ")

    val responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
    printProblemCounts(responses)
}
