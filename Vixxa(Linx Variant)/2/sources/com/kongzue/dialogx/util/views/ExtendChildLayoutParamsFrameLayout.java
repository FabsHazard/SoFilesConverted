package com.kongzue.dialogx.util.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

public class ExtendChildLayoutParamsFrameLayout extends FrameLayout {
    public ExtendChildLayoutParamsFrameLayout(Context context) {
        super(context);
    }

    public ExtendChildLayoutParamsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ExtendChildLayoutParamsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        setLayoutParams(new RelativeLayout.LayoutParams(layoutParams.width, layoutParams.height));
        super.addView(view, i, layoutParams);
    }
}
