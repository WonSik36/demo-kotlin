package ch5.ch2;


import java.util.*;

/**
 * @author 정원식 (wonsik.cheung)
 */
public class SimpleTypesafeMapJava {
    private final Map<Class<?>, Object> _map = new HashMap<>();

    <T> void put(Class<T> key, T value) {
        _map.put(key, value);
    }

    <T> T get(Class<T> key) {
        return key.cast(_map.get(key));
    }

    public static void main(String[] args) {
        SimpleTypesafeMapJava map = new SimpleTypesafeMapJava();

        map.put(Integer.class, 1);
        map.put(String.class, "a");
        map.put(List.class, List.of(1,2,3));

        System.out.println(map.get(Integer.class));
        System.out.println(map.get(String.class));

        // error
        List<String> list = map.get(List.class);
        list.forEach(str -> str.length());
    }
}
