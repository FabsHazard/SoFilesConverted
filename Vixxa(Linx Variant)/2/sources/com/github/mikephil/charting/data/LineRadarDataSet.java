package com.github.mikephil.charting.data;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.ILineRadarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.Utils;
import java.util.List;

public abstract class LineRadarDataSet<T extends Entry> extends LineScatterCandleRadarDataSet<T> implements ILineRadarDataSet<T> {
    private boolean mDrawClipPathEnabled = false;
    private boolean mDrawFilled = false;
    private int mFillAlpha = 85;
    private int mFillColor = Color.rgb(140, 234, 255);
    private List<Integer> mFillColors = null;
    protected Drawable mFillDrawable;
    private List<Float> mFillGradientPositions = null;
    private float mLineWidth = 2.5f;

    public LineRadarDataSet(List<T> list, String str) {
        super(list, str);
    }

    public int getFillColor() {
        return this.mFillColor;
    }

    public void setFillColor(int i) {
        this.mFillColor = i;
        this.mFillDrawable = null;
    }

    public List<Integer> getFillColors() {
        return this.mFillColors;
    }

    public void setFillColors(List<Integer> list) {
        this.mFillColors = list;
    }

    public void setFillColors(int... iArr) {
        this.mFillColors = ColorTemplate.createColors(iArr);
    }

    public List<Float> getFillGradientPositions() {
        return this.mFillGradientPositions;
    }

    public void setFillGradientPositions(List<Float> list) {
        this.mFillGradientPositions = list;
    }

    public Drawable getFillDrawable() {
        return this.mFillDrawable;
    }

    public void setFillDrawable(Drawable drawable) {
        this.mFillDrawable = drawable;
    }

    public int getFillAlpha() {
        return this.mFillAlpha;
    }

    public void setFillAlpha(int i) {
        this.mFillAlpha = i;
    }

    public void setLineWidth(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 10.0f) {
            f = 10.0f;
        }
        this.mLineWidth = Utils.convertDpToPixel(f);
    }

    public float getLineWidth() {
        return this.mLineWidth;
    }

    public void setDrawFilled(boolean z) {
        this.mDrawFilled = z;
    }

    public void setClipPath(boolean z) {
        this.mDrawClipPathEnabled = z;
    }

    public boolean isDrawFilledEnabled() {
        return this.mDrawFilled;
    }

    public boolean isDrawClipPathEnabled() {
        return this.mDrawClipPathEnabled;
    }

    /* access modifiers changed from: protected */
    public void copy(LineRadarDataSet lineRadarDataSet) {
        super.copy(lineRadarDataSet);
        lineRadarDataSet.mDrawClipPathEnabled = this.mDrawClipPathEnabled;
        lineRadarDataSet.mDrawFilled = this.mDrawFilled;
        lineRadarDataSet.mFillAlpha = this.mFillAlpha;
        lineRadarDataSet.mFillColor = this.mFillColor;
        lineRadarDataSet.mFillDrawable = this.mFillDrawable;
        lineRadarDataSet.mLineWidth = this.mLineWidth;
    }
}
