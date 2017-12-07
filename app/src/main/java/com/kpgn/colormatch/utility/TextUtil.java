package com.kpgn.colormatch.utility;

import android.content.Context;

import com.kpgn.colormatch.R;
import com.kpgn.colormatch.constant.ApplicationConstant;

import java.util.Locale;
import java.util.Random;


public abstract class TextUtil {

    public static String getFormattedScore(long doubleValue) {
        return String.format(Locale.US, "%06d", doubleValue);
    }

    public static String getFormattedTime(long doubleValue) {
        return String.format(Locale.US, "%02d", doubleValue);
    }

    public static int getRandomInt(int min, int max) {
        return new Random().nextInt((max - min) + 1) + min;
    }

    public static int getColorInt(Context context, String textAColor) {
        switch(textAColor) {
            case ApplicationConstant.COLOR_BLACK:
                return context.getResources().getColor(R.color.colorBlack);
            case ApplicationConstant.COLOR_YELLOW:
                return context.getResources().getColor(R.color.colorYellow);
            case ApplicationConstant.COLOR_RED:
                return context.getResources().getColor(R.color.colorRed);
            case ApplicationConstant.COLOR_BLUE:
                return context.getResources().getColor(R.color.colorBlue);
            case ApplicationConstant.COLOR_GREEN:
                return context.getResources().getColor(R.color.colorGreen);
        }
        return context.getResources().getColor(R.color.colorBlack);
    }
}