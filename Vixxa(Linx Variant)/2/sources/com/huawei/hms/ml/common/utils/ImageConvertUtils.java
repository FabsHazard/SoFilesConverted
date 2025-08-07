package com.huawei.hms.ml.common.utils;

import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.media.Image;
import java.nio.ByteBuffer;
import java.util.Arrays;
import kotlin.jvm.internal.ByteCompanionObject;

public final class ImageConvertUtils {
    public static final int INDEX_PLANE_U = 1;
    public static final int INDEX_PLANE_V = 2;
    public static final int INDEX_PLANE_Y = 0;
    private static final ImageConvertUtils INSTANCE = new ImageConvertUtils();
    public static final int YUV_FORMAT_I420 = 1;
    public static final int YUV_FORMAT_NV21 = 2;

    private static int getChannelOffset(int i, int i2, int i3) {
        if (i != 0) {
            return i != 1 ? i2 == 1 ? (int) (((double) i3) * 1.25d) : i3 : i2 == 1 ? i3 : i3 + 1;
        }
        return 0;
    }

    private static int getOutputStride(int i, int i2) {
        return (i == 0 || i2 == 1) ? 1 : 2;
    }

    private ImageConvertUtils() {
    }

    public static ImageConvertUtils getInstance() {
        return INSTANCE;
    }

    public static byte[] buffer2Byte(ByteBuffer byteBuffer) {
        byteBuffer.rewind();
        int limit = byteBuffer.limit();
        byte[] bArr = new byte[limit];
        byteBuffer.get(bArr, 0, limit);
        return bArr;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        throw r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] nv21ToJpeg(byte[] r9, int r10, int r11) {
        /*
            r0 = 0
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x0030 }
            r1.<init>()     // Catch:{ IOException -> 0x0030 }
            android.graphics.YuvImage r8 = new android.graphics.YuvImage     // Catch:{ all -> 0x0024 }
            r4 = 17
            r7 = 0
            r2 = r8
            r3 = r9
            r5 = r10
            r6 = r11
            r2.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0024 }
            android.graphics.Rect r9 = new android.graphics.Rect     // Catch:{ all -> 0x0024 }
            r9.<init>(r0, r0, r10, r11)     // Catch:{ all -> 0x0024 }
            r10 = 100
            r8.compressToJpeg(r9, r10, r1)     // Catch:{ all -> 0x0024 }
            byte[] r9 = r1.toByteArray()     // Catch:{ all -> 0x0024 }
            r1.close()     // Catch:{ IOException -> 0x0030 }
            return r9
        L_0x0024:
            r9 = move-exception
            throw r9     // Catch:{ all -> 0x0026 }
        L_0x0026:
            r10 = move-exception
            r1.close()     // Catch:{ all -> 0x002b }
            goto L_0x002f
        L_0x002b:
            r11 = move-exception
            r9.addSuppressed(r11)     // Catch:{ IOException -> 0x0030 }
        L_0x002f:
            throw r10     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            byte[] r9 = new byte[r0]
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ml.common.utils.ImageConvertUtils.nv21ToJpeg(byte[], int, int):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x001d, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] bitmap2Jpeg(android.graphics.Bitmap r2, int r3) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ IOException -> 0x001e }
            r0.<init>()     // Catch:{ IOException -> 0x001e }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ all -> 0x0012 }
            r2.compress(r1, r3, r0)     // Catch:{ all -> 0x0012 }
            byte[] r2 = r0.toByteArray()     // Catch:{ all -> 0x0012 }
            r0.close()     // Catch:{ IOException -> 0x001e }
            return r2
        L_0x0012:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0014 }
        L_0x0014:
            r3 = move-exception
            r0.close()     // Catch:{ all -> 0x0019 }
            goto L_0x001d
        L_0x0019:
            r0 = move-exception
            r2.addSuppressed(r0)     // Catch:{ IOException -> 0x001e }
        L_0x001d:
            throw r3     // Catch:{ IOException -> 0x001e }
        L_0x001e:
            r2 = 0
            byte[] r2 = new byte[r2]
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.ml.common.utils.ImageConvertUtils.bitmap2Jpeg(android.graphics.Bitmap, int):byte[]");
    }

    public static byte[] yuv2Buffer(Image image) {
        Image.Plane[] planes = image.getPlanes();
        ByteBuffer buffer = planes[0].getBuffer();
        ByteBuffer buffer2 = planes[1].getBuffer();
        ByteBuffer buffer3 = planes[2].getBuffer();
        int remaining = buffer.remaining();
        int remaining2 = buffer2.remaining();
        int remaining3 = buffer3.remaining();
        int i = remaining + remaining2 + remaining3;
        byte[] bArr = new byte[i];
        buffer.get(bArr, 0, remaining);
        buffer3.get(bArr, remaining, remaining3);
        buffer2.get(bArr, i - remaining2, remaining2);
        return bArr;
    }

    public static byte[] byteToNv21(byte[] bArr) {
        int length = bArr.length;
        int i = (length * 2) / 3;
        int i2 = length - i;
        int i3 = length / 6;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        for (int i4 = 0; i4 < i2; i4++) {
            if (i4 % 2 == 0) {
                bArr2[i + i4] = bArr[(i4 / 2) + i];
            } else {
                bArr2[i + i4] = bArr[i + i3 + (i4 / 2)];
            }
        }
        return bArr2;
    }

    public static byte[] bitmapToNv21(Bitmap bitmap, int i, int i2) {
        if (bitmap == null || bitmap.getWidth() < i || bitmap.getHeight() < i2) {
            return new byte[0];
        }
        int[] iArr = new int[(i * i2)];
        bitmap.getPixels(iArr, 0, i, 0, 0, i, i2);
        return argbToNv21(iArr, i, i2);
    }

    private static byte[] argbToNv21(int[] iArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int i5 = i3 * i4;
        int i6 = (i5 * 3) / 2;
        byte[] bArr = new byte[i6];
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < i4; i9++) {
            int i10 = 0;
            while (i10 < i3) {
                int i11 = iArr[i8];
                int i12 = (16711680 & i11) >> 16;
                int i13 = (65280 & i11) >> 8;
                int i14 = 255;
                int i15 = i11 & 255;
                int i16 = (((((i12 * 66) + (i13 * 129)) + (i15 * 25)) + 128) >> 8) + 16;
                int i17 = (((((i12 * -38) - (i13 * 74)) + (i15 * 112)) + 128) >> 8) + 128;
                int i18 = (((((i12 * 112) - (i13 * 94)) - (i15 * 18)) + 128) >> 8) + 128;
                int i19 = i7 + 1;
                if (i16 < 0) {
                    i16 = 0;
                } else if (i16 > 255) {
                    i16 = 255;
                }
                bArr[i7] = (byte) i16;
                if (i9 % 2 == 0 && i8 % 2 == 0 && i5 < i6 - 2) {
                    int i20 = i5 + 1;
                    if (i18 < 0) {
                        i18 = 0;
                    } else if (i18 > 255) {
                        i18 = 255;
                    }
                    bArr[i5] = (byte) i18;
                    i5 += 2;
                    if (i17 < 0) {
                        i14 = 0;
                    } else if (i17 <= 255) {
                        i14 = i17;
                    }
                    bArr[i20] = (byte) i14;
                }
                i8++;
                i10++;
                i7 = i19;
            }
        }
        return bArr;
    }

    public static byte[] nv21ToGray(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 2;
        byte[] bArr2 = new byte[i4];
        Arrays.fill(bArr2, ByteCompanionObject.MIN_VALUE);
        System.arraycopy(bArr2, 0, bArr, i3, i4);
        return bArr;
    }

    private static boolean isImageFormatSupported(Image image) {
        int format = image.getFormat();
        return format == 35 || format == 17 || format == 842094169;
    }

    public static byte[] getDataFromImage(Image image, int i) {
        Rect rect;
        int i2;
        int i3 = i;
        checkFormat(image, i);
        Rect cropRect = image.getCropRect();
        int format = image.getFormat();
        int width = cropRect.width();
        int height = cropRect.height();
        Image.Plane[] planes = image.getPlanes();
        int i4 = width * height;
        byte[] bArr = new byte[((ImageFormat.getBitsPerPixel(format) * i4) / 8)];
        int i5 = 0;
        byte[] bArr2 = new byte[planes[0].getRowStride()];
        int i6 = 0;
        while (i6 < planes.length) {
            ByteBuffer buffer = planes[i6].getBuffer();
            int rowStride = planes[i6].getRowStride();
            int pixelStride = planes[i6].getPixelStride();
            int channelOffset = getChannelOffset(i6, i3, i4);
            int outputStride = getOutputStride(i6, i3);
            int i7 = i6 == 0 ? i5 : 1;
            int i8 = width >> i7;
            int i9 = height >> i7;
            int i10 = width;
            buffer.position(((cropRect.top >> i7) * rowStride) + ((cropRect.left >> i7) * pixelStride));
            int i11 = 0;
            while (i11 < i9) {
                if (pixelStride == 1 && outputStride == 1) {
                    buffer.get(bArr, channelOffset, i8);
                    channelOffset += i8;
                    rect = cropRect;
                    i2 = i8;
                } else {
                    rect = cropRect;
                    i2 = ((i8 - 1) * pixelStride) + 1;
                    buffer.get(bArr2, 0, i2);
                    for (int i12 = 0; i12 < i8; i12++) {
                        bArr[channelOffset] = bArr2[i12 * pixelStride];
                        channelOffset += outputStride;
                    }
                }
                if (i11 < i9 - 1) {
                    buffer.position((buffer.position() + rowStride) - i2);
                }
                i11++;
                cropRect = rect;
            }
            Rect rect2 = cropRect;
            i6++;
            i3 = i;
            width = i10;
            i5 = 0;
        }
        return bArr;
    }

    private static void checkFormat(Image image, int i) {
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException("only support YUV_FORMAT_I420 and YUV_FORMAT_NV21");
        } else if (!isImageFormatSupported(image)) {
            throw new RuntimeException("can't convert Image to byte array, format " + image.getFormat());
        }
    }
}
