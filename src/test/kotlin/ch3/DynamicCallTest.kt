package ch3

import ch3.ch3.Button
import ch3.ch3.View
import ch3.ch3.showOff
import ch3.ch3.usingDynamic
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class DynamicCallTest: FreeSpec() {
    init {
        "상속시, 동적 호출" {
            val view: View = View()
            view.click() shouldBe "View clicked"

            val button: View = Button()
            button.click() shouldBe "Button clicked"
        }

        "확장함수는 정적 호출" {
            val view: View = View()
            view.showOff() shouldBe "I'm a view!"

            val button: View = Button()
            button.showOff() shouldBe "I'm a view!"
        }

        "확장함수 정적 호출 우회" {
            val view: View = View()
            view.usingDynamic() shouldBe "View: View clicked"

            val button: View = Button()
            button.usingDynamic() shouldBe "View: Button clicked"
        }
    }
}