package ch6.ch1

fun sendEmailTo(email: String) {
    println("Send email to $email")
}

fun main(args: Array<String>) {
    // public inline fun <T, R> T.let(block: (T) -> R): R
    var email: String? = "example@example.com"
    email?.let { sendEmailTo(it) }

    email = null
    email?.let { sendEmailTo(it) }
}