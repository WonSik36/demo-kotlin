# inline 함수

### 배경
* 코틀린은 보통 람다를 무명 클래스로 컴파일 한다. 보통 람다 식을 사용할때마다 같은 클래스를 사용한다.
* 하지만 변수를 포획하면 생성되는 시점마다 새로운 클래스를 생성한다.
* 그리고 이는 부가 비용이 들고, 일반 함수를 사용하는것보다 비효율적이다.

### 개념
* *inline* 변경자를 어떤 함수에 붙이면 컴파일러는 그 함수를 호출하는 모든 문장을 함수 본문에 해당하는 바이트코드로 바꿔치기한다.
* 즉, 새로운 무명 클래스를 생성하지 않는다.

### 사용시 주의 사항
* 일반적으로 인라인 함수의 본문에서 람다 식을 바로 호출하거나 람다 식을 인자로 전달받아 바로 호출하는 경우에는 그 람다를 인라이닝 할 수 있다.
* 하지만 전달받은 람다를 프로퍼티로 저장하는 경우, inline 할 수 없다. (파라미터로 받는 메서드가 inline 인 경우, *noinline* 을 붙여줘야한다.)

### 컬렉션 연산
* 컬렉션 연산을 할때, 전달받은 람다를 inline 한다.
* 시퀀스로 연산을 할때, 전달받은 람다를 저장해야하므로(최종 연산에서 그동안 저장된 람다를 연쇄 호출) inline 하지 않는다.
* 결론: 시퀀스 연산에서 람다가 인라이닝 되지 않기 때문에 크기가 작은 컬렉션은 오히려 일반 컬렉션 연산이 더 성능이 나을 수도 있다.

### 함수를 인라인으로 선언해야하는 경우
* 결론: 람다를 인자로 받는 함수만 성능이 좋아질 가능성이 높다.
* 일반 함수 호출의 경우 JVM 이 이미 강력하게 인라이닝을 지원한다.
* 람다를 인자로 받는 함수를 인라이닝하면 함수 호출 비용을 줄이고 람다를 표현하는 클래스와 객체를 만들 필요가 없다.
* 주의사항: 인라이닝 하는 함수가 크면서 호출하는 지점이 많다면 전체 바이트 코드가 엄청 커질수 있다.