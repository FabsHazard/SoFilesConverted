package com.microtech.aidexx.views.dialog.standard;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

public class RemeasureTextView extends AppCompatTextView {
    public RemeasureTextView(Context context) {
        super(context);
    }

    public RemeasureTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Layout layout = getLayout();
        if (layout != null) {
            setMeasuredDimension(((int) Math.ceil((double) getMaxLineWidth(layout))) + getCompoundPaddingLeft() + getCompoundPaddingRight(), getMeasuredHeight());
        }
    }

    private float getMaxLineWidth(Layout layout) {
        int lineCount = layout.getLineCount();
        float f = 0.0f;
        for (int i = 0; i < lineCount; i++) {
            if (layout.getLineWidth(i) > f) {
                f = layout.getLineWidth(i);
            }
        }
        return f;
    }
}
