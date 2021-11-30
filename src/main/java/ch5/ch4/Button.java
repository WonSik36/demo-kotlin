package ch5.ch4;

/**
 * @author 정원식 (wonsik.cheung)
 */
public class Button implements View {
    private OnClickListener listener;

    @Override
    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void click() {
        listener.onClick(this);
    }

    public void postponeComputation(int delay, Runnable computation) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        computation.run();
    }

    @Override
    public String getViewName() {
        return "Button";
    }
}
