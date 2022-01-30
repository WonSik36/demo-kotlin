package ch5.ch2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author 정원식 (wonsik.cheung)
 */
public class SuperTypeToken<T> {
    private final T value;

    public SuperTypeToken(T value) {
        this.value = value;
    }

    public static void main(String[] args) {
        // SuperTypeToken 을 상속한 익명 클래스 작성
        SuperTypeToken<List<Integer>> token = new SuperTypeToken<>(List.of(1,2,3)){};
        ParameterizedType pt = (ParameterizedType) token.getClass() // 익명 클래스
                .getGenericSuperclass();            // SuperTypeToken<List<Integer>>
        Type[] types = pt.getActualTypeArguments(); //<List<Integer>>
        System.out.println(types[0]);               // java.util.List<java.lang.Integer>

        SuperTypeToken<List<List<Integer>>> t2 = new SuperTypeToken<>(List.of(List.of(1,2,3))){};
        ParameterizedType pt2 = (ParameterizedType) t2.getClass().getGenericSuperclass();
        System.out.println(pt2.getActualTypeArguments()[0]); // java.util.List<java.util.List<java.lang.Integer>>
    }
}
