package com.microtech.aidexx.ota;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.microtech.aidexx.utils.DensityUtils;
import com.microtech.aidexx.utils.ThemeManager;

public class HorizonProgressBar extends View {
    private final float barHeight;
    private Paint mBGPaint;
    private int mPercent;
    private String mPercentStr;
    private float mPercentWidth;
    private Paint mProgressPaint;
    private Paint mTextPaint;
    private Rect rect;

    public void setProgress(int i) {
        this.mPercent = i;
        this.mPercentStr = i + "%";
        postInvalidate();
    }

    public int getProgress() {
        return this.mPercent;
    }

    public HorizonProgressBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public HorizonProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPercent = 0;
        this.mPercentStr = "";
        this.mPercentWidth = 0.0f;
        this.barHeight = 20.0f;
        init();
    }

    private void init() {
        Paint paint = new Paint();
        this.mProgressPaint = paint;
        paint.setAntiAlias(true);
        this.mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressPaint.setStrokeWidth((float) DensityUtils.dp2px(20.0f));
        this.mProgressPaint.setStyle(Paint.Style.STROKE);
        if (ThemeManager.INSTANCE.isLight()) {
            this.mProgressPaint.setColor(Color.parseColor("#4D913C"));
        } else {
            this.mProgressPaint.setColor(Color.parseColor("#2784E4"));
        }
        Paint paint2 = new Paint();
        this.mTextPaint = paint2;
        paint2.setAntiAlias(true);
        this.mTextPaint.setSubpixelText(true);
        this.mTextPaint.setColor(Color.parseColor("#FFFFFF"));
        this.mTextPaint.setTextSize(30.0f);
        Paint paint3 = new Paint();
        this.mBGPaint = paint3;
        paint3.setAntiAlias(true);
        this.mBGPaint.setStrokeWidth((float) DensityUtils.dp2px(21.0f));
        this.mBGPaint.setStyle(Paint.Style.STROKE);
        this.mBGPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mBGPaint.setColor(Color.parseColor("#dddddd"));
        this.rect = new Rect();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i4 = 0;
        if (mode == 1073741824) {
            i3 = View.MeasureSpec.getSize(i);
        } else {
            i3 = mode == Integer.MIN_VALUE ? DensityUtils.dp2px(275.0f) : 0;
        }
        if (mode2 == 1073741824) {
            i4 = View.MeasureSpec.getSize(i2);
        } else if (mode == Integer.MIN_VALUE) {
            i4 = DensityUtils.dp2px(50.0f);
        }
        setMeasuredDimension(i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = this.mTextPaint;
        String str = this.mPercentStr;
        paint.getTextBounds(str, 0, str.length(), this.rect);
        canvas.drawLine((float) DensityUtils.dp2px(15.0f), (((float) getHeight()) / 2.0f) - (((float) DensityUtils.dp2px(20.0f)) / 2.0f), (float) (getWidth() - DensityUtils.dp2px(15.0f)), (((float) getHeight()) / 2.0f) - (((float) DensityUtils.dp2px(20.0f)) / 2.0f), this.mBGPaint);
        float width = ((float) ((getWidth() - DensityUtils.dp2px(30.0f)) * this.mPercent)) / 100.0f;
        this.mPercentWidth = width;
        if (width < ((float) this.rect.width())) {
            this.mPercentWidth = (float) this.rect.width();
        }
        canvas.drawLine((float) DensityUtils.dp2px(15.0f), (((float) getHeight()) / 2.0f) - (((float) DensityUtils.dp2px(20.0f)) / 2.0f), ((float) DensityUtils.dp2px(15.0f)) + this.mPercentWidth, (((float) getHeight()) / 2.0f) - (((float) DensityUtils.dp2px(20.0f)) / 2.0f), this.mProgressPaint);
        canvas.drawText(this.mPercentStr, (((float) DensityUtils.dp2px(15.0f)) + this.mPercentWidth) - ((float) this.rect.width()), ((((float) getHeight()) / 2.0f) - (((float) this.rect.height()) / 2.0f)) - ((float) DensityUtils.dp2px(2.0f)), this.mTextPaint);
    }
}
