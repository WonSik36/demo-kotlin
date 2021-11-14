package ch3

import io.kotest.core.spec.style.FreeSpec
import io.kotest.core.test.TestCase
import io.kotest.matchers.shouldBe

class CollectionTest: FreeSpec(){
    override fun beforeEach(testCase: TestCase) {
        println("beforeEach")
    }

    init {
        "컬렉션 테스트" - {
            "List" - {
                "arrayListOf" {
                    val list = arrayListOf("1", "2", "3")

                    list.javaClass.toString() shouldBe "class java.util.ArrayList"
                }

                "listOf" {
                    val list = listOf("1", "2", "3")

                    list.javaClass.toString() shouldBe "class java.util.Arrays\$ArrayList"
                }
            }

            "Set" - {
                "setOf" {
                    val set = setOf("1", "2", "3")

                    set.javaClass.toString() shouldBe "class java.util.LinkedHashSet"
                }

                "hashSetOf" {
                    val set = hashSetOf("1", "2", "3")

                    set.javaClass.toString() shouldBe "class java.util.HashSet"
                }
            }

            "Map" - {
                "mapOf" {
                    val map = mapOf("1" to 1, "2" to 2, "3" to 3)

                    map.javaClass.toString() shouldBe "class java.util.LinkedHashMap"
                }

                "hashMapOf" {
                    val map = hashMapOf("1" to 1, "2" to 2, "3" to 3)

                    map.javaClass.toString() shouldBe "class java.util.HashMap"
                }
            }
        }

        "확장 함수" - {
            "ex1" {
                val strings = listOf("first", "second", "fourteenth")

                strings.last() shouldBe "fourteenth"
            }

            "ex2" {
                val numbers = setOf(1, 14, 2)

                numbers.maxOrNull() shouldBe 14
            }
        }
    }
}