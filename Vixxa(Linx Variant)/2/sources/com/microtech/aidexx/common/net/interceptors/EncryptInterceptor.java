package com.microtech.aidexx.common.net.interceptors;

import java.io.IOException;
import java.util.HashMap;
import okhttp3.Interceptor;
import okhttp3.RequestBody;
import okio.Buffer;

public class EncryptInterceptor implements Interceptor {
    private final HashMap<String, String> hashMap = new HashMap<>();

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00cf, code lost:
        if (r1.equals("delete") == false) goto L_0x00a6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r9) throws java.io.IOException {
        /*
            r8 = this;
            okhttp3.Request r0 = r9.request()
            java.lang.String r1 = r0.method()
            okhttp3.RequestBody r2 = r0.body()
            if (r2 == 0) goto L_0x00e9
            java.lang.String r3 = r2.toString()
            boolean r3 = r3.isEmpty()
            if (r3 != 0) goto L_0x00e9
            okhttp3.MediaType r3 = r2.contentType()
            r4 = 0
            if (r3 == 0) goto L_0x0034
            java.lang.String r5 = r3.type()
            java.lang.String r6 = "multipart"
            boolean r5 = r5.equalsIgnoreCase(r6)
            java.lang.String r3 = r3.subtype()
            java.lang.String r6 = "form-data"
            boolean r3 = r3.equalsIgnoreCase(r6)
            goto L_0x0036
        L_0x0034:
            r3 = r4
            r5 = r3
        L_0x0036:
            okhttp3.Request$Builder r6 = r0.newBuilder()
            if (r5 == 0) goto L_0x0056
            if (r3 != 0) goto L_0x003f
            goto L_0x0056
        L_0x003f:
            java.lang.String r0 = "encryption"
            r6.removeHeader(r0)
            java.lang.String r1 = "disable"
            r6.addHeader(r0, r1)
            java.lang.String r0 = "data-decrypt"
            java.lang.String r1 = "false"
            r6.addHeader(r0, r1)
            okhttp3.Request r0 = r6.build()
            goto L_0x00e9
        L_0x0056:
            java.util.HashMap<java.lang.String, java.lang.String> r3 = r8.hashMap
            r3.clear()
            r3 = 0
            java.lang.String r5 = r8.getContent(r2)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r7 = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCifgLBAr2MhgWLBJWtTuhtGC4f47eb5xs1Ys/GvYjS77h6aX9Zw2HIpovVRLITdd0bMjD4/VHnrC1bZOD/OeXchOTmjrVlIdKVeJK4RIrYc7oDSlWUYkBKDRqWLEUXS2CS0Fc1X6wa2Pub7G9e3ukV+orrJkMC0+YTEgn18iLUBQIDAQAB"
            java.security.interfaces.RSAPublicKey r7 = com.microtech.aidexx.common.net.RSAUtil.getPublicKey(r7)     // Catch:{ Exception -> 0x0072 }
            java.lang.String r3 = com.microtech.aidexx.common.net.RSAUtil.encryptByPublicKey(r5, r7)     // Catch:{ Exception -> 0x0072 }
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r8.hashMap     // Catch:{ Exception -> 0x0072 }
            java.lang.String r7 = "data"
            r5.put(r7, r3)     // Catch:{ Exception -> 0x0072 }
            goto L_0x0076
        L_0x0072:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0076:
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r8.hashMap
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x00e9
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.util.HashMap<java.lang.String, java.lang.String> r5 = r8.hashMap
            r0.toJson((java.lang.Object) r5)
            if (r3 == 0) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            java.lang.String r3 = ""
        L_0x008d:
            okhttp3.MediaType r0 = r2.contentType()
            okhttp3.RequestBody r0 = okhttp3.RequestBody.create((java.lang.String) r3, (okhttp3.MediaType) r0)
            java.util.Locale r2 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r2)
            r1.hashCode()
            int r2 = r1.hashCode()
            r3 = -1
            switch(r2) {
                case -1335458389: goto L_0x00c9;
                case 111375: goto L_0x00be;
                case 3446944: goto L_0x00b3;
                case 106438728: goto L_0x00a8;
                default: goto L_0x00a6;
            }
        L_0x00a6:
            r4 = r3
            goto L_0x00d2
        L_0x00a8:
            java.lang.String r2 = "patch"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00b1
            goto L_0x00a6
        L_0x00b1:
            r4 = 3
            goto L_0x00d2
        L_0x00b3:
            java.lang.String r2 = "post"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00bc
            goto L_0x00a6
        L_0x00bc:
            r4 = 2
            goto L_0x00d2
        L_0x00be:
            java.lang.String r2 = "put"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00c7
            goto L_0x00a6
        L_0x00c7:
            r4 = 1
            goto L_0x00d2
        L_0x00c9:
            java.lang.String r2 = "delete"
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x00d2
            goto L_0x00a6
        L_0x00d2:
            switch(r4) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00de;
                case 2: goto L_0x00da;
                case 3: goto L_0x00d6;
                default: goto L_0x00d5;
            }
        L_0x00d5:
            goto L_0x00e5
        L_0x00d6:
            r6.patch(r0)
            goto L_0x00e5
        L_0x00da:
            r6.post(r0)
            goto L_0x00e5
        L_0x00de:
            r6.put(r0)
            goto L_0x00e5
        L_0x00e2:
            r6.delete(r0)
        L_0x00e5:
            okhttp3.Request r0 = r6.build()
        L_0x00e9:
            okhttp3.Response r9 = r9.proceed(r0)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.net.interceptors.EncryptInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    private String getContent(RequestBody requestBody) {
        Buffer buffer = new Buffer();
        try {
            requestBody.writeTo(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer.readUtf8();
    }
}
