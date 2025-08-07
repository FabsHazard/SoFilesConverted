package com.huawei.hms.scankit;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.bumptech.glide.Registry;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.WriterException;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.ml.scan.HmsBuildBitmapOption;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanResult;
import com.huawei.hms.scankit.p.c5;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.r3;
import com.huawei.hms.scankit.p.r6;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.w7;
import com.huawei.hms.scankit.p.x3;
import com.huawei.hms.scankit.p.y3;

/* compiled from: IRemoteDecoderDelegateImpl */
public class f extends IRemoteDecoderDelegate.Stub {
    private static volatile f c = new f();
    private volatile w3 a = null;
    private volatile x3 b = null;

    static f a() {
        return c;
    }

    public IObjectWrapper buildBitmap(IObjectWrapper iObjectWrapper) throws RemoteException {
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            throw new RemoteException("Bundle is Null");
        }
        Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
        String string = bundle.getString(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_CONTENT);
        int i = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_FOTMAT);
        int i2 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_WIDTH);
        int i3 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_HEIGHT);
        int i4 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_MARGIN, 1);
        int i5 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_COLOR, -1);
        int i6 = bundle.getInt(HmsBuildBitmapOption.TYPE_BUILD_BITMAP_BACKCOLOR, -1);
        try {
            Bitmap a2 = new c5().a(string, i, i2, i3, new HmsBuildBitmapOption.Creator().setBitmapMargin(i4).setBitmapColor(i5).setBitmapBackgroundColor(i6).create());
            if (a2 != null) {
                return ObjectWrapper.wrap(a2);
            }
            throw new RemoteException("Bitmap is Null");
        } catch (WriterException e) {
            throw new RemoteException(e.getMessage());
        }
    }

    public void buildBitmapLog(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null && (ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
            if (this.b == null) {
                try {
                    this.b = new x3();
                    this.b.c(bundle);
                } catch (RuntimeException unused) {
                    o4.b("IRemoteDecoderDelegateImpl", "buildBitmapLog RuntimeException");
                } catch (Exception unused2) {
                    o4.b("IRemoteDecoderDelegateImpl", "buildBitmapLog Exception");
                }
            }
        }
    }

    public HmsScan[] decodeWithBitmap(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle bundle;
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            bundle = new Bundle();
        } else {
            bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper2);
        }
        String str = "";
        if (iObjectWrapper2 != null && (ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            str = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getString(DetailRect.CP_PACKAGE, str);
        }
        if (this.a == null && y3.a(str, y3.a())) {
            try {
                this.a = new w3(bundle, Registry.BUCKET_BITMAP);
            } catch (RuntimeException unused) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        return a(iObjectWrapper, iObjectWrapper2);
    }

    public HmsScanResult decodeWithBuffer(byte[] bArr, int i, int i2, IObjectWrapper iObjectWrapper) throws RemoteException {
        boolean z;
        boolean z2;
        int i3;
        Bundle bundle;
        boolean z3 = false;
        if (bArr == null) {
            o4.b("IRemoteDecoder", "buffer is null");
            return new HmsScanResult(4096, new HmsScan[0]);
        }
        boolean z4 = true;
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            i3 = 0;
            z = false;
            z2 = true;
        } else {
            int i4 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getInt(DetailRect.FORMAT_FLAG);
            boolean z5 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getBoolean(DetailRect.PHOTO_MODE, false);
            r3.c = z5;
            int i5 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getInt(DetailRect.TYPE_TRANS, 0);
            boolean z6 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getBoolean(DetailRect.PARSE_RESULT, true);
            DetailRect.HMSSCAN_SDK_VALUE = i5;
            if (i5 >= 2) {
                z3 = true;
            }
            if (z3) {
                z = z3;
                z2 = z5;
                boolean z7 = z6;
                i3 = w7.b(i4);
                z4 = z7;
            } else {
                z = z3;
                z2 = z5;
                z4 = z6;
                i3 = i4;
            }
        }
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            bundle = new Bundle();
        } else {
            bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
        }
        String str = "";
        if (iObjectWrapper != null && (ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            str = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper)).getString(DetailRect.CP_PACKAGE, str);
        }
        if (this.a == null && y3.a(str, y3.a())) {
            try {
                this.a = new w3(bundle, Registry.BUCKET_BITMAP);
            } catch (RuntimeException unused) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        r3.f = z4;
        return r6.a().a(bArr, i, i2, i3, z2, z, this.a);
    }

    public IObjectWrapper queryDeepLinkInfo(IObjectWrapper iObjectWrapper) throws RemoteException {
        return null;
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z;
        boolean z2;
        int i;
        if (iObjectWrapper == null) {
            o4.b("IRemoteDecoder", "bitmap is null");
            return new HmsScan[0];
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        boolean z3 = true;
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z = false;
            i = 0;
            z2 = true;
        } else {
            i = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            z2 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PHOTO_MODE, false);
            int i2 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            boolean z4 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PARSE_RESULT, true);
            DetailRect.HMSSCAN_SDK_VALUE = i2;
            if (i2 < 2) {
                z3 = false;
            }
            if (z3) {
                i = w7.b(i);
            }
            boolean z5 = z3;
            z3 = z4;
            z = z5;
        }
        r3.f = z3;
        if (!(unwrap instanceof Bitmap)) {
            return new HmsScan[0];
        }
        HmsScan[] b2 = r6.a().b((Bitmap) unwrap, i, z2, this.a);
        return !z ? w7.a(b2) : b2;
    }
}
