package com.huawei.hms.scankit;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.DetailRect;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.r3;
import com.huawei.hms.scankit.p.r6;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.w7;
import com.huawei.hms.scankit.p.y3;
import java.nio.ByteBuffer;

/* compiled from: IRemoteHmsDecoderDelegateImpl */
public class g extends IRemoteHmsDecoderDelegate.Stub {
    private static volatile g b = new g();
    private volatile w3 a = null;

    static g a() {
        return b;
    }

    public HmsScan[] decodeInBitmap(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        o4.c("scankit mul", "start decodeInBitmap");
        Bundle a2 = a(iObjectWrapper2);
        String str = "";
        if (iObjectWrapper2 != null && (ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            str = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getString(DetailRect.CP_PACKAGE, str);
        }
        if (this.a == null && y3.a(str, y3.a())) {
            try {
                this.a = new w3(a2, "MultiProcessor");
            } catch (RuntimeException unused) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        o4.c("scankit mul", "end decodeInBitmap");
        return a(iObjectWrapper, iObjectWrapper2);
    }

    public HmsScan[] detectWithByteBuffer(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) throws RemoteException {
        Bundle a2 = a(iObjectWrapper2);
        String str = "";
        if (iObjectWrapper2 != null && (ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            str = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getString(DetailRect.CP_PACKAGE, str);
        }
        if (this.a == null && y3.a(str, y3.a())) {
            try {
                this.a = new w3(a2, "MultiProcessor");
            } catch (RuntimeException unused) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            } catch (Exception unused2) {
                o4.b("IRemoteDecoderDelegateImpl", "Ha error");
            }
        }
        return a(detailRect, iObjectWrapper, iObjectWrapper2);
    }

    private Bundle a(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null || !(ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            return new Bundle();
        }
        return (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
    }

    private HmsScan[] a(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        o4.c("scankit mul", "start getHmsMLVisionScanResultByBitmap");
        if (iObjectWrapper == null) {
            o4.b("ScankitRemoteS", "bitmap is null");
            return new HmsScan[0];
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        boolean z4 = true;
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z = false;
            z3 = false;
            i = 0;
            z2 = false;
        } else {
            z3 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PHOTO_MODE, false);
            r3.c = z3;
            i = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            boolean z5 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PARSE_RESULT, true);
            z2 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PARSE_RESULT, false);
            int i2 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i2;
            if (i2 < 2) {
                z4 = false;
            }
            if (z4) {
                i = w7.b(i);
            }
            z = z4;
            z4 = z5;
        }
        r3.f = z4;
        r3.g = z2;
        if (!(unwrap instanceof Bitmap)) {
            return new HmsScan[0];
        }
        o4.c("scankit mul", "end getHmsMLVisionScanResultByBitmap");
        HmsScan[] a2 = r6.a().a((Bitmap) unwrap, i, z3, this.a);
        return !z ? w7.a(a2) : a2;
    }

    private HmsScan[] a(DetailRect detailRect, IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        boolean z;
        boolean z2;
        int i;
        boolean z3;
        if (iObjectWrapper == null) {
            o4.b("ScankitRemoteS", "bytebuffer is null");
            return new HmsScan[0];
        }
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        boolean z4 = true;
        if (iObjectWrapper2 == null || !(ObjectWrapper.unwrap(iObjectWrapper2) instanceof Bundle)) {
            z = false;
            z3 = false;
            i = 0;
            z2 = false;
        } else {
            int i2 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.FORMAT_FLAG);
            boolean z5 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PHOTO_MODE, false);
            int i3 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getInt(DetailRect.TYPE_TRANS, 0);
            DetailRect.HMSSCAN_SDK_VALUE = i3;
            boolean z6 = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.PARSE_RESULT, true);
            z = ((Bundle) ObjectWrapper.unwrap(iObjectWrapper2)).getBoolean(DetailRect.NEW_VERSION, false);
            if (i3 < 2) {
                z4 = false;
            }
            if (z4) {
                i2 = w7.b(i2);
            }
            i = i2;
            z2 = z5;
            z3 = z4;
            z4 = z6;
        }
        r3.f = z4;
        r3.g = z;
        if (!(unwrap instanceof ByteBuffer)) {
            return new HmsScan[0];
        }
        HmsScan[] a2 = r6.a().a((ByteBuffer) unwrap, detailRect == null ? 1000 : detailRect.width, detailRect == null ? 1000 : detailRect.height, i, z2, this.a);
        return !z3 ? w7.a(a2) : a2;
    }
}
