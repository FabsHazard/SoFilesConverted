package com.microtech.aidexx.views.selector.time;

import com.contrarywind.adapter.WheelAdapter;
import com.microtech.aidexx.common.ExtendsKt;

public class NumericWheelAdapter implements WheelAdapter {
    private final int maxValue;
    private final int minValue;

    public NumericWheelAdapter(int i, int i2) {
        this.minValue = i;
        this.maxValue = i2;
    }

    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return ExtendsKt.setYearFormat(this.minValue + i);
    }

    public int getItemsCount() {
        return (this.maxValue - this.minValue) + 1;
    }

    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.minValue;
        } catch (Exception unused) {
            return -1;
        }
    }
}
