package be.fenego.android_spotshop.utilities;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by Thijs on 7/01/2017.
 */

@SuppressWarnings("DefaultFileTemplate")
public class InputFilterMinMax implements InputFilter {

    private final int min;
    private final int max;

    @SuppressWarnings("unused")
    public InputFilterMinMax(int min, int max) {
        this.min = min;
        this.max = max;
    }

    @SuppressWarnings("SameParameterValue")
    public InputFilterMinMax(String min, String max) {
        this.min = Integer.parseInt(min);
        this.max = Integer.parseInt(max);
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        try {
            int input = Integer.parseInt(dest.toString() + source.toString());
            if (isInRange(min, max, input))
                return null;
        } catch (NumberFormatException nfe) {
            System.out.println(nfe.getMessage());
        }
        return "";
    }

    private boolean isInRange(int a, int b, int c) {
        return b > a ? c >= a && c <= b : c >= b && c <= a;
    }
}