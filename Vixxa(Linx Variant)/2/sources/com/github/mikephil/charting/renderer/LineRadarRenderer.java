package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import com.github.mikephil.charting.animation.ChartAnimator;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public abstract class LineRadarRenderer extends LineScatterCandleRadarRenderer {
    public LineRadarRenderer(ChartAnimator chartAnimator, ViewPortHandler viewPortHandler) {
        super(chartAnimator, viewPortHandler);
    }

    /* access modifiers changed from: protected */
    public void drawFilledPath(Canvas canvas, Path path, Drawable drawable, boolean z) {
        if (clipPathSupported()) {
            int save = canvas.save();
            canvas.clipPath(path);
            drawable.setBounds((int) this.mViewPortHandler.contentLeft(), (int) this.mViewPortHandler.contentTop(), (int) this.mViewPortHandler.contentRight(), (int) this.mViewPortHandler.contentBottom());
            drawable.draw(canvas);
            canvas.restoreToCount(save);
            return;
        }
        throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this ic_vcode was run on API level " + Utils.getSDKInt() + ".");
    }

    /* access modifiers changed from: protected */
    public void drawFilledPath(Canvas canvas, Path path, int i, int i2, boolean z) {
        int i3 = (i & 16777215) | (i2 << 24);
        Paint.Style style = this.mRenderPaint.getStyle();
        int color = this.mRenderPaint.getColor();
        this.mRenderPaint.setStyle(Paint.Style.FILL);
        this.mRenderPaint.setColor(i3);
        if (clipPathSupported()) {
            int save = canvas.save();
            if (z) {
                canvas.clipPath(path);
            }
            canvas.drawColor(i3);
            try {
                canvas.drawPaint(this.mRenderPaint);
                canvas.restoreToCount(save);
            } catch (Exception unused) {
            }
        } else {
            canvas.drawPath(path, this.mRenderPaint);
        }
        this.mRenderPaint.setColor(color);
        this.mRenderPaint.setStyle(style);
    }

    private boolean clipPathSupported() {
        return Utils.getSDKInt() >= 18;
    }
}
