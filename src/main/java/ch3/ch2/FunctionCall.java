package ch3.ch2;

import java.util.List;

/**
 * @author 정원식 (wonsik.cheung)
 */
public class FunctionCall {

    public static void main(String[] args) {
        List<Integer> list = List.of(1,2,3);


        System.out.println(StringFunctions.joinToString(list, "; ", "(", ")"));
        System.out.println(StringFunctions.joinToString(list));
    }
}
