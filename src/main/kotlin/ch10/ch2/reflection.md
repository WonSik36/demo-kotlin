# Kotlin Reflection API

## KAnnotatedElement
* 어노테이션이 적용된 엘레먼트
```
public interface KAnnotatedElement {
    public val annotations: List<Annotation>
}
```

## KClass
* 클래스
```
public actual interface KClass<T : Any> : KDeclarationContainer, KAnnotatedElement, KClassifier {
    public actual val simpleName: String?
    public actual val qualifiedName: String?
    override val members: Collection<KCallable<*>>
    public val constructors: Collection<KFunction<T>>
    public val nestedClasses: Collection<KClass<*>>
    public val objectInstance: T?
    ...
}
```

## KCallable
* 호출할 수 있는 엔티티
```
public actual interface KCallable<out R> : KAnnotatedElement {
    public fun call(vararg args: Any?): R
    ...
}
```

### KFunction
* 함수
```
public actual interface KFunction<out R> : KCallable<R>, Function<R> {
    ...
}
```

### KProperty
* 프로퍼티
```
public actual interface KProperty<out V> : KCallable<V> {
    public val getter: Getter<V>
    ...
}
```

### KMutableProperty
* 변경 가능한 프로퍼티
```
public actual interface KMutableProperty<V> : KProperty<V> {
    public val setter: Setter<V>
    ...
}
```


## KParameter
* 파라미터
```
public interface KParameter : KAnnotatedElement {
    public val index: Int
    public val name: String?
    public val type: KType  // for varargs
    public val kind: Kind
    ...
}
```