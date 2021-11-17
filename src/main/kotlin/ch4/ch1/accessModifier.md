# Access Modifier

## Inheritance

### interface
* 인터페이스 멤버는 항상 open 이며 final 로 변경할 수 없다.
* 인터페이스 멤버는 본문이 없으면 자동으로 추상 멤버가 된다.

### class

| modifier | 이 변경자가 붙은 멤버는.. | 설명 |
|---|---|---|
| final | 오버라이드할 수 없음 | 클래스 멤버의 기본 변경자 |
| open | 오버라이드할 수 있음 | 반드시 open 을 명시해야 오버라이드 가능 |
| abstract | 반드시 오버라이드해야 함 | 추상 클래스의 멤버에만 이 변경자를 붙일수 있다 |
| override | 상위 클래스나 상위 인스턴스의 멤버를 오버라이딩 하는 중 | 오버라이드하는 멤버는 기본적으로 open. <br>하위 클래스의 오버라이드를 금지하려면 final 명시 |

## Visibility

| modifier | 클래스 멤버 | 최상위 선언 |
|---|---|---|
| public (기본) | 모든 곳에서 볼 수 있다. | 모든 곳에서 볼 수 있다. |
| internal | 같은 모듈 안에서만 볼 수 있다. | 같은 모듈 안에서만 볼 수 있다. |
| protected | 하위 클래스 안에서만 볼 수 있다 | (최상위 선언에 적용할 수 없음) |
| private | 같은 클래스 안에서만 볼 수 있다 | 같은 파일 안에서만 볼 수 있다. |

## Reference
* [Kotlin in Action](http://www.acornpub.co.kr/book/kotlin-in-action) 의 4장