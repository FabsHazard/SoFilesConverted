package com.microtech.aidexx.ui.main.trend.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.DensityUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\tJ$\u0010\u0019\u001a\u00020\u00172\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0014J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0014R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/view/DotView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dotColor", "getDotColor", "()I", "setDotColor", "(I)V", "mPaint", "Landroid/graphics/Paint;", "getMPaint", "()Landroid/graphics/Paint;", "setMPaint", "(Landroid/graphics/Paint;)V", "changeColor", "", "color", "init", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DotView.kt */
public final class DotView extends View {
    private int dotColor;
    private Paint mPaint;

    public final int getDotColor() {
        return this.dotColor;
    }

    public final void setDotColor(int i) {
        this.dotColor = i;
    }

    public final Paint getMPaint() {
        return this.mPaint;
    }

    public final void setMPaint(Paint paint) {
        Intrinsics.checkNotNullParameter(paint, "<set-?>");
        this.mPaint = paint;
    }

    public DotView(Context context) {
        this(context, (AttributeSet) null);
    }

    public DotView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DotView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dotColor = R.color.gray_cc;
        this.mPaint = new Paint();
        init(context, attributeSet, i);
    }

    private final void init(Context context, AttributeSet attributeSet, int i) {
        if (context != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.DotView, i, 0);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
            this.dotColor = obtainStyledAttributes.getColor(R.styleable.DotView_dot_color, ContextCompat.getColor(context, R.color.gray_cc));
            obtainStyledAttributes.recycle();
        }
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i4 = 0;
        if (mode == Integer.MIN_VALUE) {
            i3 = DensityUtils.dp2px(12.0f);
        } else if (mode != 1073741824) {
            i3 = 0;
        } else {
            i3 = View.MeasureSpec.getSize(i);
        }
        if (mode2 == 1073741824) {
            i4 = View.MeasureSpec.getSize(i2);
        } else if (mode == Integer.MIN_VALUE) {
            i4 = DensityUtils.dp2px(12.0f);
        }
        setMeasuredDimension(i3, i4);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        this.mPaint.setColor(this.dotColor);
        canvas.drawCircle(((float) getWidth()) / 2.0f, ((float) getHeight()) / 2.0f, ((float) getWidth()) / 2.0f, this.mPaint);
    }

    public final void changeColor(int i) {
        this.dotColor = i;
        postInvalidate();
    }
}
