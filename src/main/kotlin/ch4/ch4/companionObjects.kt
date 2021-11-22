package ch4.ch4

open class User private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) =
            User(email.substringBefore("@"))
        fun newFacebookUser(accountId: Int) =
            User(getFacebookName(accountId))

        private fun getFacebookName(accountId: Int): String = "FB$accountId"
    }
}

fun main(args: Array<String>) {
    val user1 = User.newSubscribingUser("alice@example.com")
    println("User1: ${user1.nickname}")
    val user2 = User.newFacebookUser(12345)
    println("User1: ${user2.nickname}")
}