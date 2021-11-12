package ch2.ch5

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeInstanceOf
import java.io.BufferedReader
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.RuntimeException

class ExceptionTest: AnnotationSpec() {

    @Test
    fun `퍼센트 테스트 - 정상`() {
        val input = 99

        val result = percentage(input)

        result shouldBe input
    }

    @Test
    fun `퍼센트 테스트 - 올바르지 않은 입력`() {
        val input = 101

        val ex = shouldThrow<RuntimeException> { percentage(input) }

        ex.shouldBeInstanceOf<IllegalArgumentException>()
    }

    @Test
    fun `숫자 입력 테스트 - 정상`() {
        val reader = BufferedReader(StringReader("123"))

        val result = readNumber1(reader)

        result shouldBe 123
    }

    @Test
    fun `숫자 입력 테스트 - 올바르지 않은 입력`() {
        val reader = BufferedReader(StringReader("123$"))

        val result = readNumber1(reader)

        result shouldBe null
    }
}