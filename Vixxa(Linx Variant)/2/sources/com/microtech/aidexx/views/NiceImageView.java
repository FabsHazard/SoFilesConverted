package com.microtech.aidexx.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.DensityUtils;

public class NiceImageView extends AppCompatImageView {
    private int borderColor;
    private float[] borderRadii;
    private RectF borderRectF;
    private int borderWidth;
    private int cornerBottomLeftRadius;
    private int cornerBottomRightRadius;
    private int cornerRadius;
    private int cornerTopLeftRadius;
    private int cornerTopRightRadius;
    private int height;
    private int innerBorderColor;
    private int innerBorderWidth;
    private boolean isCircle;
    private boolean isCoverSrc;
    private int maskColor;
    private Paint paint;
    private Path path;
    private float radius;
    private Path srcPath;
    private float[] srcRadii;
    private RectF srcRectF;
    private int width;
    private Xfermode xfermode;

    public NiceImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public NiceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NiceImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isCircle = true;
        this.isCoverSrc = true;
        this.borderColor = -1;
        this.innerBorderColor = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NiceImageView, 0, 0);
        for (int i2 = 0; i2 < obtainStyledAttributes.getIndexCount(); i2++) {
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.NiceImageView_is_cover_src) {
                this.isCoverSrc = obtainStyledAttributes.getBoolean(index, this.isCoverSrc);
            } else if (index == R.styleable.NiceImageView_is_circle) {
                this.isCircle = obtainStyledAttributes.getBoolean(index, this.isCircle);
            } else if (index == R.styleable.NiceImageView_border_width) {
                this.borderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.borderWidth);
            } else if (index == R.styleable.NiceImageView_border_color) {
                this.borderColor = obtainStyledAttributes.getColor(index, this.borderColor);
            } else if (index == R.styleable.NiceImageView_inner_border_width) {
                this.innerBorderWidth = obtainStyledAttributes.getDimensionPixelSize(index, this.innerBorderWidth);
            } else if (index == R.styleable.NiceImageView_inner_border_color) {
                this.innerBorderColor = obtainStyledAttributes.getColor(index, this.innerBorderColor);
            } else if (index == R.styleable.NiceImageView_corner_radius) {
                this.cornerRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerRadius);
            } else if (index == R.styleable.NiceImageView_corner_top_left_radius) {
                this.cornerTopLeftRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerTopLeftRadius);
            } else if (index == R.styleable.NiceImageView_corner_top_right_radius) {
                this.cornerTopRightRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerTopRightRadius);
            } else if (index == R.styleable.NiceImageView_corner_bottom_left_radius) {
                this.cornerBottomLeftRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerBottomLeftRadius);
            } else if (index == R.styleable.NiceImageView_corner_bottom_right_radius) {
                this.cornerBottomRightRadius = obtainStyledAttributes.getDimensionPixelSize(index, this.cornerBottomRightRadius);
            } else if (index == R.styleable.NiceImageView_mask_color) {
                this.maskColor = obtainStyledAttributes.getColor(index, this.maskColor);
            }
        }
        this.borderRadii = new float[8];
        this.srcRadii = new float[8];
        this.borderRectF = new RectF();
        this.srcRectF = new RectF();
        this.paint = new Paint();
        this.path = new Path();
        if (Build.VERSION.SDK_INT <= 26) {
            this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
            return;
        }
        this.xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.srcPath = new Path();
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.width = i;
        this.height = i2;
        clearInnerBorderWidth();
        calculateRadii();
        initBorderRectF();
        initSrcRectF();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.saveLayer(this.srcRectF, (Paint) null, 31);
        if (!this.isCoverSrc) {
            int i = this.width;
            int i2 = this.borderWidth;
            int i3 = this.innerBorderWidth;
            int i4 = this.height;
            canvas.scale((((float) ((i - (i2 * 2)) - (i3 * 2))) * 1.0f) / ((float) i), (((float) ((i4 - (i2 * 2)) - (i3 * 2))) * 1.0f) / ((float) i4), ((float) i) / 2.0f, ((float) i4) / 2.0f);
        }
        super.onDraw(canvas);
        this.paint.reset();
        this.path.reset();
        this.srcPath.reset();
        if (this.isCircle) {
            this.path.addCircle(((float) this.width) / 2.0f, ((float) this.height) / 2.0f, this.radius, Path.Direction.CCW);
        } else {
            this.path.addRoundRect(this.srcRectF, this.srcRadii, Path.Direction.CCW);
        }
        this.paint.setAntiAlias(true);
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setXfermode(this.xfermode);
        if (Build.VERSION.SDK_INT <= 26) {
            canvas.drawPath(this.path, this.paint);
        } else {
            this.srcPath.addRect(this.srcRectF, Path.Direction.CCW);
            this.srcPath.op(this.path, Path.Op.DIFFERENCE);
            canvas.drawPath(this.srcPath, this.paint);
        }
        this.paint.setXfermode((Xfermode) null);
        int i5 = this.maskColor;
        if (i5 != 0) {
            this.paint.setColor(i5);
            canvas.drawPath(this.path, this.paint);
        }
        canvas.restore();
        drawBorders(canvas);
    }

    private void drawBorders(Canvas canvas) {
        if (this.isCircle) {
            int i = this.borderWidth;
            if (i > 0) {
                drawCircleBorder(canvas, i, this.borderColor, this.radius - (((float) i) / 2.0f));
            }
            int i2 = this.innerBorderWidth;
            if (i2 > 0) {
                drawCircleBorder(canvas, i2, this.innerBorderColor, (this.radius - ((float) this.borderWidth)) - (((float) i2) / 2.0f));
                return;
            }
            return;
        }
        int i3 = this.borderWidth;
        if (i3 > 0) {
            drawRectFBorder(canvas, i3, this.borderColor, this.borderRectF, this.borderRadii);
        }
    }

    private void drawCircleBorder(Canvas canvas, int i, int i2, float f) {
        initBorderPaint(i, i2);
        this.path.addCircle(((float) this.width) / 2.0f, ((float) this.height) / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void drawRectFBorder(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        initBorderPaint(i, i2);
        this.path.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.path, this.paint);
    }

    private void initBorderPaint(int i, int i2) {
        this.path.reset();
        this.paint.setStrokeWidth((float) i);
        this.paint.setColor(i2);
        this.paint.setStyle(Paint.Style.STROKE);
    }

    private void initBorderRectF() {
        if (!this.isCircle) {
            RectF rectF = this.borderRectF;
            int i = this.borderWidth;
            rectF.set(((float) i) / 2.0f, ((float) i) / 2.0f, ((float) this.width) - (((float) i) / 2.0f), ((float) this.height) - (((float) i) / 2.0f));
        }
    }

    private void initSrcRectF() {
        if (this.isCircle) {
            float min = ((float) Math.min(this.width, this.height)) / 2.0f;
            this.radius = min;
            RectF rectF = this.srcRectF;
            int i = this.width;
            int i2 = this.height;
            rectF.set((((float) i) / 2.0f) - min, (((float) i2) / 2.0f) - min, (((float) i) / 2.0f) + min, (((float) i2) / 2.0f) + min);
            return;
        }
        this.srcRectF.set(0.0f, 0.0f, (float) this.width, (float) this.height);
        if (this.isCoverSrc) {
            this.srcRectF = this.borderRectF;
        }
    }

    private void calculateRadii() {
        if (!this.isCircle) {
            int i = 0;
            if (this.cornerRadius > 0) {
                while (true) {
                    float[] fArr = this.borderRadii;
                    if (i < fArr.length) {
                        int i2 = this.cornerRadius;
                        fArr[i] = (float) i2;
                        this.srcRadii[i] = ((float) i2) - (((float) this.borderWidth) / 2.0f);
                        i++;
                    } else {
                        return;
                    }
                }
            } else {
                float[] fArr2 = this.borderRadii;
                int i3 = this.cornerTopLeftRadius;
                float f = (float) i3;
                fArr2[1] = f;
                fArr2[0] = f;
                int i4 = this.cornerTopRightRadius;
                float f2 = (float) i4;
                fArr2[3] = f2;
                fArr2[2] = f2;
                int i5 = this.cornerBottomRightRadius;
                float f3 = (float) i5;
                fArr2[5] = f3;
                fArr2[4] = f3;
                int i6 = this.cornerBottomLeftRadius;
                float f4 = (float) i6;
                fArr2[7] = f4;
                fArr2[6] = f4;
                float[] fArr3 = this.srcRadii;
                int i7 = this.borderWidth;
                float f5 = ((float) i3) - (((float) i7) / 2.0f);
                fArr3[1] = f5;
                fArr3[0] = f5;
                float f6 = ((float) i4) - (((float) i7) / 2.0f);
                fArr3[3] = f6;
                fArr3[2] = f6;
                float f7 = ((float) i5) - (((float) i7) / 2.0f);
                fArr3[5] = f7;
                fArr3[4] = f7;
                float f8 = ((float) i6) - (((float) i7) / 2.0f);
                fArr3[7] = f8;
                fArr3[6] = f8;
            }
        }
    }

    private void calculateRadiiAndRectF(boolean z) {
        if (z) {
            this.cornerRadius = 0;
        }
        calculateRadii();
        initBorderRectF();
        invalidate();
    }

    private void clearInnerBorderWidth() {
        if (!this.isCircle) {
            this.innerBorderWidth = 0;
        }
    }

    public void isCoverSrc(boolean z) {
        this.isCoverSrc = z;
        initSrcRectF();
        invalidate();
    }

    public void isCircle(boolean z) {
        this.isCircle = z;
        clearInnerBorderWidth();
        initSrcRectF();
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.borderWidth = DensityUtils.dp2px((float) i);
        calculateRadiiAndRectF(false);
    }

    public void setBorderColor(int i) {
        this.borderColor = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.innerBorderWidth = DensityUtils.dp2px((float) i);
        clearInnerBorderWidth();
        invalidate();
    }

    public void setInnerBorderColor(int i) {
        this.innerBorderColor = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.cornerRadius = DensityUtils.dp2px((float) i);
        calculateRadiiAndRectF(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.cornerTopLeftRadius = DensityUtils.dp2px((float) i);
        calculateRadiiAndRectF(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.cornerTopRightRadius = DensityUtils.dp2px((float) i);
        calculateRadiiAndRectF(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.cornerBottomLeftRadius = DensityUtils.dp2px((float) i);
        calculateRadiiAndRectF(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.cornerBottomRightRadius = DensityUtils.dp2px((float) i);
        calculateRadiiAndRectF(true);
    }

    public void setMaskColor(int i) {
        this.maskColor = i;
        invalidate();
    }
}
