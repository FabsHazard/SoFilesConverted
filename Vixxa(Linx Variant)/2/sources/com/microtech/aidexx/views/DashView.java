package com.microtech.aidexx.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.widget.TextView;

public class DashView extends TextView {
    private final Paint linePaint;
    private final Path linePath;
    private final PathEffect pathEffect;

    public DashView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public DashView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.linePaint = new Paint();
        this.linePath = new Path();
        this.pathEffect = new DashPathEffect(new float[]{30.0f, 10.0f, 30.0f, 10.0f}, 2.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.linePaint.reset();
        this.linePaint.setAntiAlias(true);
        this.linePaint.setStyle(Paint.Style.STROKE);
        this.linePaint.setStrokeWidth(10.0f);
        this.linePaint.setColor(getTextColors().getDefaultColor());
        this.linePaint.setPathEffect(this.pathEffect);
        this.linePath.reset();
        this.linePath.moveTo(0.0f, 0.0f);
        this.linePath.lineTo(0.0f, (float) getHeight());
        canvas.drawPath(this.linePath, this.linePaint);
    }
}
