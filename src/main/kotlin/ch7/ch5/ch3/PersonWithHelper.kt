package ch7.ch5.ch3

class PersonWithHelper(
    val name: String, age: Int, salary: Int
): PropertyChangeAware() {
    var age: Int by ObservableProperty(age, changeSupport)
    var salary: Int by ObservableProperty(salary, changeSupport)
}