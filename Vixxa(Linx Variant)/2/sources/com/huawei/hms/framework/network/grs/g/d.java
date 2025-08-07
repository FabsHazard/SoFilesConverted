package com.huawei.hms.framework.network.grs.g;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.microtech.aidexx.utils.TimeUtils;
import java.nio.ByteBuffer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;

public class d {
    private static final String o = "d";
    private Map<String, List<String>> a;
    private byte[] b;
    private int c;
    private long d;
    private long e;
    private long f;
    private String g;
    private int h;
    private int i;
    private String j;
    private long k;
    private String l;
    private Exception m;
    private String n;

    public d(int i2, Map<String, List<String>> map, byte[] bArr, long j2) {
        this.h = 2;
        this.i = 9001;
        this.j = "";
        this.k = 0;
        this.l = "";
        this.c = i2;
        this.a = map;
        this.b = ByteBuffer.wrap(bArr).array();
        this.d = j2;
        s();
    }

    public d(Exception exc, long j2) {
        this.c = 0;
        this.h = 2;
        this.i = 9001;
        this.j = "";
        this.k = 0;
        this.l = "";
        this.m = exc;
        this.d = j2;
    }

    private void a(Map<String, String> map) {
        String str;
        String str2;
        if (map.containsKey("ETag")) {
            String str3 = map.get("ETag");
            if (!TextUtils.isEmpty(str3)) {
                Logger.i(o, "success get Etag from server");
                a(str3);
                return;
            }
            str = o;
            str2 = "The Response Heads Etag is Empty";
        } else {
            str = o;
            str2 = "Response Heads has not Etag";
        }
        Logger.i(str, str2);
    }

    private void b(int i2) {
        this.i = i2;
    }

    private void b(Map<String, String> map) {
        long j2;
        if (map.containsKey("Cache-Control")) {
            String str = map.get("Cache-Control");
            if (!TextUtils.isEmpty(str) && str.contains("max-age=")) {
                try {
                    j2 = Long.parseLong(str.substring(str.indexOf("max-age=") + 8));
                    try {
                        Logger.v(o, "Cache-Control value{%s}", Long.valueOf(j2));
                    } catch (NumberFormatException e2) {
                        e = e2;
                    }
                } catch (NumberFormatException e3) {
                    e = e3;
                    j2 = 0;
                    Logger.w(o, "getExpireTime addHeadersToResult NumberFormatException", (Throwable) e);
                    j2 = TimeUtils.oneDaySeconds;
                    long j3 = j2 * 1000;
                    Logger.i(o, "convert expireTime{%s}", Long.valueOf(j3));
                    c(String.valueOf(j3 + System.currentTimeMillis()));
                }
                if (j2 <= 0 || j2 > 2592000) {
                    j2 = TimeUtils.oneDaySeconds;
                }
                long j32 = j2 * 1000;
                Logger.i(o, "convert expireTime{%s}", Long.valueOf(j32));
                c(String.valueOf(j32 + System.currentTimeMillis()));
            }
        } else if (map.containsKey("Expires")) {
            String str2 = map.get("Expires");
            Logger.v(o, "expires is{%s}", str2);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss 'GMT'", Locale.ROOT);
            String str3 = map.containsKey("Date") ? map.get("Date") : null;
            try {
                j2 = (simpleDateFormat.parse(str2).getTime() - (TextUtils.isEmpty(str3) ? new Date() : simpleDateFormat.parse(str3)).getTime()) / 1000;
            } catch (ParseException e4) {
                Logger.w(o, "getExpireTime ParseException.", (Throwable) e4);
            }
            j2 = TimeUtils.oneDaySeconds;
            long j322 = j2 * 1000;
            Logger.i(o, "convert expireTime{%s}", Long.valueOf(j322));
            c(String.valueOf(j322 + System.currentTimeMillis()));
        } else {
            Logger.i(o, "response headers neither contains Cache-Control nor Expires.");
        }
        j2 = 0;
        j2 = TimeUtils.oneDaySeconds;
        long j3222 = j2 * 1000;
        Logger.i(o, "convert expireTime{%s}", Long.valueOf(j3222));
        c(String.valueOf(j3222 + System.currentTimeMillis()));
    }

    private void c(int i2) {
        this.h = i2;
    }

    private void c(long j2) {
        this.k = j2;
    }

    private void c(String str) {
        this.j = str;
    }

    private void c(Map<String, String> map) {
        long j2;
        if (map.containsKey("Retry-After")) {
            String str = map.get("Retry-After");
            if (!TextUtils.isEmpty(str)) {
                try {
                    j2 = Long.parseLong(str);
                } catch (NumberFormatException e2) {
                    Logger.w(o, "getRetryAfter addHeadersToResult NumberFormatException", (Throwable) e2);
                }
                long j3 = j2 * 1000;
                Logger.v(o, "convert retry-afterTime{%s}", Long.valueOf(j3));
                c(j3);
            }
        }
        j2 = 0;
        long j32 = j2 * 1000;
        Logger.v(o, "convert retry-afterTime{%s}", Long.valueOf(j32));
        c(j32);
    }

    private void d(String str) {
    }

    private void e(String str) {
    }

    private void f(String str) {
        this.g = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        if (r8.getInt("resultCode") == 0) goto L_0x0052;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062 A[SYNTHETIC, Splitter:B:24:0x0062] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0070 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0097 A[Catch:{ JSONException -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00a0 A[Catch:{ JSONException -> 0x00b6 }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00aa A[Catch:{ JSONException -> 0x00b6 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void p() {
        /*
            r9 = this;
            java.lang.String r0 = "errorDesc"
            java.lang.String r1 = "errorList"
            java.lang.String r2 = "errorCode"
            java.lang.String r3 = "resultCode"
            java.lang.String r4 = "isSuccess"
            boolean r5 = r9.m()
            r6 = 1
            if (r5 == 0) goto L_0x001c
            java.lang.String r0 = o
            java.lang.String r1 = "GRSSDK get httpcode{304} not any changed."
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            r9.c((int) r6)
            return
        L_0x001c:
            boolean r5 = r9.o()
            r7 = 2
            if (r5 != 0) goto L_0x002e
            java.lang.String r0 = o
            java.lang.String r1 = "GRSSDK parse server body all failed."
            com.huawei.hms.framework.common.Logger.i(r0, r1)
            r9.c((int) r7)
            return
        L_0x002e:
            byte[] r5 = r9.b     // Catch:{ JSONException -> 0x00b6 }
            java.lang.String r5 = com.huawei.hms.framework.common.StringUtils.byte2Str(r5)     // Catch:{ JSONException -> 0x00b6 }
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ JSONException -> 0x00b6 }
            r8.<init>(r5)     // Catch:{ JSONException -> 0x00b6 }
            boolean r5 = r8.has(r4)     // Catch:{ JSONException -> 0x00b6 }
            if (r5 == 0) goto L_0x0046
            int r3 = r8.getInt(r4)     // Catch:{ JSONException -> 0x00b6 }
            if (r3 != r6) goto L_0x0054
            goto L_0x0052
        L_0x0046:
            boolean r4 = r8.has(r3)     // Catch:{ JSONException -> 0x00b6 }
            if (r4 == 0) goto L_0x0056
            int r3 = r8.getInt(r3)     // Catch:{ JSONException -> 0x00b6 }
            if (r3 != 0) goto L_0x0054
        L_0x0052:
            r3 = r6
            goto L_0x005e
        L_0x0054:
            r3 = r7
            goto L_0x005e
        L_0x0056:
            java.lang.String r3 = o     // Catch:{ JSONException -> 0x00b6 }
            java.lang.String r4 = "sth. wrong because server errorcode's key."
            com.huawei.hms.framework.common.Logger.e(r3, r4)     // Catch:{ JSONException -> 0x00b6 }
            r3 = -1
        L_0x005e:
            java.lang.String r4 = "services"
            if (r3 == r6) goto L_0x0069
            boolean r5 = r8.has(r4)     // Catch:{ JSONException -> 0x00b6 }
            if (r5 == 0) goto L_0x0069
            r3 = 0
        L_0x0069:
            r9.c((int) r3)     // Catch:{ JSONException -> 0x00b6 }
            java.lang.String r5 = ""
            if (r3 == r6) goto L_0x0091
            if (r3 != 0) goto L_0x0073
            goto L_0x0091
        L_0x0073:
            boolean r1 = r8.has(r2)     // Catch:{ JSONException -> 0x00b6 }
            if (r1 == 0) goto L_0x007e
            int r1 = r8.getInt(r2)     // Catch:{ JSONException -> 0x00b6 }
            goto L_0x0080
        L_0x007e:
            r1 = 9001(0x2329, float:1.2613E-41)
        L_0x0080:
            r9.b((int) r1)     // Catch:{ JSONException -> 0x00b6 }
            boolean r1 = r8.has(r0)     // Catch:{ JSONException -> 0x00b6 }
            if (r1 == 0) goto L_0x008d
            java.lang.String r5 = r8.getString(r0)     // Catch:{ JSONException -> 0x00b6 }
        L_0x008d:
            r9.d(r5)     // Catch:{ JSONException -> 0x00b6 }
            goto L_0x00cd
        L_0x0091:
            boolean r0 = r8.has(r4)     // Catch:{ JSONException -> 0x00b6 }
            if (r0 == 0) goto L_0x00a0
            org.json.JSONObject r0 = r8.getJSONObject(r4)     // Catch:{ JSONException -> 0x00b6 }
            java.lang.String r0 = r0.toString()     // Catch:{ JSONException -> 0x00b6 }
            goto L_0x00a1
        L_0x00a0:
            r0 = r5
        L_0x00a1:
            r9.f(r0)     // Catch:{ JSONException -> 0x00b6 }
            boolean r0 = r8.has(r1)     // Catch:{ JSONException -> 0x00b6 }
            if (r0 == 0) goto L_0x00b2
            org.json.JSONObject r0 = r8.getJSONObject(r1)     // Catch:{ JSONException -> 0x00b6 }
            java.lang.String r5 = r0.toString()     // Catch:{ JSONException -> 0x00b6 }
        L_0x00b2:
            r9.e(r5)     // Catch:{ JSONException -> 0x00b6 }
            goto L_0x00cd
        L_0x00b6:
            r0 = move-exception
            java.lang.String r1 = o
            java.lang.String r0 = r0.getMessage()
            java.lang.String r0 = com.huawei.hms.framework.common.StringUtils.anonymizeMessage(r0)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r2 = "GrsResponse GrsResponse(String result) JSONException: %s"
            com.huawei.hms.framework.common.Logger.w((java.lang.String) r1, (java.lang.String) r2, (java.lang.Object[]) r0)
            r9.c((int) r7)
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.framework.network.grs.g.d.p():void");
    }

    private void q() {
        if (o() || n() || m()) {
            Map<String, String> r = r();
            if (r.size() <= 0) {
                Logger.w(o, "parseHeader {headers.size() <= 0}");
                return;
            }
            try {
                if (o() || m()) {
                    b(r);
                    a(r);
                }
                if (n()) {
                    c(r);
                }
            } catch (JSONException e2) {
                Logger.w(o, "parseHeader catch JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
            }
        }
    }

    private Map<String, String> r() {
        HashMap hashMap = new HashMap(16);
        Map<String, List<String>> map = this.a;
        if (map == null || map.size() <= 0) {
            Logger.v(o, "parseRespHeaders {respHeaders == null} or {respHeaders.size() <= 0}");
            return hashMap;
        }
        for (Map.Entry next : this.a.entrySet()) {
            String str = (String) next.getKey();
            for (String put : (List) next.getValue()) {
                hashMap.put(str, put);
            }
        }
        return hashMap;
    }

    private void s() {
        q();
        p();
    }

    public String a() {
        return this.j;
    }

    public void a(int i2) {
    }

    public void a(long j2) {
        this.f = j2;
    }

    public void a(String str) {
        this.l = str;
    }

    public int b() {
        return this.c;
    }

    public void b(long j2) {
        this.e = j2;
    }

    public void b(String str) {
        this.n = str;
    }

    public int c() {
        return this.i;
    }

    public Exception d() {
        return this.m;
    }

    public String e() {
        return this.l;
    }

    public int f() {
        return this.h;
    }

    public long g() {
        return this.f;
    }

    public long h() {
        return this.e;
    }

    public long i() {
        return this.d;
    }

    public String j() {
        return this.g;
    }

    public long k() {
        return this.k;
    }

    public String l() {
        return this.n;
    }

    public boolean m() {
        return this.c == 304;
    }

    public boolean n() {
        return this.c == 503;
    }

    public boolean o() {
        return this.c == 200;
    }
}
