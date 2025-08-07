package com.microtech.aidexx.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import androidx.core.content.res.ResourcesCompat;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001aB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\bJ\u001e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0014\u001a\u00020\bJ\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/utils/BitmapUtils;", "", "()V", "TEXT_SIZE", "", "combineVectorAndTextToDrawable", "Landroid/graphics/drawable/BitmapDrawable;", "vectorResId", "", "text", "", "isTextOnTop", "", "convertVectorToBitmap", "Landroid/graphics/Bitmap;", "vectorDrawable", "Landroid/graphics/drawable/Drawable;", "dp2px", "dp", "getBitmapFromResource", "id", "width", "height", "getDrawableFromResource", "getTextHeight", "getTextWidth", "TextPosition", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BitmapUtils.kt */
public final class BitmapUtils {
    public static final BitmapUtils INSTANCE = new BitmapUtils();
    private static final float TEXT_SIZE = DensityUtils.sp2px(8.0f);

    private BitmapUtils() {
    }

    public final int dp2px(float f) {
        return MathKt.roundToInt(ExtendsKt.getContext().getResources().getDisplayMetrics().density * f);
    }

    public final Drawable getDrawableFromResource(int i) {
        return ExtendsKt.getContext().getResources().getDrawable(i, (Resources.Theme) null);
    }

    public final BitmapDrawable getBitmapFromResource(int i, float f, float f2) {
        Bitmap bitmapFromResource = getBitmapFromResource(i);
        Matrix matrix = new Matrix();
        matrix.postScale(f / ((float) bitmapFromResource.getWidth()), f2 / ((float) bitmapFromResource.getHeight()));
        Bitmap createBitmap = Bitmap.createBitmap(bitmapFromResource, 0, 0, bitmapFromResource.getWidth(), bitmapFromResource.getHeight(), matrix, true);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        return new BitmapDrawable(ExtendsKt.getContext().getResources(), createBitmap);
    }

    public final Bitmap getBitmapFromResource(int i) {
        Drawable drawable = ResourcesCompat.getDrawable(ExtendsKt.getContext().getResources(), i, (Resources.Theme) null);
        Intrinsics.checkNotNull(drawable);
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public final BitmapDrawable combineVectorAndTextToDrawable(int i, String str, boolean z) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "text");
        Drawable drawable = ResourcesCompat.getDrawable(ExtendsKt.getContext().getResources(), i, ExtendsKt.getContext().getTheme());
        if (drawable == null) {
            return null;
        }
        Bitmap convertVectorToBitmap = convertVectorToBitmap(drawable);
        int textWidth = getTextWidth(str2);
        int width = convertVectorToBitmap.getWidth();
        float textHeight = (float) getTextHeight(str2);
        int max = Math.max((int) Math.max((double) textWidth, (double) width), (int) (((((float) convertVectorToBitmap.getHeight()) / 2.0f) + textHeight) * ((float) 2)));
        Bitmap createBitmap = Bitmap.createBitmap(max, max, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        TextPaint textPaint = new TextPaint();
        if (ThemeManager.INSTANCE.isLight()) {
            textPaint.setColor(ExtendsKt.getContext().getColor(R.color.blackAlpha50));
        } else {
            textPaint.setColor(ExtendsKt.getContext().getColor(R.color.gray_d8));
        }
        textPaint.setTextSize(TEXT_SIZE);
        textPaint.setAntiAlias(true);
        StaticLayout build = StaticLayout.Builder.obtain(str2, 0, str.length(), textPaint, textWidth).setAlignment(Layout.Alignment.ALIGN_CENTER).setIncludePad(false).setLineSpacing(0.0f, 1.0f).build();
        Intrinsics.checkNotNullExpressionValue(build, "build(...)");
        if (z) {
            canvas.save();
            canvas.translate((float) ((max - textWidth) / 2), (((float) (max - convertVectorToBitmap.getHeight())) / 2.0f) - textHeight);
            build.draw(canvas);
            canvas.restore();
            canvas.drawBitmap(convertVectorToBitmap, new Rect(0, 0, width, convertVectorToBitmap.getHeight()), new Rect((int) (((float) (max - width)) / 2.0f), (int) (((float) (max - convertVectorToBitmap.getHeight())) / 2.0f), (int) (((float) (width + max)) / 2.0f), (int) ((((float) max) / 2.0f) + (((float) convertVectorToBitmap.getHeight()) / 2.0f))), (Paint) null);
        } else {
            float f = ((float) max) / 2.0f;
            canvas.drawBitmap(convertVectorToBitmap, new Rect(0, 0, width, convertVectorToBitmap.getHeight()), new Rect((int) (((float) (max - width)) / 2.0f), (int) (f - (((float) convertVectorToBitmap.getHeight()) / 2.0f)), (int) (((float) (width + max)) / 2.0f), (int) (f + (((float) convertVectorToBitmap.getHeight()) / 2.0f))), (Paint) null);
            canvas.save();
            canvas.translate((float) ((max - textWidth) / 2), ((float) (max + convertVectorToBitmap.getHeight())) / 2.0f);
            build.draw(canvas);
            canvas.restore();
        }
        return new BitmapDrawable(ExtendsKt.getContext().getResources(), createBitmap);
    }

    private final Bitmap convertVectorToBitmap(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            intrinsicWidth = 40;
            intrinsicHeight = 40;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private final int getTextWidth(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(TEXT_SIZE);
        return (int) textPaint.measureText(str);
    }

    private final int getTextHeight(String str) {
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(TEXT_SIZE);
        return new StaticLayout(str, textPaint, 1000, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, false).getHeight();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/utils/BitmapUtils$TextPosition;", "", "(Ljava/lang/String;I)V", "TOP", "BOTTOM", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BitmapUtils.kt */
    public enum TextPosition {
        TOP,
        BOTTOM;

        public static EnumEntries<TextPosition> getEntries() {
            return $ENTRIES;
        }

        static {
            TextPosition[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }
}
