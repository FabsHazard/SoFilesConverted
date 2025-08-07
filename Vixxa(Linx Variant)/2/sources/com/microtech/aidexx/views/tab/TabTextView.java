package com.microtech.aidexx.views.tab;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.DensityUtils;
import com.microtech.aidexx.utils.ThemeManager;

public class TabTextView extends View implements TabView {
    private int mHeight;
    private int mPadding;
    private Paint mPaint;
    private String mText;
    private int mTextColor;
    private int mTextColorFocus;
    private float mTextHeight;
    private int mTextSize;
    private int mWidth;

    public void onScroll(float f) {
    }

    public void setNumber(String str, int i) {
    }

    public TabTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TabTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mText = "title";
        init(context);
    }

    private void init(Context context) {
        this.mTextSize = DensityUtils.dp2px(18.0f);
        this.mTextColor = ThemeManager.getTypeValue(getContext(), R.attr.colorFormTitle);
        this.mTextColorFocus = ThemeManager.getTypeValue(getContext(), R.attr.appColorAccent);
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setTextAlign(Paint.Align.CENTER);
        this.mPaint.setTextSize((float) this.mTextSize);
        this.mPaint.setFakeBoldText(true);
        this.mPaint.setColor(this.mTextColor);
        this.mTextHeight = getTextHeight(this.mPaint);
    }

    public float getTextHeight(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (float) ((Math.ceil((double) (fontMetrics.descent - fontMetrics.top)) + 2.0d) / 2.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(this.mText, ((float) this.mWidth) / 2.0f, (((float) this.mHeight) / 2.0f) + (this.mTextHeight / 2.0f), this.mPaint);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            this.mWidth = View.MeasureSpec.getSize(i);
        } else {
            this.mWidth = getTextWidth(this.mText, this.mPaint) + (this.mPadding * 2);
        }
        int defaultSize = getDefaultSize(getSuggestedMinimumWidth(), i2);
        this.mHeight = defaultSize;
        setMeasuredDimension(this.mWidth, defaultSize);
    }

    /* access modifiers changed from: package-private */
    public int getTextWidth(String str, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        return rect.width();
    }

    public void setText(String str) {
        this.mText = str;
        requestLayout();
    }

    public void setPadding(int i) {
        this.mPadding = i;
        requestLayout();
    }

    public void notifyData(boolean z) {
        this.mPaint.setColor(z ? this.mTextColorFocus : this.mTextColor);
        invalidate();
    }
}
