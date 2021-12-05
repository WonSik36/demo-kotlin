package ch6.ch1

class MyController {
    private lateinit var myService: MyService

    fun setMyService(myService: MyService) {
        this.myService = myService
    }

    fun call(): String {
        return myService.call()
    }
}
interface MyService {
    fun call(): String
}
class MyServiceImpl(): MyService {
    override fun call(): String {
        return "MyServiceImpl"
    }
}

fun main(args: Array<String>) {
    val controller = MyController()

    try {
        controller.call()
    } catch (ex: UninitializedPropertyAccessException) {
        println(ex.message)
    }

    controller.setMyService(MyServiceImpl())
    println(controller.call())
}