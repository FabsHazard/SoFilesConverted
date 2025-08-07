package com.github.mikephil.charting.interfaces.datasets;

import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import java.util.List;

public interface ILineRadarDataSet<T extends Entry> extends ILineScatterCandleRadarDataSet<T> {
    int getFillAlpha();

    int getFillColor();

    List<Integer> getFillColors();

    Drawable getFillDrawable();

    List<Float> getFillGradientPositions();

    float getLineWidth();

    boolean isDrawClipPathEnabled();

    boolean isDrawFilledEnabled();

    void setClipPath(boolean z);

    void setDrawFilled(boolean z);
}
