package ch4.ch2

class User1(val nickname: String)
class User2 constructor(_nickname: String) {
    val nickname: String

    init {
        nickname = _nickname
    }
}
class User3 constructor(_nickname: String) {
    val nickname = _nickname
}
class User4(val nickname: String, val isSubscribed: Boolean = true)

open class User5(val nickname: String)
class User6(nickname: String, ): User5(nickname)

fun main(args: Array<String>) {
    val user1 = User1("alice")
    println(user1.nickname)

    val user2 = User2("bob")
    println(user2.nickname)

    val user3 = User3("chris")
    println(user3.nickname)

    val user4 = User4("daniel")
    println(user4.isSubscribed)
}
