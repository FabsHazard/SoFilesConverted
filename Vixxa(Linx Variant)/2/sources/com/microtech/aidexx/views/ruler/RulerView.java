package com.microtech.aidexx.views.ruler;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.core.view.ViewCompat;
import com.contrarywind.timer.MessageHandler;
import com.microtech.aidexx.R;
import java.text.NumberFormat;
import java.util.Locale;

public class RulerView extends View {
    private static final boolean LOG_ENABLE = false;
    private final int MAX_FLING_VELOCITY;
    private final int MIN_FLING_VELOCITY;
    private final int TOUCH_SLOP;
    private int[] barColors;
    private float barWidth;
    private int bgColor;
    private float[] colorStartValues;
    private float currentValue;
    private int gradationColor;
    private float gradationGap;
    private float gradationNumberGap;
    private float gradationUnit;
    private boolean[] indicatorColorChange;
    private int indicatorLineColor;
    private float indicatorLineLen;
    private float indicatorLineWidth;
    private boolean isMoved;
    private float longGradationLen;
    private float longLineWidth;
    private int[] mColorStartNumber;
    private float mCurrentDistance;
    private int mCurrentNumber;
    private int mDownX;
    private int mHalfWidth;
    private int mHeight;
    private int mLastX;
    private int mLastY;
    private int mMaxNumber;
    private int mMinNumber;
    private float mNumberRangeDistance;
    private int mNumberUnit;
    private Paint mPaint;
    private Scroller mScroller;
    private TextPaint mTextPaint;
    private OnValueChangedListener mValueChangedListener;
    private VelocityTracker mVelocityTracker;
    private int mWidth;
    private int mWidthRangeNumber;
    private float maxValue;
    private float minValue;
    private int numberPerCount;
    private float shortGradationLen;
    private float shortLineWidth;
    private int stickyIndex;
    private int textColor;
    private float textSize;

    public interface OnValueChangedListener {
        void onValueChanged(float f);
    }

    private void logD(String str, Object... objArr) {
    }

    public RulerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RulerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RulerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.stickyIndex = -1;
        initAttrs(context, attributeSet);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.TOUCH_SLOP = viewConfiguration.getScaledTouchSlop();
        this.MIN_FLING_VELOCITY = viewConfiguration.getScaledMinimumFlingVelocity();
        this.MAX_FLING_VELOCITY = viewConfiguration.getScaledMaximumFlingVelocity();
        convertValue2Number();
        init(context);
    }

    private void initAttrs(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RuleView);
        this.bgColor = obtainStyledAttributes.getColor(R.styleable.RuleView_zjun_bgColor, Color.parseColor("#f5f8f5"));
        this.gradationColor = obtainStyledAttributes.getColor(R.styleable.RuleView_zjun_gradationColor, -3355444);
        this.shortLineWidth = obtainStyledAttributes.getDimension(R.styleable.RuleView_gv_shortLineWidth, (float) dp2px(1.0f));
        this.shortGradationLen = obtainStyledAttributes.getDimension(R.styleable.RuleView_gv_shortGradationLen, (float) dp2px(16.0f));
        this.longGradationLen = obtainStyledAttributes.getDimension(R.styleable.RuleView_gv_longGradationLen, this.shortGradationLen * 2.0f);
        this.longLineWidth = obtainStyledAttributes.getDimension(R.styleable.RuleView_gv_longLineWidth, this.shortLineWidth * 2.0f);
        this.textColor = obtainStyledAttributes.getColor(R.styleable.RuleView_zjun_textColor, ViewCompat.MEASURED_STATE_MASK);
        this.textSize = obtainStyledAttributes.getDimension(R.styleable.RuleView_zjun_textSize, (float) sp2px(14.0f));
        this.indicatorLineColor = obtainStyledAttributes.getColor(R.styleable.RuleView_zjun_indicatorLineColor, Color.parseColor("#48b975"));
        this.indicatorLineWidth = obtainStyledAttributes.getDimension(R.styleable.RuleView_zjun_indicatorLineWidth, (float) dp2px(3.0f));
        this.indicatorLineLen = obtainStyledAttributes.getDimension(R.styleable.RuleView_gv_indicatorLineLen, (float) dp2px(35.0f));
        this.minValue = obtainStyledAttributes.getFloat(R.styleable.RuleView_gv_minValue, 0.0f);
        this.maxValue = obtainStyledAttributes.getFloat(R.styleable.RuleView_gv_maxValue, 100.0f);
        this.currentValue = obtainStyledAttributes.getFloat(R.styleable.RuleView_gv_currentValue, 50.0f);
        this.gradationUnit = obtainStyledAttributes.getFloat(R.styleable.RuleView_gv_gradationUnit, 0.1f);
        this.numberPerCount = obtainStyledAttributes.getInt(R.styleable.RuleView_gv_numberPerCount, 10);
        this.gradationGap = obtainStyledAttributes.getDimension(R.styleable.RuleView_gv_gradationGap, (float) dp2px(10.0f));
        this.gradationNumberGap = obtainStyledAttributes.getDimension(R.styleable.RuleView_gv_gradationNumberGap, (float) dp2px(8.0f));
        obtainStyledAttributes.recycle();
    }

    private void init(Context context) {
        Paint paint = new Paint(1);
        this.mPaint = paint;
        paint.setStrokeWidth(this.shortLineWidth);
        TextPaint textPaint = new TextPaint(1);
        this.mTextPaint = textPaint;
        textPaint.setTextSize(this.textSize);
        this.mTextPaint.setColor(this.textColor);
        this.mScroller = new Scroller(context);
    }

    private void convertValue2Number() {
        setColorStartValues(this.colorStartValues);
        int i = (int) (this.minValue * 10.0f);
        this.mMinNumber = i;
        int i2 = (int) (this.maxValue * 10.0f);
        this.mMaxNumber = i2;
        int i3 = (int) (this.currentValue * 10.0f);
        this.mCurrentNumber = i3;
        int i4 = (int) (this.gradationUnit * 10.0f);
        this.mNumberUnit = i4;
        float f = this.gradationGap;
        this.mCurrentDistance = ((float) ((i3 - i) / i4)) * f;
        this.mNumberRangeDistance = ((float) ((i2 - i) / i4)) * f;
        int i5 = this.mWidth;
        if (i5 != 0) {
            this.mWidthRangeNumber = (int) ((((float) i5) / f) * ((float) i4));
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.mWidth = calculateSize(true, i);
        int calculateSize = calculateSize(false, i2);
        this.mHeight = calculateSize;
        int i3 = this.mWidth;
        this.mHalfWidth = i3 >> 1;
        if (this.mWidthRangeNumber == 0) {
            this.mWidthRangeNumber = (int) ((((float) i3) / this.gradationGap) * ((float) this.mNumberUnit));
        }
        setMeasuredDimension(i3, calculateSize);
    }

    private int calculateSize(boolean z, int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int min = (mode == Integer.MIN_VALUE && !z) ? Math.min(size, dp2px(80.0f)) : size;
        logD("isWidth=%b, mode=%d, size=%d, realSize=%d", Boolean.valueOf(z), Integer.valueOf(mode), Integer.valueOf(size), Integer.valueOf(min));
        return min;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        logD("onTouchEvent: action=%d", Integer.valueOf(action));
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (action == 0) {
            this.mScroller.forceFinished(true);
            this.mDownX = x;
            this.isMoved = false;
        } else if (action == 1) {
            this.mVelocityTracker.computeCurrentVelocity(1000, (float) this.MAX_FLING_VELOCITY);
            int xVelocity = (int) this.mVelocityTracker.getXVelocity();
            if (Math.abs(xVelocity) >= this.MIN_FLING_VELOCITY) {
                this.mScroller.fling((int) this.mCurrentDistance, 0, -xVelocity, 0, 0, (int) this.mNumberRangeDistance, 0, 0);
                invalidate();
            } else {
                scrollToGradation();
            }
        } else if (action == 2) {
            int i = x - this.mLastX;
            if (!this.isMoved) {
                if (Math.abs(i) >= Math.abs(y - this.mLastY) && Math.abs(x - this.mDownX) >= this.TOUCH_SLOP) {
                    this.isMoved = true;
                }
            }
            this.mCurrentDistance += (float) (-i);
            calculateValue();
        }
        this.mLastX = x;
        this.mLastY = y;
        return true;
    }

    private void calculateValue() {
        float min = Math.min(Math.max(this.mCurrentDistance, 0.0f), this.mNumberRangeDistance);
        this.mCurrentDistance = min;
        int round = this.mMinNumber + (Math.round(min / this.gradationGap) * this.mNumberUnit);
        this.mCurrentNumber = round;
        this.currentValue = ((float) round) / 10.0f;
        logD("calculateValue: mCurrentDistance=%f, mCurrentNumber=%d, currentValue=%f", Float.valueOf(this.mCurrentDistance), Integer.valueOf(this.mCurrentNumber), Float.valueOf(this.currentValue));
        OnValueChangedListener onValueChangedListener = this.mValueChangedListener;
        if (onValueChangedListener != null) {
            onValueChangedListener.onValueChanged(this.currentValue);
        }
        invalidate();
    }

    private void scrollToGradation() {
        int round = this.mMinNumber + (Math.round(this.mCurrentDistance / this.gradationGap) * this.mNumberUnit);
        this.mCurrentNumber = round;
        int min = Math.min(Math.max(round, this.mMinNumber), this.mMaxNumber);
        this.mCurrentNumber = min;
        float f = ((float) ((min - this.mMinNumber) / this.mNumberUnit)) * this.gradationGap;
        this.mCurrentDistance = f;
        this.currentValue = ((float) min) / 10.0f;
        logD("scrollToGradation: mCurrentDistance=%f, mCurrentNumber=%d, currentValue=%f", Float.valueOf(f), Integer.valueOf(this.mCurrentNumber), Float.valueOf(this.currentValue));
        OnValueChangedListener onValueChangedListener = this.mValueChangedListener;
        if (onValueChangedListener != null) {
            onValueChangedListener.onValueChanged(this.currentValue);
        }
        invalidate();
    }

    public void computeScroll() {
        if (!this.mScroller.computeScrollOffset()) {
            return;
        }
        if (this.mScroller.getCurrX() != this.mScroller.getFinalX()) {
            this.mCurrentDistance = (float) this.mScroller.getCurrX();
            calculateValue();
            return;
        }
        scrollToGradation();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.drawColor(this.bgColor);
        drawGradation(canvas);
        drawColorBar(canvas);
        drawIndicator(canvas);
    }

    private void drawGradation(Canvas canvas) {
        this.mPaint.setColor(this.gradationColor);
        this.mPaint.setStrokeWidth(this.shortLineWidth);
        float f = this.mCurrentDistance;
        int i = this.mHalfWidth;
        float f2 = this.gradationGap;
        int i2 = this.mNumberUnit;
        int i3 = this.mMinNumber;
        int i4 = i2 << 1;
        int i5 = ((((((int) f) - i) / ((int) f2)) * i2) + i3) - i4;
        if (i5 < i3) {
            i5 = i3;
        }
        int i6 = i5 + i4 + this.mWidthRangeNumber + i4;
        int i7 = this.mMaxNumber;
        if (i6 > i7) {
            i6 = i7;
        }
        float f3 = ((float) i) - (f - (((float) ((i5 - i3) / i2)) * f2));
        int i8 = i2 * this.numberPerCount;
        while (i5 <= i6) {
            if (i5 % i8 == 0) {
                this.mPaint.setStrokeWidth(this.longLineWidth);
                canvas.drawLine(f3, 0.0f, f3, this.longGradationLen, this.mPaint);
                String f4 = Float.toString(((float) i5) / 10.0f);
                logD("drawGradation: text=%s", f4);
                if (f4.endsWith(".0")) {
                    f4 = f4.substring(0, f4.length() - 2);
                }
                float measureText = this.mTextPaint.measureText(f4);
                canvas.drawText(NumberFormat.getInstance(Locale.getDefault()).format((long) Integer.parseInt(f4)), f3 - (measureText * 0.5f), this.longGradationLen + this.gradationNumberGap + this.textSize, this.mTextPaint);
            } else {
                this.mPaint.setStrokeWidth(this.shortLineWidth);
                canvas.drawLine(f3, 0.0f, f3, this.shortGradationLen, this.mPaint);
            }
            i5 += this.mNumberUnit;
            f3 += this.gradationGap;
        }
    }

    private void drawColorBar(Canvas canvas) {
        float f;
        int[] iArr = this.mColorStartNumber;
        if (iArr != null && iArr.length != 0) {
            this.mPaint.setStrokeWidth(this.barWidth);
            float f2 = this.mCurrentDistance;
            int i = this.mHalfWidth;
            float f3 = this.gradationGap;
            int i2 = this.mNumberUnit;
            int i3 = this.mMinNumber;
            int i4 = i2 << 1;
            int i5 = ((((((int) f2) - i) / ((int) f3)) * i2) + i3) - i4;
            if (i5 < i3) {
                i5 = i3;
            }
            int i6 = i5 + i4 + this.mWidthRangeNumber + i4;
            int i7 = this.mMaxNumber;
            if (i6 > i7) {
                i6 = i7;
            }
            float f4 = ((float) i) - (f2 - (((float) ((i5 - i3) / i2)) * f3));
            float f5 = ((float) i) - (f2 - (((float) ((i6 - i3) / i2)) * f3));
            int i8 = 0;
            while (true) {
                int[] iArr2 = this.mColorStartNumber;
                if (i8 < iArr2.length) {
                    if (i8 == this.stickyIndex) {
                        f = (float) this.mHalfWidth;
                    } else {
                        int i9 = iArr2[i8];
                        if (i9 < i5) {
                            f = f4;
                        } else {
                            f = i9 <= this.mMaxNumber ? ((float) this.mHalfWidth) - (this.mCurrentDistance - (((float) ((i9 - this.mMinNumber) / this.mNumberUnit)) * this.gradationGap)) : f5;
                        }
                    }
                    Paint paint = this.mPaint;
                    int[] iArr3 = this.barColors;
                    paint.setColor(iArr3[i8 % iArr3.length]);
                    float f6 = this.barWidth;
                    canvas.drawLine(f, f6 / 2.0f, f5, f6 / 2.0f, this.mPaint);
                    i8++;
                } else {
                    return;
                }
            }
        }
    }

    private void drawIndicator(Canvas canvas) {
        getIndicatorLineColor();
        this.mPaint.setColor(this.indicatorLineColor);
        this.mPaint.setStrokeWidth(this.indicatorLineWidth);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        int i = this.mHalfWidth;
        canvas.drawLine((float) i, 0.0f, (float) i, this.indicatorLineLen, this.mPaint);
        this.mPaint.setStrokeCap(Paint.Cap.BUTT);
    }

    private int dp2px(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    private int sp2px(float f) {
        return (int) TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public void setCurrentValue(float f) {
        if (f < this.minValue || f > this.maxValue) {
            throw new IllegalArgumentException(String.format("The currentValue of %f is out of range: [%f, %f]", new Object[]{Float.valueOf(f), Float.valueOf(this.minValue), Float.valueOf(this.maxValue)}));
        }
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.currentValue = f;
        int i = (int) (f * 10.0f);
        this.mCurrentNumber = i;
        float f2 = ((float) ((i - this.mMinNumber) / this.mNumberUnit)) * this.gradationGap;
        float f3 = this.mCurrentDistance;
        int i2 = (int) (f2 - f3);
        this.mScroller.startScroll((int) f3, 0, i2, (i2 * MessageHandler.WHAT_SMOOTH_SCROLL) / ((int) this.mNumberRangeDistance));
        postInvalidate();
    }

    public float getMinValue() {
        return this.minValue;
    }

    public float getMaxValue() {
        return this.maxValue;
    }

    public float getCurrentValue() {
        return this.currentValue;
    }

    public void setValue(float f, float f2, float f3, float f4, int i) {
        if (f > f2 || f3 < f || f3 > f2) {
            throw new IllegalArgumentException(String.format("The given values are invalid, check firstly: minValue=%f, maxValue=%f, curValue=%s", new Object[]{Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3)}));
        }
        if (!this.mScroller.isFinished()) {
            this.mScroller.forceFinished(true);
        }
        this.minValue = f;
        this.maxValue = f2;
        this.currentValue = f3;
        this.gradationUnit = f4;
        this.numberPerCount = i;
        convertValue2Number();
        postInvalidate();
    }

    public void setBarWidth(float f) {
        this.barWidth = f;
    }

    public void setBarColors(int[] iArr) {
        this.barColors = iArr;
    }

    public void setColorStartValues(float[] fArr) {
        this.colorStartValues = fArr;
        if (fArr != null && fArr.length > 0) {
            this.mColorStartNumber = new int[fArr.length];
            boolean[] zArr = this.indicatorColorChange;
            boolean z = zArr == null || zArr.length != fArr.length;
            if (z) {
                this.indicatorColorChange = new boolean[fArr.length];
            }
            for (int i = 0; i < fArr.length; i++) {
                this.mColorStartNumber[i] = (int) (fArr[i] * 10.0f);
                if (z) {
                    this.indicatorColorChange[i] = false;
                }
            }
        }
    }

    public void setStickyIndex(int i) {
        this.stickyIndex = i;
    }

    public void setIndicatorColorChange(boolean[] zArr) {
        this.indicatorColorChange = zArr;
    }

    public int getIndicatorLineColor() {
        int i;
        int[] iArr = this.mColorStartNumber;
        if (iArr != null && iArr.length > 0) {
            int i2 = 0;
            while (true) {
                int[] iArr2 = this.mColorStartNumber;
                if (i2 < iArr2.length) {
                    if (i2 == this.stickyIndex) {
                        i = this.mCurrentNumber;
                    } else {
                        i = iArr2[i2];
                    }
                    float f = (float) i;
                    int i3 = this.mCurrentNumber;
                    if (((float) i3) <= f && (((float) i3) != f || !this.indicatorColorChange[i2])) {
                        break;
                    }
                    int[] iArr3 = this.barColors;
                    this.indicatorLineColor = iArr3[i2 % iArr3.length];
                    i2++;
                } else {
                    break;
                }
            }
        }
        return this.indicatorLineColor;
    }

    public void setOnValueChangedListener(OnValueChangedListener onValueChangedListener) {
        this.mValueChangedListener = onValueChangedListener;
    }
}
