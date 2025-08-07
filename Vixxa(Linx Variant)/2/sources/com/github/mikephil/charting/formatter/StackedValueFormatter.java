package com.github.mikephil.charting.formatter;

import com.github.mikephil.charting.data.BarEntry;
import java.text.DecimalFormat;

public class StackedValueFormatter extends ValueFormatter {
    private final boolean mDrawWholeStack;
    private final DecimalFormat mFormat;
    private final String mSuffix;

    public StackedValueFormatter(boolean z, String str, int i) {
        this.mDrawWholeStack = z;
        this.mSuffix = str;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer);
    }

    public String getBarStackedLabel(float f, BarEntry barEntry) {
        float[] yVals;
        if (this.mDrawWholeStack || (yVals = barEntry.getYVals()) == null) {
            return this.mFormat.format((double) f) + this.mSuffix;
        }
        if (yVals[yVals.length - 1] == f) {
            return this.mFormat.format((double) barEntry.getY()) + this.mSuffix;
        }
        return "";
    }
}
