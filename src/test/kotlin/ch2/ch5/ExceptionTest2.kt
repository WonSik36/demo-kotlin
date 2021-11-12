package ch2.ch5

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.RuntimeException

class ExceptionTest2 : FreeSpec({
    "퍼센트 테스트" - {

        "성공" - {
            (0..100).map { number ->
                "입력: $number" {
                    percentage(number) shouldBe number
                }
            }
        }

        "올바르지 않은 입력" {
            val input = 101
            val ex = shouldThrow<RuntimeException> { percentage(input) }
            ex.shouldBeInstanceOf<IllegalArgumentException>()
        }
    }

    "숫자 입력 테스트" - {

        "성공" - {
            arrayListOf("1", "10", "100", "1000").map { number ->
                "입력: $number" {
                    val reader = BufferedReader(StringReader("123"))

                    val result = readNumber2(reader)

                    result shouldBe 123
                }
            }
        }

        "올바르지 않은 입력" {
            val reader = BufferedReader(StringReader("123$"))

            val result = readNumber2(reader)

            result shouldBe null
        }
    }
})
