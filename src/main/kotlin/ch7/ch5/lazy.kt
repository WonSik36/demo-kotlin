package ch7.ch5


class Person1(val name: String) {
    private var _emails: List<String>? = null   // backing property
    val emails: List<String>
        get() {
            if(_emails == null) {
                _emails = loadEmails(this)  // not thread safe
            }

            return _emails!!
        }

    private fun loadEmails(person: Person1): List<String> {
        return listOf("example@example.com")
    }
}

class Person2(val name: String) {
    val emails: List<String> by lazy { loadEmails(this) }   // thread safe

    private fun loadEmails(person: Person2): List<String> {
        return listOf("example@example.com")
    }
}

