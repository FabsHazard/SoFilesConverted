package com.igexin.push.extension.distribution.basic.a;

import java.net.ServerSocket;

public class d {
    private static final String a = ("EXT-" + d.class.getName());
    private static d d;
    private Long b;
    private ServerSocket c;

    private d() {
    }

    public static d a() {
        if (d == null) {
            d = new d();
        }
        return d;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        com.igexin.a.a.c.b.a(a + "|port 51688 has occupy by others", new java.lang.Object[0]);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x001e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(boolean r9) {
        /*
            r8 = this;
            java.lang.String r0 = "6T5@S_"
            java.lang.String r1 = "ANDROID-"
            r2 = 0
            if (r9 == 0) goto L_0x016e
            boolean r3 = com.igexin.push.core.d.j     // Catch:{ all -> 0x016c }
            if (r3 == 0) goto L_0x016e
            boolean r3 = com.igexin.push.core.d.i     // Catch:{ all -> 0x016c }
            if (r3 == 0) goto L_0x016e
            java.net.ServerSocket r3 = r8.c     // Catch:{ Exception -> 0x001e }
            if (r3 != 0) goto L_0x0038
            java.net.ServerSocket r3 = new java.net.ServerSocket     // Catch:{ Exception -> 0x001e }
            r4 = 51688(0xc9e8, float:7.243E-41)
            r3.<init>(r4)     // Catch:{ Exception -> 0x001e }
            r8.c = r3     // Catch:{ Exception -> 0x001e }
            goto L_0x0038
        L_0x001e:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r3.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r4 = a     // Catch:{ all -> 0x016c }
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x016c }
            java.lang.String r4 = "|port 51688 has occupy by others"
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x016c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x016c }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x016c }
            com.igexin.a.a.c.b.a((java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ all -> 0x016c }
        L_0x0038:
            java.net.ServerSocket r3 = r8.c     // Catch:{ all -> 0x016c }
            if (r3 == 0) goto L_0x016e
            long r3 = com.igexin.push.extension.distribution.basic.c.e.h     // Catch:{ all -> 0x016c }
            r5 = 180000(0x2bf20, double:8.8932E-319)
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0047
            com.igexin.push.extension.distribution.basic.c.e.h = r5     // Catch:{ all -> 0x016c }
        L_0x0047:
            long r3 = com.igexin.push.extension.distribution.basic.c.e.g     // Catch:{ all -> 0x016c }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x004f
            com.igexin.push.extension.distribution.basic.c.e.g = r5     // Catch:{ all -> 0x016c }
        L_0x004f:
            java.lang.Long r3 = r8.b     // Catch:{ all -> 0x016c }
            if (r3 != 0) goto L_0x0085
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x016c }
            long r5 = com.igexin.push.extension.distribution.basic.c.e.i     // Catch:{ all -> 0x016c }
            long r3 = r3 - r5
            long r5 = com.igexin.push.extension.distribution.basic.c.e.h     // Catch:{ all -> 0x016c }
            int r5 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r5 >= 0) goto L_0x007b
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r9.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r0 = a     // Catch:{ all -> 0x016c }
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ all -> 0x016c }
            java.lang.String r0 = "|lastReportInterval < reportCidRestartThreshold not report"
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ all -> 0x016c }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x016c }
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x016c }
            com.igexin.a.a.c.b.a((java.lang.String) r9, (java.lang.Object[]) r0)     // Catch:{ all -> 0x016c }
            return
        L_0x007b:
            long r5 = com.igexin.push.extension.distribution.basic.c.e.g     // Catch:{ all -> 0x016c }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0083
            r3 = 2
            goto L_0x0097
        L_0x0083:
            r3 = r2
            goto L_0x0097
        L_0x0085:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x016c }
            java.lang.Long r5 = r8.b     // Catch:{ all -> 0x016c }
            long r5 = r5.longValue()     // Catch:{ all -> 0x016c }
            long r3 = r3 - r5
            long r5 = com.igexin.push.extension.distribution.basic.c.e.g     // Catch:{ all -> 0x016c }
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 < 0) goto L_0x0151
            r3 = 1
        L_0x0097:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r4.<init>()     // Catch:{ all -> 0x016c }
            java.io.File r5 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ all -> 0x016c }
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x016c }
            java.lang.String r5 = "/libs"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch:{ all -> 0x016c }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x016c }
            java.util.List r4 = com.igexin.push.extension.distribution.basic.g.e.a((java.lang.String) r4)     // Catch:{ all -> 0x016c }
            if (r4 != 0) goto L_0x00ba
            org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ all -> 0x016c }
            r4.<init>()     // Catch:{ all -> 0x016c }
            goto L_0x00c6
        L_0x00ba:
            int r5 = r4.size()     // Catch:{ all -> 0x016c }
            if (r5 <= 0) goto L_0x0150
            org.json.JSONArray r5 = new org.json.JSONArray     // Catch:{ all -> 0x016c }
            r5.<init>(r4)     // Catch:{ all -> 0x016c }
            r4 = r5
        L_0x00c6:
            org.json.JSONObject r5 = new org.json.JSONObject     // Catch:{ all -> 0x016c }
            r5.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r6 = "appinfo"
            r5.put(r6, r4)     // Catch:{ all -> 0x016c }
            java.lang.String r4 = "deviceid"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r6.<init>(r1)     // Catch:{ all -> 0x016c }
            java.lang.String r1 = com.igexin.push.core.d.y     // Catch:{ all -> 0x016c }
            java.lang.StringBuilder r1 = r6.append(r1)     // Catch:{ all -> 0x016c }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x016c }
            r5.put(r4, r1)     // Catch:{ all -> 0x016c }
            java.lang.String r1 = "type"
            r5.put(r1, r3)     // Catch:{ all -> 0x016c }
            java.lang.String r1 = "pkg"
            android.content.Context r3 = com.igexin.push.core.d.e     // Catch:{ all -> 0x016c }
            java.lang.String r3 = r3.getPackageName()     // Catch:{ all -> 0x016c }
            r5.put(r1, r3)     // Catch:{ all -> 0x016c }
            r5.toString()     // Catch:{ all -> 0x016c }
            android.os.Bundle r1 = new android.os.Bundle     // Catch:{ all -> 0x016c }
            r1.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r3 = "action"
            java.lang.String r4 = "sendMessage"
            r1.putString(r3, r4)     // Catch:{ all -> 0x016c }
            java.lang.String r3 = "taskid"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r4.<init>(r0)     // Catch:{ all -> 0x016c }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r0.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r6 = com.igexin.push.core.d.s     // Catch:{ all -> 0x016c }
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch:{ all -> 0x016c }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x016c }
            java.lang.StringBuilder r0 = r0.append(r6)     // Catch:{ all -> 0x016c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x016c }
            java.lang.String r0 = com.igexin.a.b.a.a((java.lang.String) r0)     // Catch:{ all -> 0x016c }
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch:{ all -> 0x016c }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x016c }
            r1.putString(r3, r0)     // Catch:{ all -> 0x016c }
            java.lang.String r0 = "extraData"
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x016c }
            byte[] r3 = r3.getBytes()     // Catch:{ all -> 0x016c }
            r1.putByteArray(r0, r3)     // Catch:{ all -> 0x016c }
            com.igexin.push.core.a.e r0 = com.igexin.push.core.a.e.a()     // Catch:{ all -> 0x016c }
            r0.a((android.os.Bundle) r1)     // Catch:{ all -> 0x016c }
            com.igexin.push.extension.distribution.basic.d.b r0 = com.igexin.push.extension.distribution.basic.d.b.a()     // Catch:{ all -> 0x016c }
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x016c }
            r0.a(r3)     // Catch:{ all -> 0x016c }
            goto L_0x016e
        L_0x0150:
            return
        L_0x0151:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x016c }
            r9.<init>()     // Catch:{ all -> 0x016c }
            java.lang.String r0 = a     // Catch:{ all -> 0x016c }
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ all -> 0x016c }
            java.lang.String r0 = "|offline time < reportCidOfflineThreshold not report"
            java.lang.StringBuilder r9 = r9.append(r0)     // Catch:{ all -> 0x016c }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x016c }
            java.lang.Object[] r0 = new java.lang.Object[r2]     // Catch:{ all -> 0x016c }
            com.igexin.a.a.c.b.a((java.lang.String) r9, (java.lang.Object[]) r0)     // Catch:{ all -> 0x016c }
            return
        L_0x016c:
            r9 = move-exception
            goto L_0x017b
        L_0x016e:
            if (r9 != 0) goto L_0x019d
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x016c }
            java.lang.Long r9 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x016c }
            r8.b = r9     // Catch:{ all -> 0x016c }
            goto L_0x019d
        L_0x017b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = a
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r1 = "|do report exception:"
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r9 = r9.toString()
            java.lang.StringBuilder r9 = r0.append(r9)
            java.lang.String r9 = r9.toString()
            java.lang.Object[] r0 = new java.lang.Object[r2]
            com.igexin.a.a.c.b.a((java.lang.String) r9, (java.lang.Object[]) r0)
        L_0x019d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.extension.distribution.basic.a.d.a(boolean):void");
    }
}
