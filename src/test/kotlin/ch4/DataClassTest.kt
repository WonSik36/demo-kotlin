package ch4

import ch4.ch3.Address
import ch4.ch3.AddressWithEqualsAndHashCode
import ch4.ch3.Client3
import ch4.ch3.Client4
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class DataClassTest: FreeSpec() {
    init {
        "Data 클래스의 equals 와 hashCode 는 내부적으로 재귀 호출된다." - {
            "멤버 클래스가 equals 와 hashCode 를 구현한 경우" {
                val address1 = AddressWithEqualsAndHashCode("a", "b", "c")
                val client1 = Client3("Alice", 41024, address1)
                val address2 = AddressWithEqualsAndHashCode("a", "b", "c")
                val client2 = Client3("Alice", 41024, address2)

                (client1 == client2) shouldBe true
                client1.hashCode() shouldBe client2.hashCode()
            }

            "멤버 클래스가 equals 와 hashCode 를 구현하지 않은 경우" {
                val address1 = Address("a", "b", "c")
                val client1 = Client4("Alice", 41024, address1)
                val address2 = Address("a", "b", "c")
                val client2 = Client4("Alice", 41024, address2)

                (client1 == client2) shouldBe false
                client1.hashCode() shouldNotBe client2.hashCode()
            }
        }
    }
}