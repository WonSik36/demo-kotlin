package ch6.ch1

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

class NullableTypeTest: FreeSpec() {
    init {
        "Elvis 연산자" - {
            "Null 인 경우" {
                val len = strLenSafe2(null)

                len shouldBe 0
            }

            "Null 이 아닌 경우" {
                val len = strLenSafe2("123")

                len shouldBe 3
            }
        }

        "Not Null Assertion 연산자" - {
            "Null 인 경우" {
                shouldThrow<NullPointerException> { strLenSafe3(null) }
            }

            "Null 이 아닌 경우" {
                val len = strLenSafe3("123")

                len shouldBe 3
            }
        }
    }
}