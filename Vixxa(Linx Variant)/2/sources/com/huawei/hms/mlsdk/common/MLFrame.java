package com.huawei.hms.mlsdk.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.Image;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Pair;
import com.huawei.hms.ml.common.utils.ImageConvertUtils;
import java.io.IOException;
import java.nio.ByteBuffer;

public class MLFrame {
    public static final int SCREEN_FIRST_QUADRANT = 0;
    public static final int SCREEN_FOURTH_QUADRANT = 3;
    public static final int SCREEN_SECOND_QUADRANT = 1;
    public static final int SCREEN_THIRD_QUADRANT = 2;
    /* access modifiers changed from: private */
    public Bitmap bitmap;
    /* access modifiers changed from: private */
    public ByteBuffer byteBuffer;
    private byte[] bytes;
    private volatile Boolean frameInit;
    private Property property;
    private int recMode;

    private boolean isSupportedYuvFormat(int i) {
        return i == 842094169 || i == 17;
    }

    public MLFrame() {
        this.frameInit = false;
        this.property = new Property();
        this.byteBuffer = null;
        this.bitmap = null;
    }

    private MLFrame(ByteBuffer byteBuffer2, Property property2) {
        this.frameInit = false;
        this.byteBuffer = byteBuffer2;
        this.property = property2 == null ? new Property() : property2;
    }

    private MLFrame(byte[] bArr, Property property2) {
        this(ByteBuffer.wrap(bArr), property2);
    }

    private MLFrame(Bitmap bitmap2) {
        this.frameInit = false;
        this.bitmap = bitmap2;
    }

    private MLFrame(Bitmap bitmap2, Property property2) {
        this.frameInit = false;
        this.bitmap = bitmap2;
        this.property = property2 == null ? new Property() : property2;
    }

    private MLFrame(byte[] bArr) {
        this.frameInit = false;
        this.bytes = bArr;
    }

    public Property acquireProperty() {
        return this.property;
    }

    public ByteBuffer acquireGrayByteBuffer() {
        ByteBuffer byteBuffer2 = this.byteBuffer;
        if (!(byteBuffer2 == null || this.property == null)) {
            ImageConvertUtils.nv21ToGray(byteBuffer2.array(), this.property.width, this.property.height);
        }
        return this.byteBuffer;
    }

    public int getRecMode() {
        return this.recMode;
    }

    public void setRecMode(int i) {
        this.recMode = i;
    }

    public ByteBuffer getByteBuffer() {
        return this.byteBuffer;
    }

    public Bitmap getPreviewBitmap() {
        if (this.bytes != null || this.byteBuffer != null || this.bitmap != null) {
            return wrapBitmap();
        }
        throw new IllegalStateException("At least one of bytes, byteBuffer or bitmap should be not null");
    }

    public Bitmap readBitmap() {
        return this.bitmap;
    }

    private final Bitmap wrapBitmap() {
        Bitmap bitmap2 = this.bitmap;
        if (bitmap2 != null) {
            return bitmap2;
        }
        if (this.property != null) {
            try {
                byte[] wrapJpeg = wrapJpeg(false);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(wrapJpeg, 0, wrapJpeg.length);
                if (this.property.getQuadrant() != 0) {
                    decodeByteArray = rotate(decodeByteArray, this.property.getQuadrant());
                }
                this.bitmap = decodeByteArray;
            } catch (ArrayIndexOutOfBoundsException | Exception | IllegalArgumentException unused) {
                return null;
            }
        }
        return this.bitmap;
    }

    public static class Property {
        public static final int IMAGE_FORMAT_NV21 = 17;
        public static final int IMAGE_FORMAT_YV12 = 842094169;
        public static final int SCREEN_FIRST_QUADRANT = 0;
        public static final int SCREEN_FOURTH_QUADRANT = 3;
        public static final int SCREEN_SECOND_QUADRANT = 1;
        public static final int SCREEN_THIRD_QUADRANT = 2;
        /* access modifiers changed from: private */
        public Ext ext;
        /* access modifiers changed from: private */
        public int formatType;
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */
        public int itemIdentity;
        /* access modifiers changed from: private */
        public int quadrant;
        /* access modifiers changed from: private */
        public long timestamp;
        /* access modifiers changed from: private */
        public int width;

        public Property() {
            this.quadrant = 0;
            this.formatType = -1;
            this.itemIdentity = -1;
            this.ext = new Ext.Creator().build();
        }

        public Property(Property property) {
            this.quadrant = 0;
            this.formatType = -1;
            this.itemIdentity = -1;
            this.width = property.getWidth();
            this.height = property.getHeight();
            this.formatType = property.getFormatType();
            this.quadrant = property.getQuadrant();
            this.itemIdentity = property.getItemIdentity();
            this.timestamp = property.getTimestamp();
            this.ext = property.getExt();
        }

        private Property(int i, int i2, int i3, int i4, int i5, long j, Ext ext2) {
            this.width = i;
            this.height = i2;
            this.quadrant = i3;
            this.formatType = i4;
            this.itemIdentity = i5;
            this.timestamp = j;
            this.ext = ext2;
        }

        public int getWidth() {
            return this.width;
        }

        public int getHeight() {
            return this.height;
        }

        public int getQuadrant() {
            return this.quadrant;
        }

        public int getFormatType() {
            return this.formatType;
        }

        public int getItemIdentity() {
            return this.itemIdentity;
        }

        public long getTimestamp() {
            return this.timestamp;
        }

        public Ext getExt() {
            return this.ext;
        }

        public void resetWidthAndHeight() {
            if (this.quadrant % 2 != 0) {
                int i = this.width;
                this.width = this.height;
                this.height = i;
            }
            this.quadrant = 0;
        }

        public static class Ext {
            private int lensId;
            private int maxZoom;
            private Rect rect;
            private int zoom;

            public int getLensId() {
                return this.lensId;
            }

            public int getMaxZoom() {
                return this.maxZoom;
            }

            public int getZoom() {
                return this.zoom;
            }

            public Rect getRect() {
                return this.rect;
            }

            private Ext(int i, int i2, int i3, Rect rect2) {
                this.lensId = i;
                this.zoom = i2;
                this.maxZoom = i3;
                this.rect = rect2;
            }

            public static class Creator {
                private int lensId = 0;
                private int maxZoom;
                private Rect rect;
                private int zoom = 0;

                public Creator setLensId(int i) {
                    this.lensId = i;
                    return this;
                }

                public Creator setMaxZoom(int i) {
                    this.maxZoom = i;
                    return this;
                }

                public Creator setZoom(int i) {
                    this.zoom = i;
                    return this;
                }

                public Creator setRect(Rect rect2) {
                    this.rect = rect2;
                    return this;
                }

                public Ext build() {
                    return new Ext(this.lensId, this.zoom, this.maxZoom, this.rect);
                }
            }
        }

        public static class Creator {
            private Ext ext;
            private int formatType;
            private int height;
            private int itemIdentity;
            private int quadrant;
            private long timestamp;
            private int width;

            public Creator setWidth(int i) {
                this.width = i;
                return this;
            }

            public Creator setHeight(int i) {
                this.height = i;
                return this;
            }

            public Creator setQuadrant(int i) {
                this.quadrant = i;
                return this;
            }

            public Creator setFormatType(int i) {
                this.formatType = i;
                return this;
            }

            public Creator setItemIdentity(int i) {
                this.itemIdentity = i;
                return this;
            }

            public Creator setTimestamp(int i) {
                this.timestamp = (long) i;
                return this;
            }

            public Creator setExt(Ext ext2) {
                this.ext = ext2;
                return this;
            }

            public Property create() {
                return new Property(this.width, this.height, this.quadrant, this.formatType, this.itemIdentity, this.timestamp, this.ext);
            }
        }
    }

    public static class Creator {
        private MLFrame frame = new MLFrame();

        public Creator setBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Bitmap unused = this.frame.bitmap = bitmap;
            Property acquireProperty = this.frame.acquireProperty();
            int unused2 = acquireProperty.width = width;
            int unused3 = acquireProperty.height = height;
            return this;
        }

        public Creator writeByteBufferData(ByteBuffer byteBuffer, int i, int i2, int i3) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Parameter： data is not specified");
            } else if (byteBuffer.capacity() < i * i2) {
                throw new IllegalArgumentException("Not enough capacity for image data size.");
            } else if (i3 == 17 || i3 == 16 || i3 == 842094169) {
                ByteBuffer unused = this.frame.byteBuffer = byteBuffer;
                Property acquireProperty = this.frame.acquireProperty();
                if (acquireProperty != null) {
                    int unused2 = acquireProperty.formatType = i3;
                    int unused3 = acquireProperty.width = i;
                    int unused4 = acquireProperty.height = i2;
                }
                return this;
            } else {
                throw new IllegalArgumentException("Parameter formatType:" + i3 + " is not supported");
            }
        }

        public Creator setItemIdentity(int i) {
            int unused = this.frame.acquireProperty().itemIdentity = i;
            return this;
        }

        public Creator setTimestamp(long j) {
            long unused = this.frame.acquireProperty().timestamp = j;
            return this;
        }

        public Creator setQuadrant(int i) {
            int unused = this.frame.acquireProperty().quadrant = i;
            return this;
        }

        public Creator setFramePropertyExt(Property.Ext ext) {
            Property.Ext unused = this.frame.acquireProperty().ext = ext;
            return this;
        }

        public MLFrame create() {
            if (this.frame.byteBuffer != null || this.frame.bitmap != null) {
                return this.frame;
            }
            throw new IllegalStateException("Failed to create image instance, both bitmap and byteBuffer data are not specified.");
        }
    }

    public static MLFrame fromByteBuffer(ByteBuffer byteBuffer2, Property property2) {
        return new MLFrame(byteBuffer2, property2);
    }

    public static MLFrame fromByteArray(byte[] bArr, Property property2) {
        return new MLFrame(bArr, property2);
    }

    public static MLFrame fromBitmap(Bitmap bitmap2) {
        return new MLFrame(bitmap2);
    }

    public static MLFrame fromMediaImage(Image image, int i) {
        MLFrame mLFrame;
        Image.Plane plane;
        int format = image.getFormat();
        if (format == 256 || format == 35) {
            if (format == 256) {
                Image.Plane[] planes = image.getPlanes();
                if (planes == null || planes.length != 1 || (plane = planes[0]) == null || plane.getBuffer() == null) {
                    mLFrame = null;
                } else {
                    ByteBuffer buffer = planes[0].getBuffer();
                    int remaining = buffer.remaining();
                    byte[] bArr = new byte[remaining];
                    buffer.get(bArr);
                    mLFrame = i != 0 ? new MLFrame(rotate(BitmapFactory.decodeByteArray(bArr, 0, remaining), i)) : new MLFrame(bArr);
                }
            } else {
                Property.Creator creator = new Property.Creator();
                creator.setFormatType(17).setWidth(image.getWidth()).setHeight(image.getHeight()).setQuadrant(i);
                mLFrame = new MLFrame(ImageConvertUtils.getDataFromImage(image, 2), creator.create());
            }
            if (mLFrame != null) {
                return mLFrame;
            }
            throw new IllegalStateException("Failed to create frame from media image.");
        }
        throw new IllegalArgumentException("Unsupported format: " + image.getFormat() + ", Only JPEG and YUV_420_888 are supported");
    }

    public static MLFrame fromFilePath(Context context, Uri uri) throws IOException {
        if (context == null) {
            throw new IllegalArgumentException("Parameter context is mandatory");
        } else if (uri != null) {
            Bitmap bitmap2 = MediaStore.Images.Media.getBitmap(context.getContentResolver(), uri);
            if (bitmap2 != null) {
                return new MLFrame(bitmap2);
            }
            throw new NullPointerException("Failed to load bitmap from uri");
        } else {
            throw new IllegalArgumentException("Parameter uri is mandatory");
        }
    }

    public final Pair<byte[], Float> create(int i, int i2) {
        byte[] bArr;
        if (getPreviewSize() == null) {
            return null;
        }
        int intValue = ((Integer) getPreviewSize().first).intValue();
        int intValue2 = ((Integer) getPreviewSize().second).intValue();
        float min = Math.min(((float) i) / ((float) intValue), ((float) i2) / ((float) intValue2));
        float f = 1.0f;
        if (min >= 1.0f) {
            bArr = wrapJpeg(true);
        } else {
            Matrix matrix = new Matrix();
            matrix.postScale(min, min);
            f = min;
            bArr = ImageConvertUtils.bitmap2Jpeg(Bitmap.createBitmap(wrapBitmap(), 0, 0, intValue, intValue2, matrix, true), 100);
        }
        return Pair.create(bArr, Float.valueOf(f));
    }

    private Pair<Integer, Integer> getPreviewSize() {
        Property property2 = this.property;
        if (property2 == null) {
            return null;
        }
        if (property2.getItemIdentity() == -1) {
            return Pair.create(Integer.valueOf(wrapBitmap().getWidth()), Integer.valueOf(wrapBitmap().getHeight()));
        }
        boolean z = true;
        if (!(this.property.getQuadrant() == 1 || this.property.getQuadrant() == 3)) {
            z = false;
        }
        Property property3 = this.property;
        return Pair.create(Integer.valueOf(z ? property3.getHeight() : property3.getWidth()), Integer.valueOf(z ? this.property.getWidth() : this.property.getHeight()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final byte[] wrapJpeg(boolean r3) {
        /*
            r2 = this;
            byte[] r0 = r2.bytes
            if (r0 == 0) goto L_0x0005
            return r0
        L_0x0005:
            java.nio.ByteBuffer r0 = r2.byteBuffer
            if (r0 == 0) goto L_0x0051
            com.huawei.hms.mlsdk.common.MLFrame$Property r0 = r2.property
            int r0 = r0.getFormatType()
            boolean r1 = r2.isSupportedYuvFormat(r0)
            if (r1 == 0) goto L_0x0049
            if (r3 == 0) goto L_0x001f
            com.huawei.hms.mlsdk.common.MLFrame$Property r3 = r2.property
            int r3 = r3.getQuadrant()
            if (r3 != 0) goto L_0x0051
        L_0x001f:
            java.nio.ByteBuffer r3 = r2.byteBuffer
            byte[] r3 = com.huawei.hms.ml.common.utils.ImageConvertUtils.buffer2Byte(r3)
            r1 = 842094169(0x32315659, float:1.0322389E-8)
            if (r1 != r0) goto L_0x002e
            byte[] r3 = com.huawei.hms.ml.common.utils.ImageConvertUtils.byteToNv21(r3)
        L_0x002e:
            com.huawei.hms.mlsdk.common.MLFrame$Property r0 = r2.property
            int r0 = r0.getWidth()
            com.huawei.hms.mlsdk.common.MLFrame$Property r1 = r2.property
            int r1 = r1.getHeight()
            byte[] r3 = com.huawei.hms.ml.common.utils.ImageConvertUtils.nv21ToJpeg(r3, r0, r1)
            com.huawei.hms.mlsdk.common.MLFrame$Property r0 = r2.property
            int r0 = r0.getQuadrant()
            if (r0 != 0) goto L_0x0052
            r2.bytes = r3
            goto L_0x0052
        L_0x0049:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            java.lang.String r0 = "Only support NV21 or YV12"
            r3.<init>(r0)
            throw r3
        L_0x0051:
            r3 = 0
        L_0x0052:
            if (r3 != 0) goto L_0x0060
            android.graphics.Bitmap r3 = r2.wrapBitmap()
            r0 = 100
            byte[] r3 = com.huawei.hms.ml.common.utils.ImageConvertUtils.bitmap2Jpeg(r3, r0)
            r2.bytes = r3
        L_0x0060:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.mlsdk.common.MLFrame.wrapJpeg(boolean):byte[]");
    }

    public static Bitmap rotate(Bitmap bitmap2, int i) {
        if (i < 0 || i > 3) {
            throw new IllegalArgumentException(new StringBuilder(29).append("Invalid quadrant: ").append(i).toString());
        } else if (i == 0) {
            return bitmap2;
        } else {
            Matrix matrix = new Matrix();
            matrix.postRotate((float) (i * 90));
            return Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), matrix, true);
        }
    }

    public final void initialize() {
        ByteBuffer byteBuffer2 = this.byteBuffer;
        if (byteBuffer2 != null) {
            ByteBuffer allocate = ByteBuffer.allocate(byteBuffer2.capacity());
            byteBuffer2.rewind();
            allocate.put(byteBuffer2);
            byteBuffer2.rewind();
            allocate.flip();
            this.byteBuffer = allocate;
        }
    }

    public final synchronized MLFrame getFrame(boolean z, boolean z2) {
        if (this.frameInit.booleanValue()) {
            return this;
        }
        if (!z) {
            if (this.byteBuffer != null) {
                int formatType = this.property.getFormatType();
                if (z2) {
                    if (formatType != 17) {
                        if (formatType == 842094169) {
                            this.byteBuffer = ByteBuffer.wrap(ImageConvertUtils.byteToNv21(ImageConvertUtils.buffer2Byte(this.byteBuffer)));
                        }
                        Property.Creator creator = new Property.Creator();
                        creator.setFormatType(17).setWidth(this.property.getWidth()).setHeight(this.property.getHeight()).setQuadrant(this.property.getQuadrant());
                        this.property = creator.create();
                        this.frameInit = true;
                        return this;
                    }
                }
                this.frameInit = true;
                return this;
            }
        }
        this.bitmap = getPreviewBitmap();
        this.property = new Creator().setBitmap(readBitmap()).create().property;
        this.frameInit = true;
        return this;
    }
}
