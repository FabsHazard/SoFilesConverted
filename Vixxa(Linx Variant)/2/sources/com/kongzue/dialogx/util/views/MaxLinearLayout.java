package com.kongzue.dialogx.util.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.kongzue.dialogx.R;

public class MaxLinearLayout extends LinearLayout {
    private int maxHeight;
    private int maxWidth;
    private int minHeight;
    private int minWidth;
    private int preWidth = -1;

    public MaxLinearLayout(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public MaxLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MaxLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DialogXMaxLayout);
            this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DialogXMaxLayout_maxLayoutWidth, 0);
            this.maxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DialogXMaxLayout_maxLayoutHeight, 0);
            this.minWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DialogXMaxLayout_minLayoutWidth, 0);
            this.minHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.DialogXMaxLayout_minLayoutHeight, 0);
            obtainStyledAttributes.recycle();
        }
        int i = this.minWidth;
        if (i == 0) {
            i = getMinimumWidth();
        }
        this.minWidth = i;
        int i2 = this.minHeight;
        if (i2 == 0) {
            i2 = getMinimumHeight();
        }
        this.minHeight = i2;
    }

    public MaxLinearLayout setMaxHeight(int i) {
        this.maxHeight = i;
        return this;
    }

    public MaxLinearLayout setMaxWidth(int i) {
        this.maxWidth = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i);
        if (this.preWidth == -1 && size2 != 0) {
            this.preWidth = size2;
        }
        int i3 = this.maxHeight;
        if (size > i3 && i3 != 0) {
            size = i3;
        }
        int i4 = this.maxWidth;
        if (size2 > i4 && i4 != 0) {
            size2 = i4;
        }
        View findViewWithTag = findViewWithTag("blurView");
        View findViewWithoutTag = findViewWithoutTag("blurView");
        if (findViewWithoutTag != null && findViewWithTag != null) {
            int measuredWidth = findViewWithoutTag.getMeasuredWidth() == 0 ? getMeasuredWidth() : findViewWithoutTag.getMeasuredWidth();
            int measuredHeight = findViewWithoutTag.getMeasuredHeight() == 0 ? getMeasuredHeight() : findViewWithoutTag.getMeasuredHeight();
            int i5 = this.minWidth;
            if (measuredWidth < i5) {
                measuredWidth = i5;
            }
            int i6 = this.minHeight;
            if (measuredHeight < i6) {
                measuredHeight = i6;
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) findViewWithTag.getLayoutParams();
            layoutParams.addRule(13);
            layoutParams.width = measuredWidth;
            layoutParams.height = measuredHeight;
            findViewWithTag.setLayoutParams(layoutParams);
        } else if (findViewWithTag != null) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) findViewWithTag.getLayoutParams();
            layoutParams2.width = getMeasuredWidth();
            layoutParams2.height = getMeasuredHeight();
            findViewWithTag.setLayoutParams(layoutParams2);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size2, mode2), View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    private View findViewWithoutTag(String str) {
        for (int i = 0; i < getChildCount(); i++) {
            if (!str.equals(getChildAt(i).getTag())) {
                return getChildAt(i);
            }
        }
        return null;
    }

    public int dip2px(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMinimumHeight(int i) {
        this.minHeight = i;
        super.setMinimumHeight(i);
    }

    public void setMinimumWidth(int i) {
        this.minWidth = i;
        super.setMinimumWidth(i);
    }
}
