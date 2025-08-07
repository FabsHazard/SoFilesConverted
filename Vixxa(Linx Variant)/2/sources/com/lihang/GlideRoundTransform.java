package com.lihang;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import java.security.MessageDigest;

class GlideRoundTransform implements Transformation<Bitmap> {
    private boolean isLeftBottom;
    private boolean isLeftTop;
    private boolean isRightBottom;
    private boolean isRightTop;
    private float leftBottom_radius;
    private float leftTop_radius;
    private BitmapPool mBitmapPool;
    private float rightBottom_radius;
    private float rightTop_radius;

    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    public GlideRoundTransform(Context context, float f, float f2, float f3, float f4) {
        this.mBitmapPool = Glide.get(context).getBitmapPool();
        this.leftTop_radius = f;
        if (f != 0.0f) {
            this.isLeftTop = true;
        }
        this.leftBottom_radius = f2;
        if (f2 != 0.0f) {
            this.isLeftBottom = true;
        }
        this.rightTop_radius = f3;
        if (f3 != 0.0f) {
            this.isRightTop = true;
        }
        this.rightBottom_radius = f4;
        if (f4 != 0.0f) {
            this.isRightBottom = true;
        }
    }

    public Resource<Bitmap> transform(Context context, Resource<Bitmap> resource, int i, int i2) {
        int i3;
        int i4;
        Bitmap bitmap = resource.get();
        if (i > i2) {
            float f = (float) i2;
            float f2 = (float) i;
            i3 = bitmap.getWidth();
            i4 = (int) (((float) bitmap.getWidth()) * (f / f2));
            if (i4 > bitmap.getHeight()) {
                i4 = bitmap.getHeight();
                i3 = (int) (((float) bitmap.getHeight()) * (f2 / f));
            }
        } else if (i < i2) {
            float f3 = (float) i;
            float f4 = (float) i2;
            int height = bitmap.getHeight();
            int height2 = (int) (((float) bitmap.getHeight()) * (f3 / f4));
            if (height2 > bitmap.getWidth()) {
                i3 = bitmap.getWidth();
                i4 = (int) (((float) bitmap.getWidth()) * (f4 / f3));
            } else {
                int i5 = height;
                i3 = height2;
                i4 = i5;
            }
        } else {
            i3 = bitmap.getHeight();
            i4 = i3;
        }
        float f5 = ((float) i4) / ((float) i2);
        this.leftTop_radius *= f5;
        this.leftBottom_radius *= f5;
        this.rightTop_radius *= f5;
        this.rightBottom_radius *= f5;
        Bitmap bitmap2 = this.mBitmapPool.get(i3, i4, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(i3, i4, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        int width = (bitmap.getWidth() - i3) / 2;
        int height3 = (bitmap.getHeight() - i4) / 2;
        if (!(width == 0 && height3 == 0)) {
            Matrix matrix = new Matrix();
            matrix.setTranslate((float) (-width), (float) (-height3));
            bitmapShader.setLocalMatrix(matrix);
        }
        paint.setShader(bitmapShader);
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0.0f, 0.0f, (float) canvas.getWidth(), (float) canvas.getHeight());
        float f6 = this.leftTop_radius;
        float f7 = this.rightTop_radius;
        float f8 = this.rightBottom_radius;
        float f9 = this.leftBottom_radius;
        Path path = new Path();
        path.addRoundRect(rectF, new float[]{f6, f6, f7, f7, f8, f8, f9, f9}, Path.Direction.CW);
        canvas.drawPath(path, paint);
        return BitmapResource.obtain(bitmap2, this.mBitmapPool);
    }
}
