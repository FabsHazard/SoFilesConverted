package com.github.mikephil.charting.utils;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public class Fill {
    private int mAlpha;
    private Integer mColor;
    protected Drawable mDrawable;
    private Integer mFinalColor;
    private int[] mGradientColors;
    private float[] mGradientPositions;
    private Type mType;

    public enum Direction {
        DOWN,
        UP,
        RIGHT,
        LEFT
    }

    public enum Type {
        EMPTY,
        COLOR,
        LINEAR_GRADIENT,
        DRAWABLE
    }

    public Fill() {
        this.mType = Type.EMPTY;
        this.mColor = null;
        this.mFinalColor = null;
        this.mAlpha = 255;
    }

    public Fill(int i) {
        this.mType = Type.EMPTY;
        this.mColor = null;
        this.mFinalColor = null;
        this.mAlpha = 255;
        this.mType = Type.COLOR;
        this.mColor = Integer.valueOf(i);
        calculateFinalColor();
    }

    public Fill(int i, int i2) {
        this.mType = Type.EMPTY;
        this.mColor = null;
        this.mFinalColor = null;
        this.mAlpha = 255;
        this.mType = Type.LINEAR_GRADIENT;
        this.mGradientColors = new int[]{i, i2};
    }

    public Fill(int[] iArr) {
        this.mType = Type.EMPTY;
        this.mColor = null;
        this.mFinalColor = null;
        this.mAlpha = 255;
        this.mType = Type.LINEAR_GRADIENT;
        this.mGradientColors = iArr;
    }

    public Fill(int[] iArr, float[] fArr) {
        this.mType = Type.EMPTY;
        this.mColor = null;
        this.mFinalColor = null;
        this.mAlpha = 255;
        this.mType = Type.LINEAR_GRADIENT;
        this.mGradientColors = iArr;
        this.mGradientPositions = fArr;
    }

    public Fill(Drawable drawable) {
        this.mType = Type.EMPTY;
        this.mColor = null;
        this.mFinalColor = null;
        this.mAlpha = 255;
        this.mType = Type.DRAWABLE;
        this.mDrawable = drawable;
    }

    public Type getType() {
        return this.mType;
    }

    public void setType(Type type) {
        this.mType = type;
    }

    public Integer getColor() {
        return this.mColor;
    }

    public void setColor(int i) {
        this.mColor = Integer.valueOf(i);
        calculateFinalColor();
    }

    public int[] getGradientColors() {
        return this.mGradientColors;
    }

    public void setGradientColors(int[] iArr) {
        this.mGradientColors = iArr;
    }

    public float[] getGradientPositions() {
        return this.mGradientPositions;
    }

    public void setGradientPositions(float[] fArr) {
        this.mGradientPositions = fArr;
    }

    public void setGradientColors(int i, int i2) {
        this.mGradientColors = new int[]{i, i2};
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public void setAlpha(int i) {
        this.mAlpha = i;
        calculateFinalColor();
    }

    private void calculateFinalColor() {
        Integer num = this.mColor;
        if (num == null) {
            this.mFinalColor = null;
        } else {
            this.mFinalColor = Integer.valueOf((((int) Math.floor(((((double) (num.intValue() >> 24)) / 255.0d) * (((double) this.mAlpha) / 255.0d)) * 255.0d)) << 24) | (this.mColor.intValue() & 16777215));
        }
    }

    /* renamed from: com.github.mikephil.charting.utils.Fill$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$github$mikephil$charting$utils$Fill$Type;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.github.mikephil.charting.utils.Fill$Type[] r0 = com.github.mikephil.charting.utils.Fill.Type.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$github$mikephil$charting$utils$Fill$Type = r0
                com.github.mikephil.charting.utils.Fill$Type r1 = com.github.mikephil.charting.utils.Fill.Type.EMPTY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$utils$Fill$Type     // Catch:{ NoSuchFieldError -> 0x001d }
                com.github.mikephil.charting.utils.Fill$Type r1 = com.github.mikephil.charting.utils.Fill.Type.COLOR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$utils$Fill$Type     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.github.mikephil.charting.utils.Fill$Type r1 = com.github.mikephil.charting.utils.Fill.Type.LINEAR_GRADIENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$github$mikephil$charting$utils$Fill$Type     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.github.mikephil.charting.utils.Fill$Type r1 = com.github.mikephil.charting.utils.Fill.Type.DRAWABLE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.utils.Fill.AnonymousClass1.<clinit>():void");
        }
    }

    public void fillRect(Canvas canvas, Paint paint, float f, float f2, float f3, float f4, Direction direction) {
        Drawable drawable;
        Canvas canvas2 = canvas;
        Paint paint2 = paint;
        float f5 = f;
        float f6 = f2;
        float f7 = f3;
        float f8 = f4;
        Direction direction2 = direction;
        int i = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$utils$Fill$Type[this.mType.ordinal()];
        if (i != 2) {
            if (i != 3) {
                if (i == 4 && (drawable = this.mDrawable) != null) {
                    drawable.setBounds((int) f5, (int) f6, (int) f7, (int) f8);
                    this.mDrawable.draw(canvas2);
                }
            } else if (this.mGradientColors != null) {
                paint2.setShader(new LinearGradient((float) ((int) (direction2 == Direction.RIGHT ? f7 : f5)), (float) ((int) (direction2 == Direction.UP ? f8 : f6)), (float) ((int) ((direction2 != Direction.RIGHT && direction2 == Direction.LEFT) ? f7 : f5)), (float) ((int) ((direction2 != Direction.UP && direction2 == Direction.DOWN) ? f8 : f6)), this.mGradientColors, this.mGradientPositions, Shader.TileMode.MIRROR));
                canvas.drawRect(f, f2, f3, f4, paint);
            }
        } else if (this.mFinalColor != null) {
            if (isClipPathSupported()) {
                int save = canvas.save();
                canvas2.clipRect(f5, f6, f7, f8);
                canvas2.drawColor(this.mFinalColor.intValue());
                canvas2.restoreToCount(save);
                return;
            }
            Paint.Style style = paint.getStyle();
            int color = paint.getColor();
            paint2.setStyle(Paint.Style.FILL);
            paint2.setColor(this.mFinalColor.intValue());
            canvas.drawRect(f, f2, f3, f4, paint);
            paint2.setColor(color);
            paint2.setStyle(style);
        }
    }

    public void fillPath(Canvas canvas, Path path, Paint paint, RectF rectF) {
        int i;
        int i2 = AnonymousClass1.$SwitchMap$com$github$mikephil$charting$utils$Fill$Type[this.mType.ordinal()];
        if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4 && this.mDrawable != null) {
                    ensureClipPathSupported();
                    int save = canvas.save();
                    canvas.clipPath(path);
                    Drawable drawable = this.mDrawable;
                    int i3 = 0;
                    if (rectF == null) {
                        i = 0;
                    } else {
                        i = (int) rectF.left;
                    }
                    if (rectF != null) {
                        i3 = (int) rectF.top;
                    }
                    drawable.setBounds(i, i3, rectF == null ? canvas.getWidth() : (int) rectF.right, rectF == null ? canvas.getHeight() : (int) rectF.bottom);
                    this.mDrawable.draw(canvas);
                    canvas.restoreToCount(save);
                }
            } else if (this.mGradientColors != null) {
                paint.setShader(new LinearGradient(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight(), this.mGradientColors, this.mGradientPositions, Shader.TileMode.MIRROR));
                canvas.drawPath(path, paint);
            }
        } else if (this.mFinalColor != null) {
            if (rectF == null || !isClipPathSupported()) {
                Paint.Style style = paint.getStyle();
                int color = paint.getColor();
                paint.setStyle(Paint.Style.FILL);
                paint.setColor(this.mFinalColor.intValue());
                canvas.drawPath(path, paint);
                paint.setColor(color);
                paint.setStyle(style);
                return;
            }
            int save2 = canvas.save();
            canvas.clipPath(path);
            canvas.drawColor(this.mFinalColor.intValue());
            canvas.restoreToCount(save2);
        }
    }

    private boolean isClipPathSupported() {
        return Utils.getSDKInt() >= 18;
    }

    private void ensureClipPathSupported() {
        if (Utils.getSDKInt() < 18) {
            throw new RuntimeException("Fill-drawables not (yet) supported below API level 18, this ic_vcode was run on API level " + Utils.getSDKInt() + ".");
        }
    }
}
