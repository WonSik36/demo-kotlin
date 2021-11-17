package ch3.ch3;

import ch3.ch3.extensions.StringUtils;

public class JavaClient {
    public static void main(String[] args) {
        String str = "Hello Java";
        System.out.println(StringUtils.firstChar(str));
        System.out.println(StringUtils.lastChar(str));
    }
}
