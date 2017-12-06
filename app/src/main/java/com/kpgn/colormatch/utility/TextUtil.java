package com.kpgn.colormatch.utility;

import java.util.Locale;


public abstract class TextUtil {

    public static String getFormattedTime(long doubleValue) {
        return String.format(Locale.US, "%02d", doubleValue);
    }

}