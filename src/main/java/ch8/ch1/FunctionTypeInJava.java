package ch8.ch1;

import kotlin.Unit;
import kotlin.collections.CollectionsKt;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 정원식 (wonsik.cheung)
 */
public class FunctionTypeInJava {
    public static void main(String[] args) {
        FunctionTypeInJavaKt.processTheAnswer(x -> x + 1);

        List<String> strings = new ArrayList<>();
        strings.add("42");
        CollectionsKt.forEach(strings, s -> {
            System.out.println(s);
            return Unit.INSTANCE;
        });
    }
}
