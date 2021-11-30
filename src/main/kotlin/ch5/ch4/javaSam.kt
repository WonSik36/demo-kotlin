package ch5.ch4

fun main(args: Array<String>) {
    val button = Button()
    button.setOnClickListener { view -> println("${view.viewName} is clicked") }
    button.click()
    button.setOnClickListener(object :OnClickListener {
        override fun onClick(v: View?) {
            if (v is View) {
                println("${v.viewName} is clicked!!!")
            }
        }
    })
    button.click()

    button.postponeComputation(100) { println(42) }             // 기본 사용
    button.postponeComputation(100, object: Runnable {          // 무몀 객체: 매번 새로 생성
        override fun run() {
            println(42)
        }
    })

    button.postponeComputation(100){ println(42) }              // 람다: (외부 변수 사용 안할시) 전역 변수 사용
    button.postponeComputation(100, Runnable { println(42) })   // 앞선 람다식과 동일한 객체 & SAM 생성자
    val id = 1
    button.postponeComputation(100){ println(id) }              // 람다: (외부 변수 사용시) 매번 새로 생성

    val person = Person("alice", 27)
    person.showNameAndAge()
}

data class Person(val name: String, val age: Int) {
    fun showNameAndAge() {
        run { println("name: ${this.name}, age: ${this.age}") }         // 람다: this -> 람다를 둘러싼 클래스 인스턴스
    }
}