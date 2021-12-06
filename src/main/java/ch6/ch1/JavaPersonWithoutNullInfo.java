package ch6.ch1;

/**
 * @author 정원식 (wonsik.cheung)
 */
public class JavaPersonWithoutNullInfo {
    private final String name;

    public JavaPersonWithoutNullInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
