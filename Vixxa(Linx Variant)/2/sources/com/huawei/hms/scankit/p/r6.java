package com.huawei.hms.scankit.p;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.ml.scan.HmsScanResult;
import com.huawei.hms.scankit.p.w3;
import java.nio.ByteBuffer;

/* compiled from: RemoteDecoderWork */
public class r6 {
    private static volatile r6 a;

    public static r6 a() {
        if (a == null) {
            synchronized (r6.class) {
                if (a == null) {
                    a = new r6();
                }
            }
        }
        return a;
    }

    public HmsScan[] b(Bitmap bitmap, int i, boolean z, w3 w3Var) {
        w3.c cVar;
        if (w3Var != null) {
            w3Var.a("single");
            cVar = w3Var.a(z, bitmap.getHeight() * bitmap.getWidth());
            if (bitmap.getHeight() < 30 || bitmap.getWidth() < 30) {
                cVar.a(-1005);
            }
        } else {
            cVar = null;
        }
        s6[] b = m1.b(bitmap, new x6(i, z));
        o4.c("Scankit", "start totalParseResult");
        HmsScan[] a2 = y6.a(b);
        if (w3Var != null) {
            w3Var.a(a2, cVar);
        }
        return a2;
    }

    public HmsScanResult a(byte[] bArr, int i, int i2, int i3, boolean z, boolean z2, w3 w3Var) {
        w3.c cVar;
        int i4 = i;
        int i5 = i2;
        w3 w3Var2 = w3Var;
        if (w3Var2 != null) {
            w3Var2.a("single");
            boolean z3 = z;
            cVar = w3Var2.a(z, i5 * i4);
            if (i5 < 30 || i4 < 30) {
                cVar.a(-1005);
            }
        } else {
            boolean z4 = z;
            cVar = null;
        }
        w3.c cVar2 = cVar;
        o4.c("Scankit", "start decodeSingleCode");
        byte[] bArr2 = bArr;
        s6[] c = m1.c(bArr, new x6(i, i2, i3, true, z));
        o4.c("Scankit", "start totalParseResult");
        HmsScan[] a2 = y6.a(c);
        o4.c("Scankit", "end totalParseResult");
        if (w3Var2 != null) {
            w3Var2.a(a2, cVar2);
        }
        if (!z2) {
            o4.c("Scankit", "start hmsResultTrans");
            a2 = w7.a(a2);
            o4.c("Scankit", "end hmsResultTrans");
        }
        int i6 = i3 == 0 ? HmsScanBase.ALL_SCAN_TYPE : i3;
        if (r3.d) {
            return new HmsScanResult(4099, a2);
        }
        if (r3.e) {
            return new HmsScanResult(4100, a2);
        }
        if (r3.h && a2.length == 0) {
            int i7 = HmsScanBase.QRCODE_SCAN_TYPE;
            if ((i6 & i7) == i7) {
                return new HmsScanResult(4097, a2);
            }
        }
        if (a2.length == 0) {
            return new HmsScanResult(4096, a2);
        }
        if (a2.length > 0 && !TextUtils.isEmpty(a2[0].getOriginalValue())) {
            return new HmsScanResult(0, a2);
        }
        if (a2.length <= 0 || a2[0].getZoomValue() <= 1.0d) {
            return new HmsScanResult(4096, new HmsScan[0]);
        }
        return new HmsScanResult(4098, a2);
    }

    public HmsScan[] a(Bitmap bitmap, int i, boolean z, w3 w3Var) {
        w3.c cVar;
        o4.c("scankit mul", "start decodeWithBitmapWorkMulti");
        if (w3Var != null) {
            w3Var.a("multi");
            cVar = w3Var.a(z, bitmap.getHeight() * bitmap.getWidth());
            if (bitmap.getHeight() < 30 || bitmap.getWidth() < 30) {
                cVar.a(-1005);
            }
        } else {
            cVar = null;
        }
        o4.c("scankit mul", "end decodeWithBitmapWorkMulti");
        s6[] a2 = m1.a(bitmap, new x6(i, z));
        o4.c("scankit mul", "start totalParseResult");
        HmsScan[] a3 = y6.a(a2);
        o4.c("scankit mul", "end totalParseResult");
        if (w3Var != null) {
            w3Var.a(a3, cVar);
        }
        return a3;
    }

    public HmsScan[] a(ByteBuffer byteBuffer, int i, int i2, int i3, boolean z, w3 w3Var) {
        w3.c cVar;
        if (w3Var != null) {
            w3Var.a("multi");
            int i4 = i2 * i;
            cVar = w3Var.a(z, i4);
            if (i < 30 || i2 < 30) {
                cVar.a(-1007);
            } else if (byteBuffer.array().length < i4) {
                cVar.a(-1008);
            }
        } else {
            cVar = null;
        }
        HmsScan[] a2 = y6.a(m1.a(byteBuffer, new x6(i, i2, i3, true, z)));
        if (w3Var != null) {
            w3Var.a(a2, cVar);
        }
        return a2;
    }
}
