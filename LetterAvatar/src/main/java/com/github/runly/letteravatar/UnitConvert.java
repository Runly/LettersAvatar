package com.github.runly.letteravatar;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Created by ranly on 17-2-6.
 */

public class UnitConvert {
    /**
     *convert dip tp px
     */
    public static int dp2Px(Context context, int dipValue) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dipValue, metrics) + 0.5f);
    }
}
