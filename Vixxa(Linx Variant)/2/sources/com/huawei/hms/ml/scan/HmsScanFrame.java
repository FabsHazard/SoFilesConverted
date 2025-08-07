package com.huawei.hms.ml.scan;

import android.graphics.Bitmap;
import android.graphics.YuvImage;

public class HmsScanFrame {
    private Bitmap bitmap;
    private int height;
    private int width;
    private YuvImage yuvImage;

    public HmsScanFrame(YuvImage yuvImage2) {
        if (yuvImage2.getYuvData() != null && yuvImage2.getYuvFormat() == 17) {
            this.yuvImage = yuvImage2;
            this.width = yuvImage2.getWidth();
            this.height = yuvImage2.getHeight();
        }
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public YuvImage getYuvImage() {
        return this.yuvImage;
    }

    public HmsScanFrame(Bitmap bitmap2) {
        this.bitmap = bitmap2;
        if (bitmap2 != null) {
            this.width = bitmap2.getWidth();
            this.height = bitmap2.getHeight();
        }
    }
}
