package ch5.ch2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;

/**
 * @author 정원식 (wonsik.cheung)
 */
public class TypeReferenceJava<T> {
    private final Type type;

    public TypeReferenceJava() {
        Type superType = this.getClass().getGenericSuperclass();

        // new TypeReference<Integer>(){} 와 같이 익명 클래스를 사용해서 정의
        if(superType instanceof ParameterizedType) {
            this.type = ((ParameterizedType) superType).getActualTypeArguments()[0];
        } else {
            throw new IllegalStateException("Generic Type is not set");
        }
    }

    public Type type() {
        return type;
    }

    // Map 에서 사용하기 위해 equals 와 hashCode 를 작성
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o instanceof TypeReference) return false;
        TypeReferenceJava<?> that = (TypeReferenceJava<?>) o;

        return type.equals(that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type);
    }
}
