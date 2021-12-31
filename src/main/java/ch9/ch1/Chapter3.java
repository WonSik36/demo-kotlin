package ch9.ch1;

import java.io.IOException;

/**
 * @author 정원식 (wonsik.cheung)
 */
public class Chapter3 {

    public static <T extends CharSequence & Appendable> void ensureTrailingPeriod(T seq) {
        if(seq.charAt(seq.length() - 1) != '.') {
            try {
                seq.append('.');
            } catch (IOException ex) {
                // do nothing
            }
        }
    }
}
