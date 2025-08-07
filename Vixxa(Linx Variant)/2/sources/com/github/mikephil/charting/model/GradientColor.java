package com.github.mikephil.charting.model;

import com.github.mikephil.charting.utils.Fill;

@Deprecated
public class GradientColor extends Fill {
    @Deprecated
    public int getStartColor() {
        return getGradientColors()[0];
    }

    @Deprecated
    public void setStartColor(int i) {
        int i2 = 0;
        if (getGradientColors() == null || getGradientColors().length != 2) {
            if (getGradientColors() != null && getGradientColors().length > 1) {
                i2 = getGradientColors()[1];
            }
            setGradientColors(new int[]{i, i2});
            return;
        }
        getGradientColors()[0] = i;
    }

    @Deprecated
    public int getEndColor() {
        return getGradientColors()[1];
    }

    @Deprecated
    public void setEndColor(int i) {
        if (getGradientColors() == null || getGradientColors().length != 2) {
            int i2 = 0;
            if (getGradientColors() != null && getGradientColors().length > 0) {
                i2 = getGradientColors()[0];
            }
            setGradientColors(new int[]{i2, i});
            return;
        }
        getGradientColors()[1] = i;
    }
}
