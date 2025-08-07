package com.huawei.hms.scankit.util;

import com.huawei.hms.scankit.p.m1;
import com.huawei.hms.scankit.p.o4;

public class OpencvJNI {
    static {
        o4.c("OpencvJNI", "start load method");
        try {
            System.loadLibrary("scannative");
        } catch (UnsatisfiedLinkError unused) {
            o4.b("OpencvJNI", "UnsatisfiedLinkError");
            m1.a(false);
        }
    }

    public static native byte[] QRCornerDetect(byte[] bArr, int i, int i2, float[] fArr);

    public static native float[] QuadFitting(float[] fArr, int i, float[] fArr2);

    public static native byte[] adaptiveBinary(byte[] bArr, int i, int i2, int i3, boolean z);

    public static native byte[] imageResize(byte[] bArr, int i, int i2, int i3, int i4);

    public static native byte[] imageRotate(byte[] bArr, int i, int i2, int i3, int i4, float f, double d);

    public static void init() {
        o4.c("OpencvJNI", "init()");
    }

    public static native float[] multiBarcodeDetect(byte[] bArr, int i, int i2, int i3, boolean z);

    public static native byte[] removeMoirePattern(byte[] bArr, int i, int i2);

    public static native void setModel(byte[] bArr, int i, byte[] bArr2, int i2, byte[] bArr3, int i3);

    public static native byte[] sharpen(byte[] bArr, int i, int i2);
}
