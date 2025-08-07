package com.microtech.aidexx.views.codeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;

public class PwdTextView extends AppCompatTextView {
    private boolean hasPwd;
    private float radius;

    public PwdTextView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PwdTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PwdTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.hasPwd) {
            Paint paint = new Paint(1);
            paint.setColor(ViewCompat.MEASURED_STATE_MASK);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), this.radius, paint);
        }
    }

    public void clearPwd() {
        this.hasPwd = false;
        invalidate();
    }

    public void drawPwd(float f) {
        this.hasPwd = true;
        if (f == 0.0f) {
            this.radius = (float) (getWidth() / 4);
        } else {
            this.radius = f;
        }
        invalidate();
    }
}
