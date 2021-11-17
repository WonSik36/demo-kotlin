package ch3.ch6

data class User(val id: Int, val name: String, val address: String)

fun main(args: Array<String>) {
    val user = User(1, "bob", "Seoul")

    saveUser(user)
}

fun saveUser(user: User) {
    user.validateBeforeSave()

    println("$user is saved")
}

fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if(value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }

    validate(name, "Name")
    validate(address, "Address")
}