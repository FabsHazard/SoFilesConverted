package com.huawei.hms.scankit;

import android.os.RemoteException;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteDecoderDelegate;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.scankit.p.o4;

public class Creator extends IRemoteCreator.Stub {
    private static final String TAG = "Creator";
    private f iRemoteDecoderDelegate = null;
    private g iRemoteHmsDecoderDelegate = null;
    private e iRemoteViewDelegate = null;

    public IRemoteDecoderDelegate newRemoteDecoderDelegate() throws RemoteException {
        o4.c(TAG, "newRemoteDecoderDelegate()");
        f a = f.a();
        this.iRemoteDecoderDelegate = a;
        return a;
    }

    public IRemoteHmsDecoderDelegate newRemoteHmsDecoderDelegate() throws RemoteException {
        o4.c(TAG, "newRemoteHmsDecoderDelegate()");
        g a = g.a();
        this.iRemoteHmsDecoderDelegate = a;
        return a;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00ae  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.hmsscankit.api.IRemoteViewDelegate newRemoteViewDelegate(com.huawei.hms.feature.dynamic.IObjectWrapper r14, com.huawei.hms.feature.dynamic.IObjectWrapper r15) throws android.os.RemoteException {
        /*
            r13 = this;
            java.lang.String r0 = "Creator"
            r1 = 0
            if (r14 != 0) goto L_0x000d
            java.lang.String r14 = "ScankitRemoteS"
            java.lang.String r15 = "Context is null"
            com.huawei.hms.scankit.p.o4.b(r14, r15)
            return r1
        L_0x000d:
            java.lang.Object r14 = com.huawei.hms.feature.dynamic.ObjectWrapper.unwrap(r14)
            r2 = 1
            r3 = 0
            if (r15 == 0) goto L_0x0089
            java.lang.Object r4 = com.huawei.hms.feature.dynamic.ObjectWrapper.unwrap(r15)
            boolean r5 = r4 instanceof android.os.Bundle
            if (r5 == 0) goto L_0x0092
            android.os.Bundle r4 = (android.os.Bundle) r4
            java.lang.String r1 = "CustomedFlag"
            boolean r1 = r4.getBoolean(r1, r3)
            java.lang.String r5 = "FormatValue"
            int r5 = r4.getInt(r5, r3)
            java.lang.String r6 = "RectValue"
            android.os.Parcelable r6 = r4.getParcelable(r6)
            java.lang.Object r7 = com.huawei.hms.feature.dynamic.ObjectWrapper.unwrap(r15)
            android.os.Bundle r7 = (android.os.Bundle) r7
            java.lang.String r8 = "TransType"
            int r7 = r7.getInt(r8, r3)
            com.huawei.hms.hmsscankit.DetailRect.HMSSCAN_SDK_VALUE = r7
            r8 = 2
            if (r7 < r8) goto L_0x0044
            r7 = r2
            goto L_0x0045
        L_0x0044:
            r7 = r3
        L_0x0045:
            if (r7 == 0) goto L_0x004b
            int r5 = com.huawei.hms.scankit.p.w7.b((int) r5)
        L_0x004b:
            java.lang.String r8 = "return_bitmap"
            boolean r8 = r4.getBoolean(r8, r3)
            java.lang.String r9 = "localui"
            boolean r9 = r4.getBoolean(r9, r3)
            java.lang.String r10 = "ScanViewTypeFlag"
            int r3 = r4.getInt(r10, r3)
            if (r9 == 0) goto L_0x0081
            boolean r4 = r14 instanceof android.content.Context
            if (r4 == 0) goto L_0x0081
            r4 = r14
            android.content.Context r4 = (android.content.Context) r4     // Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x0076, InvocationTargetException -> 0x0070, IllegalAccessException -> 0x006a }
            com.huawei.hms.hmsscankit.f.b(r4)     // Catch:{ ClassNotFoundException -> 0x007c, NoSuchMethodException -> 0x0076, InvocationTargetException -> 0x0070, IllegalAccessException -> 0x006a }
            goto L_0x0081
        L_0x006a:
            java.lang.String r4 = "IllegalAccessException"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r0, (java.lang.String) r4)
            goto L_0x0081
        L_0x0070:
            java.lang.String r4 = "InvocationTargetException"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r0, (java.lang.String) r4)
            goto L_0x0081
        L_0x0076:
            java.lang.String r4 = "NoSuchMethodException"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r0, (java.lang.String) r4)
            goto L_0x0081
        L_0x007c:
            java.lang.String r4 = "ClassNotFoundException"
            com.huawei.hms.scankit.p.o4.a((java.lang.String) r0, (java.lang.String) r4)
        L_0x0081:
            r0 = r7
            r10 = r8
            r7 = r6
            r6 = r5
            r12 = r3
            r3 = r1
            r1 = r12
            goto L_0x0098
        L_0x0089:
            android.os.Bundle r15 = new android.os.Bundle
            r15.<init>()
            com.huawei.hms.feature.dynamic.IObjectWrapper r15 = com.huawei.hms.feature.dynamic.ObjectWrapper.wrap(r15)
        L_0x0092:
            r7 = r1
            r0 = r3
            r1 = r0
            r6 = r1
            r9 = r6
            r10 = r9
        L_0x0098:
            if (r3 == 0) goto L_0x00ae
            boolean r1 = r14 instanceof android.content.Context
            if (r1 == 0) goto L_0x00d2
            com.huawei.hms.scankit.e r1 = new com.huawei.hms.scankit.e
            r5 = r14
            android.content.Context r5 = (android.content.Context) r5
            r11 = r9 ^ 1
            r4 = r1
            r8 = r15
            r9 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11)
            r13.iRemoteViewDelegate = r1
            goto L_0x00d2
        L_0x00ae:
            boolean r2 = r14 instanceof android.content.Context
            if (r2 == 0) goto L_0x00d2
            if (r9 == 0) goto L_0x00c4
            com.huawei.hms.scankit.h r2 = new com.huawei.hms.scankit.h
            r5 = r14
            android.content.Context r5 = (android.content.Context) r5
            r9 = 0
            r4 = r2
            r7 = r15
            r8 = r0
            r10 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            r13.iRemoteViewDelegate = r2
            goto L_0x00d2
        L_0x00c4:
            com.huawei.hms.scankit.i r1 = new com.huawei.hms.scankit.i
            r5 = r14
            android.content.Context r5 = (android.content.Context) r5
            r9 = 1
            r4 = r1
            r7 = r15
            r8 = r0
            r4.<init>(r5, r6, r7, r8, r9)
            r13.iRemoteViewDelegate = r1
        L_0x00d2:
            com.huawei.hms.scankit.e r14 = r13.iRemoteViewDelegate
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.Creator.newRemoteViewDelegate(com.huawei.hms.feature.dynamic.IObjectWrapper, com.huawei.hms.feature.dynamic.IObjectWrapper):com.huawei.hms.hmsscankit.api.IRemoteViewDelegate");
    }
}
