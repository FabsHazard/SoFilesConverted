package com.huawei.hms.scankit.p;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.IObjectWrapper;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;

/* compiled from: IRemoteFrameDecoderDelegateImpl */
public class h4 extends IRemoteFrameDecoderDelegate.Stub {
    private static volatile h4 d = new h4();
    Point a;
    int b = 0;
    Rect c;

    private h4() {
    }

    public static h4 a() {
        return d;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0056, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Rect b(int r5, int r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            android.graphics.Rect r0 = r4.a(r5, r6)     // Catch:{ all -> 0x0057 }
            android.graphics.Rect r1 = new android.graphics.Rect     // Catch:{ all -> 0x0057 }
            r1.<init>(r0)     // Catch:{ all -> 0x0057 }
            android.graphics.Point r0 = new android.graphics.Point     // Catch:{ all -> 0x0057 }
            r0.<init>(r5, r6)     // Catch:{ all -> 0x0057 }
            android.graphics.Point r5 = r4.a     // Catch:{ all -> 0x0057 }
            if (r5 != 0) goto L_0x0016
            monitor-exit(r4)
            r5 = 0
            return r5
        L_0x0016:
            int r6 = r5.x     // Catch:{ all -> 0x0057 }
            int r5 = r5.y     // Catch:{ all -> 0x0057 }
            if (r6 >= r5) goto L_0x0039
            int r2 = r1.left     // Catch:{ all -> 0x0057 }
            int r3 = r0.y     // Catch:{ all -> 0x0057 }
            int r2 = r2 * r3
            int r2 = r2 / r6
            r1.left = r2     // Catch:{ all -> 0x0057 }
            int r2 = r1.right     // Catch:{ all -> 0x0057 }
            int r2 = r2 * r3
            int r2 = r2 / r6
            r1.right = r2     // Catch:{ all -> 0x0057 }
            int r6 = r1.top     // Catch:{ all -> 0x0057 }
            int r0 = r0.x     // Catch:{ all -> 0x0057 }
            int r6 = r6 * r0
            int r6 = r6 / r5
            r1.top = r6     // Catch:{ all -> 0x0057 }
            int r6 = r1.bottom     // Catch:{ all -> 0x0057 }
            int r6 = r6 * r0
            int r6 = r6 / r5
            r1.bottom = r6     // Catch:{ all -> 0x0057 }
            goto L_0x0055
        L_0x0039:
            int r2 = r1.top     // Catch:{ all -> 0x0057 }
            int r3 = r0.y     // Catch:{ all -> 0x0057 }
            int r2 = r2 * r3
            int r2 = r2 / r5
            r1.top = r2     // Catch:{ all -> 0x0057 }
            int r2 = r1.bottom     // Catch:{ all -> 0x0057 }
            int r2 = r2 * r3
            int r2 = r2 / r5
            r1.bottom = r2     // Catch:{ all -> 0x0057 }
            int r5 = r1.left     // Catch:{ all -> 0x0057 }
            int r0 = r0.x     // Catch:{ all -> 0x0057 }
            int r5 = r5 * r0
            int r5 = r5 / r6
            r1.left = r5     // Catch:{ all -> 0x0057 }
            int r5 = r1.right     // Catch:{ all -> 0x0057 }
            int r5 = r5 * r0
            int r5 = r5 / r6
            r1.right = r5     // Catch:{ all -> 0x0057 }
        L_0x0055:
            monitor-exit(r4)
            return r1
        L_0x0057:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0057 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.h4.b(int, int):android.graphics.Rect");
    }

    public s6[] decode(byte[] bArr, int i, int i2, int i3, int i4, IObjectWrapper iObjectWrapper) throws RemoteException {
        if (iObjectWrapper != null && (ObjectWrapper.unwrap(iObjectWrapper) instanceof Bundle)) {
            Bundle bundle = (Bundle) ObjectWrapper.unwrap(iObjectWrapper);
            this.a = (Point) bundle.getParcelable("Screen");
            this.c = (Rect) bundle.getParcelable("Rect");
        }
        if (this.c == null) {
            this.c = new Rect(-1, -1, -1, -1);
        }
        if (this.a == null) {
            this.a = new Point(1080, 1920);
        }
        e6 a2 = a(bArr, i, i2, i3);
        byte[] b2 = a2.b();
        x6 x6Var = new x6(a2.c(), a2.a(), i4);
        int i5 = this.b;
        this.b = i5 + 1;
        return m1.c(b2, x6Var.a(i5));
    }

    private e6 a(byte[] bArr, int i, int i2, int i3) {
        if (i3 == 0) {
            byte[] bArr2 = new byte[bArr.length];
            for (int i4 = 0; i4 < i2; i4++) {
                for (int i5 = 0; i5 < i; i5++) {
                    bArr2[(((i5 * i2) + i2) - i4) - 1] = bArr[(i4 * i) + i5];
                }
            }
            return a(bArr2, i2, i);
        } else if (i3 == 2) {
            byte[] bArr3 = new byte[bArr.length];
            for (int i6 = 0; i6 < i2; i6++) {
                for (int i7 = 0; i7 < i; i7++) {
                    bArr3[(((i - 1) - i7) * i2) + i6] = bArr[(i6 * i) + i7];
                }
            }
            return a(bArr3, i2, i);
        } else if (i3 != 3) {
            return a(bArr, i, i2);
        } else {
            byte[] bArr4 = new byte[bArr.length];
            for (int i8 = 0; i8 < i2; i8++) {
                for (int i9 = 0; i9 < i; i9++) {
                    bArr4[(((((i2 - 1) - i8) * i) + i) - 1) - i9] = bArr[(i8 * i) + i9];
                }
            }
            return a(bArr4, i, i2);
        }
    }

    public synchronized Rect a(int i, int i2) {
        int min;
        int i3;
        int i4;
        min = Math.min(i, i2);
        i3 = (i - min) / 2;
        i4 = (i2 - min) / 2;
        return new Rect(i3, i4, i3 + min, min + i4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00de  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ea  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.scankit.p.e6 a(byte[] r14, int r15, int r16) {
        /*
            r13 = this;
            r0 = r13
            r3 = r15
            r4 = r16
            android.graphics.Rect r1 = r13.b(r15, r4)
            if (r1 != 0) goto L_0x000c
            r1 = 0
            return r1
        L_0x000c:
            int r1 = java.lang.Math.min(r15, r16)
            double r1 = (double) r1
            r5 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            double r1 = r1 * r5
            int r1 = (int) r1
            int r2 = r3 - r1
            int r2 = r2 / 2
            int r7 = r4 - r1
            int r7 = r7 / 2
            android.graphics.Rect r8 = r0.c
            r9 = 0
            if (r8 == 0) goto L_0x00b0
            int r1 = r8.left
            r2 = -1
            if (r1 != r2) goto L_0x0051
            int r1 = r8.right
            if (r1 != r2) goto L_0x0051
            int r1 = r8.top
            if (r1 != r2) goto L_0x0051
            int r1 = r8.bottom
            if (r1 != r2) goto L_0x0051
            double r1 = (double) r3
            r7 = 4605831338911806259(0x3feb333333333333, double:0.85)
            double r1 = r1 * r7
            int r1 = (int) r1
            int r2 = r3 - r1
            int r2 = r2 / 2
            double r7 = (double) r4
            double r5 = r5 * r7
            int r5 = (int) r5
            r10 = 4591870180066957722(0x3fb999999999999a, double:0.1)
            double r7 = r7 * r10
            int r7 = (int) r7
        L_0x004c:
            r12 = r2
            r2 = r1
            r1 = r5
            r5 = r12
            goto L_0x00b2
        L_0x0051:
            int r1 = java.lang.Math.min(r15, r16)
            double r1 = (double) r1
            r5 = 4606281698874543309(0x3feccccccccccccd, double:0.9)
            double r1 = r1 * r5
            int r1 = (int) r1
            int r2 = r3 - r1
            int r2 = r2 / 2
            android.graphics.Rect r5 = new android.graphics.Rect
            android.graphics.Rect r6 = r0.c
            int r7 = r6.left
            int r8 = r6.top
            int r10 = r6.right
            int r6 = r6.bottom
            r5.<init>(r7, r8, r10, r6)
            int r6 = java.lang.Math.max(r15, r16)
            android.graphics.Point r7 = r0.a
            if (r7 == 0) goto L_0x007d
            int r8 = r7.x
            int r7 = r7.y
            goto L_0x007f
        L_0x007d:
            r7 = r6
            r8 = r7
        L_0x007f:
            int r7 = java.lang.Math.max(r8, r7)
            float r6 = (float) r6
            float r7 = (float) r7
            float r6 = r6 / r7
            android.graphics.Rect r7 = r0.c
            int r8 = r7.top
            float r8 = (float) r8
            float r8 = r8 * r6
            int r8 = (int) r8
            r5.top = r8
            int r7 = r7.bottom
            float r7 = (float) r7
            float r7 = r7 * r6
            int r6 = (int) r7
            r5.bottom = r6
            float r5 = (float) r8
            float r7 = (float) r4
            r10 = 1096810496(0x41600000, float:14.0)
            float r7 = r7 / r10
            int r5 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r5 <= 0) goto L_0x00a1
            int r5 = (int) r7
            int r8 = r8 - r5
        L_0x00a1:
            if (r8 >= 0) goto L_0x00a5
            r7 = r9
            goto L_0x00a6
        L_0x00a5:
            r7 = r8
        L_0x00a6:
            int r5 = r6 - r7
            int r6 = r7 + r5
            if (r6 <= r4) goto L_0x004c
            int r5 = r4 - r1
            int r7 = r5 / 2
        L_0x00b0:
            r5 = r2
            r2 = r1
        L_0x00b2:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r8 = "top:"
            r6.<init>(r8)
            java.lang.StringBuilder r6 = r6.append(r7)
            java.lang.String r8 = "scanSizeHeight"
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.StringBuilder r6 = r6.append(r1)
            java.lang.String r8 = "mHeight:"
            java.lang.StringBuilder r6 = r6.append(r8)
            java.lang.StringBuilder r6 = r6.append(r4)
            java.lang.String r6 = r6.toString()
            java.lang.String r8 = "ScanSize"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r8, (java.lang.String) r6)
            int r6 = r7 + r1
            if (r4 >= r6) goto L_0x00e1
            r8 = r4
            r6 = r9
            goto L_0x00e3
        L_0x00e1:
            r8 = r1
            r6 = r7
        L_0x00e3:
            int r1 = r5 + r2
            if (r3 >= r1) goto L_0x00ea
            r7 = r3
            r5 = r9
            goto L_0x00eb
        L_0x00ea:
            r7 = r2
        L_0x00eb:
            com.huawei.hms.scankit.p.e6 r10 = new com.huawei.hms.scankit.p.e6
            r9 = 0
            r1 = r10
            r2 = r14
            r3 = r15
            r4 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.p.h4.a(byte[], int, int):com.huawei.hms.scankit.p.e6");
    }
}
