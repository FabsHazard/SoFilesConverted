package com.huawei.hms.ml.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicYuvToRGB;
import android.renderscript.Type;
import java.util.Locale;

public class NV21ToBitmapConverter1 {
    private Context applicationContext;
    private int height = -1;
    private Allocation in;
    private int length = -1;
    private Allocation out;
    private RenderScript renderScript;
    private Type.Builder rgbaType;
    private int width = -1;
    private ScriptIntrinsicYuvToRGB yuvToRgbIntrinsic;
    private Type.Builder yuvType;

    public NV21ToBitmapConverter1(Context context) {
        if (context != null) {
            Context applicationContext2 = context.getApplicationContext();
            if (applicationContext2 == null) {
                this.applicationContext = context;
            } else {
                this.applicationContext = applicationContext2;
            }
            RenderScript create = RenderScript.create(this.applicationContext);
            this.renderScript = create;
            if (create != null) {
                this.yuvToRgbIntrinsic = ScriptIntrinsicYuvToRGB.create(create, Element.U8_4(create));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("context can't be null");
    }

    public Context getApplicationContext() {
        Context context = this.applicationContext;
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("initial must be called first");
    }

    public Bitmap convertYUVtoRGB(byte[] bArr, int i, int i2) {
        if (this.yuvType == null) {
            RenderScript renderScript2 = this.renderScript;
            Type.Builder x = new Type.Builder(renderScript2, Element.U8(renderScript2)).setX(bArr.length);
            this.yuvType = x;
            this.in = Allocation.createTyped(this.renderScript, x.create(), 1);
            RenderScript renderScript3 = this.renderScript;
            Type.Builder y = new Type.Builder(renderScript3, Element.RGBA_8888(renderScript3)).setX(i).setY(i2);
            this.rgbaType = y;
            this.out = Allocation.createTyped(this.renderScript, y.create(), 1);
        }
        this.in.copyFrom(bArr);
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB = this.yuvToRgbIntrinsic;
        if (scriptIntrinsicYuvToRGB != null) {
            scriptIntrinsicYuvToRGB.setInput(this.in);
            this.yuvToRgbIntrinsic.forEach(this.out);
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
        this.out.copyTo(createBitmap);
        return createBitmap;
    }

    public Matrix getTransformationMatrix(int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3) {
        Matrix matrix = new Matrix();
        if (i5 != 0) {
            if (i5 % 90 == 0) {
                matrix.postTranslate(((float) (-i)) / 2.0f, ((float) (-i2)) / 2.0f);
                matrix.postRotate((float) i5);
            } else {
                throw new IllegalArgumentException(String.format(Locale.ENGLISH, "Rotation of %d", new Object[]{Integer.valueOf(i5)}));
            }
        }
        int i6 = 1;
        boolean z4 = (Math.abs(i5) + 90) % 180 == 0;
        int i7 = z4 ? i2 : i;
        if (!z4) {
            i = i2;
        }
        int i8 = z ? -1 : 1;
        if (z2) {
            i6 = -1;
        }
        if (!(i7 == i3 && i == i4)) {
            float f = ((float) (i8 * i3)) / ((float) i7);
            float f2 = ((float) (i6 * i4)) / ((float) i);
            if (z3) {
                float max = Math.max(Math.abs(f), Math.abs(f2));
                matrix.postScale(max, max);
            } else {
                matrix.postScale(f, f2);
            }
        }
        if (i5 != 0) {
            float f3 = ((float) i3) / 2.0f;
            float f4 = ((float) i4) / 2.0f;
            matrix.postTranslate(f3, f4);
            matrix.postScale((float) i8, (float) i6, f3, f4);
        }
        return matrix;
    }

    public Bitmap convert(byte[] bArr, int i, int i2, int i3, int i4, int i5, boolean z, boolean z2, boolean z3) {
        byte[] bArr2 = bArr;
        int i6 = i2;
        int i7 = i5;
        recreateIfNeed(bArr, i, i6, i7);
        Bitmap createBitmap = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        new Canvas(createBitmap).drawBitmap(convertYUVtoRGB(bArr, i, i2), getTransformationMatrix(i, i6, i3, i4, i7, z, z2, z3), (Paint) null);
        return createBitmap;
    }

    public Bitmap convert(byte[] bArr, int i, int i2, int i3, int i4, int i5) {
        return convert(bArr, i, i2, i3, i4, i5, false, false, false);
    }

    private void recreateIfNeed(byte[] bArr, int i, int i2, int i3) {
        if (this.width != i || this.height != i2 || this.length != bArr.length) {
            this.width = i;
            this.height = i2;
            this.length = bArr.length;
            this.yuvType = null;
            this.rgbaType = null;
        }
    }
}
