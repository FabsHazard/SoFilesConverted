package com.huawei.hms.mlsdk.common;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import com.huawei.hms.ml.common.utils.StreamUtils;
import com.huawei.hms.mlsdk.common.MLFrame;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;

public final class BitmapUtils {
    private static final String TAG = "BitmapUtils";

    public static Bitmap getBitmap(ByteBuffer byteBuffer, MLFrame.Property property) {
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteBuffer.rewind();
            int limit = byteBuffer.limit();
            byte[] bArr = new byte[limit];
            byteBuffer.get(bArr, 0, limit);
            YuvImage yuvImage = new YuvImage(bArr, 17, property.getWidth(), property.getHeight(), (int[]) null);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, property.getWidth(), property.getHeight()), 100, byteArrayOutputStream2);
                Bitmap rotateBitmap = rotateBitmap(BitmapFactory.decodeByteArray(byteArrayOutputStream2.toByteArray(), 0, byteArrayOutputStream2.size()), property.getQuadrant());
                StreamUtils.closeStreams(byteArrayOutputStream2);
                return rotateBitmap;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                StreamUtils.closeStreams(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            StreamUtils.closeStreams(byteArrayOutputStream);
            throw th;
        }
    }

    public static Bitmap rotateBitmap(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        matrix.postRotate((float) (i != 1 ? i != 2 ? i != 3 ? 0 : 270 : 180 : 90));
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static Bitmap cut(Bitmap bitmap, Point[] pointArr, int i) {
        Bitmap bitmap2 = bitmap;
        Point[] pointArr2 = pointArr;
        if (bitmap2 == null || pointArr2 == null || pointArr2.length != 4) {
            return null;
        }
        for (Point point : pointArr2) {
            if (point == null) {
                return null;
            }
        }
        Point point2 = pointArr2[0];
        Point point3 = pointArr2[1];
        Point point4 = pointArr2[2];
        double atan2 = Math.atan2((double) (point3.y - point2.y), (double) (point3.x - point2.x));
        float degrees = (float) Math.toDegrees(atan2);
        if (Math.abs((int) degrees) <= 0) {
            return cutPaddingExtendRect(bitmap, point2, point4, 0, 0, i);
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i2 = width >> 1;
        int i3 = height >> 1;
        Point point5 = new Point(i2, i3);
        Matrix matrix = new Matrix();
        matrix.setRotate(-degrees, (float) i2, (float) i3);
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
        return cutPaddingExtendRect(createBitmap, rotateCoordinate(bitmap2, point5, point2, atan2), rotateCoordinate(bitmap2, point5, point4, atan2), (createBitmap.getWidth() - width) >> 1, (createBitmap.getHeight() - height) >> 1, i);
    }

    private static Point rotateCoordinate(Bitmap bitmap, Point point, Point point2, double d) {
        int height = bitmap.getHeight();
        int i = point2.x;
        int i2 = point.x;
        int i3 = height - point.y;
        double d2 = (double) (i - i2);
        double d3 = (double) ((height - point2.y) - i3);
        return new Point((int) (((Math.cos(d) * d2) - (Math.sin(d) * d3)) + ((double) i2)), height - ((int) (((d2 * Math.sin(d)) + (d3 * Math.cos(d))) + ((double) i3))));
    }

    private static Bitmap cutPaddingExtendRect(Bitmap bitmap, Point point, Point point2, int i, int i2, int i3) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i4 = (point.x + i) - i3;
        int i5 = 0;
        if (i4 < 0) {
            i4 = 0;
        }
        int i6 = (point.y + i2) - i3;
        if (i6 >= 0) {
            i5 = i6;
        }
        int i7 = point2.x + i + i3;
        if (i7 <= width) {
            width = i7;
        }
        int i8 = point2.y + i2 + i3;
        if (i8 <= height) {
            height = i8;
        }
        return Bitmap.createBitmap(bitmap, i4, i5, width - i4, height - i5);
    }
}
