package ch5.ch2;

/**
 * @author 정원식 (wonsik.cheung)
 */
public class SimpleTypeEntry<T> {
    private final T value;

    public SimpleTypeEntry(T value) {
        this.value = value;
    }

    public static void main(String[] args) throws Exception {
        SimpleTypeEntry<Integer> entry = new SimpleTypeEntry<Integer>(1);

        System.out.println(entry.getClass().getDeclaredField("value").getType());   // class java.lang.Object
    }
}
