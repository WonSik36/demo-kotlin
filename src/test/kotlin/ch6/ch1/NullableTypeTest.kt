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

        "shippingLabel 테스트" - {
            "null 이 아닌 경우" {
                val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
                val jetbrains = Company("Jetbrains", address)
                val person = Person("Dmitry", jetbrains)

                val label = shippingLabel(person)
                label shouldContain "Germany"
            }

            "null 인 경우" {
                val person = Person("Alice", null)

                val ex = shouldThrow<IllegalArgumentException> { shippingLabel(person) }
                ex.message shouldBe "No Address"
            }
        }
    }
}