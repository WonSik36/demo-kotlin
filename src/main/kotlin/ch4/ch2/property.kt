package ch4.ch2

interface User7 {
    val nickname: String
}

class PrivateUser(override val nickname: String): User7

class SubscribingUser(val email: String): User7 {
    override val nickname: String
        get() = email.substringBefore("@")

}

class FacebookUser(val accountId: Int): User7 {
    override val nickname = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String = "FB${accountId}"
}

fun main(args: Array<String>) {
    println(PrivateUser("alice").nickname)
    println(SubscribingUser("bob@example.com").nickname)
    println(FacebookUser(123).nickname)
}
