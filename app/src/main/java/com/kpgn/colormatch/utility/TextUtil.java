package com.kpgn.colormatch.utility;

import java.util.Locale;


public abstract class TextUtil {

    public static String getFormattedString(double doubleValue) {
        return String.format(Locale.US, "%.01f", doubleValue);
    }

}