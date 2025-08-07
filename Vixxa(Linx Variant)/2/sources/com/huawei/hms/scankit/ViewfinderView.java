package com.huawei.hms.scankit;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.os.Build;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.huawei.hms.scankit.p.u6;

public final class ViewfinderView extends View {
    private int[] A;
    private float[] B;
    private Rect C;
    private boolean D;
    Point E;
    private boolean F;
    private Paint a;
    private TextPaint b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private float h;
    private c i;
    private String j;
    private int k;
    private float l;
    public int m;
    public int n;
    private boolean o;
    private int p;
    private int q;
    private int r;
    private int s;
    private b t;
    private int u;
    private int v;
    private Rect w;
    private int x;
    private ValueAnimator y;
    Paint z;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ViewfinderView.this.m = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            ViewfinderView.this.invalidate();
        }
    }

    public enum b {
        NONE(0),
        LINE(1),
        GRID(2);
        
        /* access modifiers changed from: private */
        public int a;

        private b(int i) {
            this.a = i;
        }

        /* access modifiers changed from: private */
        public static b b(int i) {
            for (b bVar : values()) {
                if (bVar.a == i) {
                    return bVar;
                }
            }
            return LINE;
        }
    }

    public enum c {
        TOP(0),
        BOTTOM(1);
        
        private int a;

        private c(int i) {
            this.a = i;
        }

        /* access modifiers changed from: private */
        public static c b(int i) {
            for (c cVar : values()) {
                if (cVar.a == i) {
                    return cVar;
                }
            }
            return TOP;
        }
    }

    public ViewfinderView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ViewfinderView);
        this.c = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_maskColor, b(context, R.color.scankit_viewfinder_mask));
        this.d = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_frameColor, b(context, R.color.scankit_viewfinder_frame));
        this.f = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_cornerColor, b(context, R.color.scankit_viewfinder_corner));
        this.e = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_laserColor, b(context, R.color.scankit_viewfinder_lasers));
        this.g = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_resultPointColor, b(context, R.color.scankit_viewfinder_result_point_color));
        this.j = obtainStyledAttributes.getString(R.styleable.ViewfinderView_scankit_labelText);
        this.k = obtainStyledAttributes.getColor(R.styleable.ViewfinderView_scankit_labelTextColor, b(context, R.color.scankit_viewfinder_text_color));
        this.l = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_labelTextSize, TypedValue.applyDimension(2, 14.0f, getResources().getDisplayMetrics()));
        this.h = obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_labelTextPadding, TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()));
        this.i = c.b(obtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_labelTextLocation, 0));
        this.o = obtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_scankit_showResultPoint, false);
        this.r = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_scankit_frameWidth, 0);
        this.s = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ViewfinderView_scankit_frameHeight, 0);
        this.t = b.b(obtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_laserStyle, b.LINE.a));
        this.u = obtainStyledAttributes.getInt(R.styleable.ViewfinderView_scankit_gridColumn, 20);
        this.v = (int) obtainStyledAttributes.getDimension(R.styleable.ViewfinderView_scankit_gridHeight, TypedValue.applyDimension(1, 40.0f, getResources().getDisplayMetrics()));
        this.F = obtainStyledAttributes.getBoolean(R.styleable.ViewfinderView_scankit_line_anim, true);
        obtainStyledAttributes.recycle();
        this.a = new Paint(1);
        this.b = new TextPaint(1);
        this.x = a(context, 136);
        this.q = getDisplayMetrics().heightPixels;
        this.p = getDisplayMetrics().widthPixels;
    }

    public static int b(Context context, int i2) {
        try {
            return context.getColor(i2);
        } catch (Resources.NotFoundException unused) {
            Log.e("ViewfinderView", "getColor: Resources.NotFoundException");
            return 16777215;
        } catch (Exception unused2) {
            Log.e("ViewfinderView", "getColor: Exception");
            return 16777215;
        }
    }

    private DisplayMetrics getDisplayMetrics() {
        return getResources().getDisplayMetrics();
    }

    public void a(u6 u6Var) {
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.y;
        if (valueAnimator != null) {
            valueAnimator.pause();
            this.y.removeAllListeners();
            this.y.cancel();
        }
    }

    public void onDraw(Canvas canvas) {
        if (this.F) {
            canvas.save();
            String str = Build.DEVICE;
            a(canvas, "HWTAH".equals(str) || str.equals("HWTAH-C"));
            canvas.restore();
        }
        a(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.p = i2;
        this.q = i3;
        a();
    }

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewfinderView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.m = 0;
        this.n = 0;
        this.w = new Rect();
        this.z = new Paint();
        this.A = new int[]{Color.parseColor("#FFFFFFFF"), Color.parseColor("#72FFFFFF"), Color.parseColor("#58FFFFFF"), Color.parseColor("#40FFFFFF"), Color.parseColor("#28FFFFFF"), Color.parseColor("#13FFFFFF"), Color.parseColor("#00FFFFFF")};
        this.B = new float[]{0.0f, 0.5f, 0.6f, 0.7f, 0.8f, 0.9f, 1.0f};
        this.D = true;
        this.F = true;
        a(context, attributeSet);
    }

    private void a(Canvas canvas, boolean z2) {
        this.a.setStyle(Paint.Style.FILL);
        this.a.setColor(this.e);
        if (e.z || z2) {
            Rect rect = this.w;
            int i2 = this.p / 2;
            rect.left = i2 - 540;
            int i3 = this.m;
            rect.top = i3;
            rect.bottom = i3 + this.x;
            rect.right = i2 + 540;
        } else {
            Rect rect2 = this.w;
            rect2.left = 0;
            int i4 = this.m;
            rect2.top = i4;
            rect2.bottom = i4 + this.x;
            rect2.right = this.p;
        }
        int i5 = this.p / 2;
        float f2 = (float) i5;
        float f3 = (float) (this.w.bottom + 500);
        this.a.setShader(new RadialGradient(f2, f3, (float) 690, this.A, this.B, Shader.TileMode.CLAMP));
        this.a.setStrokeWidth(10.0f);
        Rect rect3 = this.w;
        float f4 = (float) rect3.left;
        float f5 = (float) rect3.bottom;
        canvas.drawLine(f4, f5, (float) rect3.right, f5, this.a);
        canvas.clipRect(this.w);
        canvas.drawCircle(f2, f3, (float) (i5 + 200), this.a);
    }

    public void a() {
        if (e.z) {
            this.n = this.q;
        } else {
            this.n = this.q - a(getContext(), 139);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, this.n - this.x});
        this.y = ofInt;
        ofInt.setDuration(3000);
        this.y.setInterpolator(new AccelerateDecelerateInterpolator());
        this.y.setRepeatMode(1);
        this.y.setRepeatCount(-1);
        this.y.addUpdateListener(new a());
        this.y.start();
    }

    public void a(Rect rect, boolean z2, Point point) {
        this.D = z2;
        this.E = point;
        if (this.C == null) {
            this.C = rect;
            invalidate();
        }
    }

    public static int a(Context context, int i2) {
        return (int) ((((float) i2) * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x012b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.graphics.Canvas r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            android.graphics.Rect r2 = r0.C
            if (r2 != 0) goto L_0x0009
            return
        L_0x0009:
            int r2 = r19.getWidth()
            int r3 = r19.getHeight()
            boolean r4 = r0.D
            if (r4 == 0) goto L_0x0021
            android.graphics.Point r4 = new android.graphics.Point
            android.graphics.Point r5 = r0.E
            int r6 = r5.y
            int r5 = r5.x
            r4.<init>(r6, r5)
            goto L_0x002c
        L_0x0021:
            android.graphics.Point r4 = new android.graphics.Point
            android.graphics.Point r5 = r0.E
            int r6 = r5.x
            int r5 = r5.y
            r4.<init>(r6, r5)
        L_0x002c:
            float r5 = (float) r2
            int r6 = r4.x
            float r7 = (float) r6
            float r5 = r5 / r7
            float r7 = (float) r3
            int r8 = r4.y
            float r9 = (float) r8
            float r7 = r7 / r9
            double r8 = (double) r8
            r10 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            double r8 = r8 * r10
            int r8 = (int) r8
            double r9 = (double) r6
            r11 = 4594572339843380019(0x3fc3333333333333, double:0.15)
            double r9 = r9 * r11
            r11 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r9 = r9 / r11
            int r6 = (int) r9
            android.graphics.RectF r9 = new android.graphics.RectF
            r9.<init>()
            boolean r10 = r0.D
            r11 = 0
            if (r10 == 0) goto L_0x0075
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x0066
            int r10 = r4.y
            float r10 = (float) r10
            float r10 = r10 * r5
            int r10 = (int) r10
            int r12 = r3 / 2
            int r13 = r10 / 2
            int r12 = r12 - r13
            float r12 = (float) r12
            r1.translate(r11, r12)
            goto L_0x0087
        L_0x0066:
            int r10 = r4.x
            float r10 = (float) r10
            float r10 = r10 * r7
            int r10 = (int) r10
            int r12 = r2 / 2
            int r13 = r10 / 2
            int r12 = r12 - r13
            float r12 = (float) r12
            r1.translate(r12, r11)
            goto L_0x0097
        L_0x0075:
            int r10 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r10 <= 0) goto L_0x0089
            int r10 = r4.y
            float r10 = (float) r10
            float r10 = r10 * r5
            int r10 = (int) r10
            int r12 = r3 / 2
            int r13 = r10 / 2
            int r12 = r12 - r13
            float r12 = (float) r12
            r1.translate(r11, r12)
        L_0x0087:
            r12 = r2
            goto L_0x0099
        L_0x0089:
            int r10 = r4.x
            float r10 = (float) r10
            float r10 = r10 * r7
            int r10 = (int) r10
            int r12 = r2 / 2
            int r13 = r10 / 2
            int r12 = r12 - r13
            float r12 = (float) r12
            r1.translate(r12, r11)
        L_0x0097:
            r12 = r10
            r10 = r3
        L_0x0099:
            android.graphics.Rect r13 = r0.C
            int r14 = r13.left
            int r14 = r14 + r6
            float r14 = (float) r14
            int r15 = r4.x
            float r15 = (float) r15
            float r14 = r14 / r15
            int r11 = r13.right
            int r11 = r11 + r6
            float r6 = (float) r11
            float r6 = r6 / r15
            int r11 = r13.top
            int r11 = r11 + r8
            float r11 = (float) r11
            int r4 = r4.y
            float r4 = (float) r4
            float r11 = r11 / r4
            int r13 = r13.bottom
            int r13 = r13 + r8
            float r8 = (float) r13
            float r8 = r8 / r4
            float r4 = (float) r12
            float r14 = r14 * r4
            r9.left = r14
            float r6 = r6 * r4
            r9.right = r6
            float r4 = (float) r10
            float r11 = r11 * r4
            r9.top = r11
            float r8 = r8 * r4
            r9.bottom = r8
            float r14 = r14 + r6
            r4 = 1073741824(0x40000000, float:2.0)
            float r14 = r14 / r4
            float r11 = r11 + r8
            float r11 = r11 / r4
            android.graphics.Paint r4 = r0.z
            android.graphics.Paint$Style r6 = android.graphics.Paint.Style.FILL
            r4.setStyle(r6)
            android.graphics.Paint r4 = r0.z
            r6 = -1
            r4.setColor(r6)
            android.util.DisplayMetrics r4 = r18.getDisplayMetrics()
            float r4 = r4.density
            r6 = 1103101952(0x41c00000, float:24.0)
            float r4 = r4 * r6
            double r8 = (double) r4
            r16 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r8 = r8 + r16
            int r4 = (int) r8
            int r4 = r4 / 2
            float r4 = (float) r4
            android.graphics.Paint r6 = r0.z
            r1.drawCircle(r14, r11, r4, r6)
            android.graphics.Paint r4 = r0.z
            java.lang.String r6 = "#007DFF"
            int r6 = android.graphics.Color.parseColor(r6)
            r4.setColor(r6)
            android.util.DisplayMetrics r4 = r18.getDisplayMetrics()
            float r4 = r4.density
            r6 = 1102053376(0x41b00000, float:22.0)
            float r4 = r4 * r6
            double r8 = (double) r4
            double r8 = r8 + r16
            int r4 = (int) r8
            int r4 = r4 / 2
            float r4 = (float) r4
            android.graphics.Paint r6 = r0.z
            r1.drawCircle(r14, r11, r4, r6)
            boolean r4 = r0.D
            if (r4 == 0) goto L_0x012b
            int r4 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r4 <= 0) goto L_0x0120
            int r10 = r10 / 2
            int r3 = r3 / 2
            int r10 = r10 - r3
            float r2 = (float) r10
            r4 = 0
            r1.translate(r4, r2)
            goto L_0x0143
        L_0x0120:
            r4 = 0
            int r12 = r12 / 2
            int r2 = r2 / 2
            int r12 = r12 - r2
            float r2 = (float) r12
            r1.translate(r2, r4)
            goto L_0x0143
        L_0x012b:
            r4 = 0
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x013a
            int r10 = r10 / 2
            int r3 = r3 / 2
            int r10 = r10 - r3
            float r2 = (float) r10
            r1.translate(r4, r2)
            goto L_0x0143
        L_0x013a:
            int r12 = r12 / 2
            int r2 = r2 / 2
            int r12 = r12 - r2
            float r2 = (float) r12
            r1.translate(r2, r4)
        L_0x0143:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.ViewfinderView.a(android.graphics.Canvas):void");
    }
}
