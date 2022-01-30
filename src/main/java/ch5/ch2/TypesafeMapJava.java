package ch5.ch2;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 정원식 (wonsik.cheung)
 */
public class TypesafeMapJava {
    private final Map<TypeReferenceJava<?>, Object> _map = new HashMap<>();

    <T> void put(TypeReferenceJava<T> key, T value) {
        _map.put(key, value);
    }

    <T> T get(TypeReferenceJava<T> key) {
        if(key.type() instanceof Class) {
            @SuppressWarnings("unchecked")
            Class<T> clazz = (Class<T>) key.type();

            return clazz.cast(_map.get(key));
        } else {
            ParameterizedType pt = (ParameterizedType) key.type();

            @SuppressWarnings("unchecked")
            Class<T> clazz = (Class<T>) pt.getRawType();

            return clazz.cast(_map.get(key));
        }
    }

    public static void main(String[] args) {
        TypesafeMapJava map = new TypesafeMapJava();

        map.put(new TypeReferenceJava<Integer>(){}, 1);
        map.put(new TypeReferenceJava<String>(){}, "a");
        map.put(new TypeReferenceJava<List<Integer>>(){}, List.of(1,2,3));
        map.put(new TypeReferenceJava<List<List<Integer>>>(){}, List.of(List.of(1,2,3)));


        System.out.println(map.get(new TypeReferenceJava<Integer>(){}));    // 1
        System.out.println(map.get(new TypeReferenceJava<String>(){}));     // a

        System.out.println(map.get(new TypeReferenceJava<List<Integer>>(){}));       // [1, 2, 3]
        System.out.println(map.get(new TypeReferenceJava<List<List<Integer>>>(){})); // [[1, 2, 3]]

        System.out.println(map.get(new TypeReferenceJava<List<String>>(){}));   // null
        // List<String> list = map.get(new TypeReferenceJava<List<Integer>>(){});  // compile error
    }
}
