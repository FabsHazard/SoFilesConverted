package com.huawei.hms.scankit.drawable;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.huawei.hms.scankit.R;
import com.huawei.hms.scankit.p.b1;
import com.huawei.hms.scankit.p.b6;
import com.huawei.hms.scankit.p.n6;
import com.huawei.hms.scankit.p.y5;
import com.microtech.aidexx.ui.pair.PairUtilKt;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class ScanDrawable extends Drawable implements Animatable {
    /* access modifiers changed from: private */
    public static final Interpolator A = new b1(0.25f, 0.0f, 0.4f, 1.0f);
    private static final int[] x = {13625597, 357325};
    /* access modifiers changed from: private */
    public static final Interpolator y = new b1(0.4f, 0.0f, 0.4f, 1.0f);
    /* access modifiers changed from: private */
    public static final Interpolator z = new b1(0.4f, 0.0f, 0.7f, 1.0f);
    private final ValueAnimator a;
    /* access modifiers changed from: private */
    public final ValueAnimator b;
    private final Matrix c;
    private final Paint d;
    private final Paint e;
    private final ColorMatrix f;
    private final Matrix g;
    private final Rect h;
    private final Rect i;
    private final Rect j;
    /* access modifiers changed from: private */
    public final Rect k;
    private int l;
    private int m;
    /* access modifiers changed from: private */
    public float n;
    /* access modifiers changed from: private */
    public boolean o;
    /* access modifiers changed from: private */
    public float p;
    /* access modifiers changed from: private */
    public int q;
    private y5 r;
    private float s;
    /* access modifiers changed from: private */
    public boolean t;
    private Bitmap u;
    private Bitmap v;
    private AnimatorSet w;

    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) ScanDrawable.this.b.getAnimatedValue()).floatValue();
            ScanDrawable scanDrawable = ScanDrawable.this;
            int unused = scanDrawable.q = scanDrawable.k.top + ((int) (((float) ScanDrawable.this.k.height()) * ScanDrawable.y.getInterpolation(floatValue)));
            if (floatValue < 0.389f) {
                float unused2 = ScanDrawable.this.p = ScanDrawable.z.getInterpolation(floatValue / 0.389f);
            } else {
                float unused3 = ScanDrawable.this.p = 1.0f - ScanDrawable.A.getInterpolation((floatValue - 0.389f) / 0.611f);
            }
            ScanDrawable.this.invalidateSelf();
        }
    }

    class b extends AnimatorListenerAdapter {
        b() {
        }

        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            ScanDrawable scanDrawable = ScanDrawable.this;
            boolean unused = scanDrawable.o = !scanDrawable.o;
        }
    }

    class c extends AnimatorListenerAdapter {
        c() {
        }

        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            float abs = Math.abs(((Float) ScanDrawable.this.b.getAnimatedValue()).floatValue() - 0.5f);
            ScanDrawable scanDrawable = ScanDrawable.this;
            boolean unused = scanDrawable.t = !scanDrawable.t;
            if (!ScanDrawable.this.t) {
                return;
            }
            if (abs > 0.35f) {
                float unused2 = ScanDrawable.this.n = 0.0f;
            } else {
                float unused3 = ScanDrawable.this.n = n6.a(0.5f);
            }
        }
    }

    public ScanDrawable() {
        this.a = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.b = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.c = new Matrix();
        this.d = new Paint();
        this.e = new Paint();
        this.f = new ColorMatrix();
        this.g = new Matrix();
        this.h = new Rect();
        this.i = new Rect();
        this.j = new Rect();
        this.k = new Rect();
        this.n = 0.5f;
        this.o = false;
        this.p = 0.0f;
        this.t = true;
        this.w = new AnimatorSet();
        d();
    }

    private void e() {
        this.a.setInterpolator(new LinearInterpolator());
        this.a.setRepeatMode(2);
        this.a.setRepeatCount(-1);
        this.a.setDuration(500);
        this.a.setStartDelay(200);
        this.a.addListener(new c());
    }

    private void f() {
        this.b.setDuration(PairUtilKt.DELAY_A_WHILE);
        this.b.setInterpolator(new LinearInterpolator());
        this.b.setRepeatCount(-1);
        this.b.setRepeatMode(2);
        this.b.addUpdateListener(new a());
        this.b.addListener(new b());
    }

    public void draw(Canvas canvas) {
        if (!isRunning() || canvas == null) {
            Log.w("ScanDrawable", "animator is not running or canvas is null.");
            return;
        }
        if (!this.o) {
            int i2 = this.q;
            this.i.set(0, i2, getBounds().right, i2 - ((int) ((((float) this.m) * this.p) * 0.5f)));
            int i3 = this.q;
            this.j.set(0, i3, getBounds().right, i3 - ((int) (((float) this.m) * this.p)));
        } else {
            int i4 = this.q;
            this.i.set(0, i4, getBounds().right, ((int) (((float) this.m) * this.p * 0.5f)) + i4);
            int i5 = this.q;
            this.j.set(0, i5, getBounds().right, ((int) (((float) this.m) * this.p)) + i5);
        }
        a(canvas, this.j);
        b(canvas);
        a(canvas);
    }

    public int getOpacity() {
        return -3;
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        if (resources == null || xmlPullParser == null || attributeSet == null) {
            Log.e("ScanDrawable", "resources, xmlPullParser or attributeSet is null when inflating drawable");
            return;
        }
        a(resources);
        super.inflate(resources, xmlPullParser, attributeSet, theme);
    }

    public boolean isRunning() {
        return this.w.isRunning();
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (rect == null) {
            Log.e("ScanDrawable", "on bounds change: bounds is null!");
            return;
        }
        super.onBoundsChange(rect);
        a(rect);
    }

    public void setAlpha(int i2) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void start() {
        if (isRunning()) {
            Log.i("ScanDrawable", "start failed, animator is running");
            return;
        }
        this.o = false;
        this.t = true;
        a(getBounds());
        this.w.start();
        Log.i("ScanDrawable", "start scan animator success");
    }

    public void stop() {
        if (isRunning()) {
            this.w.end();
            this.r = null;
            Log.i("ScanDrawable", "stop scan animator success");
            return;
        }
        Log.i("ScanDrawable", "stop failed, animator is not running");
    }

    private void d() {
        f();
        e();
        AnimatorSet animatorSet = new AnimatorSet();
        this.w = animatorSet;
        animatorSet.playTogether(new Animator[]{this.b, this.a});
    }

    private void b(Canvas canvas) {
        y5 y5Var = this.r;
        if (y5Var == null) {
            Log.e("ScanDrawable", "drawParticle failed, mParticle is null");
        } else {
            y5Var.a(canvas, this.i);
        }
    }

    private void a(Resources resources) {
        if (resources == null) {
            Log.e("ScanDrawable", "resources is null when init drawable");
            return;
        }
        Bitmap decodeResource = BitmapFactory.decodeResource(resources, R.drawable.scankit_scan_light);
        this.v = Bitmap.createBitmap(decodeResource.getWidth() * 2, decodeResource.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas();
        canvas.setBitmap(this.v);
        Paint paint = new Paint();
        Shader.TileMode tileMode = Shader.TileMode.MIRROR;
        paint.setShader(new BitmapShader(decodeResource, tileMode, tileMode));
        canvas.drawRect(0.0f, 0.0f, (float) (decodeResource.getWidth() * 2), (float) (decodeResource.getHeight() * 2), paint);
        this.u = BitmapFactory.decodeResource(resources, R.drawable.scankit_scan_tail);
        this.s = resources.getDisplayMetrics().density;
    }

    private void a(Rect rect) {
        Rect rect2 = rect;
        if (rect.height() == 0) {
            Log.d("ScanDrawable", "initBounds bounds is null");
            return;
        }
        this.k.set(rect2);
        this.k.inset(0, (int) (((float) rect.height()) * 0.1f));
        this.l = (int) (((float) rect.height()) * 0.18f);
        this.m = (int) (((float) rect.height()) * 0.36f);
        Rect rect3 = new Rect(rect2);
        rect3.inset((int) (((float) rect.width()) * 0.2f), 0);
        float f2 = this.s;
        float f3 = 0.001f;
        if (f2 != 0.0f) {
            f3 = 0.001f / (f2 * f2);
        }
        int width = (int) (f3 * ((float) rect3.width()) * ((float) rect3.height()));
        this.r = new y5(new b6(width, 500).b(0.33f, 1.0f).a(0, -1, 0, 100, new LinearInterpolator()).a(-1, 0, 400, 500, new LinearInterpolator()), rect3, width, this.s * 2.0f, x);
    }

    public ScanDrawable(Resources resources) {
        this();
        a(resources);
    }

    private void a(Canvas canvas, Rect rect) {
        Bitmap bitmap = this.u;
        if (bitmap == null || bitmap.getWidth() == 0 || this.u.getHeight() == 0) {
            Log.e("ScanDrawable", "dawTail failed, input bitmap is null");
            return;
        }
        this.c.setScale(((float) rect.width()) / ((float) this.u.getWidth()), ((float) rect.height()) / ((float) this.u.getHeight()));
        this.c.postTranslate((float) rect.left, (float) rect.top);
        canvas.drawBitmap(this.u, this.c, this.d);
        this.c.reset();
    }

    private void a(Canvas canvas) {
        Bitmap bitmap = this.v;
        if (bitmap == null || bitmap.getWidth() == 0 || this.v.getHeight() == 0) {
            Log.e("ScanDrawable", "drawLight failed, light bitmap is null");
            return;
        }
        float floatValue = (this.p * 0.5f) + (((Float) this.a.getAnimatedValue()).floatValue() * this.n);
        float f2 = (1.5f - floatValue) * 0.05f;
        float f3 = f2 + 1.0f;
        this.f.set(new float[]{1.0f, f2, f2, f2, 0.0f, f2, f3, f2, f2, 0.0f, f2, f2, f3, f2, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f});
        this.e.setColorFilter(new ColorMatrixColorFilter(this.f));
        int i2 = (int) (((float) this.l) * ((floatValue * 0.2f) + 0.4f));
        if (this.o) {
            int i3 = this.q;
            this.h.set(0, i3 + i2, getBounds().right, i3 - i2);
        } else {
            int i4 = this.q;
            this.h.set(0, i4 - i2, getBounds().right, i4 + i2);
        }
        this.g.setScale(((float) this.h.width()) / ((float) this.v.getWidth()), ((float) this.h.height()) / ((float) this.v.getHeight()));
        Matrix matrix = this.g;
        Rect rect = this.h;
        matrix.postTranslate((float) rect.left, (float) rect.top);
        canvas.drawBitmap(this.v, this.g, this.e);
        this.g.reset();
    }
}
