package com.microtech.aidexx.views.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import androidx.appcompat.R;
import androidx.appcompat.widget.AppCompatTextView;

public class StateButton extends AppCompatTextView {
    private int mDuration;
    private GradientDrawable mNormalBackground;
    private int mNormalBackgroundColor;
    private int mNormalStrokeColor;
    private int mNormalStrokeWidth;
    private int mNormalTextColor;
    private GradientDrawable mPressedBackground;
    private int mPressedBackgroundColor;
    private int mPressedStrokeColor;
    private int mPressedStrokeWidth;
    private int mPressedTextColor;
    private float mRadius;
    private boolean mRound;
    StateListDrawable mStateBackground;
    private float mStrokeDashGap;
    private float mStrokeDashWidth;
    ColorStateList mTextColorStateList;
    private GradientDrawable mUnableBackground;
    private int mUnableBackgroundColor;
    private int mUnableStrokeColor;
    private int mUnableStrokeWidth;
    private int mUnableTextColor;
    private int[][] states;

    public StateButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public StateButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public StateButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNormalTextColor = 0;
        this.mPressedTextColor = 0;
        this.mUnableTextColor = 0;
        this.mDuration = 0;
        this.mRadius = 0.0f;
        this.mStrokeDashWidth = 0.0f;
        this.mStrokeDashGap = 0.0f;
        this.mNormalStrokeWidth = 0;
        this.mPressedStrokeWidth = 0;
        this.mUnableStrokeWidth = 0;
        this.mNormalStrokeColor = 0;
        this.mPressedStrokeColor = 0;
        this.mUnableStrokeColor = 0;
        this.mNormalBackgroundColor = 0;
        this.mPressedBackgroundColor = 0;
        this.mUnableBackgroundColor = 0;
        setup(attributeSet);
    }

    private void setup(AttributeSet attributeSet) {
        this.states = new int[4][];
        Drawable background = getBackground();
        if (background instanceof StateListDrawable) {
            this.mStateBackground = (StateListDrawable) background;
        } else {
            this.mStateBackground = new StateListDrawable();
        }
        this.mNormalBackground = new GradientDrawable();
        this.mPressedBackground = new GradientDrawable();
        this.mUnableBackground = new GradientDrawable();
        int[][] iArr = this.states;
        iArr[0] = new int[]{16842910, 16842919};
        iArr[1] = new int[]{16842910, 16842908};
        iArr[3] = new int[]{-16842910};
        iArr[2] = new int[]{16842910};
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.microtech.aidexx.R.styleable.StateButton);
        ColorStateList textColors = getTextColors();
        this.mTextColorStateList = textColors;
        int colorForState = textColors.getColorForState(this.states[2], getCurrentTextColor());
        int colorForState2 = this.mTextColorStateList.getColorForState(this.states[0], getCurrentTextColor());
        int colorForState3 = this.mTextColorStateList.getColorForState(this.states[3], getCurrentTextColor());
        this.mNormalTextColor = obtainStyledAttributes.getColor(com.microtech.aidexx.R.styleable.StateButton_normalTextColor, colorForState);
        this.mPressedTextColor = obtainStyledAttributes.getColor(com.microtech.aidexx.R.styleable.StateButton_pressedTextColor, colorForState2);
        this.mUnableTextColor = obtainStyledAttributes.getColor(com.microtech.aidexx.R.styleable.StateButton_unableTextColor, colorForState3);
        setTextColor();
        int integer = obtainStyledAttributes.getInteger(com.microtech.aidexx.R.styleable.StateButton_animationDuration, this.mDuration);
        this.mDuration = integer;
        this.mStateBackground.setEnterFadeDuration(integer);
        this.mStateBackground.setExitFadeDuration(this.mDuration);
        this.mNormalBackgroundColor = obtainStyledAttributes.getColor(com.microtech.aidexx.R.styleable.StateButton_normalBackgroundColor, 0);
        this.mPressedBackgroundColor = obtainStyledAttributes.getColor(com.microtech.aidexx.R.styleable.StateButton_pressedBackgroundColor, 0);
        this.mUnableBackgroundColor = obtainStyledAttributes.getColor(com.microtech.aidexx.R.styleable.StateButton_unableBackgroundColor, 0);
        this.mNormalBackground.setColor(this.mNormalBackgroundColor);
        this.mPressedBackground.setColor(this.mPressedBackgroundColor);
        this.mUnableBackground.setColor(this.mUnableBackgroundColor);
        this.mRadius = (float) obtainStyledAttributes.getDimensionPixelSize(com.microtech.aidexx.R.styleable.StateButton_bgRadius, 0);
        this.mRound = obtainStyledAttributes.getBoolean(com.microtech.aidexx.R.styleable.StateButton_isRound, false);
        this.mNormalBackground.setCornerRadius(this.mRadius);
        this.mPressedBackground.setCornerRadius(this.mRadius);
        this.mUnableBackground.setCornerRadius(this.mRadius);
        this.mStrokeDashWidth = (float) obtainStyledAttributes.getDimensionPixelSize(com.microtech.aidexx.R.styleable.StateButton_strokeDashWidth, 0);
        this.mStrokeDashGap = (float) obtainStyledAttributes.getDimensionPixelSize(com.microtech.aidexx.R.styleable.StateButton_strokeDashWidth, 0);
        this.mNormalStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(com.microtech.aidexx.R.styleable.StateButton_normalStrokeWidth, 0);
        this.mPressedStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(com.microtech.aidexx.R.styleable.StateButton_pressedStrokeWidth, 0);
        this.mUnableStrokeWidth = obtainStyledAttributes.getDimensionPixelSize(com.microtech.aidexx.R.styleable.StateButton_unableStrokeWidth, 0);
        this.mNormalStrokeColor = obtainStyledAttributes.getColor(com.microtech.aidexx.R.styleable.StateButton_normalStrokeColor, 0);
        this.mPressedStrokeColor = obtainStyledAttributes.getColor(com.microtech.aidexx.R.styleable.StateButton_pressedStrokeColor, 0);
        this.mUnableStrokeColor = obtainStyledAttributes.getColor(com.microtech.aidexx.R.styleable.StateButton_unableStrokeColor, 0);
        setStroke();
        this.mStateBackground.addState(this.states[0], this.mPressedBackground);
        this.mStateBackground.addState(this.states[1], this.mPressedBackground);
        this.mStateBackground.addState(this.states[3], this.mUnableBackground);
        this.mStateBackground.addState(this.states[2], this.mNormalBackground);
        setBackgroundDrawable(this.mStateBackground);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setRound(this.mRound);
    }

    public void setNormalStrokeColor(int i) {
        this.mNormalStrokeColor = i;
        setStroke(this.mNormalBackground, i, this.mNormalStrokeWidth);
    }

    public void setPressedStrokeColor(int i) {
        this.mPressedStrokeColor = i;
        setStroke(this.mPressedBackground, i, this.mPressedStrokeWidth);
    }

    public void setUnableStrokeColor(int i) {
        this.mUnableStrokeColor = i;
        setStroke(this.mUnableBackground, i, this.mUnableStrokeWidth);
    }

    public void setStateStrokeColor(int i, int i2, int i3) {
        this.mNormalStrokeColor = i;
        this.mPressedStrokeColor = i2;
        this.mUnableStrokeColor = i3;
        setStroke();
    }

    public void setNormalStrokeWidth(int i) {
        this.mNormalStrokeWidth = i;
        setStroke(this.mNormalBackground, this.mNormalStrokeColor, i);
    }

    public void setPressedStrokeWidth(int i) {
        this.mPressedStrokeWidth = i;
        setStroke(this.mPressedBackground, this.mPressedStrokeColor, i);
    }

    public void setUnableStrokeWidth(int i) {
        this.mUnableStrokeWidth = i;
        setStroke(this.mUnableBackground, this.mUnableStrokeColor, i);
    }

    public void setStateStrokeWidth(int i, int i2, int i3) {
        this.mNormalStrokeWidth = i;
        this.mPressedStrokeWidth = i2;
        this.mUnableStrokeWidth = i3;
        setStroke();
    }

    public void setStrokeDash(float f, float f2) {
        this.mStrokeDashWidth = f;
        this.mStrokeDashGap = f;
        setStroke();
    }

    private void setStroke() {
        setStroke(this.mNormalBackground, this.mNormalStrokeColor, this.mNormalStrokeWidth);
        setStroke(this.mPressedBackground, this.mPressedStrokeColor, this.mPressedStrokeWidth);
        setStroke(this.mUnableBackground, this.mUnableStrokeColor, this.mUnableStrokeWidth);
    }

    private void setStroke(GradientDrawable gradientDrawable, int i, int i2) {
        gradientDrawable.setStroke(i2, i, this.mStrokeDashWidth, this.mStrokeDashGap);
    }

    public void setRadius(float f) {
        this.mRadius = f;
        this.mNormalBackground.setCornerRadius(f);
        this.mPressedBackground.setCornerRadius(this.mRadius);
        this.mUnableBackground.setCornerRadius(this.mRadius);
    }

    public void setRound(boolean z) {
        this.mRound = z;
        int measuredHeight = getMeasuredHeight();
        if (this.mRound) {
            setRadius(((float) measuredHeight) / 2.0f);
        }
    }

    public void setRadius(float[] fArr) {
        this.mNormalBackground.setCornerRadii(fArr);
        this.mPressedBackground.setCornerRadii(fArr);
        this.mUnableBackground.setCornerRadii(fArr);
    }

    public void setStateBackgroundColor(int i, int i2, int i3) {
        this.mNormalBackgroundColor = i;
        this.mPressedBackgroundColor = i2;
        this.mUnableBackgroundColor = i3;
        this.mNormalBackground.setColor(i);
        this.mPressedBackground.setColor(this.mPressedBackgroundColor);
        this.mUnableBackground.setColor(this.mUnableBackgroundColor);
    }

    public void setNormalBackgroundColor(int i) {
        this.mNormalBackgroundColor = i;
        this.mNormalBackground.setColor(i);
    }

    public void setPressedBackgroundColor(int i) {
        this.mPressedBackgroundColor = i;
        this.mPressedBackground.setColor(i);
    }

    public void setUnableBackgroundColor(int i) {
        this.mUnableBackgroundColor = i;
        this.mUnableBackground.setColor(i);
    }

    public void setAnimationDuration(int i) {
        this.mDuration = i;
        this.mStateBackground.setEnterFadeDuration(i);
    }

    private void setTextColor() {
        int i = this.mPressedTextColor;
        ColorStateList colorStateList = new ColorStateList(this.states, new int[]{i, i, this.mNormalTextColor, this.mUnableTextColor});
        this.mTextColorStateList = colorStateList;
        setTextColor(colorStateList);
    }

    public void setStateTextColor(int i, int i2, int i3) {
        this.mNormalTextColor = i;
        this.mPressedTextColor = i2;
        this.mUnableTextColor = i3;
        setTextColor();
    }

    public void setNormalTextColor(int i) {
        this.mNormalTextColor = i;
        setTextColor();
    }

    public void setPressedTextColor(int i) {
        this.mPressedTextColor = i;
        setTextColor();
    }

    public void setUnableTextColor(int i) {
        this.mUnableTextColor = i;
        setTextColor();
    }
}
