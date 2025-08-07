package com.huawei.hms.framework.network.grs.g;

import android.content.Context;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.e.c;
import java.util.concurrent.Callable;

public class f extends a implements Callable<d> {
    private static final String i = "f";

    public f(String str, int i2, c cVar, Context context, String str2, GrsBaseInfo grsBaseInfo, c cVar2) {
        super(str, i2, cVar, context, str2, grsBaseInfo, cVar2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v6, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v0, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v1, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: byte[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v8, resolved type: javax.net.ssl.HttpsURLConnection} */
    /* JADX WARNING: type inference failed for: r0v25, types: [byte[]] */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00aa, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00ab, code lost:
        com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ae, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d6, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00d8, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00d9, code lost:
        r10 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00da, code lost:
        r20 = r5;
        r5 = r8;
        r7 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e0, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:?, code lost:
        r10.disconnect();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0102, code lost:
        r5 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0109, code lost:
        r5 = r7;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:7:0x002e, B:34:0x009d] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e0 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:1:0x0012] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00fe A[SYNTHETIC, Splitter:B:59:0x00fe] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0145 A[SYNTHETIC, Splitter:B:78:0x0145] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.huawei.hms.framework.network.grs.g.d call() {
        /*
            r22 = this;
            r1 = r22
            java.lang.String r2 = "RequestCallableV2 disconnect HttpsURLConnection catch Throwable"
            java.lang.String r3 = "RequestCallableV2 disconnect HttpsURLConnection catch RuntimeException"
            java.lang.String r0 = "httpsURLConnection result code:"
            java.lang.String r4 = i
            java.lang.String r5 = "Post call execute"
            com.huawei.hms.framework.common.Logger.i(r4, r5)
            r5 = 0
            r7 = 0
            long r8 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x00e2, all -> 0x00e0 }
            long r5 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00d8, all -> 0x00e0 }
            java.lang.String r10 = r22.c()     // Catch:{ IOException -> 0x00d8, all -> 0x00e0 }
            android.content.Context r11 = r22.a()     // Catch:{ IOException -> 0x00d8, all -> 0x00e0 }
            java.lang.String r12 = r22.e()     // Catch:{ IOException -> 0x00d8, all -> 0x00e0 }
            javax.net.ssl.HttpsURLConnection r10 = com.huawei.hms.framework.network.grs.h.f.a.a(r10, r11, r12)     // Catch:{ IOException -> 0x00d8, all -> 0x00e0 }
            if (r10 != 0) goto L_0x0043
            java.lang.String r0 = "create HttpsURLConnection instance by url return null."
            com.huawei.hms.framework.common.Logger.w(r4, r0)     // Catch:{ IOException -> 0x00d6 }
            if (r10 == 0) goto L_0x0042
            r10.disconnect()     // Catch:{ RuntimeException -> 0x003d, all -> 0x0037 }
            goto L_0x0042
        L_0x0037:
            java.lang.String r0 = i
            com.huawei.hms.framework.common.Logger.w(r0, r2)
            goto L_0x0042
        L_0x003d:
            java.lang.String r0 = i
            com.huawei.hms.framework.common.Logger.w(r0, r3)
        L_0x0042:
            return r7
        L_0x0043:
            java.lang.String r11 = "Content-Type"
            java.lang.String r12 = "application/json; charset=UTF-8"
            r10.setRequestProperty(r11, r12)     // Catch:{ IOException -> 0x00d6 }
            java.lang.String r11 = "POST"
            r10.setRequestMethod(r11)     // Catch:{ IOException -> 0x00d6 }
            r11 = 1
            r10.setDoOutput(r11)     // Catch:{ IOException -> 0x00d6 }
            r10.setDoInput(r11)     // Catch:{ IOException -> 0x00d6 }
            com.huawei.hms.framework.network.grs.g.c r11 = r22.b()     // Catch:{ IOException -> 0x00d6 }
            java.lang.String r12 = ""
            if (r11 == 0) goto L_0x0067
            com.huawei.hms.framework.network.grs.g.c r11 = r22.b()     // Catch:{ IOException -> 0x00d6 }
            java.lang.String r11 = r11.a()     // Catch:{ IOException -> 0x00d6 }
            goto L_0x0068
        L_0x0067:
            r11 = r12
        L_0x0068:
            java.lang.String r13 = "If-None-Match"
            boolean r14 = android.text.TextUtils.isEmpty(r11)     // Catch:{ IOException -> 0x00d6 }
            if (r14 == 0) goto L_0x0072
            java.lang.String r11 = "&"
        L_0x0072:
            r10.setRequestProperty(r13, r11)     // Catch:{ IOException -> 0x00d6 }
            r10.connect()     // Catch:{ IOException -> 0x00d6 }
            com.huawei.hms.framework.network.grs.e.c r11 = r22.f()     // Catch:{ IOException -> 0x00d6 }
            java.lang.String r13 = "services"
            java.lang.String r11 = r11.a(r13, r12)     // Catch:{ IOException -> 0x00d6 }
            com.huawei.hms.framework.network.grs.h.f.a.a(r10, r11)     // Catch:{ IOException -> 0x00d6 }
            int r13 = r10.getResponseCode()     // Catch:{ IOException -> 0x00d6 }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d6 }
            r11.<init>(r0)     // Catch:{ IOException -> 0x00d6 }
            java.lang.StringBuilder r0 = r11.append(r13)     // Catch:{ IOException -> 0x00d6 }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x00d6 }
            com.huawei.hms.framework.common.Logger.i(r4, r0)     // Catch:{ IOException -> 0x00d6 }
            r0 = 200(0xc8, float:2.8E-43)
            if (r13 != r0) goto L_0x00af
            java.io.InputStream r7 = r10.getInputStream()     // Catch:{ all -> 0x00aa }
            byte[] r0 = com.huawei.hms.framework.common.IoUtils.toByteArray(r7)     // Catch:{ all -> 0x00aa }
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r7)     // Catch:{ IOException -> 0x00d6 }
            r7 = r0
            goto L_0x00af
        L_0x00aa:
            r0 = move-exception
            com.huawei.hms.framework.common.IoUtils.closeSecure((java.io.InputStream) r7)     // Catch:{ IOException -> 0x00d6 }
            throw r0     // Catch:{ IOException -> 0x00d6 }
        L_0x00af:
            java.util.Map r14 = r10.getHeaderFields()     // Catch:{ IOException -> 0x00d6 }
            r10.disconnect()     // Catch:{ IOException -> 0x00d6 }
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IOException -> 0x00d6 }
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x00d6 }
            if (r7 != 0) goto L_0x00c5
            r0 = 0
            byte[] r0 = new byte[r0]     // Catch:{ IOException -> 0x00d6 }
            r15 = r0
            goto L_0x00c6
        L_0x00c5:
            r15 = r7
        L_0x00c6:
            com.huawei.hms.framework.network.grs.g.d r0 = new com.huawei.hms.framework.network.grs.g.d     // Catch:{ IOException -> 0x00d6 }
            long r16 = r11 - r8
            r12 = r0
            r12.<init>(r13, r14, r15, r16)     // Catch:{ IOException -> 0x00d6 }
            r1.a = r0     // Catch:{ IOException -> 0x00d6 }
            if (r10 == 0) goto L_0x0111
            r10.disconnect()     // Catch:{ RuntimeException -> 0x010a, all -> 0x0103 }
            goto L_0x0111
        L_0x00d6:
            r0 = move-exception
            goto L_0x00da
        L_0x00d8:
            r0 = move-exception
            r10 = r7
        L_0x00da:
            r20 = r5
            r5 = r8
            r7 = r20
            goto L_0x00e5
        L_0x00e0:
            r0 = move-exception
            goto L_0x0143
        L_0x00e2:
            r0 = move-exception
            r10 = r7
            r7 = r5
        L_0x00e5:
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0141 }
            long r18 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0141 }
            java.lang.String r4 = i     // Catch:{ all -> 0x0141 }
            java.lang.String r9 = "RequestCallableV2 run task catch IOException"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r4, (java.lang.String) r9, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0141 }
            com.huawei.hms.framework.network.grs.g.d r4 = new com.huawei.hms.framework.network.grs.g.d     // Catch:{ all -> 0x0141 }
            long r11 = r11 - r5
            r4.<init>(r0, r11)     // Catch:{ all -> 0x0141 }
            r1.a = r4     // Catch:{ all -> 0x0141 }
            if (r10 == 0) goto L_0x0110
            r10.disconnect()     // Catch:{ RuntimeException -> 0x0109, all -> 0x0102 }
            goto L_0x0110
        L_0x0102:
            r5 = r7
        L_0x0103:
            java.lang.String r0 = i
            com.huawei.hms.framework.common.Logger.w(r0, r2)
            goto L_0x0111
        L_0x0109:
            r5 = r7
        L_0x010a:
            java.lang.String r0 = i
            com.huawei.hms.framework.common.Logger.w(r0, r3)
            goto L_0x0111
        L_0x0110:
            r5 = r7
        L_0x0111:
            r2 = r18
            com.huawei.hms.framework.network.grs.g.d r0 = r1.a
            java.lang.String r4 = r22.c()
            r0.b((java.lang.String) r4)
            com.huawei.hms.framework.network.grs.g.d r0 = r1.a
            int r4 = r22.d()
            r0.a((int) r4)
            com.huawei.hms.framework.network.grs.g.d r0 = r1.a
            r0.b((long) r5)
            com.huawei.hms.framework.network.grs.g.d r0 = r1.a
            r0.a((long) r2)
            com.huawei.hms.framework.network.grs.g.c r0 = r22.b()
            if (r0 == 0) goto L_0x013e
            com.huawei.hms.framework.network.grs.g.c r0 = r22.b()
            com.huawei.hms.framework.network.grs.g.d r2 = r1.a
            r0.a((com.huawei.hms.framework.network.grs.g.d) r2)
        L_0x013e:
            com.huawei.hms.framework.network.grs.g.d r0 = r1.a
            return r0
        L_0x0141:
            r0 = move-exception
            r7 = r10
        L_0x0143:
            if (r7 == 0) goto L_0x0154
            r7.disconnect()     // Catch:{ RuntimeException -> 0x014f, all -> 0x0149 }
            goto L_0x0154
        L_0x0149:
            java.lang.String r3 = i
            com.huawei.hms.framework.common.Logger.w(r3, r2)
            goto L_0x0154
        L_0x014f:
            java.lang.String r2 = i
            com.huawei.hms.framework.common.Logger.w(r2, r3)
        L_0x0154:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.f.call():com.huawei.hms.framework.network.grs.g.d");
    }
}
