# Variance

## Invariance, Covariance, Contravariance
* Invariance: 타입 사이에 하위 타입 관계가 성립하지 않음
* Covariance: 하위 타입 관계가 유지된다. (out)
* Contravariance: 상위 타입 관계가 유지된다. (in)

| Invariance        | Covariance                                   | Contravariance                               |
|-------------------|----------------------------------------------|----------------------------------------------|
| MutableList\<T\>  | Producer\<out T\>                            | Consumer\<in T\>                             |
| 하위 타입 관계 X        | 타입 인자의 하위 타입 관계가 제네릭 타입에서 유지                 | 타입 인자의 하위 타입 관계가 제네릭 타입에서 뒤집힘                |
|                   | Producer\<Cat\> 은 Producer\<Animal\> 의 하위 타입 | Consumer\<Animal\> 은 Consumer\<Cat\> 의 하위 타입 |
| T를 아무 위치에서나 사용 가능 | T를 파라미터 위치에서만 사용 가능                          | T를 리턴 위치에서만 사용 가능                            | 

### 세부 사항
* 생성자 파라미터는 in, out 모두 해당되지 않는다.
* private 메서드의 파라미터는 in, out 모두 해당되지 않는다.

## 선언 지점 변성, 사용 지점 변성
* 선언 지점 변성: 클래스를 선언하면서 변성을 지정
* 사용 지점 변경: 타입 파라미터가 있는 타입을 사용할때마다 해당 타입 파라미터의 변성을 지정
  * `fun<T> copyData(src: MutableList<out T>, dst: MutableList<in T>)`
    * src 에서 T 를 in 위치에서 사용하는 메서드 호출 X
      * in 메서드 사용시 `Required: Nothing`
    * dst 에서 T 를 out 위치에서 사용하는 메서드 호출 X
      * out 메서드 사용시 `Any?` 로 반환

## 스타 프로젝션
* 어떤 구체적인 타입의 원소만을 사용하나 해당 원소의 타입을 정확히 모름
* 값을 만들어내는 메서드만 호출할 수 있고, 그 값의 타입을 신경써서는 안된다.