package com.igexin.push.extension.distribution.basic.f;

import android.os.Process;
import android.util.Base64;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.igexin.a.a.b.c;
import com.igexin.a.a.c.b;
import com.igexin.a.a.d.e;
import com.igexin.push.extension.distribution.basic.g.h;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;

public class a extends e {
    public d a;
    public HttpURLConnection b;
    public boolean c;
    private boolean d;

    public a(d dVar) {
        super(0);
        this.a = dVar;
        b.a("AsyncHttpTask|httpPlugin = " + dVar, new Object[0]);
    }

    private b a(String str) {
        try {
            HttpURLConnection b2 = b(str);
            this.b = b2;
            byte[] a2 = a(b2);
            if (a2 != null) {
                b b3 = b(this.b, a2);
                i();
                return b3;
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            i();
            throw th;
        }
        i();
        return new b(this, false, (byte[]) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00cf, code lost:
        if (r9 == null) goto L_0x00d4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00e1 A[SYNTHETIC, Splitter:B:42:0x00e1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.igexin.push.extension.distribution.basic.f.b a(java.lang.String r8, byte[] r9) {
        /*
            r7 = this;
            java.lang.String r0 = "AsyncHttpTask|httpPost() server resp len ="
            java.lang.String r1 = "AsyncHttpTask|httpPost() getEncHttpData len = "
            java.lang.String r2 = "AsyncHttpTask|httpPost() src body len = "
            java.lang.String r3 = "AsyncHttpTask httpPost|error|"
            r4 = 0
            java.lang.Object[] r5 = new java.lang.Object[r4]
            java.lang.String r6 = "AsyncHttpTask|call httpPost start ###"
            com.igexin.a.a.c.b.a((java.lang.String) r6, (java.lang.Object[]) r5)
            r5 = 0
            boolean r6 = r7.b((byte[]) r9)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            if (r6 == 0) goto L_0x0020
            com.igexin.push.extension.distribution.basic.f.b r8 = new com.igexin.push.extension.distribution.basic.f.b     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            r8.<init>(r7, r4, r5)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            r7.i()
            return r8
        L_0x0020:
            java.net.HttpURLConnection r8 = r7.b((java.lang.String) r8, (byte[]) r9)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            r7.b = r8     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            r8.<init>(r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            int r2 = r9.length     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.lang.StringBuilder r8 = r8.append(r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.lang.String r8 = r8.toString()     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            com.igexin.a.a.c.b.a((java.lang.String) r8, (java.lang.Object[]) r2)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.net.HttpURLConnection r8 = r7.b     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            byte[] r8 = r7.a((byte[]) r9, (java.net.HttpURLConnection) r8)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            if (r8 != 0) goto L_0x0052
            java.lang.String r8 = "AsyncHttpTask|httpPost() getEncHttpData body = null"
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            com.igexin.a.a.c.b.a((java.lang.String) r8, (java.lang.Object[]) r9)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            com.igexin.push.extension.distribution.basic.f.b r8 = new com.igexin.push.extension.distribution.basic.f.b     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            r9 = 1
            r8.<init>(r7, r9, r5)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            r7.i()
            return r8
        L_0x0052:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            r9.<init>(r1)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            int r1 = r8.length     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.lang.StringBuilder r9 = r9.append(r1)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.lang.String r9 = r9.toString()     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            com.igexin.a.a.c.b.a((java.lang.String) r9, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.net.HttpURLConnection r9 = r7.b     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            r9.connect()     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.io.DataOutputStream r9 = new java.io.DataOutputStream     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.net.HttpURLConnection r1 = r7.b     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            java.io.OutputStream r1 = r1.getOutputStream()     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            r9.<init>(r1)     // Catch:{ Exception -> 0x00b7, all -> 0x00b5 }
            int r1 = r8.length     // Catch:{ Exception -> 0x00b3 }
            r9.write(r8, r4, r1)     // Catch:{ Exception -> 0x00b3 }
            r9.flush()     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r8 = "AsyncHttpTask|httpPost() write and flush"
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00b3 }
            com.igexin.a.a.c.b.a((java.lang.String) r8, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x00b3 }
            java.net.HttpURLConnection r8 = r7.b     // Catch:{ Exception -> 0x00b3 }
            byte[] r8 = r7.a((java.net.HttpURLConnection) r8)     // Catch:{ Exception -> 0x00b3 }
            if (r8 == 0) goto L_0x00ab
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00b3 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x00b3 }
            int r0 = r8.length     // Catch:{ Exception -> 0x00b3 }
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch:{ Exception -> 0x00b3 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x00b3 }
            java.lang.Object[] r1 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00b3 }
            com.igexin.a.a.c.b.a((java.lang.String) r0, (java.lang.Object[]) r1)     // Catch:{ Exception -> 0x00b3 }
            java.net.HttpURLConnection r0 = r7.b     // Catch:{ Exception -> 0x00b3 }
            com.igexin.push.extension.distribution.basic.f.b r8 = r7.b((java.net.HttpURLConnection) r0, (byte[]) r8)     // Catch:{ Exception -> 0x00b3 }
            r9.close()     // Catch:{ Exception -> 0x00a7 }
        L_0x00a7:
            r7.i()
            return r8
        L_0x00ab:
            java.lang.String r8 = "AsyncHttpTask|httpPost() server resp is null"
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x00b3 }
            com.igexin.a.a.c.b.a((java.lang.String) r8, (java.lang.Object[]) r0)     // Catch:{ Exception -> 0x00b3 }
            goto L_0x00d1
        L_0x00b3:
            r8 = move-exception
            goto L_0x00b9
        L_0x00b5:
            r8 = move-exception
            goto L_0x00df
        L_0x00b7:
            r8 = move-exception
            r9 = r5
        L_0x00b9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00dd }
            r0.<init>(r3)     // Catch:{ all -> 0x00dd }
            java.lang.String r8 = r8.getMessage()     // Catch:{ all -> 0x00dd }
            java.lang.StringBuilder r8 = r0.append(r8)     // Catch:{ all -> 0x00dd }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00dd }
            java.lang.Object[] r0 = new java.lang.Object[r4]     // Catch:{ all -> 0x00dd }
            com.igexin.a.a.c.b.a((java.lang.String) r8, (java.lang.Object[]) r0)     // Catch:{ all -> 0x00dd }
            if (r9 == 0) goto L_0x00d4
        L_0x00d1:
            r9.close()     // Catch:{ Exception -> 0x00d4 }
        L_0x00d4:
            r7.i()
            com.igexin.push.extension.distribution.basic.f.b r8 = new com.igexin.push.extension.distribution.basic.f.b
            r8.<init>(r7, r4, r5)
            return r8
        L_0x00dd:
            r8 = move-exception
            r5 = r9
        L_0x00df:
            if (r5 == 0) goto L_0x00e4
            r5.close()     // Catch:{ Exception -> 0x00e4 }
        L_0x00e4:
            r7.i()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.f.a.a(java.lang.String, byte[]):com.igexin.push.extension.distribution.basic.f.b");
    }

    private Method a(String str, Class<?>... clsArr) {
        try {
            return Class.forName("com.igexin.push.util.EncryptUtils").getMethod(str, clsArr);
        } catch (Exception unused) {
            b.a(this.l + "invokeMethod error", new Object[0]);
            return null;
        }
    }

    private void a(HttpURLConnection httpURLConnection, byte[] bArr) throws Exception {
        if (httpURLConnection != null) {
            byte[] bArr2 = new byte[0];
            if (bArr == null) {
                bArr = bArr2;
            }
            httpURLConnection.addRequestProperty("GT_C_T", String.valueOf(1));
            httpURLConnection.addRequestProperty("GT_C_K", new String((byte[]) a("getRSAKeyId", (Class<?>[]) new Class[0]).invoke((Object) null, new Object[0])));
            httpURLConnection.addRequestProperty("GT_C_V", (String) a("getHttpGTCV", (Class<?>[]) new Class[0]).invoke((Object) null, new Object[0]));
            String valueOf = String.valueOf(System.currentTimeMillis());
            httpURLConnection.addRequestProperty("GT_T", valueOf);
            httpURLConnection.addRequestProperty("GT_C_S", (String) a("getHttpSignature", (Class<?>[]) new Class[]{String.class, byte[].class}).invoke((Object) null, new Object[]{valueOf, bArr}));
        }
    }

    private void a(byte[] bArr) throws Exception {
        this.a.a(bArr);
        c.b().a((Object) this.a);
        c.b().c();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:(2:21|22)|23|24|25) */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:8|(2:9|(1:11)(1:51))|12|(2:14|15)|16|17|18) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x002b */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0034 */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x004d A[SYNTHETIC, Splitter:B:43:0x004d] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0052 A[SYNTHETIC, Splitter:B:47:0x0052] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.net.HttpURLConnection r5) throws java.lang.Exception {
        /*
            r4 = this;
            r0 = 0
            java.io.InputStream r1 = r5.getInputStream()     // Catch:{ Exception -> 0x0047, all -> 0x0044 }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0040, all -> 0x003c }
            r2.<init>()     // Catch:{ Exception -> 0x0040, all -> 0x003c }
            int r5 = r5.getResponseCode()     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r3 = 200(0xc8, float:2.8E-43)
            if (r5 != r3) goto L_0x002f
            r5 = 1024(0x400, float:1.435E-42)
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
        L_0x0016:
            int r0 = r1.read(r5)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            r3 = -1
            if (r0 == r3) goto L_0x0022
            r3 = 0
            r2.write(r5, r3, r0)     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            goto L_0x0016
        L_0x0022:
            byte[] r5 = r2.toByteArray()     // Catch:{ Exception -> 0x003a, all -> 0x0038 }
            if (r1 == 0) goto L_0x002b
            r1.close()     // Catch:{ Exception -> 0x002b }
        L_0x002b:
            r2.close()     // Catch:{ Exception -> 0x002e }
        L_0x002e:
            return r5
        L_0x002f:
            if (r1 == 0) goto L_0x0034
            r1.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            r2.close()     // Catch:{ Exception -> 0x0037 }
        L_0x0037:
            return r0
        L_0x0038:
            r5 = move-exception
            goto L_0x003e
        L_0x003a:
            r5 = move-exception
            goto L_0x0042
        L_0x003c:
            r5 = move-exception
            r2 = r0
        L_0x003e:
            r0 = r1
            goto L_0x004b
        L_0x0040:
            r5 = move-exception
            r2 = r0
        L_0x0042:
            r0 = r1
            goto L_0x0049
        L_0x0044:
            r5 = move-exception
            r2 = r0
            goto L_0x004b
        L_0x0047:
            r5 = move-exception
            r2 = r0
        L_0x0049:
            throw r5     // Catch:{ all -> 0x004a }
        L_0x004a:
            r5 = move-exception
        L_0x004b:
            if (r0 == 0) goto L_0x0050
            r0.close()     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            if (r2 == 0) goto L_0x0055
            r2.close()     // Catch:{ Exception -> 0x0055 }
        L_0x0055:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.f.a.a(java.net.HttpURLConnection):byte[]");
    }

    private byte[] a(byte[] bArr, HttpURLConnection httpURLConnection) {
        Class<byte[]> cls = byte[].class;
        try {
            b.a("AsyncHttpTask|getEncHttpData|isUseAES = |" + this.c, new Object[0]);
            if (!this.c) {
                return h.a(bArr);
            }
            String requestProperty = httpURLConnection.getRequestProperty("GT_C_S");
            if (requestProperty != null) {
                return (byte[]) a("aesEncHttp", (Class<?>[]) new Class[]{cls, cls}).invoke((Object) null, new Object[]{bArr, a("md5", (Class<?>[]) new Class[]{cls}).invoke((Object) null, new Object[]{requestProperty.getBytes()})});
            }
            return null;
        } catch (Throwable th) {
            b.a("AsyncHttpTask|getEncHttpData|error|" + th.getMessage(), new Object[0]);
        }
    }

    private b b(HttpURLConnection httpURLConnection, byte[] bArr) {
        Class<byte[]> cls = byte[].class;
        b.a("AsyncHttpTask|authAndDecResp start ~~~", new Object[0]);
        try {
            if (this.c) {
                String headerField = httpURLConnection.getHeaderField("GT_ERR");
                b.a(this.l + "|GT_ERR = " + headerField, new Object[0]);
                if (headerField != null) {
                    if (headerField.equals("0")) {
                        String headerField2 = httpURLConnection.getHeaderField("GT_T");
                        if (headerField2 == null) {
                            b.a(this.l + "|GT_T = null", new Object[0]);
                            return new b(this, true, (byte[]) null);
                        }
                        String headerField3 = httpURLConnection.getHeaderField("GT_C_S");
                        if (headerField3 == null) {
                            b.a(this.l + "|GT_C_S = null", new Object[0]);
                            return new b(this, true, (byte[]) null);
                        }
                        byte[] bArr2 = (byte[]) a("aesDecHttp", (Class<?>[]) new Class[]{cls, cls}).invoke((Object) null, new Object[]{bArr, a("md5", (Class<?>[]) new Class[]{cls}).invoke((Object) null, new Object[]{headerField2.getBytes()})});
                        String str = (String) a("getHttpSignature", (Class<?>[]) new Class[]{String.class, cls}).invoke((Object) null, new Object[]{headerField2, bArr2});
                        if (str != null) {
                            if (str.equals(headerField3)) {
                                return new b(this, false, bArr2);
                            }
                        }
                        b.a(this.l + "|signature = null or error", new Object[0]);
                        return new b(this, true, (byte[]) null);
                    }
                }
                return new b(this, true, (byte[]) null);
            }
            if (this.a.e()) {
                bArr = Base64.decode(bArr, 0);
            }
            if (this.a.d()) {
                bArr = h.b(bArr);
            }
            return new b(this, false, bArr);
        } catch (Throwable th) {
            b.a("AsyncHttpTask|authAndDecResp|error|" + th.getMessage(), new Object[0]);
            return new b(this, true, (byte[]) null);
        }
    }

    private HttpURLConnection b(String str) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.b = httpURLConnection;
        httpURLConnection.setConnectTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        this.b.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        this.b.setRequestMethod("GET");
        this.b.setDoInput(true);
        if (this.c) {
            a(this.b, (byte[]) null);
        }
        return this.b;
    }

    private HttpURLConnection b(String str, byte[] bArr) throws Exception {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        this.b = httpURLConnection;
        httpURLConnection.setDoInput(true);
        this.b.setDoOutput(true);
        this.b.setRequestMethod("POST");
        this.b.setUseCaches(false);
        this.b.setInstanceFollowRedirects(true);
        this.b.setRequestProperty("Content-Type", "application/octet-stream");
        this.b.setConnectTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        this.b.setReadTimeout(AccessibilityNodeInfoCompat.EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH);
        if (this.c) {
            a(this.b, bArr);
        }
        return this.b;
    }

    private boolean b(byte[] bArr) {
        if (bArr == null || bArr.length / 1024 <= com.igexin.push.extension.distribution.basic.c.e.j) {
            return false;
        }
        b.a(this.l + "|http body size exceed " + com.igexin.push.extension.distribution.basic.c.e.j, new Object[0]);
        return true;
    }

    private void i() {
        b.a("AsyncHttpTask call closeHttpURLConnection", new Object[0]);
        HttpURLConnection httpURLConnection = this.b;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
                this.b = null;
            } catch (Exception unused) {
            }
        }
    }

    private boolean j() {
        return this.a.e && com.igexin.push.extension.distribution.basic.g.b.a();
    }

    public final void b() throws Exception {
        String b2;
        super.b();
        if (this.d) {
            p();
            return;
        }
        this.d = true;
        Process.setThreadPriority(10);
        d dVar = this.a;
        if (dVar != null && (b2 = dVar.b()) != null) {
            boolean j = j();
            this.c = j;
            if (!j || ((Boolean) a("isLoadSuccess", (Class<?>[]) new Class[0]).invoke((Object) null, new Object[0])).booleanValue()) {
                if (this.c && this.a.c() != null && this.a.c().length > 0) {
                    d dVar2 = this.a;
                    dVar2.b(com.igexin.a.a.b.e.a(dVar2.c()));
                }
                try {
                    b a2 = this.a.c() == null ? a(b2) : a(b2, this.a.c());
                    if (a2.a) {
                        Exception exc = new Exception("http server resp decode header error");
                        this.a.a(exc);
                        throw exc;
                    } else if (a2.b != null) {
                        a(a2.b);
                    } else {
                        Exception exc2 = new Exception("Http response exception");
                        this.a.a(exc2);
                        throw exc2;
                    }
                } catch (Exception e) {
                    b.a("AsyncHttpTask|run() post or get error = " + e.getMessage(), new Object[0]);
                    this.a.a(e);
                    throw e;
                } catch (Exception e2) {
                    b.a("AsyncHttpTask|run() error = " + e2.getMessage(), new Object[0]);
                    throw e2;
                }
            } else {
                b.a(this.l + "|so load failed! AsyncHttpTask return!", new Object[0]);
            }
        }
    }

    public final int b_() {
        return -2147483639;
    }

    public void d() {
        this.m = true;
        b.a("AsyncHttpTask initTask()|isBloker = " + this.m + "|isCycle = " + this.n, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    public void f() {
        b.a("AsyncHttpTask|dispose()|closeHttpURLConnection", new Object[0]);
        super.f();
        i();
    }
}
