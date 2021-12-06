package ch6.ch1;

import org.jetbrains.annotations.NotNull;

/**
 * @author 정원식 (wonsik.cheung)
 */
public class JavaPersonWithNullInfo {
    private final String name;

    public JavaPersonWithNullInfo(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    public String getName() {
        return this.name;
    }
}
