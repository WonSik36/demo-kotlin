package ch5.ch4;

/**
 * @author 정원식 (wonsik.cheung)
 */
public interface View {
    void setOnClickListener(OnClickListener listener);

    String getViewName();
}
