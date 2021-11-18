package ch4.ch1

/**
 * reference: https://jorgecastillo.dev/sealed-interfaces-kotlin
 * sealed interface
 */
interface Error {
    val message: String
        get() = "Error"
}

sealed interface CommonErrors: Error {
    override val message: String
        get() = "CommonError"
}

object ServerError : CommonErrors, GetUserErrors, LoginErrors {
    override val userId: String
        get() = "ServerError user"
    override val loginPath: String
        get() = "/serverError"
}

object Forbidden : CommonErrors, GetUserErrors {
    override val message: String
        get() = "ForbiddenError"
    override val userId: String
        get() = "Forbidden user"
}

object Unauthorized : CommonErrors, GetUserErrors {
    override val userId: String
        get() = "Unauthorized user"
}

sealed interface GetUserErrors {
    val userId: String
}
data class UserNotFound(override val userId: String) : GetUserErrors
data class InvalidUserId(override val userId: String) : GetUserErrors

sealed interface LoginErrors {
    val loginPath: String
}
data class InvalidUsername(val username: String, override val loginPath: String) : LoginErrors
object InvalidPasswordFormat : LoginErrors {
    override val loginPath: String = "/invalid"
}

fun handleGetUserError(error: GetUserErrors): String = when (error) {
    ServerError -> TODO()
    Forbidden -> "userId: ${error.userId}"
    Unauthorized -> TODO()
    is UserNotFound -> TODO()
    is InvalidUserId -> TODO()
}

fun handleLoginError(error: LoginErrors): String = when (error) {
    ServerError -> TODO()
    is InvalidUsername -> error.toString()
    InvalidPasswordFormat -> TODO()
}

fun handleCommonError(error: CommonErrors): String = when (error) {
    ServerError -> error.message
    Forbidden -> TODO()
    Unauthorized -> TODO()
}

fun main(args:Array<String>) {
    println(handleGetUserError(Forbidden))

    println(handleLoginError(InvalidUsername("alice", "/alicePath")))

    println(handleCommonError(ServerError))
}