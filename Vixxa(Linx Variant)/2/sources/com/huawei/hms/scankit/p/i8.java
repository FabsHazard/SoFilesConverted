package com.huawei.hms.scankit.p;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

/* compiled from: ViewUtils */
public class i8 {
    public static int a(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("navigation_bar_height", "dimen", "android"));
    }

    public static Point b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point;
    }

    public static int a(Context context, int i) {
        return (int) ((((float) i) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}
