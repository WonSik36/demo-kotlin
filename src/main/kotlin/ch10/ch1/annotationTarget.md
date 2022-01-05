# Annotation Target

## Target
* `property`: 프로퍼티 전체
* `field`: 프로퍼티에 의해 생성되는 (뒷받침하는) 필드
* `get`: 프로퍼티 게터
* `set`: 프로퍼티 세터
* `receiver`: 확장 함수나 프로퍼티의 수신 객체 파라미터
* `param`: 생성자 파라미터
* `setparam`: 세터 파라미터
* `delegate`: 위임 프로퍼티의 위임 인스턴스를 담아둔 필드
* `file`: 파일안에 선언된 최상위 함수와 프로퍼티를 담아두는 클래스

### 사용법
* 아래와 같이 어노테이션 앞에 적용 범위 기술
```
@file:JvmName 
```

## JAVA API
* `@JvmName`: 자바 필드나 메소드 이름을 변경
* `@JvmStatic`: 메소드, 객체 선언, 동반 객체에 적용시, 자바 정적 메소드로 노출됨
* `@JvmOverloads`: 디폴트 파라미터 값이 있는 함수에 대해 컴파일러가 자동으로 오버로딩한 함수 생성
* `@JvmField`: *public* 자바 필드로 프로퍼티를 노출