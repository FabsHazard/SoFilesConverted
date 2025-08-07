package com.microtech.aidexx.ui.main.trend.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.utils.DensityUtils;
import com.microtech.aidexx.utils.ThemeManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0002J\u0012\u0010+\u001a\u0004\u0018\u00010\f2\u0006\u0010,\u001a\u00020-H\u0002J\u0006\u0010.\u001a\u00020(J\u0010\u0010/\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0014J\u0018\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\tH\u0014J\u0015\u00103\u001a\u00020(2\b\u0010$\u001a\u0004\u0018\u00010%¢\u0006\u0002\u00104R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0018*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n \u0018*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n \u0018*\u0004\u0018\u00010\u00110\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X.¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/microtech/aidexx/ui/main/trend/view/LbgiCursorView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "extremelyLowBitmap", "Landroid/graphics/Bitmap;", "extremelyLowColor", "highBitmap", "highColor", "hintExtremelyLow", "", "hintHigh", "hintLow", "hintMid", "lowBitmap", "lowColor", "marker1Dot1", "kotlin.jvm.PlatformType", "marker2Dot5", "marker5", "midBitmap", "midColor", "paint", "Landroid/graphics/Paint;", "rect", "Landroid/graphics/Rect;", "size15dp", "size18dp", "textColor", "value", "", "valueString", "drawAlabo", "", "canvas", "Landroid/graphics/Canvas;", "drawableToBitmap", "drawable", "Landroid/graphics/drawable/Drawable;", "init", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setValue", "(Ljava/lang/Float;)V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LbgiCursorView.kt */
public final class LbgiCursorView extends View {
    private Bitmap extremelyLowBitmap;
    private int extremelyLowColor;
    private Bitmap highBitmap;
    private int highColor;
    private final String hintExtremelyLow;
    private final String hintHigh;
    private final String hintLow;
    private final String hintMid;
    private Bitmap lowBitmap;
    private int lowColor;
    private final String marker1Dot1;
    private final String marker2Dot5;
    private final String marker5;
    private Bitmap midBitmap;
    private int midColor;
    private Paint paint;
    private Rect rect;
    private final int size15dp;
    private final int size18dp;
    private int textColor;
    private float value;
    private String valueString;

    public LbgiCursorView(Context context) {
        this(context, (AttributeSet) null);
    }

    public LbgiCursorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LbgiCursorView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.valueString = "0";
        this.size15dp = DensityUtils.dp2px(15.0f);
        this.size18dp = DensityUtils.dp2px(18.0f);
        this.marker1Dot1 = ExtendsKt.getNumberFormatWithLocale().format(1.1d);
        this.marker2Dot5 = ExtendsKt.getNumberFormatWithLocale().format(2.5d);
        this.marker5 = ExtendsKt.getNumberFormatWithLocale().format(5);
        String string = getContext().getString(R.string.trend_lbgi_urgentLow);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        this.hintExtremelyLow = string;
        String string2 = getContext().getString(R.string.trend_lbgi_low);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        this.hintLow = string2;
        String string3 = getContext().getString(R.string.trend_lbgi_medium);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.hintMid = string3;
        String string4 = getContext().getString(R.string.trend_lbgi_high);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        this.hintHigh = string4;
        init();
    }

    private final Bitmap drawableToBitmap(Drawable drawable) {
        if (drawable instanceof BitmapDrawable) {
            return ((BitmapDrawable) drawable).getBitmap();
        }
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public final void init() {
        int i;
        this.extremelyLowColor = Color.parseColor("#89D29C");
        this.lowColor = Color.parseColor("#70BD65");
        this.midColor = Color.parseColor("#F0BE5B");
        this.highColor = Color.parseColor("#E15D4D");
        if (ThemeManager.INSTANCE.isLight()) {
            i = Color.parseColor("#393939");
        } else {
            i = Color.parseColor("#E6E6E6");
        }
        this.textColor = i;
        Paint paint2 = null;
        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_extremely_low_cursor, (Resources.Theme) null);
        if (drawable != null) {
            this.extremelyLowBitmap = drawableToBitmap(drawable);
        }
        Drawable drawable2 = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_low_cursor, (Resources.Theme) null);
        if (drawable2 != null) {
            this.lowBitmap = drawableToBitmap(drawable2);
        }
        Drawable drawable3 = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_mid_cursor, (Resources.Theme) null);
        if (drawable3 != null) {
            this.midBitmap = drawableToBitmap(drawable3);
        }
        Drawable drawable4 = ResourcesCompat.getDrawable(getResources(), R.drawable.ic_high_cursor, (Resources.Theme) null);
        if (drawable4 != null) {
            this.highBitmap = drawableToBitmap(drawable4);
        }
        Paint paint3 = new Paint();
        this.paint = paint3;
        paint3.setAntiAlias(true);
        Paint paint4 = this.paint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
        } else {
            paint2 = paint4;
        }
        paint2.setStyle(Paint.Style.FILL);
        this.rect = new Rect();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i4 = 0;
        if (mode == Integer.MIN_VALUE) {
            i3 = DensityUtils.dp2px(200.0f);
        } else if (mode != 1073741824) {
            i3 = 0;
        } else {
            i3 = View.MeasureSpec.getSize(i);
        }
        if (mode2 == Integer.MIN_VALUE) {
            i4 = DensityUtils.dp2px(80.0f);
        } else if (mode2 == 1073741824) {
            i4 = View.MeasureSpec.getSize(i2);
        }
        setMeasuredDimension(i3, i4);
    }

    public final void setValue(Float f) {
        if (f != null) {
            f.floatValue();
            if (f.floatValue() > 5.0f) {
                this.value = 5.5f;
            } else {
                this.value = f.floatValue();
            }
            this.valueString = ExtendsKt.stripTrailingZeros$default(Float.valueOf(this.value), (Integer) null, 1, (Object) null);
            postInvalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        Bitmap bitmap;
        Rect rect2;
        Canvas canvas2 = canvas;
        Intrinsics.checkNotNullParameter(canvas2, "canvas");
        super.onDraw(canvas);
        if (Intrinsics.areEqual((Object) LanguageResourceManager.INSTANCE.getCurLanguageTag(), (Object) "ar")) {
            drawAlabo(canvas);
            return;
        }
        Paint paint2 = this.paint;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint2 = null;
        }
        paint2.setColor(this.extremelyLowColor);
        float f = (float) this.size15dp;
        float height = (float) (getHeight() / 2);
        float f2 = (float) (this.size15dp / 2);
        Paint paint3 = this.paint;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint3 = null;
        }
        canvas2.drawCircle(f, height, f2, paint3);
        Rect rect3 = this.rect;
        if (rect3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect3 = null;
        }
        int i = this.size15dp;
        int height2 = (getHeight() / 2) - (this.size15dp / 2);
        int width = getWidth();
        int i2 = this.size15dp;
        rect3.set(i, height2, (int) ((((double) (width - i2)) * 0.18d) + ((double) i2)), (getHeight() / 2) + (this.size15dp / 2));
        Rect rect4 = this.rect;
        if (rect4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect4 = null;
        }
        Paint paint4 = this.paint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint4 = null;
        }
        canvas2.drawRect(rect4, paint4);
        Unit unit = Unit.INSTANCE;
        Paint paint5 = this.paint;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint5 = null;
        }
        paint5.setColor(this.lowColor);
        Rect rect5 = this.rect;
        if (rect5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect5 = null;
        }
        int width2 = getWidth();
        int i3 = this.size15dp;
        int i4 = (int) ((((double) (width2 - (i3 * 2))) * 0.18d) + ((double) i3));
        int height3 = (getHeight() / 2) - (this.size15dp / 2);
        int width3 = getWidth();
        int i5 = this.size15dp;
        rect5.set(i4, height3, (int) ((((double) (width3 - (i5 * 2))) * 0.42d) + ((double) i5)), (getHeight() / 2) + (this.size15dp / 2));
        Rect rect6 = this.rect;
        if (rect6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect6 = null;
        }
        Paint paint6 = this.paint;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint6 = null;
        }
        canvas2.drawRect(rect6, paint6);
        Unit unit2 = Unit.INSTANCE;
        Paint paint7 = this.paint;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint7 = null;
        }
        paint7.setColor(this.midColor);
        Rect rect7 = this.rect;
        if (rect7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect7 = null;
        }
        int width4 = getWidth();
        int i6 = this.size15dp;
        int i7 = (int) ((((double) (width4 - (i6 * 2))) * 0.42d) + ((double) i6));
        int height4 = (getHeight() / 2) - (this.size15dp / 2);
        int width5 = getWidth();
        int i8 = this.size15dp;
        rect7.set(i7, height4, (int) ((((double) (width5 - (i8 * 2))) * 0.83d) + ((double) i8)), (getHeight() / 2) + (this.size15dp / 2));
        Rect rect8 = this.rect;
        if (rect8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect8 = null;
        }
        Paint paint8 = this.paint;
        if (paint8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint8 = null;
        }
        canvas2.drawRect(rect8, paint8);
        Unit unit3 = Unit.INSTANCE;
        Paint paint9 = this.paint;
        if (paint9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint9 = null;
        }
        paint9.setColor(this.highColor);
        Rect rect9 = this.rect;
        if (rect9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect9 = null;
        }
        int width6 = getWidth();
        int i9 = this.size15dp;
        rect9.set((int) ((((double) (width6 - (i9 * 2))) * 0.83d) + ((double) i9)), (getHeight() / 2) - (this.size15dp / 2), getWidth() - this.size15dp, (getHeight() / 2) + (this.size15dp / 2));
        Rect rect10 = this.rect;
        if (rect10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect10 = null;
        }
        Paint paint10 = this.paint;
        if (paint10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint10 = null;
        }
        canvas2.drawRect(rect10, paint10);
        Unit unit4 = Unit.INSTANCE;
        float width7 = (float) (getWidth() - this.size15dp);
        float height5 = (float) (getHeight() / 2);
        float f3 = (float) (this.size15dp / 2);
        Paint paint11 = this.paint;
        if (paint11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint11 = null;
        }
        canvas2.drawCircle(width7, height5, f3, paint11);
        Unit unit5 = Unit.INSTANCE;
        Paint paint12 = this.paint;
        if (paint12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint12 = null;
        }
        paint12.setColor(this.textColor);
        Paint paint13 = this.paint;
        if (paint13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint13 = null;
        }
        paint13.setTypeface(Typeface.DEFAULT);
        Paint paint14 = this.paint;
        if (paint14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint14 = null;
        }
        paint14.setTextSize(DensityUtils.sp2px(12.0f));
        float f4 = this.value;
        if (0.8f > f4 || f4 > 1.4f) {
            Paint paint15 = this.paint;
            if (paint15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint15 = null;
            }
            String str = this.marker1Dot1.toString();
            int length = this.marker1Dot1.toString().length();
            Rect rect11 = this.rect;
            if (rect11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect11 = null;
            }
            paint15.getTextBounds(str, 0, length, rect11);
            String str2 = this.marker1Dot1.toString();
            int width8 = getWidth();
            int i10 = this.size15dp;
            double d = (((double) (width8 - (i10 * 2))) * 0.18d) + ((double) i10);
            Rect rect12 = this.rect;
            if (rect12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect12 = null;
            }
            float width9 = (float) (d - ((double) (rect12.width() / 2)));
            float height6 = ((float) (getHeight() / 2)) - ((float) (this.size15dp / 2));
            Rect rect13 = this.rect;
            if (rect13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect13 = null;
            }
            float height7 = height6 - ((float) rect13.height());
            Paint paint16 = this.paint;
            if (paint16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint16 = null;
            }
            canvas2.drawText(str2, width9, height7, paint16);
            Unit unit6 = Unit.INSTANCE;
        }
        float f5 = this.value;
        if (2.2f > f5 || f5 > 2.8f) {
            Paint paint17 = this.paint;
            if (paint17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint17 = null;
            }
            String str3 = this.marker2Dot5.toString();
            int length2 = this.marker2Dot5.toString().length();
            Rect rect14 = this.rect;
            if (rect14 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect14 = null;
            }
            paint17.getTextBounds(str3, 0, length2, rect14);
            String str4 = this.marker2Dot5.toString();
            int width10 = getWidth();
            int i11 = this.size15dp;
            double d2 = (((double) (width10 - (i11 * 2))) * 0.42d) + ((double) i11);
            Rect rect15 = this.rect;
            if (rect15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect15 = null;
            }
            float width11 = (float) (d2 - ((double) (rect15.width() / 2)));
            float height8 = ((float) (getHeight() / 2)) - ((float) (this.size15dp / 2));
            Rect rect16 = this.rect;
            if (rect16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect16 = null;
            }
            float height9 = height8 - ((float) rect16.height());
            Paint paint18 = this.paint;
            if (paint18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint18 = null;
            }
            canvas2.drawText(str4, width11, height9, paint18);
            Unit unit7 = Unit.INSTANCE;
        }
        double d3 = (double) this.value;
        if (4.7d > d3 || d3 > 5.3d) {
            Paint paint19 = this.paint;
            if (paint19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint19 = null;
            }
            String str5 = this.marker5.toString();
            int length3 = this.marker5.toString().length();
            Rect rect17 = this.rect;
            if (rect17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect17 = null;
            }
            paint19.getTextBounds(str5, 0, length3, rect17);
            String str6 = this.marker5.toString();
            int width12 = getWidth();
            int i12 = this.size15dp;
            double d4 = (((double) (width12 - (i12 * 2))) * 0.83d) + ((double) i12);
            Rect rect18 = this.rect;
            if (rect18 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect18 = null;
            }
            float width13 = (float) (d4 - ((double) (rect18.width() / 2)));
            float height10 = ((float) (getHeight() / 2)) - ((float) (this.size15dp / 2));
            Rect rect19 = this.rect;
            if (rect19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect19 = null;
            }
            float height11 = height10 - ((float) rect19.height());
            Paint paint20 = this.paint;
            if (paint20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint20 = null;
            }
            canvas2.drawText(str6, width13, height11, paint20);
            Unit unit8 = Unit.INSTANCE;
        }
        Paint paint21 = this.paint;
        if (paint21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint21 = null;
        }
        String str7 = this.hintExtremelyLow;
        int length4 = str7.length();
        Rect rect20 = this.rect;
        if (rect20 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect20 = null;
        }
        paint21.getTextBounds(str7, 0, length4, rect20);
        String str8 = this.hintExtremelyLow;
        int width14 = getWidth();
        int i13 = this.size15dp;
        double d5 = (double) 2;
        float f6 = ((float) ((((double) (width14 - (i13 * 2))) * 0.18d) / d5)) + ((float) i13);
        Rect rect21 = this.rect;
        if (rect21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect21 = null;
        }
        float width15 = f6 - ((float) (rect21.width() / 2));
        float height12 = ((float) (getHeight() / 2)) + ((float) (this.size18dp * 2));
        Paint paint22 = this.paint;
        if (paint22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint22 = null;
        }
        float f7 = (float) 2;
        float textSize = height12 - (paint22.getTextSize() / f7);
        Paint paint23 = this.paint;
        if (paint23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint23 = null;
        }
        canvas2.drawText(str8, width15, textSize, paint23);
        Unit unit9 = Unit.INSTANCE;
        Paint paint24 = this.paint;
        if (paint24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint24 = null;
        }
        String str9 = this.hintLow;
        int length5 = str9.length();
        Rect rect22 = this.rect;
        if (rect22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect22 = null;
        }
        paint24.getTextBounds(str9, 0, length5, rect22);
        String str10 = this.hintLow;
        int width16 = getWidth();
        int i14 = this.size15dp;
        String str11 = "rect";
        float width17 = (float) ((((((double) (getWidth() - (this.size15dp * 2))) * 0.18d) + (((double) (width16 - (i14 * 2))) * 0.42d)) + ((double) (i14 * 2))) / d5);
        Rect rect23 = this.rect;
        if (rect23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str11);
            rect23 = null;
        }
        float width18 = width17 - ((float) (rect23.width() / 2));
        float height13 = ((float) (getHeight() / 2)) + ((float) (this.size18dp * 2));
        Paint paint25 = this.paint;
        if (paint25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint25 = null;
        }
        float textSize2 = height13 - (paint25.getTextSize() / f7);
        Paint paint26 = this.paint;
        if (paint26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint26 = null;
        }
        canvas2.drawText(str10, width18, textSize2, paint26);
        Unit unit10 = Unit.INSTANCE;
        Paint paint27 = this.paint;
        if (paint27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint27 = null;
        }
        String str12 = this.hintMid;
        int length6 = str12.length();
        Rect rect24 = this.rect;
        if (rect24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str11);
            rect24 = null;
        }
        paint27.getTextBounds(str12, 0, length6, rect24);
        String str13 = this.hintMid;
        int width19 = getWidth();
        int i15 = this.size15dp;
        float width20 = (float) ((((((double) (getWidth() - (this.size15dp * 2))) * 0.42d) + (((double) (width19 - (i15 * 2))) * 0.83d)) + ((double) (i15 * 2))) / d5);
        Rect rect25 = this.rect;
        if (rect25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str11);
            rect25 = null;
        }
        float width21 = width20 - ((float) (rect25.width() / 2));
        float height14 = ((float) (getHeight() / 2)) + ((float) (this.size18dp * 2));
        Paint paint28 = this.paint;
        if (paint28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint28 = null;
        }
        float textSize3 = height14 - (paint28.getTextSize() / f7);
        Paint paint29 = this.paint;
        if (paint29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint29 = null;
        }
        canvas2.drawText(str13, width21, textSize3, paint29);
        Unit unit11 = Unit.INSTANCE;
        Paint paint30 = this.paint;
        if (paint30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint30 = null;
        }
        String str14 = this.hintHigh;
        int length7 = str14.length();
        Rect rect26 = this.rect;
        if (rect26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str11);
            rect26 = null;
        }
        paint30.getTextBounds(str14, 0, length7, rect26);
        String str15 = this.hintHigh;
        float width22 = (float) (((((double) (getWidth() - (this.size15dp * 2))) * 0.83d) + ((double) getWidth())) / d5);
        Rect rect27 = this.rect;
        if (rect27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str11);
            rect27 = null;
        }
        float width23 = width22 - ((float) (rect27.width() / 2));
        float height15 = ((float) (getHeight() / 2)) + ((float) (this.size18dp * 2));
        Paint paint31 = this.paint;
        if (paint31 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint31 = null;
        }
        float textSize4 = height15 - (paint31.getTextSize() / f7);
        Paint paint32 = this.paint;
        if (paint32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint32 = null;
        }
        canvas2.drawText(str15, width23, textSize4, paint32);
        Unit unit12 = Unit.INSTANCE;
        int width24 = getWidth();
        int i16 = this.size15dp;
        float f8 = ((this.value / 6.0f) * ((float) (width24 - (i16 * 2)))) + ((float) i16);
        Paint paint33 = this.paint;
        if (paint33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint33 = null;
        }
        paint33.setTypeface(Typeface.DEFAULT_BOLD);
        Paint paint34 = this.paint;
        if (paint34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint34 = null;
        }
        paint34.setTextSize(DensityUtils.sp2px(15.0f));
        Paint paint35 = this.paint;
        if (paint35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint35 = null;
        }
        String str16 = this.valueString;
        int length8 = str16.length();
        Rect rect28 = this.rect;
        if (rect28 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str11);
            rect28 = null;
        }
        paint35.getTextBounds(str16, 0, length8, rect28);
        String str17 = this.valueString;
        Rect rect29 = this.rect;
        if (rect29 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str11);
            rect29 = null;
        }
        float width25 = f8 - ((float) (rect29.width() / 2));
        float height16 = ((float) (getHeight() / 2)) - ((float) (this.size15dp / 2));
        Rect rect30 = this.rect;
        if (rect30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(str11);
            rect30 = null;
        }
        float height17 = height16 - ((float) rect30.height());
        Paint paint36 = this.paint;
        if (paint36 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint36 = null;
        }
        canvas2.drawText(str17, width25, height17, paint36);
        Unit unit13 = Unit.INSTANCE;
        float f9 = this.value;
        if (f9 <= 1.1f) {
            bitmap = this.extremelyLowBitmap;
        } else if (f9 > 1.1f && f9 <= 2.5f) {
            bitmap = this.lowBitmap;
        } else if (f9 <= 2.5f || f9 > 5.0f) {
            bitmap = f9 > 5.0f ? this.highBitmap : null;
        } else {
            bitmap = this.midBitmap;
        }
        if (bitmap != null) {
            Rect rect31 = this.rect;
            if (rect31 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str11);
                rect31 = null;
            }
            rect31.set((int) (f8 - ((float) (this.size15dp / 2))), (getHeight() / 2) - DensityUtils.dp2px(15.0f), (int) (f8 + ((float) (this.size15dp / 2))), (getHeight() / 2) + DensityUtils.dp2px(15.0f));
            Rect rect32 = this.rect;
            if (rect32 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(str11);
                rect32 = null;
            }
            Paint paint37 = this.paint;
            if (paint37 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                rect2 = null;
                paint37 = null;
            } else {
                rect2 = null;
            }
            canvas2.drawBitmap(bitmap, rect2, rect32, paint37);
            Unit unit14 = Unit.INSTANCE;
        }
    }

    private final void drawAlabo(Canvas canvas) {
        Bitmap bitmap;
        Canvas canvas2 = canvas;
        Paint paint2 = this.paint;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint2 = null;
        }
        paint2.setColor(this.extremelyLowColor);
        float width = (float) (getWidth() - this.size15dp);
        float height = (float) (getHeight() / 2);
        float f = (float) (this.size15dp / 2);
        Paint paint3 = this.paint;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint3 = null;
        }
        canvas2.drawCircle(width, height, f, paint3);
        Rect rect2 = this.rect;
        if (rect2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect2 = null;
        }
        int width2 = getWidth();
        int i = this.size15dp;
        rect2.set((int) ((((double) (width2 - (i * 2))) * 0.8200000000000001d) + ((double) i)), (getHeight() / 2) - (this.size15dp / 2), getWidth() - this.size15dp, (getHeight() / 2) + (this.size15dp / 2));
        if (canvas2 != null) {
            Rect rect3 = this.rect;
            if (rect3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect3 = null;
            }
            Paint paint4 = this.paint;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint4 = null;
            }
            canvas2.drawRect(rect3, paint4);
            Unit unit = Unit.INSTANCE;
        }
        Paint paint5 = this.paint;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint5 = null;
        }
        paint5.setColor(this.lowColor);
        Rect rect4 = this.rect;
        if (rect4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect4 = null;
        }
        int width3 = getWidth();
        int i2 = this.size15dp;
        int i3 = (int) ((((double) (width3 - (i2 * 2))) * 0.5800000000000001d) + ((double) i2));
        int height2 = (getHeight() / 2) - (this.size15dp / 2);
        int width4 = getWidth();
        int i4 = this.size15dp;
        rect4.set(i3, height2, (int) ((((double) (width4 - (i4 * 2))) * 0.8200000000000001d) + ((double) i4)), (getHeight() / 2) + (this.size15dp / 2));
        if (canvas2 != null) {
            Rect rect5 = this.rect;
            if (rect5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect5 = null;
            }
            Paint paint6 = this.paint;
            if (paint6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint6 = null;
            }
            canvas2.drawRect(rect5, paint6);
            Unit unit2 = Unit.INSTANCE;
        }
        Paint paint7 = this.paint;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint7 = null;
        }
        paint7.setColor(this.midColor);
        Rect rect6 = this.rect;
        if (rect6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect6 = null;
        }
        int width5 = getWidth();
        int i5 = this.size15dp;
        int i6 = (int) ((((double) (width5 - (i5 * 2))) * 0.17000000000000004d) + ((double) i5));
        int height3 = (getHeight() / 2) - (this.size15dp / 2);
        int width6 = getWidth();
        int i7 = this.size15dp;
        rect6.set(i6, height3, (int) ((((double) (width6 - (i7 * 2))) * 0.5800000000000001d) + ((double) i7)), (getHeight() / 2) + (this.size15dp / 2));
        if (canvas2 != null) {
            Rect rect7 = this.rect;
            if (rect7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect7 = null;
            }
            Paint paint8 = this.paint;
            if (paint8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint8 = null;
            }
            canvas2.drawRect(rect7, paint8);
            Unit unit3 = Unit.INSTANCE;
        }
        Paint paint9 = this.paint;
        if (paint9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint9 = null;
        }
        paint9.setColor(this.highColor);
        Rect rect8 = this.rect;
        if (rect8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect8 = null;
        }
        int i8 = this.size15dp;
        int height4 = (getHeight() / 2) - (this.size15dp / 2);
        int width7 = getWidth();
        int i9 = this.size15dp;
        rect8.set(i8, height4, (int) ((((double) (width7 - (i9 * 2))) * 0.17000000000000004d) + ((double) i9)), (getHeight() / 2) + (this.size15dp / 2));
        if (canvas2 != null) {
            Rect rect9 = this.rect;
            if (rect9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect9 = null;
            }
            Paint paint10 = this.paint;
            if (paint10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint10 = null;
            }
            canvas2.drawRect(rect9, paint10);
            Unit unit4 = Unit.INSTANCE;
        }
        if (canvas2 != null) {
            float f2 = (float) this.size15dp;
            float height5 = (float) (getHeight() / 2);
            float f3 = (float) (this.size15dp / 2);
            Paint paint11 = this.paint;
            if (paint11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint11 = null;
            }
            canvas2.drawCircle(f2, height5, f3, paint11);
            Unit unit5 = Unit.INSTANCE;
        }
        Paint paint12 = this.paint;
        if (paint12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint12 = null;
        }
        paint12.setColor(this.textColor);
        Paint paint13 = this.paint;
        if (paint13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint13 = null;
        }
        paint13.setTypeface(Typeface.DEFAULT);
        Paint paint14 = this.paint;
        if (paint14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint14 = null;
        }
        paint14.setTextSize(DensityUtils.sp2px(12.0f));
        float f4 = this.value;
        if (0.8f > f4 || f4 > 1.4f) {
            Paint paint15 = this.paint;
            if (paint15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint15 = null;
            }
            String str = this.marker1Dot1.toString();
            int length = this.marker1Dot1.toString().length();
            Rect rect10 = this.rect;
            if (rect10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect10 = null;
            }
            paint15.getTextBounds(str, 0, length, rect10);
            if (canvas2 != null) {
                String str2 = this.marker1Dot1.toString();
                int width8 = getWidth();
                int i10 = this.size15dp;
                double d = (((double) (width8 - (i10 * 2))) * 0.8200000000000001d) + ((double) i10);
                Rect rect11 = this.rect;
                if (rect11 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rect");
                    rect11 = null;
                }
                float width9 = (float) (d - ((double) (rect11.width() / 2)));
                float height6 = ((float) (getHeight() / 2)) - ((float) (this.size15dp / 2));
                Rect rect12 = this.rect;
                if (rect12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rect");
                    rect12 = null;
                }
                float height7 = height6 - ((float) rect12.height());
                Paint paint16 = this.paint;
                if (paint16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paint");
                    paint16 = null;
                }
                canvas2.drawText(str2, width9, height7, paint16);
                Unit unit6 = Unit.INSTANCE;
            }
        }
        float f5 = this.value;
        if (2.2f > f5 || f5 > 2.8f) {
            Paint paint17 = this.paint;
            if (paint17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint17 = null;
            }
            String str3 = this.marker2Dot5.toString();
            int length2 = this.marker2Dot5.toString().length();
            Rect rect13 = this.rect;
            if (rect13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect13 = null;
            }
            paint17.getTextBounds(str3, 0, length2, rect13);
            if (canvas2 != null) {
                String str4 = this.marker2Dot5.toString();
                int width10 = getWidth();
                int i11 = this.size15dp;
                double d2 = (((double) (width10 - (i11 * 2))) * 0.5800000000000001d) + ((double) i11);
                Rect rect14 = this.rect;
                if (rect14 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rect");
                    rect14 = null;
                }
                float width11 = (float) (d2 - ((double) (rect14.width() / 2)));
                float height8 = ((float) (getHeight() / 2)) - ((float) (this.size15dp / 2));
                Rect rect15 = this.rect;
                if (rect15 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rect");
                    rect15 = null;
                }
                float height9 = height8 - ((float) rect15.height());
                Paint paint18 = this.paint;
                if (paint18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paint");
                    paint18 = null;
                }
                canvas2.drawText(str4, width11, height9, paint18);
                Unit unit7 = Unit.INSTANCE;
            }
        }
        double d3 = (double) this.value;
        if (4.7d > d3 || d3 > 5.3d) {
            Paint paint19 = this.paint;
            if (paint19 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint19 = null;
            }
            String str5 = this.marker5.toString();
            int length3 = this.marker5.toString().length();
            Rect rect16 = this.rect;
            if (rect16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect16 = null;
            }
            paint19.getTextBounds(str5, 0, length3, rect16);
            if (canvas2 != null) {
                String str6 = this.marker5.toString();
                int width12 = getWidth();
                int i12 = this.size15dp;
                double d4 = (((double) (width12 - (i12 * 2))) * 0.17000000000000004d) + ((double) i12);
                Rect rect17 = this.rect;
                if (rect17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rect");
                    rect17 = null;
                }
                float width13 = (float) (d4 - ((double) (rect17.width() / 2)));
                float height10 = ((float) (getHeight() / 2)) - ((float) (this.size15dp / 2));
                Rect rect18 = this.rect;
                if (rect18 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rect");
                    rect18 = null;
                }
                float height11 = height10 - ((float) rect18.height());
                Paint paint20 = this.paint;
                if (paint20 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paint");
                    paint20 = null;
                }
                canvas2.drawText(str6, width13, height11, paint20);
                Unit unit8 = Unit.INSTANCE;
            }
        }
        Paint paint21 = this.paint;
        if (paint21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint21 = null;
        }
        String str7 = this.hintExtremelyLow;
        int length4 = str7.length();
        Rect rect19 = this.rect;
        if (rect19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect19 = null;
        }
        paint21.getTextBounds(str7, 0, length4, rect19);
        if (canvas2 != null) {
            String str8 = this.hintExtremelyLow;
            float width14 = ((float) getWidth()) - ((float) ((((double) (getWidth() - (this.size15dp * 2))) * 0.18d) / ((double) 2)));
            Rect rect20 = this.rect;
            if (rect20 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect20 = null;
            }
            float width15 = (width14 - ((float) (rect20.width() / 2))) - ((float) this.size15dp);
            float height12 = ((float) (getHeight() / 2)) + ((float) (this.size18dp * 2));
            Paint paint22 = this.paint;
            if (paint22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint22 = null;
            }
            float textSize = height12 - (paint22.getTextSize() / ((float) 2));
            Paint paint23 = this.paint;
            if (paint23 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint23 = null;
            }
            canvas2.drawText(str8, width15, textSize, paint23);
            Unit unit9 = Unit.INSTANCE;
        }
        Paint paint24 = this.paint;
        if (paint24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint24 = null;
        }
        String str9 = this.hintLow;
        int length5 = str9.length();
        Rect rect21 = this.rect;
        if (rect21 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect21 = null;
        }
        paint24.getTextBounds(str9, 0, length5, rect21);
        if (canvas2 != null) {
            String str10 = this.hintLow;
            double width16 = (((double) getWidth()) - (((double) (getWidth() - (this.size15dp * 2))) * 0.18d)) - ((((double) (getWidth() - (this.size15dp * 2))) * 0.24d) / ((double) 2));
            Rect rect22 = this.rect;
            if (rect22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect22 = null;
            }
            float width17 = (float) ((width16 - ((double) (rect22.width() / 2))) - ((double) this.size15dp));
            float height13 = ((float) (getHeight() / 2)) + ((float) (this.size18dp * 2));
            Paint paint25 = this.paint;
            if (paint25 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint25 = null;
            }
            float textSize2 = height13 - (paint25.getTextSize() / ((float) 2));
            Paint paint26 = this.paint;
            if (paint26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint26 = null;
            }
            canvas2.drawText(str10, width17, textSize2, paint26);
            Unit unit10 = Unit.INSTANCE;
        }
        Paint paint27 = this.paint;
        if (paint27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint27 = null;
        }
        String str11 = this.hintMid;
        int length6 = str11.length();
        Rect rect23 = this.rect;
        if (rect23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect23 = null;
        }
        paint27.getTextBounds(str11, 0, length6, rect23);
        if (canvas2 != null) {
            String str12 = this.hintMid;
            double width18 = (((double) getWidth()) - (((double) (getWidth() - (this.size15dp * 2))) * 0.42d)) - ((((double) (getWidth() - (this.size15dp * 2))) * 0.41d) / ((double) 2));
            Rect rect24 = this.rect;
            if (rect24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect24 = null;
            }
            float width19 = (float) ((width18 - ((double) (rect24.width() / 2))) - ((double) this.size15dp));
            float height14 = ((float) (getHeight() / 2)) + ((float) (this.size18dp * 2));
            Paint paint28 = this.paint;
            if (paint28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint28 = null;
            }
            float textSize3 = height14 - (paint28.getTextSize() / ((float) 2));
            Paint paint29 = this.paint;
            if (paint29 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint29 = null;
            }
            canvas2.drawText(str12, width19, textSize3, paint29);
            Unit unit11 = Unit.INSTANCE;
        }
        Paint paint30 = this.paint;
        if (paint30 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint30 = null;
        }
        String str13 = this.hintHigh;
        int length7 = str13.length();
        Rect rect25 = this.rect;
        if (rect25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect25 = null;
        }
        paint30.getTextBounds(str13, 0, length7, rect25);
        if (canvas2 != null) {
            String str14 = this.hintHigh;
            float width20 = (float) ((((double) (getWidth() - (this.size15dp * 2))) * 0.17000000000000004d) / ((double) 2));
            Rect rect26 = this.rect;
            if (rect26 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect26 = null;
            }
            float width21 = (width20 - ((float) (rect26.width() / 2))) + ((float) this.size15dp);
            float height15 = ((float) (getHeight() / 2)) + ((float) (this.size18dp * 2));
            Paint paint31 = this.paint;
            if (paint31 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint31 = null;
            }
            float textSize4 = height15 - (paint31.getTextSize() / ((float) 2));
            Paint paint32 = this.paint;
            if (paint32 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint32 = null;
            }
            canvas2.drawText(str14, width21, textSize4, paint32);
            Unit unit12 = Unit.INSTANCE;
        }
        float f6 = ((float) 1) - (this.value / 6.0f);
        int width22 = getWidth();
        int i13 = this.size15dp;
        float f7 = (f6 * ((float) (width22 - (i13 * 2)))) + ((float) i13);
        Paint paint33 = this.paint;
        if (paint33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint33 = null;
        }
        paint33.setTypeface(Typeface.DEFAULT_BOLD);
        Paint paint34 = this.paint;
        if (paint34 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint34 = null;
        }
        paint34.setTextSize(DensityUtils.sp2px(15.0f));
        Paint paint35 = this.paint;
        if (paint35 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("paint");
            paint35 = null;
        }
        String str15 = this.valueString;
        int length8 = str15.length();
        Rect rect27 = this.rect;
        if (rect27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rect");
            rect27 = null;
        }
        paint35.getTextBounds(str15, 0, length8, rect27);
        if (canvas2 != null) {
            String str16 = this.valueString;
            Rect rect28 = this.rect;
            if (rect28 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect28 = null;
            }
            float width23 = f7 - ((float) (rect28.width() / 2));
            float height16 = ((float) (getHeight() / 2)) - ((float) (this.size15dp / 2));
            Rect rect29 = this.rect;
            if (rect29 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect29 = null;
            }
            float height17 = height16 - ((float) rect29.height());
            Paint paint36 = this.paint;
            if (paint36 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("paint");
                paint36 = null;
            }
            canvas2.drawText(str16, width23, height17, paint36);
            Unit unit13 = Unit.INSTANCE;
        }
        float f8 = this.value;
        if (f8 <= 1.1f) {
            bitmap = this.extremelyLowBitmap;
        } else if (f8 > 1.1f && f8 <= 2.5f) {
            bitmap = this.lowBitmap;
        } else if (f8 <= 2.5f || f8 > 5.0f) {
            bitmap = f8 > 5.0f ? this.highBitmap : null;
        } else {
            bitmap = this.midBitmap;
        }
        if (bitmap != null) {
            Rect rect30 = this.rect;
            if (rect30 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rect");
                rect30 = null;
            }
            rect30.set((int) (f7 - ((float) (this.size15dp / 2))), (getHeight() / 2) - DensityUtils.dp2px(15.0f), (int) (f7 + ((float) (this.size15dp / 2))), (getHeight() / 2) + DensityUtils.dp2px(15.0f));
            if (canvas2 != null) {
                Rect rect31 = this.rect;
                if (rect31 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rect");
                    rect31 = null;
                }
                Paint paint37 = this.paint;
                if (paint37 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("paint");
                    paint37 = null;
                }
                canvas2.drawBitmap(bitmap, (Rect) null, rect31, paint37);
                Unit unit14 = Unit.INSTANCE;
            }
        }
    }
}
