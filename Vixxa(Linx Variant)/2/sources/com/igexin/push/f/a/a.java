package com.igexin.push.f.a;

import android.os.Process;
import com.igexin.a.a.b.c;
import com.igexin.a.a.c.b;
import com.igexin.a.a.d.e;
import com.igexin.push.config.l;
import java.net.HttpURLConnection;

public class a extends e {
    public static final String a = "com.igexin.push.f.a.a";
    public b b;
    private HttpURLConnection c;

    public a(b bVar) {
        super(0);
        this.b = bVar;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:(2:22|23)|49|50|51|53) */
    /* JADX WARNING: Can't wrap try/catch for region: R(8:8|(2:9|(1:11)(1:54))|12|(2:14|15)|16|17|18|20) */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0082, code lost:
        if (r1 == null) goto L_0x0087;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0053 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0084 */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f A[SYNTHETIC, Splitter:B:32:0x006f] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0074 A[SYNTHETIC, Splitter:B:36:0x0074] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x007f A[SYNTHETIC, Splitter:B:45:0x007f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            r1.<init>(r7)     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            java.net.URLConnection r7 = r1.openConnection()     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            r6.c = r7     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            r1 = 20000(0x4e20, float:2.8026E-41)
            r7.setConnectTimeout(r1)     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            java.net.HttpURLConnection r7 = r6.c     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            r7.setReadTimeout(r1)     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            java.net.HttpURLConnection r7 = r6.c     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            java.lang.String r1 = "GET"
            r7.setRequestMethod(r1)     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            java.net.HttpURLConnection r7 = r6.c     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            r1 = 1
            r7.setDoInput(r1)     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            java.net.HttpURLConnection r7 = r6.c     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            java.io.InputStream r7 = r7.getInputStream()     // Catch:{ Exception -> 0x007b, all -> 0x0069 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0067, all -> 0x0062 }
            r1.<init>()     // Catch:{ Exception -> 0x0067, all -> 0x0062 }
            java.net.HttpURLConnection r2 = r6.c     // Catch:{ Exception -> 0x007d, all -> 0x0060 }
            int r2 = r2.getResponseCode()     // Catch:{ Exception -> 0x007d, all -> 0x0060 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r2 != r3) goto L_0x005a
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x007d, all -> 0x0060 }
        L_0x003e:
            int r3 = r7.read(r2)     // Catch:{ Exception -> 0x007d, all -> 0x0060 }
            r4 = -1
            if (r3 == r4) goto L_0x004a
            r4 = 0
            r1.write(r2, r4, r3)     // Catch:{ Exception -> 0x007d, all -> 0x0060 }
            goto L_0x003e
        L_0x004a:
            byte[] r0 = r1.toByteArray()     // Catch:{ Exception -> 0x007d, all -> 0x0060 }
            if (r7 == 0) goto L_0x0053
            r7.close()     // Catch:{ Exception -> 0x0053 }
        L_0x0053:
            r1.close()     // Catch:{ Exception -> 0x0056 }
        L_0x0056:
            r6.i()
            return r0
        L_0x005a:
            if (r7 == 0) goto L_0x0084
            r7.close()     // Catch:{ Exception -> 0x0084 }
            goto L_0x0084
        L_0x0060:
            r0 = move-exception
            goto L_0x006d
        L_0x0062:
            r1 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x006d
        L_0x0067:
            r1 = r0
            goto L_0x007d
        L_0x0069:
            r7 = move-exception
            r1 = r0
            r0 = r7
            r7 = r1
        L_0x006d:
            if (r7 == 0) goto L_0x0072
            r7.close()     // Catch:{ Exception -> 0x0072 }
        L_0x0072:
            if (r1 == 0) goto L_0x0077
            r1.close()     // Catch:{ Exception -> 0x0077 }
        L_0x0077:
            r6.i()
            throw r0
        L_0x007b:
            r7 = r0
            r1 = r7
        L_0x007d:
            if (r7 == 0) goto L_0x0082
            r7.close()     // Catch:{ Exception -> 0x0082 }
        L_0x0082:
            if (r1 == 0) goto L_0x0087
        L_0x0084:
            r1.close()     // Catch:{ Exception -> 0x0087 }
        L_0x0087:
            r6.i()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.a.a(java.lang.String):byte[]");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v17, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: type inference failed for: r1v0, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARNING: type inference failed for: r1v1 */
    /* JADX WARNING: type inference failed for: r1v13 */
    /* JADX WARNING: Can't wrap try/catch for region: R(14:7|8|9|10|11|(2:12|(1:14)(1:72))|15|16|17|(2:20|21)|22|23|24|26) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x0085 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00a7 A[SYNTHETIC, Splitter:B:41:0x00a7] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ac A[SYNTHETIC, Splitter:B:45:0x00ac] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00b1 A[SYNTHETIC, Splitter:B:49:0x00b1] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bd A[SYNTHETIC, Splitter:B:59:0x00bd] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00c2 A[SYNTHETIC, Splitter:B:63:0x00c2] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c7 A[SYNTHETIC, Splitter:B:67:0x00c7] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.lang.String r8, byte[] r9) {
        /*
            r7 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            r1.<init>(r8)     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.net.URLConnection r8 = r1.openConnection()     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            r7.c = r8     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            r1 = 1
            r8.setDoInput(r1)     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            r8.setDoOutput(r1)     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.lang.String r2 = "POST"
            r8.setRequestMethod(r2)     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            r2 = 0
            r8.setUseCaches(r2)     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            r8.setInstanceFollowRedirects(r1)     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.lang.String r1 = "Content-Type"
            java.lang.String r3 = "application/octet-stream"
            r8.setRequestProperty(r1, r3)     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            r1 = 20000(0x4e20, float:2.8026E-41)
            r8.setConnectTimeout(r1)     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            r8.setReadTimeout(r1)     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.net.HttpURLConnection r8 = r7.c     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            r8.connect()     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.io.DataOutputStream r8 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.net.HttpURLConnection r1 = r7.c     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            java.io.OutputStream r1 = r1.getOutputStream()     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            r8.<init>(r1)     // Catch:{ Exception -> 0x00b8, all -> 0x00a0 }
            int r1 = r9.length     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            r8.write(r9, r2, r1)     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            r8.flush()     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            java.net.HttpURLConnection r9 = r7.c     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            int r9 = r9.getResponseCode()     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            r1 = 200(0xc8, float:2.8E-43)
            if (r9 != r1) goto L_0x0095
            java.net.HttpURLConnection r9 = r7.c     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            java.io.InputStream r9 = r9.getInputStream()     // Catch:{ Exception -> 0x009e, all -> 0x0099 }
            java.io.ByteArrayOutputStream r1 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0093, all -> 0x008e }
            r1.<init>()     // Catch:{ Exception -> 0x0093, all -> 0x008e }
            r3 = 1024(0x400, float:1.435E-42)
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x00bb, all -> 0x008c }
        L_0x006e:
            int r4 = r9.read(r3)     // Catch:{ Exception -> 0x00bb, all -> 0x008c }
            r5 = -1
            if (r4 == r5) goto L_0x0079
            r1.write(r3, r2, r4)     // Catch:{ Exception -> 0x00bb, all -> 0x008c }
            goto L_0x006e
        L_0x0079:
            byte[] r0 = r1.toByteArray()     // Catch:{ Exception -> 0x00bb, all -> 0x008c }
            r8.close()     // Catch:{ Exception -> 0x0080 }
        L_0x0080:
            if (r9 == 0) goto L_0x0085
            r9.close()     // Catch:{ Exception -> 0x0085 }
        L_0x0085:
            r1.close()     // Catch:{ Exception -> 0x0088 }
        L_0x0088:
            r7.i()
            return r0
        L_0x008c:
            r0 = move-exception
            goto L_0x00a5
        L_0x008e:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
            goto L_0x00a5
        L_0x0093:
            r1 = r0
            goto L_0x00bb
        L_0x0095:
            r8.close()     // Catch:{ Exception -> 0x00ca }
            goto L_0x00ca
        L_0x0099:
            r9 = move-exception
            r1 = r0
            r0 = r9
            r9 = r1
            goto L_0x00a5
        L_0x009e:
            r9 = r0
            goto L_0x00ba
        L_0x00a0:
            r8 = move-exception
            r9 = r0
            r1 = r9
            r0 = r8
            r8 = r1
        L_0x00a5:
            if (r8 == 0) goto L_0x00aa
            r8.close()     // Catch:{ Exception -> 0x00aa }
        L_0x00aa:
            if (r9 == 0) goto L_0x00af
            r9.close()     // Catch:{ Exception -> 0x00af }
        L_0x00af:
            if (r1 == 0) goto L_0x00b4
            r1.close()     // Catch:{ Exception -> 0x00b4 }
        L_0x00b4:
            r7.i()
            throw r0
        L_0x00b8:
            r8 = r0
            r9 = r8
        L_0x00ba:
            r1 = r9
        L_0x00bb:
            if (r8 == 0) goto L_0x00c0
            r8.close()     // Catch:{ Exception -> 0x00c0 }
        L_0x00c0:
            if (r9 == 0) goto L_0x00c5
            r9.close()     // Catch:{ Exception -> 0x00c5 }
        L_0x00c5:
            if (r1 == 0) goto L_0x00ca
            r1.close()     // Catch:{ Exception -> 0x00ca }
        L_0x00ca:
            r7.i()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.f.a.a.a(java.lang.String, byte[]):byte[]");
    }

    private void i() {
        HttpURLConnection httpURLConnection = this.c;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.c = null;
            } catch (Exception unused) {
            }
        }
    }

    public final void b() throws Exception {
        super.b();
        Process.setThreadPriority(10);
        b bVar = this.b;
        if (bVar == null || bVar.c == null || (this.b.d != null && this.b.d.length > l.w * 1024)) {
            p();
            b.a(a + "|run return ###", new Object[0]);
            return;
        }
        try {
            byte[] a2 = this.b.d == null ? a(this.b.c) : a(this.b.c, this.b.d);
            if (a2 != null) {
                try {
                    this.b.a(a2);
                    c.b().a((Object) this.b);
                    c.b().c();
                } catch (Exception e) {
                    this.b.a(e);
                    throw e;
                }
            } else {
                Exception exc = new Exception("Http response ＝＝ null");
                this.b.a(exc);
                throw exc;
            }
        } catch (Exception e2) {
            this.b.a(e2);
            throw e2;
        }
    }

    public final int b_() {
        return -2147483639;
    }

    public void d() {
        this.m = true;
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    public void f() {
        super.f();
        i();
    }
}
